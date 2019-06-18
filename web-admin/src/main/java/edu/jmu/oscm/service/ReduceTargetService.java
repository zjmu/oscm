package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.ReduceTargetMapper;
import edu.jmu.oscm.model.Item;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.Report;
import edu.jmu.oscm.model.ReportItemInstance;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.Collator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReduceTargetService {

    @Autowired
    private ReduceTargetMapper reduceTargetMapper;

    private String[] parentItemName = {"流动资产","流动负债"};

    public List<ReduceTarget> queryAll(){
        return reduceTargetMapper.queryAll();
    }

    public List<ReduceTarget> queryReduceTargetsByYear(String year, Integer type){
        if(type!=1 && type != 2){
            return null;
        }
        //初始化
        List<ReduceTarget> reduceTargets0 = reduceTargetMapper.queryAll();
        if(reduceTargets0.size() == 0){
            init();
        }
            //表中已经有数据
            //如果是新的一年则新加入
            List<String> itemNames = reduceTargetMapper.queryItemNames(parentItemName[type-1]);
        if (itemNames.size() == 0){
            return null;
        }
            //查询
            List<ReduceTarget> reduceTargets = reduceTargetMapper.queryReduceTargetsByYear(year,itemNames);
            Integer yearInt = Integer.valueOf(year);
            //计算去年
            yearInt = yearInt - 1;
            String lastYear = "";
            lastYear = yearInt.toString();
            //查询去年目标值
            List<ReportItemInstance> reportItemInstances = reduceTargetMapper.queryEndValue(lastYear, itemNames);

            //ReduceTarget中没有当年数据，需要初始化
            if (reduceTargets.size() == 0  && reportItemInstances.size() > 0){
                List<Item> items = queryItems(type);
                List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
                //占比初始化为0
                Double percent = 100.0;
                //asset_or_debt 资产或负债，0资产  1负债
                Integer asset_or_debt = type-1;
                for(ReportItemInstance reportItemInstance : reportItemInstances){
                    ReduceTarget reduceTarget = new ReduceTarget();
                    reduceTarget.setYear(year);
                    reduceTarget.setYear_percent(percent);
                    reduceTarget.setAsset_or_debt(asset_or_debt);
                    for(Item item:items){
                        if(item.getItem_name().equals(reportItemInstance.getItemName())){
                            reduceTarget.setItem_id(item.getID());
                            items.remove(item);
                            break;
                        }
                    }
                    reduceTarget.setLast_year_value(new BigDecimal(reportItemInstance.getEndValueSum()));
                    reduceTargets.add(reduceTarget);
                }
                //排序
                Collections.sort(reduceTargets, new Comparator<ReduceTarget>() {
                    @Override
                    public int compare(ReduceTarget o1, ReduceTarget o2) {
                        Collator collator = Collator.getInstance();
                        return Integer.valueOf(o1.getItem_id().subtract(o2.getItem_id()).toString());
                    }
                });
                //插入
                add(reduceTargets);
                //插入后重新查询
                return reduceTargetMapper.queryReduceTargetsByYear(year,itemNames);
            }else if(reduceTargets.size() == 0 && reportItemInstances.size() == 0){
                //没有该年份数据，且没有去年值
                return null;
            }else if(reduceTargets.size() > 0){
                //已有当年数据，返回
                return reduceTargets;
            }
        return null;
/*        //获取当前年份
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String thisYear = "";
        DateFormat sdf = new SimpleDateFormat("yyyy");
        thisYear = sdf.format(timestamp);
        //没有记录的话，插入再查询  且只能为今年插入
        if(thisYear.equals(year) && reduceTargets.size() == 0 ){
            List<Item> items = queryItems(type);
            List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
            //占比初始化为0
            Double percent = 0.0;
            //asset_or_debt 资产或负债，0资产  1负债
            Integer asset_or_debt = type-1;

            for(Item item:items){
                System.out.println(item.getID());
                ReduceTarget reduceTarget = new ReduceTarget();
                reduceTarget.setItem_id(item.getID());
                reduceTarget.setYear(thisYear);
                reduceTarget.setYear_percent(percent);
                reduceTarget.setAsset_or_debt(asset_or_debt);

                reduceTargets1.add(reduceTarget);
            }
            //插入今年数据到数据库
            add(reduceTargets1);
            //重新查找
            reduceTargets = reduceTargetMapper.queryReduceTargetsByYear(year,itemCodes);
        }
        //设置标志字段，通过该字段判断该年份是否可修改
        for(ReduceTarget reduceTarget:reduceTargets){
            if(thisYear.equals(year)){
                reduceTarget.setCnaModify(true);
            }else{
                reduceTarget.setCnaModify(false);
            }
        }
        return reduceTargets;*/
    }

    public Integer add(List<ReduceTarget> reduceTargets){
        List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
        for(ReduceTarget reduceTarget:reduceTargets){

            /*获取系统当前时间*/
            Timestamp d = new Timestamp(System.currentTimeMillis());
            reduceTarget.setCreate_date(d);
            ReduceTarget rt ;

            //计算今年的year_value
            BigDecimal num = new BigDecimal("100");
            BigDecimal yearPercent = new BigDecimal(reduceTarget.getYear_percent());
            BigDecimal yearValue = (reduceTarget.getLast_year_value().multiply(yearPercent)).divide(num,4, BigDecimal.ROUND_HALF_DOWN);
            reduceTarget.setYear_value(yearValue);

            //根据year_value初始化所有月份
            rt = caculateAverage(reduceTarget);
            reduceTargets1.add(rt);
        }
        reduceTargetMapper.add(reduceTargets1);
        return 1;
    }

    public  Boolean deleteByID(int id){
        return reduceTargetMapper.deleteByID(id);
    }

    public Boolean deleteAll(){
        return reduceTargetMapper.deleteAll();
    }

    public Boolean deleteByYearAndType(String year, Integer type){
        return  reduceTargetMapper.deleteByYearAndType(year, type);
    }

    public ReduceTarget queryByID(int id){
        return reduceTargetMapper.queryByID(id);
    }

    public Boolean updateYearPercent(ReduceTarget reduceTarget){
        ReduceTarget rt = reduceTargetMapper.queryByID(reduceTarget.getId());
        //重新计算yearValue
        BigDecimal num = new BigDecimal("100");
        BigDecimal yearPercent = new BigDecimal(reduceTarget.getYear_percent());
        BigDecimal yearValue = rt.getLast_year_value().multiply(yearPercent).divide(num,4, BigDecimal.ROUND_HALF_DOWN);
        rt.setYear_percent(reduceTarget.getYear_percent());
        rt.setYear_value(yearValue);
        //计算十二个月的value
        ReduceTarget reduceTarget1 = caculateAverage(rt);
        return reduceTargetMapper.updateYearPercent(reduceTarget1);
    }

    public Boolean updateYearPercents(List<ReduceTarget> reduceTargets){
        //参数id percent
        List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
        for(ReduceTarget reduceTarget : reduceTargets){
            ReduceTarget rt = reduceTargetMapper.queryByID(reduceTarget.getId());
            //不存在，请先插入
            if(rt == null){
                return false;
            }

            //获取当前年份
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String thisYear = "";
            DateFormat sdf = new SimpleDateFormat("yyyy");
            thisYear = sdf.format(timestamp);
            //判断是否是今年的，否则不可修改
            if(thisYear.equals(rt.getYear())){
                //如果year_percent没变化 则无需更改
                Boolean flag = rt.getYear_percent().equals(reduceTarget.getYear_percent());
                //percent 发生改变 重新计算 ，否则不变
                if(!flag){
                    //重新计算yearValue
                    BigDecimal num = new BigDecimal("100");
                    BigDecimal yearPercent = new BigDecimal(reduceTarget.getYear_percent());
                    BigDecimal yearValue = rt.getLast_year_value().multiply(yearPercent).divide(num,4, BigDecimal.ROUND_HALF_DOWN);
                    rt.setYear_percent(reduceTarget.getYear_percent());
                    rt.setYear_value(yearValue);
                    //计算十二个月的value
                    rt = caculateAverage(rt);
                }
                reduceTargets1.add(rt);
            }else{
                return false;
            }
        }
        return reduceTargetMapper.updateYearPercents(reduceTargets1);
    }

    public BigDecimal selectLastYearValue(ReduceTarget reduceTarget){
        int lastYear = Integer.parseInt(reduceTarget.getYear()) - 1;
        String lastYear_string = String.valueOf(lastYear);

        BigDecimal lastYearValue = reduceTargetMapper.selectLastYearValue(lastYear_string,reduceTarget.getItem_id());
        return lastYearValue;
    }

    public Boolean updates(List<ReduceTarget> reduceTargets){
        List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
        //最新年份的项目才可直接更改年目标值年目标值
        for(ReduceTarget rt : reduceTargets){
            ReduceTarget reduceTarget = reduceTargetMapper.queryByID(rt.getId());
            if(reduceTarget != null){
                int year = Integer.parseInt(reduceTargetMapper.queryMaxYear());
                int newYear = Integer.parseInt(reduceTarget.getYear());
                if(year == newYear){
                    reduceTargets1.add(caculateAverage(reduceTarget));
                }
            }
        }
        if (reduceTargets1.size() != 0){
            return reduceTargetMapper.updates(reduceTargets1);
        }
        return false;
    }

    public Boolean updateMonth(ReduceTarget reduceTarget){
        //校验是否是合法修改
        ReduceTarget rt = judge(reduceTarget);
        if(rt != null){
            return reduceTargetMapper.updateMonth(rt);
        }else{
            return false;
        }
    }

    public Integer updateMonths(List<ReduceTarget> reduceTargets){
        List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();

        //获取当前年份
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String thisYear = "";
        DateFormat sdf = new SimpleDateFormat("yyyy");
        thisYear = sdf.format(timestamp);

        for(ReduceTarget reduceTarget:reduceTargets){
            ReduceTarget reduceTarget1 = queryByID(reduceTarget.getId());
            if(reduceTarget1 == null){
                return -2;
            }
            //判断是否是今年的，否则不可修改
            if(thisYear.equals(reduceTarget1.getYear())){
                ReduceTarget rt = judge(reduceTarget);
                if(rt != null){
                    reduceTargets1.add(rt);
                }else{
                    return -1;
                }
            }else{
                //不是今年的，不可修改
                return 0;
            }
        }
        reduceTargetMapper.updateMonths(reduceTargets1);
        return 1;
    }

    private ReduceTarget caculateAverage(ReduceTarget reduceTarget){
        //计算12个月的平均降低值
        BigDecimal monthCount = new BigDecimal(12);
        BigDecimal yearPercent = new BigDecimal(reduceTarget.getYear_percent());
        BigDecimal averageValue = yearPercent.divide(monthCount,4,BigDecimal.ROUND_HALF_DOWN);
        //前11个月
        BigDecimal num = new BigDecimal(11);
        BigDecimal value;
        //设置前11个月的降低值=平均值
        reduceTarget.setJan(averageValue);
        reduceTarget.setFeb(averageValue);
        reduceTarget.setMar(averageValue);
        reduceTarget.setApr(averageValue);
        reduceTarget.setMay(averageValue);
        reduceTarget.setJun(averageValue);
        reduceTarget.setJul(averageValue);
        reduceTarget.setAug(averageValue);
        reduceTarget.setSept(averageValue);
        reduceTarget.setOct(averageValue);
        reduceTarget.setNov(averageValue);
        //设置第12个月的降低值
        value = yearPercent.subtract(averageValue.multiply(num));
        reduceTarget.setDec(value);
        return reduceTarget;
    }


    public List<Item> queryItems(int type){
        if(type!=1 && type != 2){
            return null;
        }
        List<String> itemNames = reduceTargetMapper.queryItemNames(parentItemName[type-1]);
        return reduceTargetMapper.queryItems(itemNames);
    }

    private ReduceTarget judge(ReduceTarget reduceTarget){
        //校验是否是合法修改
        BigDecimal sum = new BigDecimal(0);
        ReduceTarget rt = reduceTargetMapper.queryByID(reduceTarget.getId());
        if(rt == null){
            return null;
        }

        if (reduceTarget.getJan() != null){
            rt.setJan(reduceTarget.getJan());
        }
        sum = sum.add(rt.getJan());
        if (reduceTarget.getFeb() != null){
            rt.setFeb(reduceTarget.getFeb());
        }
        sum = sum.add(rt.getFeb());
        if (reduceTarget.getMar() != null){
            rt.setMar(reduceTarget.getMar());
        }
        sum = sum.add(rt.getMar());
        if (reduceTarget.getApr() != null){
            rt.setApr(reduceTarget.getApr());
        }
        sum = sum.add(rt.getApr());
        if (reduceTarget.getMay() != null){
            rt.setMay(reduceTarget.getMay());
        }
        sum = sum.add(rt.getMay());
        if (reduceTarget.getJun() != null){
            rt.setJun(reduceTarget.getJun());
        }
        sum = sum.add(rt.getJun());
        if (reduceTarget.getJul() != null){
            rt.setJul(reduceTarget.getJul());
        }
        sum = sum.add(rt.getJul());
        if (reduceTarget.getAug() != null){
            rt.setAug(reduceTarget.getAug());
        }
        sum = sum.add(rt.getAug());
        if (reduceTarget.getSept() != null){
            rt.setSept(reduceTarget.getSept());
        }
        sum = sum.add(rt.getSept());
        if (reduceTarget.getOct() != null){
            rt.setOct(reduceTarget.getOct());
        }
        sum = sum.add(rt.getOct());
        if (reduceTarget.getNov() != null){
            rt.setNov(reduceTarget.getNov());
        }
        sum = sum.add(rt.getNov());
        if (reduceTarget.getDec() != null){
            rt.setDec(reduceTarget.getDec());
        }
        sum = sum.add(rt.getDec());

        Double s=sum.doubleValue();

        //是否可以修改
        if(s.compareTo(rt.getYear_percent())==0){
            return rt;
        }else{
            return null;
        }
    }

    private void init() {
        //获取当前年份
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String thisYear = "";
        DateFormat sdf = new SimpleDateFormat("yyyy");
        thisYear = sdf.format(timestamp);
        String firstYear = reduceTargetMapper.queryFirstYear();
        if (firstYear == null) {
            firstYear = "2000";
        }
        for (int i = Integer.valueOf(firstYear) + 1; i <= Integer.valueOf(thisYear); i++) {
            String yearString = String.valueOf(i);
            for (int j = 1; j <= 2; j++) {
                List<String> itemNames = reduceTargetMapper.queryItemNames(parentItemName[j - 1]);
                if (itemNames.size() == 0) {
                    return;
                }

                //查询
                List<ReduceTarget> reduceTargets = reduceTargetMapper.queryReduceTargetsByYear(yearString, itemNames);
                Integer yearInt = Integer.valueOf(yearString);
                //计算去年
                yearInt = yearInt - 1;
                String lastYear = "";
                lastYear = yearInt.toString();
                //查询去年目标值
                List<ReportItemInstance> reportItemInstances = reduceTargetMapper.queryEndValue(lastYear, itemNames);

                if (reduceTargets.size() == 0 && reportItemInstances.size() > 0) {
                    List<Item> items = queryItems(j);
                    List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
                    //占比初始化为0
                    Double percent = 100.0;
                    //asset_or_debt 资产或负债，0资产  1负债
                    Integer asset_or_debt = j - 1;
                    for (ReportItemInstance reportItemInstance : reportItemInstances) {
                        ReduceTarget reduceTarget = new ReduceTarget();
                        reduceTarget.setYear(yearString);
                        reduceTarget.setYear_percent(percent);
                        reduceTarget.setAsset_or_debt(asset_or_debt);
                        for (Item item : items) {
                            if (item.getItem_name().equals(reportItemInstance.getItemName())) {
                                reduceTarget.setItem_id(item.getID());
                                items.remove(item);
                                break;
                            }
                        }
                        reduceTarget.setLast_year_value(new BigDecimal(reportItemInstance.getEndValueSum()));
                        reduceTargets1.add(reduceTarget);
                    }
                    //排序
                    Collections.sort(reduceTargets1, new Comparator<ReduceTarget>() {
                        @Override
                        public int compare(ReduceTarget o1, ReduceTarget o2) {
                            return Integer.valueOf(o1.getItem_id().subtract(o2.getItem_id()).toString());
                        }
                    });
                    //插入
                    add(reduceTargets1);
                }
            }
        }

    }
}

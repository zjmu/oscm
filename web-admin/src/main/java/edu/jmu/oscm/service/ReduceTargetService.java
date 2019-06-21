package edu.jmu.oscm.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.jmu.oscm.mapper.ReduceTargetMapper;
import edu.jmu.oscm.model.*;
import io.swagger.models.auth.In;
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

    private String[] parentItemCode = {"流动资产","流动负债"};

    public List<ReduceTarget> queryAll(){
        return reduceTargetMapper.queryAll();
    }

    public List<ReduceTarget> queryReduceTargetsByYear(String year, Integer type){
        if(type!=1 && type != 2){
            return null;
        }
        List<Department> firstDepartments = reduceTargetMapper.queryDepartment("0");
        List<List<String>> itemNamess = new ArrayList<List<String>>();
        List<List<Item>> itemss = new ArrayList<List<Item>>();
        for (int i = 1; i <= 2; i++) {
            List<String> itemNames = reduceTargetMapper.queryItemNames(parentItemCode[i - 1]);
            List<Item> items = queryItems(i);
            itemNamess.add(itemNames);
            itemss.add(items);
        }
        //初始化
        List<ReduceTarget> reduceTargets0 = reduceTargetMapper.queryAll();
        if(reduceTargets0.size() == 0){
            init();
        }else {
            //获取当前年份
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String thisYear = "";
            DateFormat sdf = new SimpleDateFormat("yyyy");
            thisYear = sdf.format(timestamp);
            Integer thisYearInt = Integer.valueOf(thisYear);
            //获取数据库最早年份
            String firstYear = reduceTargetMapper.queryFirstYear();
            Integer firstYearInt = Integer.valueOf(firstYear);

            //要插入到数据库的数组
            List<ReduceTarget> insertData = new ArrayList<ReduceTarget>();

            Integer yearInt = Integer.valueOf(year);
            //判断年份是否在正常区间
            if(yearInt<=firstYearInt || yearInt>thisYearInt){
                return  null;
            }
            //计算去年
            yearInt = yearInt - 1;
            String lastYear = "";
            lastYear = yearInt.toString();

            //两种类型都没有
            if (itemNamess.get(0).size() == 0 && itemNamess.get(1).size() == 0) {
                return null;
            }
            //要查询的类型没有
            if (itemNamess.get(type - 1).size() == 0) {
                return null;
            }
            if(firstDepartments.size() == 0){
                return null;
            }
            for (Department department : firstDepartments) {
                if(itemNamess.get(type-1).size() > 0){
                    List<ReduceTarget> reduceTargets2 = reduceTargetMapper.queryReduceTargetsByDepartment(year, department.getDeptCode(), itemNamess.get(type - 1));
                    //存在记录，返回
                    if (reduceTargets2.size() > 0) {
                        return reduceTargets2;
                    }
                }else {
                    return null;
                }

            }
            //不存在记录,去生成 如果instance表没有数据则跳过
            //生成各个部门
            List<Department> departments = new ArrayList<Department>();
            List<String> itemNames = new ArrayList<String >();
            List<ReduceTarget> reduceTargets = new ArrayList<ReduceTarget>();
            List<ReportItemInstance> reportItemInstances = new ArrayList<ReportItemInstance>();
            List<String> parentDeptCodes = reduceTargetMapper.queryParentDeptCode();
            for (String parentDeptCode : parentDeptCodes) {
                departments = reduceTargetMapper.queryDepartment(parentDeptCode);
                if(departments.size() == 0){
                    continue;
                }
                ////生成同级部门
                for (Department department : departments) {
                    for (int j = 1; j <= itemNamess.size(); j++) {
                        itemNames = itemNamess.get(j - 1);
                        if (itemNames.size() == 0) {
                            continue;
                        }
                        //查询
                        reduceTargets = reduceTargetMapper.queryReduceTargetsByDepartment(year, department.getDeptCode(), itemNames);

                        //查询去年目标值
                        reportItemInstances = reduceTargetMapper.queryEndValue(lastYear, department.getDeptCode(), parentItemCode[j - 1]);

                        if (reduceTargets.size() == 0 && reportItemInstances.size() > 0) {
                            List<Item> items = new ArrayList<Item>();
                            if(itemss.size()>0){
                                items = itemss.get(j-1);
                            }
                            if(items.size() == 0){
                                continue;
                            }

                            List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
                            //占比初始化为0
                            Double percent = 0.0;
                            //asset_or_debt 资产或负债，0资产  1负债
                            Integer asset_or_debt = j - 1;
                            for (ReportItemInstance reportItemInstance : reportItemInstances) {
                                ReduceTarget reduceTarget = new ReduceTarget();
                                reduceTarget.setYear(year);
                                reduceTarget.setYear_percent(percent);
                                reduceTarget.setAsset_or_debt(asset_or_debt);
                                reduceTarget.setDept_name(department.getDeptName());
                                reduceTarget.setDept_code(department.getDeptCode());
                                System.out.println();
                                for (Item item : items) {
                                    if (item.getItem_name().equals(reportItemInstance.getItemName())) {
                                        reduceTarget.setItem_id(item.getID());
                                        reduceTarget.setItem_name(item.getItem_name());
                                        reduceTarget.setItem(item);
                                        break;
                                    }
                                }
                                reduceTarget.setLast_year_value(new BigDecimal(reportItemInstance.getEndValueSum()));
                                reduceTargets1.add(reduceTarget);
                            }
                            //排序
                            if (reduceTargets1.size() > 0) {
                                Collections.sort(reduceTargets1, new Comparator<ReduceTarget>() {
                                    @Override
                                    public int compare(ReduceTarget o1, ReduceTarget o2) {
                                        return Integer.valueOf(o1.getItem_id().subtract(o2.getItem_id()).toString());
                                    }
                                });
                                //插入到数组
                                for(ReduceTarget rt :reduceTargets1){
                                    insertData.add(rt);
                                }
                            }
                        }
                    }
                }
            }
            //添加到数据库
            if(insertData.size() > 0){
                add(insertData);
            }
        }
        //重新查询
        for (Department department : firstDepartments) {
            if(itemNamess.get(type-1).size() > 0){
                List<ReduceTarget> reduceTargets2 = reduceTargetMapper.queryReduceTargetsByDepartment(year, department.getDeptCode(), itemNamess.get(type-1));
                //存在记录，返回
                if (reduceTargets2.size() > 0) {
                    return reduceTargets2;
                }
            }
        }
        return null;
    }

    private void init() {
        long startTime1=System.currentTimeMillis();   //获取开始时间
        List<ReduceTarget> insertData = new ArrayList<ReduceTarget>();
        //获取当前年份
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String thisYear = "";
        DateFormat sdf = new SimpleDateFormat("yyyy");
        thisYear = sdf.format(timestamp);
        String firstYear = reduceTargetMapper.queryFirstYear();
        List<String> parentDeptCodes = reduceTargetMapper.queryParentDeptCode();
        if (firstYear == null) {
            firstYear = "2000";
        }
        String yearString = "";
        List<List<String>> itemNamess = new ArrayList<List<String>>();
        List<List<Item>> itemss = new ArrayList<List<Item>>();
        for( int i = 1;i<=2;i++){
            List<String> itemNames = reduceTargetMapper.queryItemNames(parentItemCode[i - 1]);
            List<Item> items = queryItems(i);
            itemNamess.add(itemNames);
            itemss.add(items);
        }
        //两种类型都没有
        if(itemNamess.get(0).size() == 0 && itemNamess.get(1).size() == 0){
            return ;
        }
        List<Item> items = new ArrayList<Item>();
        List<Department> departments = new ArrayList<Department>();
        List<ReportItemInstance> reportItemInstances = new ArrayList<ReportItemInstance>();
        List<ReduceTarget> reduceTargets = new ArrayList<ReduceTarget>();
        ReduceTarget reduceTarget = new ReduceTarget();
        for (int i = Integer.valueOf(firstYear) + 1; i <= Integer.valueOf(thisYear); i++) {
            //生成各个部门
            for (String parentDeptCode:parentDeptCodes){
                //获取同级部门（PS：父部相同）
                departments = reduceTargetMapper.queryDepartment(parentDeptCode);
                yearString = String.valueOf(i);
                if(departments.size() == 0){
                    continue;
                }
                ////生成同级部门
                for (Department department:departments){
                    for (int j = 1; j <= itemNamess.size(); j++) {
                        List<String> itemNames = itemNamess.get(j-1);
                        if (itemNames.size() == 0) {
                            continue;
                        }

                        //查询
                        reduceTargets = reduceTargetMapper.queryReduceTargetsByDepartment(yearString,department.getDeptCode(),  itemNames);
                        Integer yearInt = Integer.valueOf(yearString);
                        //计算去年
                        yearInt = yearInt - 1;
                        String lastYear = "";
                        lastYear = yearInt.toString();
                        //查询去年目标值
                        reportItemInstances = reduceTargetMapper.queryEndValue(lastYear,department.getDeptCode(), parentItemCode[j-1]);

                        if (reduceTargets.size() == 0 && reportItemInstances.size() > 0) {
                            //List<Item> items = queryItems(j);

                            if(itemss.size()>0){
                                items = itemss.get(j-1);
                            }
                            if(items.size() == 0){
                                continue;
                            }

                            List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
                            //占比初始化为0
                            Double percent = 0.0;
                            //asset_or_debt 资产或负债，0资产  1负债
                            Integer asset_or_debt = j - 1;
                            for (ReportItemInstance reportItemInstance : reportItemInstances) {
                                reduceTarget = new ReduceTarget();
                                reduceTarget.setYear(yearString);
                                reduceTarget.setYear_percent(percent);
                                reduceTarget.setAsset_or_debt(asset_or_debt);
                                reduceTarget.setDept_name(department.getDeptName());
                                reduceTarget.setDept_code(department.getDeptCode());
                                for (Item item : items) {
                                    if (item.getItem_name().equals(reportItemInstance.getItemName())) {
                                        reduceTarget.setItem_id(item.getID());
                                        reduceTarget.setItem_name(item.getItem_name());
                                        reduceTarget.setItem(item);
                                        //items.remove(item);
                                        break;
                                    }
                                }
                                reduceTarget.setLast_year_value(new BigDecimal(reportItemInstance.getEndValueSum()));
                                reduceTargets1.add(reduceTarget);
                            }
                            long startTime=System.currentTimeMillis();   //获取开始时间
                            //排序
                            if(reduceTargets1.size()>0){
                                Collections.sort(reduceTargets1, new Comparator<ReduceTarget>() {
                                    @Override
                                    public int compare(ReduceTarget o1, ReduceTarget o2) {
                                        return Integer.valueOf(o1.getItem_id().subtract(o2.getItem_id()).toString());
                                    }
                                });
                                for(ReduceTarget rt :reduceTargets1){
                                    insertData.add(rt);
                                }

                            }
                            long endTime=System.currentTimeMillis(); //获取结束时间
                            System.out.println("================");
                            System.out.println("排序时间" + ( endTime - startTime)+"ms");
                            System.out.println("================");
                        }
                    }

                }
            }

        }
        long endTime1=System.currentTimeMillis(); //获取结束时间
        System.out.println("================");
        System.out.println(( endTime1 - startTime1)+"ms");
        System.out.println("================");

        if(insertData.size() > 0){
            add(insertData);
        }

    }

    // type = 0/1
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
        List<ReduceTarget> reduceTargets_month = new ArrayList<ReduceTarget>();
        Boolean sign = false;
        if(reduceTargets == null){
            return  false;
        }
        //获取当前年份
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String thisYear = "";
        DateFormat sdf = new SimpleDateFormat("yyyy");
        thisYear = sdf.format(timestamp);
        for(ReduceTarget reduceTarget : reduceTargets){
            ReduceTarget rt = reduceTargetMapper.queryByID(reduceTarget.getId());
            //不存在，请先插入
            if(rt == null){
                return false;
            }
/*            String parentDeptCode = reduceTargetMapper.queryParentDeptCodeByDeptCode(rt.getDept_code());
            if(!("0".equals(parentDeptCode))){
                return false;
            }*/
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
                    reduceTargets1.add(rt);
                }
            }else{
                return false;
            }
        }
        //更改年比例
        if(reduceTargets1.size() == 0){
            return false;
        }else{
            sign =  reduceTargetMapper.updateYearPercents(reduceTargets1);
        }

        //各个子部门
        while(reduceTargets1.size()!=0){
            //12个月的记录都做出了更改，对所有下级部门进行更新
            //迭代器
            Iterator<ReduceTarget> it = reduceTargets1.iterator();
            while(it.hasNext()){
                ReduceTarget reduceTarget0 = reduceTargets1.get(0);
/*            }
            for(ReduceTarget reduceTarget : reduceTargets1){*/
                List<ReduceTarget> childReduceTarget =reduceTargetMapper.queryReduceTargetByDepartmentAndItem(reduceTarget0.getItem_id(),thisYear,reduceTarget0.getDept_code());
                if(childReduceTarget.size()>0){
                    BigDecimal count = new BigDecimal(childReduceTarget.size());
                    List<BigDecimal> averages = CaculateAverage(reduceTarget0,count);
                    int flag = 1;
                    for(ReduceTarget rt: childReduceTarget){
                        if (flag == 1){
                            BigDecimal count1 = new BigDecimal(childReduceTarget.size() - 1);
                            rt.setJan(reduceTarget0.getJan().subtract(count1.multiply(averages.get(0))));
                            rt.setFeb(reduceTarget0.getFeb().subtract(count1.multiply(averages.get(1))));
                            rt.setMar(reduceTarget0.getApr().subtract(count1.multiply(averages.get(2))));
                            rt.setApr(reduceTarget0.getApr().subtract(count1.multiply(averages.get(3))));
                            rt.setMay(reduceTarget0.getMay().subtract(count1.multiply(averages.get(4))));
                            rt.setJun(reduceTarget0.getJun().subtract(count1.multiply(averages.get(5))));
                            rt.setJul(reduceTarget0.getJul().subtract(count1.multiply(averages.get(6))));
                            rt.setAug(reduceTarget0.getAug().subtract(count1.multiply(averages.get(7))));
                            rt.setSept(reduceTarget0.getSept().subtract(count1.multiply(averages.get(8))));
                            rt.setOct(reduceTarget0.getOct().subtract(count1.multiply(averages.get(9))));
                            rt.setNov(reduceTarget0.getNov().subtract(count1.multiply(averages.get(10))));
                            rt.setDec(reduceTarget0.getDec().subtract(count1.multiply(averages.get(11))));
                            flag = 0;
                        }else {
                            rt.setJan(averages.get(0));rt.setFeb(averages.get(1));rt.setMar(averages.get(2));
                            rt.setApr(averages.get(3));rt.setMay(averages.get(4));rt.setJun(averages.get(5));
                            rt.setJul(averages.get(6));rt.setAug(averages.get(7));rt.setSept(averages.get(8));
                            rt.setOct(averages.get(9));rt.setNov(averages.get(10));rt.setDec(averages.get(11));
                        }
                        reduceTargets1.add(rt);
                        reduceTargets_month.add(rt);
                    }
                }
                reduceTargets1.remove(reduceTarget0);
            }
            //更改子部门月比例
            if(reduceTargets_month.size()!=0){
                updateMonthValue(reduceTargets_month);
            }
        }
        return sign;
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
        if(reduceTarget!=null){
            ReduceTarget reduceTarget1 = queryByID(reduceTarget.getId());
            ReduceTarget rt = judge(reduceTarget,reduceTarget1);
            if(rt != null){
                return reduceTargetMapper.updateMonth(rt);
            }else{
                return false;
            }
        }
        return false;
    }

    private List<BigDecimal> CaculateAverage(ReduceTarget reduceTarget ,BigDecimal count){
        List<BigDecimal> averages = new ArrayList<BigDecimal>(12);
        for (int i = 0; i < 12; i++) {
            averages.add(new BigDecimal("0"));
        }
        //计算平均值
        averages.set(0,reduceTarget.getJan().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(1,reduceTarget.getFeb().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(2,reduceTarget.getMar().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(3,reduceTarget.getApr().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(4,reduceTarget.getMay().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(5,reduceTarget.getJun().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(6,reduceTarget.getJul().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(7,reduceTarget.getAug().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(8,reduceTarget.getSept().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(9,reduceTarget.getOct().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(10,reduceTarget.getNov().divide(count,4, BigDecimal.ROUND_HALF_DOWN));
        averages.set(11,reduceTarget.getDec().divide(count,4, BigDecimal.ROUND_HALF_DOWN));

        return averages;
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

    public List<ReduceTarget> queryReduceTargetByDepartmentAndItem(Integer id){
        List<ReduceTarget> reduceTargets = new ArrayList<ReduceTarget>();
        ReduceTarget reduceTarget =  reduceTargetMapper.queryByID(id);
        if(reduceTarget == null){
            return reduceTargets;
        }
        reduceTargets.add(reduceTarget);
        //查出该条记录的下级记录
        List<ReduceTarget> reduceTargets1 = reduceTargetMapper.queryReduceTargetByDepartmentAndItem(reduceTarget.getItem_id(),reduceTarget.getYear(),reduceTarget.getDept_code());
        for(ReduceTarget rt: reduceTargets1){
            reduceTargets.add(rt);
        }
        //没有下级部门
        if (reduceTargets.size() == 1){
            return null;
        }
        return reduceTargets;
    }

    //存放每个月份是否需要更改
    private List<List<Boolean>> changes = new ArrayList<List<Boolean>>();
    public Integer updateMonths(List<ReduceTarget> reduceTargets){
        if (reduceTargets == null || reduceTargets.size() == 0){
            return -2;
        }
        List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
        List<ReduceTarget> reduceTargets_month = new ArrayList<ReduceTarget>();
        changes = new ArrayList<List<Boolean>>();
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
                ReduceTarget rt = judge(reduceTarget,reduceTarget1);
                if(rt != null && rt.getId() != -1){
                    reduceTargets1.add(rt);
                }else if(rt != null && rt.getId() == -1){
                    //未作出更改
                } else{
                    return -1;
                }
            }else{
                //不是今年的，不可修改
                return 0;
            }
        }
        System.out.println(changes.size());
        for (List<Boolean> a: changes){
            for (Boolean b : a){
                System.out.print(b + "   ");
            }
            System.out.println();
        }
        if(reduceTargets1.size() > 0){
            reduceTargetMapper.updateMonths(reduceTargets1);
            //各个子部门
            while(reduceTargets1.size()!=0){
                //12个月的某几个月记录都做出了更改，对所有下级部门进行更新
                //迭代器
                Iterator<ReduceTarget> it = reduceTargets1.iterator();
                while(it.hasNext()) {
                    ReduceTarget reduceTarget0 = reduceTargets1.get(0);
                    List<ReduceTarget> childReduceTarget =reduceTargetMapper.queryReduceTargetByDepartmentAndItem(reduceTarget0.getItem_id(),thisYear,reduceTarget0.getDept_code());
                    if(childReduceTarget.size()>0) {
                        BigDecimal count = new BigDecimal(childReduceTarget.size());
                        List<BigDecimal> averages = CaculateAverage(reduceTarget0,count);
                        int flag = 1;
                        for(ReduceTarget rt: childReduceTarget){
                            if (flag == 1) {
                                BigDecimal count1 = new BigDecimal(childReduceTarget.size() - 1);
                                //上级部门一月份有改变
                                if(changes.get(0).get(0)){
                                    rt.setJan(reduceTarget0.getJan().subtract(count1.multiply(averages.get(0))));
                                }
                                if(changes.get(0).get(1)){
                                    rt.setFeb(reduceTarget0.getFeb().subtract(count1.multiply(averages.get(1))));
                                }
                                if (changes.get(0).get(2)){
                                    rt.setMar(reduceTarget0.getMar().subtract(count1.multiply(averages.get(2))));
                                }
                                if (changes.get(0).get(3)){
                                    rt.setApr(reduceTarget0.getApr().subtract(count1.multiply(averages.get(3))));
                                }
                                if (changes.get(0).get(4)){
                                    rt.setMay(reduceTarget0.getMay().subtract(count1.multiply(averages.get(4))));
                                }
                                if (changes.get(0).get(5)){
                                    rt.setJun(reduceTarget0.getJun().subtract(count1.multiply(averages.get(5))));
                                }
                                if (changes.get(0).get(6)){
                                    rt.setJul(reduceTarget0.getJul().subtract(count1.multiply(averages.get(6))));
                                }
                                if (changes.get(0).get(7)){
                                    rt.setAug(reduceTarget0.getAug().subtract(count1.multiply(averages.get(7))));
                                }
                                if (changes.get(0).get(8)){
                                    rt.setSept(reduceTarget0.getSept().subtract(count1.multiply(averages.get(8))));
                                }
                                if (changes.get(0).get(9)){
                                    rt.setOct(reduceTarget0.getOct().subtract(count1.multiply(averages.get(9))));
                                }
                                if (changes.get(0).get(10)){
                                    rt.setNov(reduceTarget0.getNov().subtract(count1.multiply(averages.get(10))));
                                }
                                if (changes.get(0).get(11)){
                                    rt.setDec(reduceTarget0.getDec().subtract(count1.multiply(averages.get(11))));
                                }
                                flag = 0;
                            }else {
                                //上级部门一月份有改变
                                if(changes.get(0).get(0)){
                                    rt.setJan(averages.get(0));
                                }
                                if(changes.get(0).get(1)){
                                    rt.setFeb(averages.get(1));
                                }
                                if(changes.get(0).get(2)){
                                    rt.setMar(averages.get(2));
                                }
                                if(changes.get(0).get(3)){
                                    rt.setApr(averages.get(3));
                                }
                                if(changes.get(0).get(4)){
                                    rt.setMay(averages.get(4));
                                }
                                if(changes.get(0).get(5)){
                                    rt.setJun(averages.get(5));
                                }
                                if(changes.get(0).get(6)){
                                    rt.setJul(averages.get(6));
                                }
                                if(changes.get(0).get(7)){
                                    rt.setAug(averages.get(7));
                                }
                                if(changes.get(0).get(8)){
                                    rt.setSept(averages.get(8));
                                }
                                if(changes.get(0).get(9)){
                                    rt.setOct(averages.get(9));
                                }
                                if(changes.get(0).get(10)){
                                    rt.setNov(averages.get(10));
                                }
                                if(changes.get(0).get(11)){
                                    rt.setDec(averages.get(11));
                                }
                            }
                            //当前部门加到府部门数组,标志数组也要同步插入
                            reduceTargets1.add(rt);
                            changes.add(changes.get(0));
                            //更改狗的记录插入到数组中，后面再一次性更改
                            reduceTargets_month.add(rt);
                        }
                    }
                    //子部门已经插入，移除该父部门 ，同步移出府部门对应的标志数组
                    reduceTargets1.remove(reduceTarget0);
                    changes.remove(0);
                }
            }
            //更改子部门月比例
            if(reduceTargets_month.size()!=0){
                updateMonthValue(reduceTargets_month);
            }
        }
        return 1;
    }

    private List<List<Boolean>> changes2 = new ArrayList<List<Boolean>>();
    public Integer updateMonthByDepartmentAndItem(List<ReduceTarget> reduceTargets){
        //  -2   不存在
        if(reduceTargets == null || reduceTargets.size() == 0 || reduceTargets.size() == 1){
            return -2;
        }
        //存放需要更新的记录
        List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
        //存放需要更新的子部门记录
        List<ReduceTarget> reduceTargets_month = new ArrayList<ReduceTarget>();
        changes2 = new ArrayList<List<Boolean>>();
        //获取当前年份
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String thisYear = "";
        DateFormat sdf = new SimpleDateFormat("yyyy");
        thisYear = sdf.format(timestamp);

        List<ReduceTarget> reduceTargetList = new ArrayList<ReduceTarget>();
        //1.判断是否可更改
        //2.可更改的话，更改，同时对子部门更新
        //取出父部门
        ReduceTarget reduceTarget = reduceTargets.get(0);
        ReduceTarget reduceTarget1 = queryByID(reduceTarget.getId());
        //最新一年，可修改

        if(thisYear.equals(reduceTarget1.getYear())){
            reduceTargetList = judge2(reduceTargets);
            // =1 修改失败 0 未作出修改 1 成功修改
            if(reduceTargetList == null){
                return -1;
            }else if (reduceTargetList.size() == 0){
                return 0;
            }else {
                //有记录可修改
                reduceTargetMapper.updateMonthValue(reduceTargetList);
            }
        }else {
            return -1;
        }

        //对子部门做出修改
        while(reduceTargetList.size()!=0){
            //迭代器
            Iterator<ReduceTarget> it = reduceTargetList.iterator();
            while(it.hasNext()) {
                ReduceTarget reduceTarget0 = reduceTargetList.get(0);
                List<ReduceTarget> childReduceTarget =reduceTargetMapper.queryReduceTargetByDepartmentAndItem(reduceTarget0.getItem_id(),thisYear,reduceTarget0.getDept_code());
                if(childReduceTarget.size()>0) {
                    BigDecimal count = new BigDecimal(childReduceTarget.size());
                    List<BigDecimal> averages = CaculateAverage(reduceTarget0,count);
                    BigDecimal count1 = new BigDecimal(childReduceTarget.size() - 1);
                    int flag = 1;
                    for(ReduceTarget rt: childReduceTarget){
                        if (flag == 1) {
                            //上级部门一月份有改变
                            if(changes2.get(0).get(0)){
                                rt.setJan(reduceTarget0.getJan().subtract(count1.multiply(averages.get(0))));
                            }
                            if(changes2.get(0).get(1)){
                                rt.setFeb(reduceTarget0.getFeb().subtract(count1.multiply(averages.get(1))));
                            }
                            if (changes2.get(0).get(2)){
                                rt.setMar(reduceTarget0.getMar().subtract(count1.multiply(averages.get(2))));
                            }
                            if (changes2.get(0).get(3)){
                                rt.setApr(reduceTarget0.getApr().subtract(count1.multiply(averages.get(3))));
                            }
                            if (changes2.get(0).get(4)){
                                rt.setMay(reduceTarget0.getMay().subtract(count1.multiply(averages.get(4))));
                            }
                            if (changes2.get(0).get(5)){
                                rt.setJun(reduceTarget0.getJun().subtract(count1.multiply(averages.get(5))));
                            }
                            if (changes2.get(0).get(6)){
                                rt.setJul(reduceTarget0.getJul().subtract(count1.multiply(averages.get(6))));
                            }
                            if (changes2.get(0).get(7)){
                                rt.setAug(reduceTarget0.getAug().subtract(count1.multiply(averages.get(7))));
                            }
                            if (changes2.get(0).get(8)){
                                rt.setSept(reduceTarget0.getSept().subtract(count1.multiply(averages.get(8))));
                            }
                            if (changes2.get(0).get(9)){
                                rt.setOct(reduceTarget0.getOct().subtract(count1.multiply(averages.get(9))));
                            }
                            if (changes2.get(0).get(10)){
                                rt.setNov(reduceTarget0.getNov().subtract(count1.multiply(averages.get(10))));
                            }
                            if (changes2.get(0).get(11)){
                                rt.setDec(reduceTarget0.getDec().subtract(count1.multiply(averages.get(11))));
                            }
                            flag = 0;
                        }else {
                            //上级部门一月份有改变
                            if(changes2.get(0).get(0)){
                                rt.setJan(averages.get(0));
                            }
                            if(changes2.get(0).get(1)){
                                rt.setFeb(averages.get(1));
                            }
                            if(changes2.get(0).get(2)){
                                rt.setMar(averages.get(2));
                            }
                            if(changes2.get(0).get(3)){
                                rt.setApr(averages.get(3));
                            }
                            if(changes2.get(0).get(4)){
                                rt.setMay(averages.get(4));
                            }
                            if(changes2.get(0).get(5)){
                                rt.setJun(averages.get(5));
                            }
                            if(changes2.get(0).get(6)){
                                rt.setJul(averages.get(6));
                            }
                            if(changes2.get(0).get(7)){
                                rt.setAug(averages.get(7));
                            }
                            if(changes2.get(0).get(8)){
                                rt.setSept(averages.get(8));
                            }
                            if(changes2.get(0).get(9)){
                                rt.setOct(averages.get(9));
                            }
                            if(changes2.get(0).get(10)){
                                rt.setNov(averages.get(10));
                            }
                            if(changes2.get(0).get(11)){
                                rt.setDec(averages.get(11));
                            }
                        }
                        //当前部门加到府部门数组,标志数组也要同步插入
                        reduceTargetList.add(rt);
                        changes2.add(changes2.get(0));
                        //更改狗的记录插入到数组中，后面再一次性更改
                        reduceTargets_month.add(rt);
                    }
                }
                //子部门已经插入，移除该父部门 ，同步移出府部门对应的标志数组
                reduceTargetList.remove(reduceTarget0);
                changes2.remove(0);
            }

        }
        //更改子部门月比例
        if(reduceTargets_month.size()!=0){
            updateMonthValue(reduceTargets_month);
        }
        return 1;
    }

    private List<ReduceTarget> judge2(List<ReduceTarget> reduceTargets){

        if(reduceTargets != null && reduceTargets.size() !=0 && reduceTargets.size() != 1){
            List<Boolean> removed = new ArrayList<Boolean>();
            //取出第一条记录   即父部门记录
            ReduceTarget reduceTarget0 = reduceTargets.get(0);
            //移除父部门，只留下子部门
            reduceTargets.remove(reduceTarget0);
            reduceTarget0 = queryByID(reduceTarget0.getId());
            //找出数据库对应子部门记录
            List<ReduceTarget> reduceTargets1 = new ArrayList<ReduceTarget>();
            for(ReduceTarget reduceTarget:reduceTargets){
                reduceTargets1.add(queryByID(reduceTarget.getId()));
            }
            //判断每一个月的更改是否符合要求
            List<BigDecimal> sum = new ArrayList<BigDecimal>();
            for(int i =0;i<12;i++){
                sum.add(new BigDecimal("0"));
            }
            BigDecimal type = new BigDecimal("0");
            for(int i = 0; i < reduceTargets.size();i++){
                List<Boolean> flags = new ArrayList<Boolean>();
                for(int j = 0;j<12;j++){
                    flags.add(false);
                }
                Boolean flag = true;
                type = reduceTargets.get(i).getJan();
                if(type!=null){
                    //用户插入字段和数据库中不相等
                    if(type.compareTo(reduceTargets1.get(i).getJan()) != 0){
                        flags.set(0,true);
                        flag = false;
                        reduceTargets1.get(i).setJan(type);
                    }
                    sum.set(0,sum.get(0).add(reduceTargets.get(i).getJan()));
                }
                type = reduceTargets.get(i).getFeb();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getFeb()) != 0){
                        flags.set(1,true);
                        flag = false;
                        reduceTargets1.get(i).setFeb(type);
                    }
                    sum.set(1,sum.get(1).add(reduceTargets.get(i).getFeb()));
                }
                type = reduceTargets.get(i).getMar();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getMar()) != 0){
                        flags.set(2,true);
                        flag = false;
                        reduceTargets1.get(i).setMar(type);
                    }
                    sum.set(2,sum.get(2).add(reduceTargets.get(i).getMar()));
                }
                type = reduceTargets.get(i).getApr();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getApr()) != 0){
                        flags.set(3,true);
                        flag = false;
                        reduceTargets1.get(i).setApr(type);
                    }
                    sum.set(3,sum.get(3).add(reduceTargets.get(i).getApr()));
                }
                type = reduceTargets.get(i).getMay();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getMay()) != 0){
                        flags.set(4,true);
                        flag = false;
                        reduceTargets1.get(i).setMay(type);
                    }
                    sum.set(4,sum.get(4).add(reduceTargets.get(i).getMay()));
                }
                type = reduceTargets.get(i).getJun();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getJun()) != 0){
                        flags.set(5,true);
                        flag = false;
                        reduceTargets1.get(i).setJun(type);
                    }
                    sum.set(5,sum.get(5).add(reduceTargets.get(i).getJun()));
                }
                type = reduceTargets.get(i).getJul();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getJul()) != 0){
                        flags.set(6,true);
                        flag = false;
                        reduceTargets1.get(i).setJul(type);
                    }
                    sum.set(6,sum.get(6).add(reduceTargets.get(i).getJul()));
                }
                type = reduceTargets.get(i).getAug();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getAug()) != 0){
                        flags.set(7,true);
                        flag = false;
                        reduceTargets1.get(i).setAug(type);
                    }
                    sum.set(7,sum.get(7).add(reduceTargets.get(i).getAug()));
                }
                type = reduceTargets.get(i).getSept();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getSept()) != 0){
                        flags.set(8,true);
                        flag = false;
                        reduceTargets1.get(i).setSept(type);
                    }
                    sum.set(8,sum.get(8).add(reduceTargets.get(i).getSept()));
                }
                type = reduceTargets.get(i).getOct();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getOct()) != 0){
                        flags.set(9,true);
                        flag = false;
                        reduceTargets1.get(i).setOct(type);
                    }
                    sum.set(9,sum.get(9).add(reduceTargets.get(i).getOct()));
                }
                type = reduceTargets.get(i).getNov();
                if(type!=null){
                    if(type.compareTo(reduceTargets1.get(i).getNov()) != 0){
                        flags.set(10,true);
                        flag = false;
                        reduceTargets1.get(i).setNov(type);
                    }
                    sum.set(10,sum.get(10).add(reduceTargets.get(i).getNov()));
                }
                type = reduceTargets.get(i).getDec();
                if(reduceTargets.get(i).getDec()!=null){
                    if(type.compareTo(reduceTargets1.get(i).getDec()) != 0){
                        flags.set(11,true);
                        flag = false;
                        reduceTargets1.get(i).setDec(type);
                    }
                    sum.set(11,sum.get(11).add(reduceTargets.get(i).getDec()));
                }
                removed.add(flag);
                changes2.add(flags);
            }
            Boolean sign = true;
            //判断总和是否相等
            if(sum.get(0).compareTo(reduceTarget0.getJan()) != 0){
                sign = false;
            }
            System.out.println(sum.get(0) + "   "+reduceTarget0.getJan());
            if(sum.get(1).compareTo(reduceTarget0.getFeb()) != 0){
                sign = false;
            }
            System.out.println(sum.get(1) + "   "+reduceTarget0.getFeb());
            if(sum.get(2).compareTo(reduceTarget0.getMar()) != 0){
                sign = false;
            }
            System.out.println(sum.get(2) + "   "+reduceTarget0.getMar());
            if(sum.get(3).compareTo(reduceTarget0.getApr()) != 0){
                sign = false;
            }
            System.out.println(sum.get(3) + "   "+reduceTarget0.getApr());
            if(sum.get(4).compareTo(reduceTarget0.getMay()) != 0){
                sign = false;
            }
            System.out.println(sum.get(4) + "   "+reduceTarget0.getMay());
            if(sum.get(5).compareTo(reduceTarget0.getJun()) != 0){
                sign = false;
            }
            System.out.println(sum.get(5) + "   "+reduceTarget0.getJun());
            if(sum.get(6).compareTo(reduceTarget0.getJul()) != 0){
                sign = false;
            }
            System.out.println(sum.get(6) + "   "+reduceTarget0.getJul());
            if(sum.get(7).compareTo(reduceTarget0.getAug()) != 0){
                sign = false;
            }
            System.out.println(sum.get(7) + "   "+reduceTarget0.getAug());
            if(sum.get(8).compareTo(reduceTarget0.getSept()) != 0){
                sign = false;
            }
            System.out.println(sum.get(8) + "   "+reduceTarget0.getSept());
            if(sum.get(9).compareTo(reduceTarget0.getOct()) != 0){
                sign = false;
            }
            System.out.println(sum.get(9) + "   "+reduceTarget0.getOct());
            if(sum.get(10).compareTo(reduceTarget0.getNov()) != 0){
                sign = false;
            }
            System.out.println(sum.get(10) + "   "+reduceTarget0.getNov());
            if(sum.get(11).compareTo(reduceTarget0.getDec()) != 0){
                sign = false;
            }
            System.out.println(sum.get(11) + "   "+reduceTarget0.getDec());
            System.out.println("===============");
            //true 所有月份总和箱等
            if(sign){
                //筛选出有字段更新的记录
                List<ReduceTarget> returnList = new ArrayList<ReduceTarget>();
                List<List<Boolean>> returnChange2 = new ArrayList<List<Boolean>>();
                for(int i =0;i < reduceTargets1.size();i++){
                    if (!removed.get(i)){
                        //整条纪录未作出更改，移除
                        returnList.add(reduceTargets1.get(i));
                        returnChange2.add(changes2.get(i));
                    }
                }
                System.out.println(returnList.size());
                changes2 = returnChange2;
                return returnList;
            }else {
                //总和不相等
                return null;
            }
        }
        return null;
    }

    //reduceTarget是前端传入的数据   rt是数据库中找出的数据
    private ReduceTarget judge(ReduceTarget reduceTarget, ReduceTarget rt){
        //校验是否是合法修改
        BigDecimal sum = new BigDecimal(0);
        //ReduceTarget rt = reduceTargetMapper.queryByID(reduceTarget.getId());
        if(rt == null){
            return null;
        }
        Boolean flag = true;
        List<Boolean> flags = new ArrayList<Boolean>();
        for(int i = 0;i < 12 ;i++){
            flags.add(false);
        }
        if (reduceTarget.getJan() != null){
            if(reduceTarget.getJan().compareTo(rt.getJan()) != 0){
                flags.set(0,flag);
            }
            rt.setJan(reduceTarget.getJan());
        }
        sum = sum.add(rt.getJan());
        if (reduceTarget.getFeb() != null){
            if(reduceTarget.getFeb().compareTo(rt.getFeb()) != 0){
                flags.set(1,flag);
            }
            rt.setFeb(reduceTarget.getFeb());
        }
        sum = sum.add(rt.getFeb());
        if (reduceTarget.getMar() != null){
            if(reduceTarget.getMar().compareTo(rt.getMar()) != 0){
                flags.set(2,flag);
            }
            rt.setMar(reduceTarget.getMar());
        }
        sum = sum.add(rt.getMar());
        if (reduceTarget.getApr() != null){
            if(reduceTarget.getApr().compareTo(rt.getApr()) != 0){
                flags.set(3,flag);
            }
            rt.setApr(reduceTarget.getApr());
        }
        sum = sum.add(rt.getApr());
        if (reduceTarget.getMay() != null){
            if(reduceTarget.getMay().compareTo(rt.getMay()) != 0){
                flags.set(4,flag);
            }
            rt.setMay(reduceTarget.getMay());
        }
        sum = sum.add(rt.getMay());
        if (reduceTarget.getJun() != null){
            if(reduceTarget.getJun().compareTo(rt.getJun()) != 0){
                flags.set(5,flag);
            }
            rt.setJun(reduceTarget.getJun());
        }
        sum = sum.add(rt.getJun());
        if (reduceTarget.getJul() != null){
            if(reduceTarget.getJul().compareTo(rt.getJul()) != 0){
                flags.set(6,flag);
            }
            rt.setJul(reduceTarget.getJul());
        }
        sum = sum.add(rt.getJul());
        if (reduceTarget.getAug() != null){
            if(reduceTarget.getAug().compareTo(rt.getAug()) != 0){
                flags.set(7,flag);
            }
            rt.setAug(reduceTarget.getAug());
        }
        sum = sum.add(rt.getAug());
        if (reduceTarget.getSept() != null){
            if(reduceTarget.getSept().compareTo(rt.getSept()) != 0){
                flags.set(8,flag);
            }
            rt.setSept(reduceTarget.getSept());
        }
        sum = sum.add(rt.getSept());
        if (reduceTarget.getOct() != null){
            if(reduceTarget.getOct().compareTo(rt.getOct()) != 0){
                flags.set(9,flag);
            }
            rt.setOct(reduceTarget.getOct());
        }
        sum = sum.add(rt.getOct());
        if (reduceTarget.getNov() != null){
            if(reduceTarget.getNov().compareTo(rt.getNov()) != 0){
                flags.set(10,flag);
            }
            rt.setNov(reduceTarget.getNov());
        }
        sum = sum.add(rt.getNov());
        if (reduceTarget.getDec() != null){
            if(reduceTarget.getDec().compareTo(rt.getDec()) != 0){
                flags.set(11,flag);
            }
            rt.setDec(reduceTarget.getDec());
        }
        sum = sum.add(rt.getDec());

        Double s=sum.doubleValue();

        ReduceTarget reduceTarget1 = new ReduceTarget();
        reduceTarget1.setId(-1);
        //是否可以修改
        if(s.compareTo(rt.getYear_percent())==0){
            for(int i = 0;i<12;i++){
                if(flags.get(i) == true){
                    //该条记录需要作出更改
                    changes.add(flags);
                    return rt;
                }
            }
            return reduceTarget1;
        }
        return null;

    }

    public List<Item> queryItems(int type){
        List<Item> items = new ArrayList<Item>();
        if(type!=1 && type != 2){
            return null;
        }
        List<String> itemNames = reduceTargetMapper.queryItemNames(parentItemCode[type-1]);
        if(itemNames.size() > 0){
            return reduceTargetMapper.queryItems(itemNames);
        }
        return items;
    }

    private Boolean updateMonthValue(List<ReduceTarget> reduceTargets){
        return reduceTargetMapper.updateMonthValue(reduceTargets);
    }

}

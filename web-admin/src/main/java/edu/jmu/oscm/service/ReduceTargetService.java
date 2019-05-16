package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.ReduceTargetMapper;
import edu.jmu.oscm.model.ReduceTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ReduceTargetService {

    @Autowired
    private ReduceTargetMapper reduceTargetMapper;

    public List<ReduceTarget> queryAll(){
        return reduceTargetMapper.queryAll();
    }

    public Boolean add(ReduceTarget reduceTarget){
        /*获取系统当前时间*/
        Timestamp d = new Timestamp(System.currentTimeMillis());
        reduceTarget.setCreate_date(d);
        ReduceTarget rt = caculateAverage(reduceTarget);
        return reduceTargetMapper.add(rt);
    }

    public  Boolean deleteByID(int id){
        return reduceTargetMapper.deleteByID(id);
    }

    public Boolean deleteAll(){
        return reduceTargetMapper.deleteAll();
    }

    public ReduceTarget queryByID(int id){
        return reduceTargetMapper.queryByID(id);
    }

    public Boolean update(ReduceTarget reduceTarget){
        ReduceTarget rt = caculateAverage(reduceTarget);
        return reduceTargetMapper.update(rt);
    }

    public Boolean updates(List<ReduceTarget> reduceTargets){
        for(ReduceTarget rt : reduceTargets){
            rt = caculateAverage(rt);
        }
        return reduceTargetMapper.updates(reduceTargets);
    }

    public Boolean updateMonth(ReduceTarget reduceTarget){
        //校验是否是合法修改
        BigDecimal sum = new BigDecimal(0);
        ReduceTarget rt = reduceTargetMapper.queryByID(reduceTarget.getId());
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
        //是否可以修改
        if(sum.compareTo(rt.getYear_value())==0){
            return reduceTargetMapper.updateMonth(rt);
        }else{
            return  false;
        }
    }

    private ReduceTarget caculateAverage(ReduceTarget reduceTarget){
        //计算12个月的平均降低值
        BigDecimal monthCount = new BigDecimal(12);
        BigDecimal averageValue = reduceTarget.getYear_value().divide(monthCount,4,BigDecimal.ROUND_HALF_DOWN);
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
        value = reduceTarget.getYear_value().subtract(averageValue.multiply(num));
        reduceTarget.setDec(value);
        return reduceTarget;
    }
}

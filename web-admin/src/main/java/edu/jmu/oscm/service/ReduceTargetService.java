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

    private ReduceTarget caculateAverage(ReduceTarget reduceTarget){
        BigDecimal monthCount = new BigDecimal(12);
        BigDecimal averageValue = reduceTarget.getYear_value().divide(monthCount,4,BigDecimal.ROUND_HALF_DOWN);
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
        reduceTarget.setDec(averageValue);
        return reduceTarget;
    }
}

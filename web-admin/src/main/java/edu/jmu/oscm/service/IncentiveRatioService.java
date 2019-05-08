package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.IncentiveRatioMapper;
import edu.jmu.oscm.model.IncentiveRatio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class IncentiveRatioService {

    @Autowired
    private IncentiveRatioMapper incentiveRatioMapper;

    public List<IncentiveRatio> queryAll(){
        return incentiveRatioMapper.queryAll();
    }

    public IncentiveRatio queryByID(int id){
        return incentiveRatioMapper.queryByID(id);
    }

    public Boolean add(IncentiveRatio incentiveRatio){
        //获取系统当前日期时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        incentiveRatio.setCreate_date(timestamp);
        return incentiveRatioMapper.add(incentiveRatio);
    }

    public  Boolean deleteByID(int id){
        return incentiveRatioMapper.deleteByID(id);
    }

    public Boolean deleteAll(){
        return incentiveRatioMapper.deleteAll();
    }


    public  Boolean update(IncentiveRatio incentiveRatio){
        return incentiveRatioMapper.update(incentiveRatio);
    }

    public Boolean updates(List<IncentiveRatio> incentiveRatios){
        return incentiveRatioMapper.updates(incentiveRatios);
    }
}

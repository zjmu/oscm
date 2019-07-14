package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.IncrementalValueMapper;
import edu.jmu.oscm.model.Completion;
import edu.jmu.oscm.model.IncrementalValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zjm
 * @date 2019/7/14
 */
@Service
public class IncrementalValueService {

    @Autowired
    private IncrementalValueMapper incrementalValueMapper;

    public List<IncrementalValue> calculateByQuarter(String year, String month, BigInteger reportId, String deptCode, Integer quarter){
        String time1="";//当前季度起始时间-1，上个季度结束时间

        try{
            time1=formatTime(year,month,-quarter+1);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        String[] yearAndMonth1=time1.split("-");

        List<IncrementalValue> incrementalValues;
        if(yearAndMonth1[0].equals(year)){
            incrementalValues=incrementalValueMapper.selectBySameYear(yearAndMonth1[0],yearAndMonth1[1],month,reportId,deptCode);
        }
        else {
            incrementalValues=incrementalValueMapper.selectByDifferentYear(yearAndMonth1[0],yearAndMonth1[1],year,month,reportId,deptCode);
        }

        return incrementalValues;
    }

    public String formatTime(String year,String month,Integer num)throws ParseException {
        String time = year + "-" + month;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = format.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, num);
        Date newTime = calendar.getTime();
        String s = format.format(newTime);
        return s;
    }
}

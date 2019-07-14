package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.ReportItemMapper;
import edu.jmu.oscm.mapper.TargetMatchingMapper;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.ReportItem;
import edu.jmu.oscm.model.TargetMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TargetMatchingService {

    @Autowired
    private TargetMatchingMapper targetMatchingMapper;

    public List<TargetMatching> calculateByQuarter(String year, String month, BigInteger reportId,String deptCode,Integer quarter){
        String time1="";//当前季度起始时间-1，上个季度结束时间
        String time2="";//上个季度起始时间-1

        try{
            time1=formatTime(year,month,-quarter);
            time2=formatTime(year,month,-2*quarter);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        String[] yearAndMonth1=time1.split("-");
        String[] yearAndMonth2=time2.split("-");

        List<TargetMatching> targetMatchings;
        if(yearAndMonth1[0].equals(year)){
            targetMatchings=targetMatchingMapper.getTargetMatchingForSameYear(yearAndMonth1[0],yearAndMonth1[1],yearAndMonth2[0],yearAndMonth2[1],
                                                                              year,month,reportId,deptCode);
        }
        else {
            targetMatchings=targetMatchingMapper.getTargetMatchingForDifferentYear(yearAndMonth1[0],yearAndMonth1[1],yearAndMonth2[0],yearAndMonth2[1],
                    year,month,reportId,deptCode);
        }

        return targetMatchings;
    }

    public String formatTime(String year,String month,Integer num)throws ParseException {
        String time=year+"-"+month;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = format.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, num);
        Date newTime = calendar.getTime();
        String s=format.format(newTime);
        return s;
    }
}

package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.ResponsibilityIndicatorMapper;
import edu.jmu.oscm.model.ResponsibilityIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zjm
 * @date 2019/7/5
 */
@Service
public class ResponsibilityIndicatorService {

    @Autowired
    private ResponsibilityIndicatorMapper responsibilityIndicatorMapper;

    public List<ResponsibilityIndicator> calculateForQuarter(String year, String month, BigInteger reportId, String deptCode, Integer quarter){
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

        List<ResponsibilityIndicator> responsibilityIndicators;
        if(yearAndMonth1[0].equals(year)){
            responsibilityIndicators=responsibilityIndicatorMapper.getResponsibilityIndicatorForSameYear(yearAndMonth1[0],yearAndMonth1[1],yearAndMonth2[0],yearAndMonth2[1],
                    year,month,reportId,deptCode);
        }
        else {
            responsibilityIndicators=responsibilityIndicatorMapper.getResponsibilityIndicatorForDifferentYear(yearAndMonth1[0],yearAndMonth1[1],yearAndMonth2[0],yearAndMonth2[1],
                    year,month,reportId,deptCode);
        }
        return responsibilityIndicators;
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

package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.CompletionMapper;
import edu.jmu.oscm.model.Completion;
import edu.jmu.oscm.model.TargetMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zjm
 * @date 2019/7/7
 */
@Service
public class CompletionService {

    @Autowired
    private CompletionMapper completionMapper;

    public List<Completion> calculateByQuarter(String year, String month, BigInteger reportId, String deptCode, Integer quarter){
        String time1="";//当前季度起始时间-1，上个季度结束时间

        try{
            time1=formatTime(year,month,-quarter+1);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        String[] yearAndMonth1=time1.split("-");

        List<Completion> completions;
        if(yearAndMonth1[0].equals(year)){
            completions=completionMapper.selectForSameYear(yearAndMonth1[0],yearAndMonth1[1],month,reportId,deptCode);
        }
        else {
            completions=completionMapper.selectForDifferentYear(yearAndMonth1[0],yearAndMonth1[1],year,month,reportId,deptCode);
        }

//        List<Completion> planTotalValueList;
//        if(Integer.valueOf(month)>=3){//不跨年
//            Integer monthValue=Integer.valueOf(month)-2;
//            planTotalValueList=completionMapper.getSameQuarterPlanValue(year,reportId,deptCode,monthValue);
//        }
//        else {//跨年
//            String lastYear=String.valueOf(Integer.valueOf(year)-1);
//            Integer monthValue=Integer.valueOf(month)+10;
//            planTotalValueList=completionMapper.getSameQuarterPlanValue(lastYear,reportId,deptCode,monthValue);
//        }
//
//        for(Completion completion:completions){
//            for(Completion planTotalValue: planTotalValueList){
//                if(planTotalValue.getItemId().equals(completion.getItemId())){
//                    BigDecimal planTotalReduceValue=planTotalValue.getPlanTotalReduceValue();
//                    if(planTotalReduceValue==null){
//                        planTotalReduceValue=new BigDecimal("0");
//                    }
//                    if(completion.getActualTotalReduceValue()==null){
//                        completion.setActualTotalReduceValue(new BigDecimal("0"));
//                    }
//                    BigDecimal differentValue=completion.getActualTotalReduceValue().subtract(planTotalReduceValue);
//                    completion.setPlanTotalReduceValue(planTotalReduceValue);
//                    completion.setTotalDifference(differentValue);
//                    break;
//                }
//            }
//        }

        return completions;
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

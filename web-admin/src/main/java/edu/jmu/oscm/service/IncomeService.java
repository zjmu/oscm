package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.CredenceMapper;
import edu.jmu.oscm.mapper.IncomeStructMapper;
import edu.jmu.oscm.mapper.IncomeValueMapper;
import edu.jmu.oscm.model.Credence;
import edu.jmu.oscm.model.IncomeStruct;
import edu.jmu.oscm.model.IncomeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class IncomeService {

    @Autowired
    private IncomeStructMapper incomeStructMapper;

    @Autowired
    private IncomeValueMapper incomeValueMapper;

    @Autowired
    private CredenceMapper credenceMapper;

    public List<IncomeValue> service(String localDate){
        List<IncomeValue> incomeValues = new ArrayList<>();

        List<IncomeStruct> incomeStructs = incomeStructMapper.find();
        for(int i=2;i<10;i++)
        {
            IncomeValue income = new IncomeValue();
            Float monthAmount = 0F;
            //先将算式分解
            List<String> forums = new ArrayList<>();
            String monthFourum = incomeStructs.get(i).getMonthForum();
//            if(monthFourum.equals(null)){
//
//            }
            forums.add("begin");
            forums = covent(monthFourum,forums);

            forums.remove(forums.size()-1);
            //计算当年当月
            monthAmount = coculateForMonth(forums, localDate);
            income.setMonthAmount(monthAmount);

            //计算当年的所有月份
            Float yearAmount = monthAmount;
            LocalDate time = LocalDate.parse(localDate + "-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate temp = time;
            Integer nowMonth = time.getMonthValue();
            for (int k = 1; k < nowMonth; k++) {
                temp = temp.minusMonths(1);
                String pastTime = temp.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                yearAmount += coculateForMonth(forums,pastTime);
            }
            income.setYearAmount(yearAmount);
            income.setYear(String.valueOf(time.getYear()));
            income.setIncomeId(incomeStructs.get(i).getIncomeId());
            income.setMonth(String.valueOf(nowMonth));

            java.util.Date date = new java.util.Date();
            Instant instant = date.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
            LocalDate createDate = localDateTime.toLocalDate();

            income.setCreateDate(createDate);
            incomeValues.add(income);
        }
        //incomeValueMapper.addIncomeValue(incomeValues);
        return incomeValues;
    }

    public Float coculateForMonth(List<String> forums, String date){
        //求一项里的所有fs值
        Float monthAmount = 0F;
        for(int j=0;j<forums.size();j++){
            List<Credence> credences;
            Map<String, String> map;
            //解析每个算式里的字段
            map = split(forums.get(j));

            credences = credenceMapper.findBorrowLendLike(map.get("subjectId"), date);
            if(map.get("direction").equals("贷")){
                monthAmount += getLend(credences);
            }
            else {
                monthAmount += getBorrow(credences);
            }
        }
        return monthAmount;
    }

    public List<String> covent(String monthFourum, List<String> forums){

        String pattern1 = "(fs.*?[+|-])(.*)";
        String pattern2 = "(fs.*)";
        Pattern r1 = Pattern.compile(pattern1);
        Matcher m1 = r1.matcher(monthFourum);
        Pattern r2 = Pattern.compile(pattern2);
        Matcher m2 = r2.matcher(monthFourum);
        if(m1.find()){
            forums.remove(forums.size()-1);
            forums.add(m1.group(1));
            forums.add(m1.group(2));
        }
        else if(m2.find()){
            forums.remove(forums.size()-1);
            forums.add(m2.group(0));
            forums.add("end");
        }
        while(forums.get(forums.size()-1) != "end"){
            forums = covent(forums.get(forums.size()-1),forums);
        }
        return forums;
    }

    private Map<String, String> split(String forum){

        Map<String,String> map = new HashMap<>();
        String pattern = "(fs\\()(\\d+)(.*?\")(.*?)(\".*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(forum);
        if(m.find()){
            String subjectId = m.group(2);
            String direction = m.group(4);
            map.put("subjectId", subjectId);
            map.put("direction",direction);
        }
        else{
            map.put("subjectId", null);
            map.put("direction", null);
        }
        return map;
    }

    private Float getLend(List<Credence> credences){
        Float lend = 0F;
        for(int i=0;i<credences.size();i++){
            lend += credences.get(i).getLendMoney();
        }
        return lend;
    }

    private Float getBorrow(List<Credence> credences){
        Float borrow = 0F;
        for(int i=0;i<credences.size();i++){
            borrow += credences.get(i).getBorrowMoney();
        }
        return borrow;
    }
}

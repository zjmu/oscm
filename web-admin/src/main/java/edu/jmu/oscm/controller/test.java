package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.BalanceStructMapper;
import edu.jmu.oscm.mapper.BalanceValueMapper;
import edu.jmu.oscm.mapper.myUserMapper;
import edu.jmu.oscm.model.BalanceStruct;
import edu.jmu.oscm.model.BalanceValue;
import edu.jmu.oscm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class test {

    @Autowired
    private myUserMapper userMapper;

    @Autowired
    private BalanceValueMapper balanceValueMapper;

    @Autowired
    private BalanceStructMapper balanceStructMapper;

    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/add")
    public String add(){
        BalanceValue balanceValue = new BalanceValue();

        balanceValue.setId(1);
        balanceValue.setItem_id(1);
        balanceValue.setYear("2016");
        balanceValue.setMonth("12");
        balanceValue.setBegin_balance(new BigDecimal(2));
        balanceValue.setEnd_balance(new BigDecimal(2));
        balanceValue.setCreate_date(new Timestamp(new Date().getTime()));

        Boolean result = balanceValueMapper.insertValue(balanceValue);

        if(result){
            System.out.println("success");
        }else{
            System.out.println("error");
        }

        return "success";
    }

    @RequestMapping("/selectAll")
    public String selectAll() {

        List<BalanceValue> balanceValues = balanceValueMapper.getAllValue();

        if(balanceValues!=null){
            for (BalanceValue balanceValue : balanceValues) {
                System.out.println(balanceValue.toString());
            }
        }

        return "hello";
    }

    @RequestMapping("/select")
    public String select(){
        BalanceValue balanceValue = balanceValueMapper.selectById(1);

        if(balanceValue!=null){
            System.out.println(balanceValue.toString());
        }else{
            System.out.println("error");
        }

        return "hello";
    }

    @RequestMapping("/insert")
    public String insert() {

        ArrayList<BalanceStruct> arrayList = new ArrayList<>();

        BalanceStruct balanceStruct = new BalanceStruct();

        balanceStruct.setItem_id(1);
        balanceStruct.setName("货币资金");
        balanceStruct.setLine(3);
        balanceStruct.setType_id(0);
        balanceStruct.setCategory(""+"流动资产");
        balanceStruct.setBegin_forum("test");
        balanceStruct.setEnd_forum("test");
        balanceStruct.setCreate_date(new Timestamp(new Date().getTime()));

        arrayList.add(balanceStruct);

        Boolean result = balanceStructMapper.insertStructs(arrayList);

        if(result){
            System.out.println("success");
        }else{
            System.out.println("error");
        }

        return "hello";
    }

    @RequestMapping("/delete")
    public String delete() {

        Boolean result = balanceStructMapper.deleteAll();

        if(result){
            System.out.println("success");
        }else{
            System.out.println("error");
        }

        return "hello";
    }
}

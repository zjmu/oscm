package edu.jmu.oscm;

import edu.jmu.oscm.mapper.BalanceTargetValueMapper;
import edu.jmu.oscm.mapper.ReduceTargetMapper;
import edu.jmu.oscm.mapper.ReportItemMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.ReportItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OscmApplicationTests {

    @Autowired
    private ReportItemMapper reportItemMapper;

    @Autowired
    private ReduceTargetMapper reduceTargetMapper;

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;
    @Test
    public void contextLoads() {
        try{
       //     List<ReportItem>reportItems = reportItemMapper.getReportItemAndItemReduceTarget(new BigInteger("1"),"2018");
            List<BalanceTargetValue> balanceTargetValues = balanceTargetValueMapper.selectAll();
//            List<ReduceTarget> reduceTargets = reduceTargetMapper.selectByItemIdAndYear(new BigInteger("1002"),"2018");
//            System.out.println(reduceTargets.toString());
//            for(ReportItem reportItem:reportItems){
//                System.out.println(reportItem.toString());
//
//            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}

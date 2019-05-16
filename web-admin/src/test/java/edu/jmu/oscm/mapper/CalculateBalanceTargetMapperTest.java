//package edu.jmu.oscm.mapper;
//
//import edu.jmu.oscm.model.BalanceTargetValue;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//public class CalculateBalanceTargetMapperTest {
//
//    @Autowired
//    private CalculateBalanceTargetMapper calculateBalanceTargetMapper;
//    @Test
//    public void selectLastMonthBalance() {
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("year","2019");
//        map.put("month","2");
//        List<BalanceTargetValue> balanceTargetValues = calculateBalanceTargetMapper.selectBase("2019","2");
//        map.put("list",balanceTargetValues);
//        List<Integer> result = calculateBalanceTargetMapper.selectLastMonthBalance(map);
//        for(Integer res:result)
//            System.out.print(res.toString());
//    }
//}
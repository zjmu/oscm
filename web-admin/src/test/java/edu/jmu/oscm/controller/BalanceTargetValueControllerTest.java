package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.BalanceTargetValueMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zjm
 * @Description
 * @date Create in 22:44 2019/5/22
 */
public class BalanceTargetValueControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(BalanceTargetValueControllerTest.class);

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    @Test
    public  void queryAll() {
            List<BalanceTargetValue> result = balanceTargetValueMapper.selectAll();
            String s = result.get(0).getMonth();
            System.out.println(result);
    }
}
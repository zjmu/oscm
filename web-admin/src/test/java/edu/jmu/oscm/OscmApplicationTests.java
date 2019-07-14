package edu.jmu.oscm;

import edu.jmu.oscm.mapper.*;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.Completion;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.ReportItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OscmApplicationTests {

    @Test
    public void contextLoads() throws ParseException {
    }

}

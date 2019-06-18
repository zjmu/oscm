package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface BalanceTargetValueMapper {

    Boolean deleteAll();

    Boolean deleteByDate(@Param(value="year") String year, @Param(value="month") String month);

    Boolean insertMore(List<BalanceTargetValue> balanceTargetValues);

    List<BalanceTargetValue> selectAll();

    List<BalanceTargetValue> selectByDate(@Param(value="year") String year, @Param(value="month") String month);

    BalanceTargetValue selectByDateAndItemId(@Param(value="item_id")BigInteger item_id, @Param(value="year") String year, @Param(value="month") String month);

}

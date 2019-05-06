package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BalanceTargetValueMapper {

    Boolean insert(BalanceTargetValue balanceTargetValue);

    Boolean insertMore(List<BalanceTargetValue> balanceTargetValues);

    Boolean deleteAll();

    Boolean deleteById(Integer id);

    Boolean update(BalanceTargetValue balanceTargetValue);

    //Boolean updateMore(List<BalanceTargetValue> balanceTargetValues);

    List<BalanceTargetValue> selectAll();

    List<BalanceTargetValue> selectByDate(@Param(value="year") String year, @Param(value="month") String month);
}

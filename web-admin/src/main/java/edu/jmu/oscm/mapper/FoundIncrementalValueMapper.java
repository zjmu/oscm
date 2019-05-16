package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoundIncrementalValueMapper {

    List<BalanceTargetValue> selectByDate(@Param(value = "year") String year, @Param(value = "month") String month);
}

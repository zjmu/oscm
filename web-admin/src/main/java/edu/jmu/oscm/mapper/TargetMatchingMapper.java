package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TargetMatchingMapper {
    List<BalanceTargetValue> getTargetMatching(@Param("year")String year,@Param("month")String month);
}

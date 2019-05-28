package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ResponsibilityIndicatorMapper {

    List<BalanceTargetValue> getResponsibilityIndicator(@Param("year")String year, @Param("month")String month);
}

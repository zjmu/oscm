package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ResponsibilityIndicator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResponsibilityIndicatorMapper {

    List<ResponsibilityIndicator> getResponsibilityIndicator(@Param("year")String year, @Param("month")String month);
}

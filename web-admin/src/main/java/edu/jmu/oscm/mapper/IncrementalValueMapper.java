package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.IncrementalValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IncrementalValueMapper {

    List<IncrementalValue> selectByDate(@Param(value = "year") String year, @Param(value = "month") String month);
}

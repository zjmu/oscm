package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.IncentiveRatio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IncentiveRatioMapper {

    List<IncentiveRatio> select(String year);
}

package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ValueCreation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ValueCreationMapper {

    Boolean insert(ValueCreation valueCreation);

    Boolean deleteAll();

    Boolean deleteById(Integer id);

    Boolean update(ValueCreation valueCreation);

    Boolean updates(List<ValueCreation> valueCreations);

    List<ValueCreation> selectAll();

    List<ValueCreation> selectByDate(@Param(value="year") String year, @Param(value="month") String month);
}

package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.IncomeValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncomeValueMapper {

    Boolean addIncomeValue(List<IncomeValue> incomeValues);

    List<IncomeValue> findByDate(String Date);

    Boolean deleteAll();

}

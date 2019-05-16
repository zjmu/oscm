package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.ItemReduceTarget;
import edu.jmu.oscm.model.ReportItemInstance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CalculateBalanceTargetMapper {

    List<BalanceTargetValue> selectBasicTable(@Param(value = "year") String year, @Param(value = "month") String month);

    List<ReportItemInstance> selectEndValue(@Param(value = "year")String year, @Param(value = "month")String month);

    List<ItemReduceTarget> selectItemReduceTarget(String year);
}

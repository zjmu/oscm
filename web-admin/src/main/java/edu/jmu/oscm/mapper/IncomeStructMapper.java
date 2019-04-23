package edu.jmu.oscm.mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.jmu.oscm.model.IncomeStruct;
import javafx.scene.chart.ValueAxis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncomeStructMapper {

    List<IncomeStruct> find();

    Boolean delete(@Param(value = "incomeId") int incomeId);

    Boolean add(@Param(value = "incomeStructs") List<IncomeStruct> incomeStructs,Integer num);

    //Integer searchMaxId();

    Boolean updateById(@Param(value = "incomeId") Integer incomeId);

    Boolean addAll(List<IncomeStruct> incomeStruct);

    Boolean deleteAll();
}

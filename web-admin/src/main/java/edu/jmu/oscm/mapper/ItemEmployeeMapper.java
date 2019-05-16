package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ItemEmployee;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ItemEmployeeMapper {

    List<ItemEmployee> selectItemEmployee(BigInteger reportItemId);
}

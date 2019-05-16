package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ItemDept;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ItemDeptMapper {

    List<ItemDept> selectItemDept(BigInteger reportItemId);
}

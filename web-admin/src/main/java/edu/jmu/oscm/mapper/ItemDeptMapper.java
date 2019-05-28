package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ItemDept;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ItemDeptMapper {

    /**
     * @
     * @description 获取全部部门
     * @parament itemId
     * @return 返回全部部门
     */
    List<ItemDept> selectItemDept(BigInteger itemId);

    /**
     * @
     * @description 获区责任部门
     * @parament itemId
     * @return 责任部门
     */
    List<ItemDept> getResponsibleItemDept(BigInteger itemId);
}

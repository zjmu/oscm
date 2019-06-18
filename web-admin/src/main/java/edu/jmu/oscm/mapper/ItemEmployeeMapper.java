package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ItemEmployee;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ItemEmployeeMapper {

    /**
     * @description 获取主责任人信息
     * @param itemId
     * @author zjm
     */
    List<ItemEmployee> selectItemEmployee(BigInteger itemId);

    /**
     * @description 获取协同责任人信息
     * @param itemId
     */
    List<ItemEmployee> selectCollaborativeEmployee(BigInteger itemId);

    /**
     * @description 获取所有责任人信息
     * @param itemId
     */
    List<ItemEmployee> selectAllItemEmployee(BigInteger itemId);
}

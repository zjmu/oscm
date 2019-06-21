package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface BalanceTargetValueMapper {

    /**
     * @description 删除所有BalanceTargetValue表记录
     * @author zjm
     */
    Boolean deleteAll();

    /**
     * @description 通过日期删除BalanceTargetValue
     * @param year
     * @param month
     * @author zjm
     */
    Boolean deleteByDate(@Param(value="year") String year, @Param(value="month") String month);

    /**
     * @description 增加多条BalanceTargetValue记录
     * @param balanceTargetValues
     * @author zjm
     */
    Boolean insertMore(List<BalanceTargetValue> balanceTargetValues);

    /**
     * @description 查询全部BalanceTargetValue
     * @author zjm
     */
    List<BalanceTargetValue> selectAll();

    /**
     * @description 通过日期查询BalanceTargetValue
     * @param year
     * @param month
     * @author zjm
     */
    List<BalanceTargetValue> selectByDate(@Param(value="year") String year, @Param(value="month") String month);

    BalanceTargetValue selectByDateAndItemId(@Param(value="item_id")BigInteger item_id, @Param(value="year") String year, @Param(value="month") String month);
}

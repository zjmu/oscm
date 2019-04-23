package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zyx
 * @date 19-4-23 下午8:31
 * @email zhangyuxin2009@126.com
 */

@Mapper
public interface BalanceValueMapper {

    Boolean deleteAll();

    Boolean insertValue(BalanceValue balanceValue);

    BalanceValue selectById(int id);

    List<BalanceValue> getAllValue();

    Boolean insertValues(List<BalanceValue> balanceValueList);

}

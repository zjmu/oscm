package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceStruct;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyx
 * @date 19-4-21 下午6:56
 * @email zhangyuxin2009@126.com
 */

@Mapper
public interface BalanceStructMapper {

    /**
     * 清空资产负债表
     * @return
     */
    Boolean deleteAll();

    /**
     * 增加一条
     * @param balanceStruct
     * @return
     */
    Boolean insertStruct(BalanceStruct balanceStruct);

    /**
     * 查找所有记录
     * @return
     */
    List<BalanceStruct> getAllStruct();


    /**
     * 批量增加
     * @param arrayBalanceStruct
     * @return
     */
    Boolean insertStructs(List<BalanceStruct> arrayBalanceStruct);
}

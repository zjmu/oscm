package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.BalanceStruct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zyx
 * @date 19-4-21 下午6:56
 * @email zhangyuxin2009@126.com
 */

@Mapper
public interface BalanceStructMapper {

    /**
     * 清空
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
     * 根据id查找一条
     * @param id
     * @return
     */
    BalanceStruct selectById(int id);



    /**
     * 查找所有记录
     * @return
     */
    List<BalanceStruct> getAllStruct();




    /**
     * 批量增加
     * @param balanceStructList
     * @return
     */
    Boolean insertStructs(List<BalanceStruct> balanceStructList);
}

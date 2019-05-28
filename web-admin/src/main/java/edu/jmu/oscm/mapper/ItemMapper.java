package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zyx
 * @date 19-5-23 下午10:40
 * @email zhangyuxin2009@126.com
 */

@Mapper
public interface ItemMapper {
    /**
     * 增加一条Item记录
     * @param item
     * @return
     */
    boolean insertItem(Item item);

    /**
     * 获取所有Item记录
     * @return
     */
    List<Item> getAllItem();

    /**
     * 根据itemId获取Item记录
     * @param itemId
     * @return
     */
    Item getItemByItemId(@Param("itemId") BigInteger itemId);

    /**
     * 清空item表
     * @return
     */
    boolean deleteAllItem();

    /**
     * 根据itemCode删除item记录
     * @param itemId
     * @return
     */
    boolean deleteItemByItemId(@Param("itemId") int itemId);
}

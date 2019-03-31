package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guantianmin
 * @date 2019/3/12
 */
@Mapper
public interface OrderMapper {
    /**
     * 返回所有订单记录
     *
     * @return 返回所有订单记录
     */
    List<Order> queryAll();
}

package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.OrderMapper;
import edu.jmu.oscm.model.Order;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单demo控制器
 *
 * @author guantianmin
 * @date 2019/3/31 18:44
 */
@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询所有订单记录
     *
     * @api {GET} /orders 查询订单信息
     * @apiName queryAll 查询订单信息
     * @apiGroup api
     * @apiParamExample {json} Request_Example:
     * GET: /orders
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查询订单成功","data":[{"id":1,"name":"order1","goodsNum":1},{"id":2,"name":"order2","goodsNum":2}]}
     */
    @GetMapping("/orders")
    public BasicResponse<List<Order>> queryAll() {
        return BusinessWrapper.wrap(response -> {
            List<Order> orders = orderMapper.queryAll();
            ResponseUtil.set(response, 0, "查询订单成功", orders);
        }, logger);
    }
}

package edu.jmu.oscm.controller;


import edu.jmu.oscm.mapper.ItemMapper;
import edu.jmu.oscm.mapper.ResponsibilityIndicatorMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.Item;
import edu.jmu.oscm.model.Order;
import edu.jmu.oscm.model.ResponsibilityIndicator;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ResponsibilityIndicatorController {
    private static final Logger logger = LoggerFactory.getLogger(ResponsibilityIndicatorController.class);

    @Autowired
    private ResponsibilityIndicatorMapper responsibilityIndicatorMapper;

    /**
     * 查询流动资金占用成本管控责任指标
     * @api {GET} /queryResponsibilityIndicator 查询流动资金占用成本管控责任关键指标
     * @apiName queryResponsibilityIndicator 查询流动资金占用成本管控责任关键指标
     * @apiGroup ResponsibilityIndicator
     * @apiParam {String} year 指定动资金占用成本管控责任关键指标表year值
     * @apiParam {String} month 指定动资金占用成本管控责任关键指标表month值
     * @apiParamExample {json} Request_Example:
     * GET: /queryResponsibilityIndicator？year= &month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{
     *   "code": 0,
     *   "message": "查询流动资金占用成本管控责任指标成功",
     *   "data": [
     *     {
     *       "lastMonthBalance": 622549,
     *       "planMonthTargetValue": 47638.88,
     *       "itemEmployee": null,
     *       "itemDepts": [
     *         {
     *           "id": null,
     *           "itemId": 1001,
     *           "isCharge": 1,
     *           "deptCode": "C500",
     *           "department": {
     *             "id": null,
     *             "deptCode": "C500",
     *             "deptName": "战略客户部公共",
     *             "parentDeptCode": null,
     *             "level": null,
     *             "state": null,
     *             "modifyTime": null
     *           }
     *         },
     *         {
     *           "id": null,
     *           "itemId": 1001,
     *           "isCharge": 0,
     *           "deptCode": "BIZ06",
     *           "department": {
     *             "id": null,
     *             "deptCode": "BIZ06",
     *             "deptName": "其他",
     *             "parentDeptCode": null,
     *             "level": null,
     *             "state": null,
     *             "modifyTime": null
     *           }
     *         }
     *       ],
     *       "itemEmployees": [
     *         {
     *           "id": 1,
     *           "itemId": 1001,
     *           "isCharge": 1,
     *           "employeeId": 449,
     *           "employee": {
     *             "id": 449,
     *             "employeeCode": null,
     *             "simpleCode": null,
     *             "employeeName": "-*-",
     *             "employeeType": null,
     *             "deptCode": null,
     *             "state": null,
     *             "modifyTime": null
     *           }
     *         }
     *       ],
     *       "item": {
     *         "item_code": "资产",
     *         "item_name": "资产",
     *         "calc_expr": "",
     *         "calc_explain": "",
     *         "state": "1",
     *         "modify_date": "2019-04-28T01:54:33.000+0000",
     *         "id": 1001
     *       }
     *     }
     *     ]
     *}
     * */
    @GetMapping("/queryResponsibilityIndicator")
    public BasicResponse<List<ResponsibilityIndicator>> queryResponsibilityIndicator(@RequestParam("year")String year, @RequestParam("month")String month) {
        return BusinessWrapper.wrap(response -> {
            String message;
            List<ResponsibilityIndicator> responsibilityIndicators = responsibilityIndicatorMapper.getResponsibilityIndicator(year,month);
            if(responsibilityIndicators.size()==0){
                message="请先计算当月的值";
                responsibilityIndicators=null;
            }
            else{
                message="查询流动资金占用成本管控责任指标成功";
            }
            ResponseUtil.set(response, 0,message, responsibilityIndicators);
        }, logger);
    }
}

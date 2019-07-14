package edu.jmu.oscm.controller;


import edu.jmu.oscm.mapper.ItemMapper;
import edu.jmu.oscm.mapper.ResponsibilityIndicatorMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.Item;
import edu.jmu.oscm.model.Order;
import edu.jmu.oscm.model.ResponsibilityIndicator;
import edu.jmu.oscm.service.ResponsibilityIndicatorService;
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
    private ResponsibilityIndicatorService responsibilityIndicatorService;

    /**
     * 查询流动资金占用成本管控责任指标
     * @api {GET} /queryResponsibilityIndicator 查询流动资金占用成本管控责任关键指标
     * @apiName queryResponsibilityIndicator 查询流动资金占用成本管控责任关键指标
     * @apiGroup ResponsibilityIndicator
     * @apiParam {String} year 指定年份值
     * @apiParam {String} month 指定月份值
     * @apiParam {BigInteger} reportId 指定reportId值
     * @apiParam {String} deptCode 指定部门编号值
     * @apiParam {Integer} quarter 指定季度值
     * @apiParamExample {json} Request_Example:
     * GET: /queryResponsibilityIndicator?year= &month= &reportId= &deptCode= &quarter=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{
     *     "code": 0,
     *     "message": "查询流动资金占用成本管控责任指标成功",
     *     "data": [
     *         {
     *             "lastQuarterEndValue": null,
     *             "quarterTargetValue": null,
     *             "itemEmployee": null,
     *             "itemDepts": [
     *                 {
     *                     "id": null,
     *                     "itemId": 1001,
     *                     "isCharge": 1,
     *                     "deptCode": "C500",
     *                     "department": {
     *                         "id": null,
     *                         "deptCode": "C500",
     *                         "deptName": "战略客户部公共",
     *                         "parentDeptCode": null,
     *                         "level": null,
     *                         "state": null,
     *                         "modifyTime": null
     *                     }
     *                 },
     *                 {
     *                     "id": null,
     *                     "itemId": 1001,
     *                     "isCharge": 0,
     *                     "deptCode": "B101",
     *                     "department": {
     *                         "id": null,
     *                         "deptCode": "B101",
     *                         "deptName": "桌面产品营销处",
     *                         "parentDeptCode": null,
     *                         "level": null,
     *                         "state": null,
     *                         "modifyTime": null
     *                     }
     *                 }
     *             ],
     *             "itemEmployees": [
     *                 {
     *                     "id": 1,
     *                     "itemId": 1001,
     *                     "isCharge": 1,
     *                     "employeeId": 456,
     *                     "employee": {
     *                         "id": 456,
     *                         "employeeCode": null,
     *                         "simpleCode": null,
     *                         "employeeName": "陈*坤",
     *                         "employeeType": null,
     *                         "deptCode": null,
     *                         "state": null,
     *                         "modifyTime": null
     *                     }
     *                 }
     *             ],
     *             "item": {
     *                 "item_code": "资产",
     *                 "item_name": "资产",
     *                 "calc_expr": "",
     *                 "calc_explain": "",
     *                 "state": "1",
     *                 "modify_date": "2019-04-28T01:54:33.000+0000",
     *                 "id": 1001
     *             }
     *         }
     *         ......
     *     ]
     *}
     * */
    @GetMapping("/queryResponsibilityIndicator")
    public BasicResponse<List<ResponsibilityIndicator>> queryResponsibilityIndicator(@RequestParam("year")String year, @RequestParam("month")String month,@RequestParam("reportId")BigInteger reportId,
                                                                                           @RequestParam("deptCode")String deptCode,@RequestParam("quarter")Integer quarter) {
        return BusinessWrapper.wrap(response -> {
            String message;
            List<ResponsibilityIndicator> responsibilityIndicators = responsibilityIndicatorService.calculateForQuarter(year,month,reportId,deptCode,quarter);
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

package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.TargetMatchingMapper;
import edu.jmu.oscm.model.TargetMatching;
import edu.jmu.oscm.service.TargetMatchingService;
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
public class TargetMatchingController {
    private static final Logger logger= LoggerFactory.getLogger(TargetMatchingController.class);

    @Autowired
    private TargetMatchingService targetMatchingService;

    /**
     * 查询流动资产与流动负债目标匹配表
     * @api {GET} /queryTargetMatching 查询流动资产与流动负债目标匹配表
     * @apiName queryTargetMatching 查询流动资产与流动负债目标匹配表
     * @apiGroup TargetMatching
     * @apiParam {String} year 指定年份值
     * @apiParam {String} month 指定月份值
     * @apiParam {BigInteger} reportId 指定reportId值
     * @apiParam {String} deptCode 指定部门编号值
     * @apiParam {Integer} quarter 指定季度值
     * @apiParamExample {json} Request_Example:
     * GET: /queryTargetMatching?year= &month= &reportId= &deptCode= &quarter=
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
     *             "parentItemCode": "流动资产",
     *             "lastQuarterEndValue": null,
     *             "quarterTargetValue": null,
     *             "itemEmployee": [
     *                 {
     *                     "id": 5,
     *                     "itemId": 1003,
     *                     "isCharge": 1,
     *                     "employeeId": 453,
     *                     "employee": {
     *                         "id": 453,
     *                         "employeeCode": null,
     *                         "simpleCode": null,
     *                         "employeeName": "郭*芸",
     *                         "employeeType": null,
     *                         "deptCode": null,
     *                         "state": null,
     *                         "modifyTime": null
     *                     }
     *                 }
     *             ],
     *             "item": {
     *                 "item_code": "货币资金",
     *                 "item_name": "货币资金",
     *                 "calc_expr": "$1001+$1002+$1009",
     *                 "calc_explain": "现金+银行存款+其他货币资金",
     *                 "state": "1",
     *                 "modify_date": "2019-04-28T01:54:33.000+0000",
     *                 "id": 1003
     *             }
     *         }
     *         ......
     *     ]
     *}
     * */
    @GetMapping("/queryTargetMatching")
    public BasicResponse<List<TargetMatching>> queryTargetMatchingByDeptCode(@RequestParam("year")String year, @RequestParam("month")String month, @RequestParam("reportId")BigInteger reportId,@RequestParam("deptCode")String deptCode,@RequestParam("quarter")Integer quarter) {
        return BusinessWrapper.wrap(response -> {
            String message;
            List<TargetMatching> targetMatchings = targetMatchingService.calculateByQuarter(year,month,reportId,deptCode,quarter);
            if(targetMatchings.size()==0){
                message="请先计算当月的值";
                targetMatchings=null;
            }
            else{
                message="根据部门查询流动资金占用成本管控责任指标成功";
            }
            ResponseUtil.set(response, 0,message, targetMatchings);
        }, logger);
    }
}

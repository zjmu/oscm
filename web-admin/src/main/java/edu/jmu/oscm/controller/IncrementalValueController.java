package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.BalanceTargetValueMapper;
import edu.jmu.oscm.mapper.IncrementalValueMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.Completion;
import edu.jmu.oscm.model.IncrementalValue;
import edu.jmu.oscm.service.IncrementalValueService;
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
import java.util.ArrayList;
import java.util.List;

@RestController
public class IncrementalValueController {
    private static final Logger logger = LoggerFactory.getLogger(CompletionController.class);

    @Autowired
    private IncrementalValueService incrementalValueService;

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    /**
     * 查询流动资金占用成本管控增创价值表
     * @api {GET} /queryIncrementalValue 查询流动资金占用成本管控增创价值表
     * @apiName queryIncrementalValue 查询流动资金占用成本管控增创价值表
     * @apiGroup IncrementalValue
     * @apiParam {String} year 指定年份值
     * @apiParam {String} month 指定月份值
     * @apiParam {BigInteger} reportId  指定reportId值
     * @apiParam {String} deptCode 指定部门编号值
     * @apiParam {Integer} quarter 指定季度值
     * @apiParamExample {json} Request_Example:
     * GET: /queryIncrementalValue?year= &month= &reportId= &deptCode= &quarter=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{
     *     "code": 0,
     *     "message": "根据部门查询流动资金占用成本管控目标完成情况成功",
     *     "data": [
     *         {
     *             "quarterActualTargetValue": 233.00,
     *             "actualTotalReduceValue": 6161.00,
     *             "quarterIncrementalValue": 0.00,
     *             "totalIncrementalValue": 0.00,
     *             "itemDept": [
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
    @GetMapping("/queryIncrementalValue")
    public BasicResponse<List<IncrementalValue>> queryIncrementalValue(@RequestParam(value = "year") String year, @RequestParam(value = "month") String month, @RequestParam("reportId") BigInteger reportId,
                                                                             @RequestParam("deptCode")String deptCode,@RequestParam("quarter")Integer quarter) {
        return BusinessWrapper.wrap(response -> {
            String message;
            List<IncrementalValue> incrementalValues=new ArrayList<>();
            List<BalanceTargetValue> balanceTargetValues=balanceTargetValueMapper.selectByDate(year,month);
            if(balanceTargetValues.size()==0){
                message="请先计算当月的值";
            }
            else{
                incrementalValues=incrementalValueService.calculateByQuarter(year,month,reportId,deptCode,quarter);
                message = "查询流动资金占用成本管控目标完成情况成功";
            }
            ResponseUtil.set(response, 0, message, incrementalValues);
        }, logger);
    }
}

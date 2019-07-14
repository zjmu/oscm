package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.BalanceTargetValueMapper;
import edu.jmu.oscm.mapper.CompletionMapper;

import edu.jmu.oscm.mapper.ProportionMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.Completion;
import edu.jmu.oscm.model.ReportItemInstance;
import edu.jmu.oscm.service.CompletionService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class CompletionController {
    private static final Logger logger = LoggerFactory.getLogger(CompletionController.class);

    @Autowired
    private CompletionService completionService;

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    /**
     * 查询流动资金占用成本管控目标完成情况分析
     * @api {GET} /queryCompletion 查询流动资金占用成本管控目标完成情况分析
     * @apiName queryCompletion 查询流动资金占用成本管控目标完成情况分析
     * @apiGroup Completion
     * @apiParam {String} year 指定年份值
     * @apiParam {String} month 指定月份值
     * @apiParam {BigInteger} reportId 指定reportId值
     * @apiParam {String} deptCode 指定部门编号值
     * @apiParam {Integer} quarter 指定季度值
     * @apiParamExample {json} Request_Example:
     * GET: /queryCompletion?year= &month= &reportId= &deptCode= &quarter=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{
     *     "code": 0,
     *     "message": "查询流动资金占用成本管控目标完成情况成功",
     *     "data": [
     *         {
     *             "itemId": "1001",
     *             "quarterPlanValue": 47638.88,
     *             "planTotalReduceValue": 142916.63,
     *             "quarterActualValue": 233.00,
     *             "actualTotalReduceValue": 6161.00,
     *             "totalDifference": -136755.63,
     *             "item": {
     *                 "item_code": "资产",
     *                 "item_name": "资产",
     *                 "calc_expr": "",
     *                 "calc_explain": "",
     *                 "state": "1",
     *                 "modify_date": "2019-04-28T01:54:33.000+0000",
     *                 "id": 1001
     *             },
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
     *             ]
     *         }
     *         ......
     *         ]
     * }
     * */
    @GetMapping("/queryCompletion")
    public BasicResponse<List<Completion>> queryCompletion(@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("reportId")BigInteger reportId,@RequestParam("deptCode")String deptCode,@RequestParam("quarter")Integer quarter) {

        return BusinessWrapper.wrap(response -> {
            String message;
            List<Completion> completions=new ArrayList<>();
            List<BalanceTargetValue> balanceTargetValues=balanceTargetValueMapper.selectByDate(year,month);
            if(balanceTargetValues.size()==0){
                message="请先计算当月的值";
            }
            else{
                completions=completionService.calculateByQuarter(year,month,reportId,deptCode,quarter);
                message = "查询流动资金占用成本管控目标完成情况成功";
            }
            ResponseUtil.set(response, 0,message,completions);
        }, logger);
    }
}

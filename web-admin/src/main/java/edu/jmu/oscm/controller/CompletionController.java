package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.CompletionMapper;

import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.Completion;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CompletionController {
    private static final Logger logger = LoggerFactory.getLogger(CompletionController.class);

    @Autowired
    private CompletionMapper completionMapper;

    /**
     * 查询流动资金占用成本管控目标完成情况分析
     * @api {GET} /queryCompletion 查询流动资金占用成本管控目标完成情况分析
     * @apiName queryCompletion 查询流动资金占用成本管控目标完成情况分析
     * @apiGroup Completion
     * @apiParam {String} year 指定流动资金占用成本管控目标完成情况分析year值
     * @apiParam {String} month 指定流动资金占用成本管控目标完成情况分析month值
     * @apiParamExample {json} Request_Example:
     * GET: /queryCompletion?year= &month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{
     *   "code": 0,
     *   "message": "查询流动资金占用成本管控目标完成情况成功",
     *   "data": [
     *     {
     *       "planMonthTargetValue": 47638.88,
     *       "planTotalReduceValue": 142916.63,
     *       "actualMonthTargetValue": 476,
     *       "actualTotalReduceValue": 183963,
     *       "totalDifference": 41046.37,
     *       "item": {
     *         "item_code": "资产",
     *         "item_name": "资产",
     *         "calc_expr": "",
     *         "calc_explain": "",
     *         "state": "1",
     *         "modify_date": "2019-04-28T01:54:33.000+0000",
     *         "id": 1001
     *       },
     *       "itemDept": [
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
     *         }
     *       ]
     *     }
     *    ]
     *}
     * */
    @GetMapping("/queryCompletion")
    public BasicResponse<List<Completion>> queryCompletion(@RequestParam(value = "year") String year, @RequestParam(value = "month") String month) {

        return BusinessWrapper.wrap(response -> {
            String message;
            List<Completion> completions = completionMapper.selectByDate(year,month);
            if(completions.size()==0){
                message="请先计算当月的值";
            }
            else{
                BigDecimal actualTotal;
                BigDecimal planTotal;
                for(int i=0;i<completions.size();i++){
                    actualTotal = completions.get(i).getActualTotalReduceValue();
                    planTotal = completions.get(i).getPlanTotalReduceValue();
                    completions.get(i).setTotalDifference(actualTotal.subtract(planTotal));
                }
                message = "查询流动资金占用成本管控目标完成情况成功";
            }
            ResponseUtil.set(response, 0,message,completions);
        }, logger);
    }
}

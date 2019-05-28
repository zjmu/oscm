package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.CompletionMapper;

import edu.jmu.oscm.model.BalanceTargetValue;
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
     *{"code":0,"message":"查询流动资金占用成本管控目标完成情况成功","data":{
     * "totalDifference":[935.00],
     * "foundCosts":[
     * {"id":null,"reportItemId":1,"year":"2018","month":"03","lastMonthBalance":null,"planMonthTargetValue":33.00,"planTotalReduceValue":166.00,
     * "actualMonthTargetValue":1091.00,"actualTotalReduceValue":1101.00,"monthIncrementalValue":null,"totalIncrementalValue":null,"monthReward":null,"totalReward":null,"createDate":null,
     * "itemDept":[
     * {"id":null,"reportItemId":1,"isCharge":1,"deptCode":"C500",
     * "department":
     * {"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}},
     * {"id":null,"reportItemId":1,"isCharge":0,"deptCode":"C500",
     * "department":
     * {"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}}],"itemEmployee":null,
     * "reportItemInstance":
     * {"id":null,"reportItemId":null,"reportCode":null,"reportName":null,"objectType":null,"objectId":null,"itemCode":null,"itemName":"货币资金","orderNum":null,"year":null,"month":null,"beginValue":null,"value":null,"endValue":null,"modifyTime":null}}]}
     * }
     * */
    @GetMapping("/queryCompletion")
    public BasicResponse<Map<String,Object>> queryCompletion(@RequestParam(value = "year") String year, @RequestParam(value = "month") String month) {

        return BusinessWrapper.wrap(response -> {
            String message;
            Map<String,Object> map = new HashMap<>();
            List<BalanceTargetValue> completion = completionMapper.selectByDate(year,month);
            if(completion.size()==0){
                message="请先计算当月的值";
                map=null;
            }
            else{
                List<BigDecimal> totalDifference = new ArrayList<>();
                BigDecimal actualTotal;
                BigDecimal planTotal;
                for(int i=0;i<completion.size();i++){
                    actualTotal = completion.get(i).getActualTotalReduceValue();
                    planTotal = completion.get(i).getPlanTotalReduceValue();
                    totalDifference.add(actualTotal.subtract(planTotal));
                }
                map.put("completion",completion);
                map.put("totalDifference",totalDifference);
                message = "查询流动资金占用成本管控目标完成情况成功";
            }

            ResponseUtil.set(response, 0,message, map);
        }, logger);
    }
}

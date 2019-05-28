package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.IncrementalValueMapper;
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

import java.util.List;

@RestController
public class IncrementalValueController {
    private static final Logger logger = LoggerFactory.getLogger(CompletionController.class);

    @Autowired
    private IncrementalValueMapper incrementalValueMapper;

    /**
     * 查询流动资金占用成本管控增创价值表
     * @api {GET} /queryIncrementalValue 查询流动资金占用成本管控增创价值表
     * @apiName queryIncrementalValue 查询流动资金占用成本管控增创价值表
     * @apiGroup IncrementalValue
     * @apiParam {String} year 指定流动资金占用成本管控增创价值表year值
     * @apiParam {String} month 指定流动资金占用成本管控增创价值表month值
     * @apiParamExample {json} Request_Example:
     * GET: /queryIncrementalValue?year= &month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"查询流动资金占用成本管控增创价值成功","data":[
     * {"id":null,"reportItemId":1,"year":"2018","month":"03","lastMonthBalance":null,"planMonthTargetValue":null,"planTotalReduceValue":null,"actualMonthTargetValue":1091.00,
     * "actualTotalReduceValue":1101.00,"monthIncrementalValue":12273.75,"totalIncrementalValue":12386.25,"monthReward":172077.98,"totalReward":173655.23,"createDate":null,
     * "itemDept":[
     * {"id":null,"reportItemId":1,"isCharge":1,"deptCode":"C500","department":{"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}},
     * {"id":null,"reportItemId":1,"isCharge":0,"deptCode":"C500","department":{"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}}],
     * "itemEmployee":null,
     * "reportItemInstance":
     * {"id":null,"reportItemId":null,"reportCode":null,"reportName":null,"objectType":null,"objectId":null,"itemCode":null,"itemName":"货币资金","orderNum":null,"year":null,"month":null,"beginValue":null,"value":null,"endValue":null,"modifyTime":null}}]
     * }
     * */
    @GetMapping("/queryIncrementalValue")
    public BasicResponse<List<BalanceTargetValue>> queryIncrementalValue(@RequestParam(value = "year") String year, @RequestParam(value = "month") String month) {
        return BusinessWrapper.wrap(response -> {
            String message;
            List<BalanceTargetValue> incrementalValues = incrementalValueMapper.selectByDate(year,month);
            if(incrementalValues.size()==0){
                message="请先计算当月的值";
                incrementalValues=null;
            }
            else{
                message="查询流动资金占用成本管控增创价值成功";
            }
            ResponseUtil.set(response, 0, message, incrementalValues);
        }, logger);
    }
}

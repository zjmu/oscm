package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.FoundIncrementalValueMapper;
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
public class FoundIncrementalValueController {
    private static final Logger logger = LoggerFactory.getLogger(FoundCostController.class);

    @Autowired
    private FoundIncrementalValueMapper foundIncrementalValueMapper;

    /**
     * 查询流动资金占用成本管控增创价值表
     * @api {GET} /queryFoundIncrementalValue 查询流动资金占用成本管控增创价值表
     * @apiName queryFoundIncrementalValue 查询流动资金占用成本管控增创价值表
     * @apiGroup FoundIncrementalValue
     * @apiParam {String} year 指定流动资金占用成本管控增创价值表year值
     * @apiParam {String} month 指定流动资金占用成本管控增创价值表month值
     * @apiParamExample {json} Request_Example:
     * GET: /queryFoundIncrementalValue?year= month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"查询订单成功","data":[
     * {"id":null,"reportItemId":1,"year":"2019","month":"3","lastMonthBalance":null,"planMonthTargetValue":null,"planTotalReduceValue":null,"actualMonthTargetValue":1091.00,
     * "actualTotalReduceValue":1101.00,"monthIncrementalValue":12273.75,"totalIncrementalValue":12386.25,"monthReward":172077.98,"totalReward":173655.23,"createDate":null,
     * "itemDept":[
     * {"id":null,"reportItemId":1,"isCharge":1,"deptCode":"C500","department":{"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}},
     * {"id":null,"reportItemId":1,"isCharge":0,"deptCode":"C500","department":{"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}}],
     * "itemEmployee":null,
     * "reportItemInstance":
     * {"id":null,"reportItemId":null,"reportCode":null,"reportName":null,"objectType":null,"objectId":null,"itemCode":null,"itemName":"货币资金","orderNum":null,"year":null,"month":null,"beginValue":null,"value":null,"endValue":null,"modifyTime":null}}]
     * }
     * */
    @GetMapping("/queryFoundIncrementalValue")
    public BasicResponse<List<BalanceTargetValue>> queryFoundIncrementalValue(@RequestParam(value = "year") String year, @RequestParam(value = "month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<BalanceTargetValue> foundIncrementalValues = foundIncrementalValueMapper.selectByDate(year,month);
            ResponseUtil.set(response, 0, "查询订单成功", foundIncrementalValues);
        }, logger);
    }
}

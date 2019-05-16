package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.TargetMatchingMapper;
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
public class TargetMatchingController {
    private static final Logger logger= LoggerFactory.getLogger(TargetMatchingController.class);
    @Autowired
    private TargetMatchingMapper targetMatchingMapper;

    /**
     * 查询流动资产与流动负债目标匹配表
     * @api {GET} /queryTargetMatching 查询流动资产与流动负债目标匹配表
     * @apiName queryTargetMatching 查询流动资产与流动负债目标匹配表
     * @apiGroup TargetMatching
     * @apiParam {String} year 指定流动资产与流动负债目标匹配表year值
     * @apiParam {String} month 指定流动资产与流动负债目标匹配表month值
     * @apiParamExample {json} Request_Example:
     * GET: /queryTargetMatching?year= month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"查询订单成功","data":[
     * {"id":null,"reportItemId":1,"year":"2019","month":"3","lastMonthBalance":20.00,"planMonthTargetValue":33.00,"planTotalReduceValue":null,"actualMonthTargetValue":null,
     * "actualTotalReduceValue":null,"monthIncrementalValue":null,"totalIncrementalValue":null,"monthReward":null,"totalReward":null,"createDate":null,"itemDept":null,
     * "itemEmployee":[
     * {"id":1,"reportItemId":1,"isCharge":0,"employeeId":449,"employee":
     * {"id":449,"employeeCode":null,"simpleCode":null,"employeeName":"-*-","employeeType":null,"deptCode":null,"state":null,"modifyTime":null}},
     * {"id":5,"reportItemId":1,"isCharge":1,"employeeId":453,"employee":
     * {"id":453,"employeeCode":null,"simpleCode":null,"employeeName":"郭*芸","employeeType":null,"deptCode":null,"state":null,"modifyTime":null}}],
     * "reportItemInstance":
     * {"id":null,"reportItemId":null,"reportCode":null,"reportName":null,"objectType":null,"objectId":null,"itemCode":null,"itemName":"货币资金","orderNum":null,"year":null,"month":null,"beginValue":null,"value":null,"endValue":null,"modifyTime":null}}]
     * }
     * */
    @GetMapping("/queryTargetMatching")
    public BasicResponse<List<BalanceTargetValue>> queryTargetMatching(@RequestParam("year")String year, @RequestParam("month")String month) {
        return BusinessWrapper.wrap(response -> {
            List<BalanceTargetValue> result = targetMatchingMapper.getTargetMatching(year,month);
            ResponseUtil.set(response, 0, "查询订单成功", result);
        }, logger);
    }
}

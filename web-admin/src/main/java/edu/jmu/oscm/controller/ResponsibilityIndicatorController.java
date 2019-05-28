package edu.jmu.oscm.controller;


import edu.jmu.oscm.mapper.ItemMapper;
import edu.jmu.oscm.mapper.ResponsibilityIndicatorMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.oscm.model.Item;
import edu.jmu.oscm.model.Order;
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

    @Autowired
    private ItemMapper itemMapper;

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
     *{"code":0,"message":"查询流动资金占用成本管控责任指标成功","data":[
     * {"id":null,"reportItemId":1,"year":"2018","month":"03","lastMonthBalance":20.00,"planMonthTargetValue":33.00,"planTotalReduceValue":null,
     * "actualMonthTargetValue":null,"actualTotalReduceValue":null,"monthIncrementalValue":null,"totalIncrementalValue":null,"monthReward":null,
     * "totalReward":null,"createDate":null,
     * "itemDept":[
     * {"id":null,"reportItemId":1,"isCharge":1,"deptCode":"C500","
     * department":
     * {"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}},
     * {"id":null,"reportItemId":1,"isCharge":0,"deptCode":"C500",
     * "department":
     * {"id":null,"deptCode":"C500","deptName":"战略客户部公共","parentDeptCode":null,"level":null,"state":null,"modifyTime":null}}
     * ],
     * "itemEmployee":[
     * {"id":1,"reportItemId":1,"isCharge":0,"employeeId":449,
     * "employee":
     * {"id":449,"employeeCode":null,"simpleCode":null,"employeeName":"-*-","employeeType":null,"deptCode":null,"state":null,"modifyTime":null}},
     * {"id":5,"reportItemId":1,"isCharge":1,"employeeId":453,
     * "employee":
     * {"id":453,"employeeCode":null,"simpleCode":null,"employeeName":"郭*芸","employeeType":null,"deptCode":null,"state":null,"modifyTime":null}}
     * ],
     * "reportItemInstance":
     * {"id":null,"reportItemId":null,"reportCode":null,"reportName":null,"objectType":null,"objectId":null,"itemCode":null,"itemName":"货币资金","orderNum":null,"year":null,"month":null,"beginValue":null,"value":null,"endValue":null,"modifyTime":null}}]
     * }
     * */
    @GetMapping("/queryResponsibilityIndicator")
    public BasicResponse<List<BalanceTargetValue>> queryResponsibilityIndicator(@RequestParam("year")String year,@RequestParam("month")String month) {
        return BusinessWrapper.wrap(response -> {
            String message;
            List<BalanceTargetValue> result = responsibilityIndicatorMapper.getResponsibilityIndicator(year,month);
            if(result.size()==0){
                message="请先计算当月的值";
                result=null;
            }
            else{
                message="查询流动资金占用成本管控责任指标成功";
            }
            ResponseUtil.set(response, 0,message, result);
        }, logger);
    }
}

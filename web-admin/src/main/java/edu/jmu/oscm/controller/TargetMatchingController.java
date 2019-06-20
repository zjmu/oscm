package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.TargetMatchingMapper;
import edu.jmu.oscm.model.TargetMatching;
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
     * GET: /queryTargetMatching?year= &month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{
     *   "code": 0,
     *   "message": "查询流动资金占用成本管控责任指标成功",
     *   "data": [
     *     {
     *       "parentItemCode": "流动资产",
     *       "lastMonthBalance": 622557,
     *       "planMonthTargetValue": 42875.03,
     *       "itemEmployee": [
     *         {
     *           "id": 5,
     *           "itemId": 1003,
     *           "isCharge": 1,
     *           "employeeId": 453,
     *           "employee": {
     *             "id": 453,
     *             "employeeCode": null,
     *             "simpleCode": null,
     *             "employeeName": "郭*芸",
     *             "employeeType": null,
     *             "deptCode": null,
     *             "state": null,
     *             "modifyTime": null
     *           }
     *         }
     *       ],
     *       "item": {
     *         "item_code": "货币资金",
     *         "item_name": "货币资金",
     *         "calc_expr": "$1001+$1002+$1009",
     *         "calc_explain": "现金+银行存款+其他货币资金",
     *         "state": "1",
     *         "modify_date": "2019-04-28T01:54:33.000+0000",
     *         "id": 1003
     *       }
     *     }
     *     ]
     *}
     * */
    @GetMapping("/queryTargetMatching")
    public BasicResponse<List<TargetMatching>> queryTargetMatching(@RequestParam("year")String year, @RequestParam("month")String month) {
        return BusinessWrapper.wrap(response -> {
            String message;
            List<TargetMatching> targetMatchings = targetMatchingMapper.getTargetMatching(year,month);
            if(targetMatchings.size()==0){
                message="请先计算当月的值";
                targetMatchings=null;
            }
            else{
                message="查询流动资金占用成本管控责任指标成功";
            }
            ResponseUtil.set(response, 0,message, targetMatchings);
        }, logger);
    }
}

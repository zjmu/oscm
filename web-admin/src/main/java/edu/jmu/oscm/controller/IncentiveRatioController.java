package edu.jmu.oscm.controller;

import edu.jmu.oscm.model.IncentiveRatio;
import edu.jmu.oscm.service.IncentiveRatioService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncentiveRatioController {
    private static final Logger logger = LoggerFactory.getLogger(IncentiveRatioController.class);

    @Autowired
    private IncentiveRatioService incentiveRatioService;

    /**
     * 查询所有部门奖励比例
     *
     * @api {GET} /queryIncentiveRatios  查询所有部门奖励比例
     * @apiName queryIncentiveRatios 查询所有部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParamExample {json} Request_Example:
     * GET: /queryIncentiveRatios
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * ("code":0, "message":"查询所有部门奖励比例成功",
     * "data":[
     *      {
     *          "id":200,
     *          "year":"2018",
     *          "interest_rate":15.01,
     *          "incentive_ratio":15.01,
     *          "max_limit":15.01,
     *          "create_date":2019-05-08T11:20:12.000+0000
     *      },
     *      {
     *          "id":201,
     *          "year":"2019",
     *          "interest_rate":25.02,
     *          "incentive_ratio":25.02,
     *          "max_limit":25.02,
     *          "create_date":2019-05-08T11:20:36.000+0000
     *      }
     * ])
     * */
    @GetMapping("/queryIncentiveRatios")
    public BasicResponse<List<IncentiveRatio>> queryAll(){
        return BusinessWrapper.wrap(response -> {
            List<IncentiveRatio> incentiveRatios = incentiveRatioService.queryAll();
            ResponseUtil.set(response, 0,"查询所有部门奖励比例成功",incentiveRatios);
        },logger);
    }

    /**
     * 查询指定部门奖励比例
     *
     * @api {GET} /queryIncentiveRatio?id=  查询指定部门奖励比例
     * @apiName queryIncentiveRatio 查询指定部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParam {int} id 指定部门奖励比例id
     * @apiParamExample {json} Request_Example:
     * GET: /queryIncentiveRatio?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * ("code":0, "message":"查询指定部门奖励比例成功",
     * "data":{
     *          "id":200,
     *          "year":"2018",
     *          "interest_rate":15.01,
     *          "incentive_ratio":15.01,
     *          "max_limit":15.01,
     *          "create_date":2019-05-08T11:20:12.000+0000
     * }
     * */
    @GetMapping("/queryIncentiveRatio")
    public BasicResponse<IncentiveRatio> queryByID(@RequestParam("id") int id){
        return BusinessWrapper.wrap(response ->{
            IncentiveRatio incentiveRatio = incentiveRatioService.queryByID(id);
            ResponseUtil.set(response,0,"查询指定部门奖励比例成功",incentiveRatio);
        },logger);
    }

    /**
     * 添加一条部门奖励比例
     *
     * @api {POST} /addIncentiveRatio 添加一条部门奖励比例成功
     * @apiName addIncentiveRatio 添加一条部门奖励比例成功
     * @apiGroup IncentiveRatio
     * @apiParam {String} year 年份（每年一月，设置）
     * @apiParam {BigDecimal} interest_rate 利率
     * @apiParam {BigDecimal} incentive_ratio 奖励比例
     * @apiParam {BigDecimal} max_limit 大额资金限制
     * @apiParamExample {json} Request_Example:
     * {
     *          "year":"2019",
     *          "interest_rate":35.03,
     *          "incentive_ratio":35.03,
     *          "max_limit":35.03
     * }
     * POST: /addIncentiveRatio
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"添加一条部门奖励比例成功", "data":true}
     */
    @PostMapping("/addIncentiveRatio")
    public BasicResponse<Boolean> add(@RequestBody IncentiveRatio incentiveRatio){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.add(incentiveRatio);
            ResponseUtil.set(response,0,"添加一条部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 删除指定部门奖励比例
     *
     * @api {DELETE} /deleteIncentiveRatio?id= 删除指定部门奖励比例
     * @apiName deleteIncentiveRatio 删除指定部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParam {int} id 指定部门奖励比例id
     * @apiParamExample {json} Request_Example:
     * DELETE: /deleteIncentiveRatio?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除指定部门奖励比例成功", "data":true}
     */
    @DeleteMapping("/deleteIncentiveRatio")
    public BasicResponse<Boolean> deleteByID(@RequestParam("id") int id){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.deleteByID(id);
            ResponseUtil.set(response,0,"删除指定部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 删除所有部门奖励比例
     *
     * @api {DELETE} /deleteIncentiveRatios 删除所有部门奖励比例
     * @apiName deleteIncentiveRatios 删除所有部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParamExample {json} Request_Example:
     * DELETE: /deleteIncentiveRatios
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除所有部门奖励比例成功", "data":true}
     */
    @DeleteMapping("/deleteIncentiveRatios")
    public BasicResponse<Boolean> deleteAll(){
        return BusinessWrapper.wrap(response->{
            Boolean flag = incentiveRatioService.deleteAll();
            ResponseUtil.set(response,0,"删除所有部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 更改指定部门奖励比例成功
     *
     * @api {PUT} /updateIncentiveRatio 更改指定部门奖励比例成功
     * @apiName updateIncentiveRatio 更改指定部门奖励比例成功
     * @apiGroup IncentiveRatio
     * @apiParam {int} id 指定部门奖励比例id
     * @apiParam {String} year 年份（每年一月，设置）
     * @apiParam {BigDecimal} interest_rate 利率
     * @apiParam {BigDecimal} incentive_ratio 奖励比例
     * @apiParam {BigDecimal} max_limit 大额资金限制
     * @apiParamExample {json} Request_Example:
     * {
     *          "id":200,
     *          "year":"2019",
     *          "interest_rate":35.03,
     *          "incentive_ratio":35.03,
     *          "max_limit":35.03
     * }
     * POST: /updateIncentiveRatio
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更改指定部门奖励比例成功", "data":true}
     */
    @PutMapping("/updateIncentiveRatio")
    public BasicResponse<Boolean> update(@RequestBody IncentiveRatio incentiveRatio){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.update(incentiveRatio);
            ResponseUtil.set(response,0,"更改指定部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 批量更改部门奖励比例成功
     *
     * @api {PUT} /updateIncentiveRatios 更改指定部门奖励比例成功
     * @apiName updateIncentiveRatios 更改指定部门奖励比例成功
     * @apiGroup IncentiveRatio
     * @apiParam {int} id 指定部门奖励比例id
     * @apiParam {String} year 年份（每年一月，设置）
     * @apiParam {BigDecimal} interest_rate 利率
     * @apiParam {BigDecimal} incentive_ratio 奖励比例
     * @apiParam {BigDecimal} max_limit 大额资金限制
     * @apiParamExample {json} Request_Example:
     * [
     *      {
     *          "id":200,
     *          "year":"2019",
     *          "interest_rate":35.03,
     *          "incentive_ratio":35.03,
     *          "max_limit":35.03
     *      },
     *      {
     *          "id":201,
     *          "year":"2019",
     *          "interest_rate":45.04,
     *          "incentive_ratio":45.04,
     *          "max_limit":45.04
     *      }
     * ]
     * POST: /updateIncentiveRatios
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"批量更改部门奖励比例成功", "data":true}
     */
    @PutMapping("/updateIncentiveRatios")
    public BasicResponse<Boolean> updates(@RequestBody List<IncentiveRatio> incentiveRatios){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.updates(incentiveRatios);
            ResponseUtil.set(response,0,"批量更改部门奖励比例成功",flag);
        },logger);
    }
}

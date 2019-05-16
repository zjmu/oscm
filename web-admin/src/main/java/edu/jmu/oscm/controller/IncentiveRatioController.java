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
     * @api {GET} /incentiveRatios  查询所有部门奖励比例
     * @apiName queryAllIncentiveRatios 查询所有部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParamExample {json} Request_Example:
     * GET: /incentiveRatios
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
     *          "interest_rate":10.01,
     *          "incentive_ratio":12.01,
     *          "max_limit":15.02,
     *          "create_date":2019-05-09T13:14:48.000+0000
     *      },
     *      {
     *          "id":201,
     *          "year":"2018",
     *          "interest_rate":12.55,
     *          "incentive_ratio":14,
     *          "max_limit":18.1,
     *          "create_date":2019-05-09T13:15:01.000+0000
     *      }
     * ])
     * */
    @GetMapping("/incentiveRatios")
    public BasicResponse<List<IncentiveRatio>> queryAll(){
        return BusinessWrapper.wrap(response -> {
            List<IncentiveRatio> incentiveRatios = incentiveRatioService.queryAll();
            ResponseUtil.set(response, 0,"查询所有部门奖励比例成功",incentiveRatios);
        },logger);
    }

    /**
     * 查询指定部门奖励比例
     *
     * @api {GET} /incentiveRatio?id=  查询指定部门奖励比例
     * @apiName queryIncentiveRatio 查询指定部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParam {int} id 指定部门奖励比例id
     * @apiParamExample {json} Request_Example:
     * GET: /incentiveRatio?id=200
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
     *          "interest_rate":10.01,
     *          "incentive_ratio":12.01,
     *          "max_limit":15.02,
     *          "create_date":2019-05-09T13:14:48.000+0000
     *      }
     * */
    @GetMapping("/incentiveRatio")
    public BasicResponse<IncentiveRatio> queryByID(@RequestParam("id") int id){
        return BusinessWrapper.wrap(response ->{
            IncentiveRatio incentiveRatio = incentiveRatioService.queryByID(id);
            ResponseUtil.set(response,0,"查询指定部门奖励比例成功",incentiveRatio);
        },logger);
    }

    /**
     * 添加一条部门奖励比例
     *
     * @api {POST} /incentiveRatio 添加一条部门奖励比例
     * @apiName addIncentiveRatio 添加一条部门奖励比例
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
     * POST: /incentiveRatio
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
    @PostMapping("/incentiveRatio")
    public BasicResponse<Boolean> add(@RequestBody IncentiveRatio incentiveRatio){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.add(incentiveRatio);
            ResponseUtil.set(response,0,"添加一条部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 删除指定部门奖励比例
     *
     * @api {DELETE} /incentiveRatio?id= 删除指定部门奖励比例
     * @apiName deleteIncentiveRatio 删除指定部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParam {int} id 指定部门奖励比例id
     * @apiParamExample {json} Request_Example:
     * DELETE: /incentiveRatio?id=211
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
    @DeleteMapping("/incentiveRatio")
    public BasicResponse<Boolean> deleteByID(@RequestParam("id") int id){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.deleteByID(id);
            ResponseUtil.set(response,0,"删除指定部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 删除所有部门奖励比例
     *
     * @api {DELETE} /incentiveRatios 删除所有部门奖励比例
     * @apiName deleteAllIncentiveRatios 删除所有部门奖励比例
     * @apiGroup IncentiveRatio
     * @apiParamExample {json} Request_Example:
     * DELETE: /incentiveRatios
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
    @DeleteMapping("/incentiveRatios")
    public BasicResponse<Boolean> deleteAll(){
        return BusinessWrapper.wrap(response->{
            Boolean flag = incentiveRatioService.deleteAll();
            ResponseUtil.set(response,0,"删除所有部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 更改指定部门奖励比例
     *
     * @api {PUT} /incentiveRatio 更改指定部门奖励比例
     * @apiName updateIncentiveRatio 更改指定部门奖励比例
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
     * PUT: /incentiveRatio
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
    @PutMapping("/incentiveRatio")
    public BasicResponse<Boolean> update(@RequestBody IncentiveRatio incentiveRatio){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.update(incentiveRatio);
            ResponseUtil.set(response,0,"更改指定部门奖励比例成功",flag);
        },logger);
    }

    /**
     * 批量更改部门奖励比例
     *
     * @api {PUT} /incentiveRatios 批量更改部门奖励比例
     * @apiName updateIncentiveRatios 批量更改部门奖励比例
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
     * PUT: /incentiveRatios
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
    @PutMapping("/incentiveRatios")
    public BasicResponse<Boolean> updates(@RequestBody List<IncentiveRatio> incentiveRatios){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = incentiveRatioService.updates(incentiveRatios);
            ResponseUtil.set(response,0,"批量更改部门奖励比例成功",flag);
        },logger);
    }
}

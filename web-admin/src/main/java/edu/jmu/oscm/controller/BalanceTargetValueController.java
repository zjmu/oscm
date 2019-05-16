package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.*;
import edu.jmu.oscm.model.*;
import edu.jmu.oscm.service.BalanceTargetValueService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class BalanceTargetValueController {

    private static final Logger logger = LoggerFactory.getLogger(BalanceTargetValueController.class);

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    @Autowired
    private BalanceTargetValueService balanceTargetValueService;

    /**
     * 批量插入上月余额与目标降低值表
     * @api {Post} /createMoreBalanceTargetValue 批量插入上月余额与目标降低值表信息
     * @apiName createMoreBalanceTargetValue 批量插入上月余额与目标降低值表信息
     * @apiGroup BalanceTargetValue
     * @apiParamExample {json} Request_Example:
     *[
     * {
     *  "reportItemId":2,
     *  "year":2019,
     *  "month":3,
     *  "lastMonthBalance":45,
     *  "planMonthTargetValue":65,
     *  "planTotalReduceValue":85,
     *  "actualMonthTargetValue":98,
     *  "actualTotalReduceValue":98,
     *  "monthIncrementalValue":78,
     *  "totalIncrementalValue":78,
     *  "monthReward":25,
     *  "totalReward":12,
     *  "date":"2019-05-06"
     *},
     *{
     *  "reportItemId":3,
     *  "year":2019,
     *  "month":5,
     *  "lastMonthBalance":845,
     *  "planMonthTargetValue":165,
     *  "planTotalReduceValue":85,
     *  "actualMonthTargetValue":988,
     *  "actualTotalReduceValue":98,
     *  "monthIncrementalValue":78,
     *  "totalIncrementalValue":78,
     *  "monthReward":25,
     *  "totalReward":12,
     *  "date":"2019-05-06"
     *}
     * ]
     * POST: /createMoreBalanceTargetValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"批量增加记录成功","data":true}
     */
    @PostMapping("/createMoreBalanceTargetValue")
    public BasicResponse<Boolean> createMore(@RequestBody List<BalanceTargetValue> balanceTargetValues) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = balanceTargetValueMapper.insertMore(balanceTargetValues);
            ResponseUtil.set(response, 0, "批量增加记录成功", isSuccess);
        }, logger);
    }

    /**
     * 删除所有上月余额与目标降低值表
     *
     * @api {Delete} /deleteAllBalanceTargetValue 删除所有上月余额与目标降低值表信息
     * @apiName deleteAllBalanceTargetValue  删除所有上月余额与目标降低值表信息
     * @apiGroup BalanceTargetValue
     * @apiParamExample {json} Request_Example:
     * Delete: /deleteAllBalanceTargetValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"清空数据成功","data":true}
     */
    @DeleteMapping("/deleteAllBalanceTargetValue")
    public BasicResponse<Boolean> deleteAll() {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = balanceTargetValueMapper.deleteAll();
            ResponseUtil.set(response, 0, "清空数据成功", isSuccess);
        }, logger);
    }

    /**
     * 查询所有上月余额与目标降低值表
     * @api {GET} /queryAllBalanceTargetValue 查询所有上月余额与目标降低值
     * @apiName queryAllBalanceTargetValue 查询所有上月余额与目标降低值
     * @apiGroup BalanceTargetValue
     * @apiParamExample {json} Request_Example:
     * GET: /queryAllBalanceTargetValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"查询数据成功","data":[
     * {"id":11,"reportItemId":2,"year":"2019","month":"5","lastMonthBalance":45.0000,"planMonthTargetValue":65.0000,
     * "planTotalReduceValue":85.0000,"actualMonthTargetValue":7500.0000,"actualTotalReduceValue":98.0000,"monthIncrementalValue":78.0000,
     * "totalIncrementalValue":99999.0000,"monthReward":25.0000,"totalReward":12.0000,"date":"2019-05-06 00:00:00.0"},
     * {"id":12,"reportItemId":3,"year":"2019","month":"4","lastMonthBalance":405.0000,"planMonthTargetValue":605.0000,
     * "planTotalReduceValue":85.0000,"actualMonthTargetValue":7500.0000,"actualTotalReduceValue":98.0000,"monthIncrementalValue":708.0000,
     * "totalIncrementalValue":999.0000,"monthReward":25.0000,"totalReward":12.0000,"date":"2019-05-06 00:00:00.0"}]
     * }
     * */
    @GetMapping("/queryAllBalanceTargetValue")
    public BasicResponse<List<BalanceTargetValue>> queryAll() {
        return BusinessWrapper.wrap(response -> {
            List<BalanceTargetValue> result = balanceTargetValueMapper.selectAll();
            ResponseUtil.set(response, 0, "查询数据成功", result);
        }, logger);
    }

    /**
     * 根据年月查询上月余额与目标降低值表
     * @api {GET} /queryBalanceTargetValue?year=&month= 根据年月查询上月余额与目标降低值表
     * @apiName queryBalanceTargetValue 根据年月查询上月余额与目标降低值表
     * @apiGroup BalanceTargetValue
     * @apiParam {String} year 指定上月余额与目标降低值表year值
     * @apiParam {String} month 指定上月余额与目标降低值表month值
     * @apiParamExample {json} Request_Example:
     * GET: /queryBalanceTargetValue?year= & month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"查询数据成功","data":[{"id":11,"reportItemId":2,"year":"2019","month":"5","lastMonthBalance":45.0000,"planMonthTargetValue":65.0000,
     * "planTotalReduceValue":85.0000,"actualMonthTargetValue":7500.0000,"actualTotalReduceValue":98.0000,"monthIncrementalValue":78.0000,
     * "totalIncrementalValue":99999.0000,"monthReward":25.0000,"totalReward":12.0000,"date":"2019-05-06 00:00:00.0"}]
     * }
     * */
    @GetMapping("/queryBalanceTargetValue")
    public BasicResponse<List<BalanceTargetValue>> queryByDate(@RequestParam(value = "year") String year,@RequestParam(value = "month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<BalanceTargetValue> result = balanceTargetValueMapper.selectByDate(year,month);
            ResponseUtil.set(response, 0, "查询数据成功", result);
        }, logger);
    }

    /**
     * 计算上月余额与目标降低值表
     * @api {GET} /calculateBalanceTargetValue 计算上月余额与目标降低值表
     * @apiName calculateBalanceTargetValue 计算上月余额与目标降低值表
     * @apiGroup balanceTargetValue
     * @apiParam {String} year 指定计算上月余额与目标降低值表year值
     * @apiParam {String} month 指定计算上月余额与目标降低值表month值
     * @apiParamExample {json} Request_Example:
     * GET: /calculateBalanceTargetValue?year= month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{
     * "code": 0,
     * "message": "执行计算",
     * "data": "计算完成!"
     *}
     * */
    @GetMapping("/calculateBalanceTargetValue")
    public BasicResponse<String> calculateBalanceTargetValue(@RequestParam("year")String year, @RequestParam("month")String month) {
        return BusinessWrapper.wrap(response -> {
            String message = balanceTargetValueService.calculate(year,month);
            //List<BalanceTargetValue> result = balanceTargetValueMapper.selectByDate("2019","3");
            ResponseUtil.set(response, 0, "执行计算", message);
        }, logger);
    }
}

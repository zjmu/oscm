package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.BalanceTargetValueMapper;
import edu.jmu.oscm.model.BalanceTargetValue;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BalanceTargetValueController {

    private static final Logger logger = LoggerFactory.getLogger(BalanceTargetValueController.class);

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    /**
     * 插入上月余额与目标降低值表
     *
     * @api {Post} /createBalanceTargetValue 插入上月余额与目标降低值表信息
     * @apiName createBalanceTargetValue 插入上月余额与目标降低值表信息
     * @apiGroup BalanceTargetValue
     * @apiParamExample {json} Request_Example:
     *{
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
     *}
     * POST: /createBalanceTargetValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"增加记录成功","data":true}
     */
    @PostMapping("/createBalanceTargetValue")
    public BasicResponse<Boolean> create(@RequestBody BalanceTargetValue balanceTargetValue) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = balanceTargetValueMapper.insert(balanceTargetValue);
            ResponseUtil.set(response, 0, "增加记录成功", isSuccess);
        }, logger);
    }

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
     * 根据ID删除上月余额与目标降低值表
     *
     * @api {Delete} /deleteBalanceTargetValue?id= 删除指定上月余额与目标降低值表信息
     * @apiName deleteBalanceTargetValue 删除指定上月余额与目标降低值表信息
     * @apiGroup BalanceTargetValue
     * @apiParam {Integer} id 指定要删除的上月余额与目标降低值表记录id
     * @apiParamExample {json} Request_Example:
     * Delete: /deleteBalanceTargetValue?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除数据成功","data":true}
     */
    @DeleteMapping("/deleteBalanceTargetValue")
    public BasicResponse<Boolean> deleteAll(@RequestParam(value="id") Integer id) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = balanceTargetValueMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除数据成功", isSuccess);
        }, logger);
    }


    /**
     * 更新上月余额与目标降低值表
     *
     * @api {Put} /updateBalanceTargetValue 更新上月余额与目标降低值表信息
     * @apiName updateBalanceTargetValue 更新上月余额与目标降低值表信息
     * @apiGroup BalanceTargetValue
     * @apiParamExample {json} Request_Example:
     *{
     *  "id":1,
     *  "reportItemId":3,
     *  "year":2019,
     *  "month":5,
     *  "lastMonthBalance":45,
     *  "planMonthTargetValue":98,
     *  "planTotalReduceValue":85,
     *  "actualMonthTargetValue":98,
     *  "actualTotalReduceValue":9888,
     *  "monthIncrementalValue":78,
     *  "totalIncrementalValue":768,
     *  "monthReward":25,
     *  "totalReward":12,
     *  "date":"2019-05-06"
     *}
     * PUT: /updateBalanceTargetValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"修改数据成功","data":true}
     */
    @PutMapping("/updateBalanceTargetValue")
    public BasicResponse<Boolean> update(@RequestBody BalanceTargetValue balanceTargetValue) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = balanceTargetValueMapper.update(balanceTargetValue);
            ResponseUtil.set(response, 0, "修改数据成功", isSuccess);
        }, logger);
    }


//    @PutMapping("/updateBalanceTargetValue")
//    public BasicResponse<Boolean> updateMore(@RequestBody List<BalanceTargetValue> balanceTargetValues) {
//        return BusinessWrapper.wrap(response -> {
//            Boolean isSuccess = balanceTargetValueMapper.updateMore(balanceTargetValues);
//            ResponseUtil.set(response, 0, "修改数据成功", isSuccess);
//        }, logger);
//    }

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
}

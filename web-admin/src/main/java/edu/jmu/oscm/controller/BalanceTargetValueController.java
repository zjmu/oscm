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
     * 按年月删除上月余额与目标降低值表
     *
     * @api {Delete} /deleteBalanceTargetValue 按年月删除上月余额与目标降低值表信息
     * @apiName deleteByDate  按年月删除上月余额与目标降低值表信息
     * @apiGroup BalanceTargetValue
     * @apiParamExample {json} Request_Example:
     * Delete: /deleteBalanceTargetValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"清除数据成功","data":true}
     */
    @DeleteMapping("/deleteBalanceTargetValue")
    public BasicResponse<Boolean> deleteByDate(@RequestParam(value = "year") String year,@RequestParam(value = "month") String month) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = balanceTargetValueMapper.deleteByDate(year,month);
            ResponseUtil.set(response, 0, "清空数据成功", isSuccess);
        }, logger);
    }

    /**
     * 删除所有上月余额与目标降低值表
     *
     * @api {Delete} /deleteAllBalanceTargetValue 删除所有上月余额与目标降低值表信息
     * @apiName deleteAll  删除所有上月余额与目标降低值表信息
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
     * 根据年月查询上月余额与目标降低值表
     * @api {GET} /queryBalanceTargetValue 根据年月查询上月余额与目标降低值表
     * @apiName queryByDate 根据年月查询上月余额与目标降低值表
     * @apiGroup BalanceTargetValue
     * @apiParam {String} year 指定上月余额与目标降低值表year值
     * @apiParam {String} month 指定上月余额与目标降低值表reportId值
     * @apiParamExample {json} Request_Example:
     * GET: /queryBalanceTargetValue?year= & month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"查询数据成功","data":[
     *  {"id":122,
     *  "itemId":1,
     *  "year":"2018",
     *  "month":"03",
     *  "lastMonthBalance":2090.00,
     *  "planMonthTargetValue":33.00,
     *  "planTotalReduceValue":166.00,
     *  "actualMonthTargetValue":-979.00,
     *  "actualTotalReduceValue":1101.00,
     *  "monthIncrementalValue":-11013.75,
     *  "totalIncrementalValue":12386.25,
     *  "monthReward":-154412.78,
     *  "totalReward":173655.23,
     *  "createDate":"2019-05-12T08:01:22.000+0000",
     *  "assetOrDebt":null,
     *  "itemDept":null,
     *  "itemEmployee":null,
     *  "reportItemInstance":null}
     *  ]}
     * */
    @GetMapping("/queryBalanceTargetValue")
    public BasicResponse<List<BalanceTargetValue>> queryByDate(@RequestParam(value = "year") String year,@RequestParam(value = "month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<BalanceTargetValue> result = balanceTargetValueMapper.selectByDate(year,month);
            ResponseUtil.set(response, 0, "查询数据成功", result);
        }, logger);
    }

    /**
     * 查询所有上月余额与目标降低值表
     * @api {GET} /queryAllBalanceTargetValue 查询所有上月余额与目标降低值
     * @apiName queryAll 查询所有上月余额与目标降低值
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
     *  {"id":122,
     *  "itemId":1,
     *  "year":"2018",
     *  "month":"03",
     *  "lastMonthBalance":2090.00,
     *  "planMonthTargetValue":33.00,
     *  "planTotalReduceValue":166.00,
     *  "actualMonthTargetValue":-979.00,
     *  "actualTotalReduceValue":1101.00,
     *  "monthIncrementalValue":-11013.75,
     *  "totalIncrementalValue":12386.25,
     *  "monthReward":-154412.78,
     *  "totalReward":173655.23,
     *  "createDate":"2019-05-12T08:01:22.000+0000",
     *  "assetOrDebt":null,
     *  "itemDept":null,
     *  "itemEmployee":null,
     *  "reportItemInstance":null}
     *  ]}
     * */
    @GetMapping("/queryAllBalanceTargetValue")
    public BasicResponse<List<BalanceTargetValue>> queryAll() {
        return BusinessWrapper.wrap(response -> {
            List<BalanceTargetValue> result = balanceTargetValueMapper.selectAll();
            ResponseUtil.set(response, 0, "查询数据成功", result);
        }, logger);
    }

     /**
     * 计算上月余额与目标降低值表
     * @api {GET} /calculateBalanceTargetValue 计算上月余额与目标降低值表
     * @apiName calculateBalanceTargetValue 计算上月余额与目标降低值表
     * @apiGroup BalanceTargetValue
     * @apiParam {String} year 指定计算上月余额与目标降低值表year值
     * @apiParam {String} month 指定计算上月余额与目标降低值表month值
     * @apiParam {String} month 指定上月余额与目标降低值表month值
     * @apiParamExample {json} Request_Example:
     * GET: /calculateBalanceTargetValue?year= &month= &reportId=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"执行计算","data":[
     * {"id":289,"reportItemId":1,"year":"2018","month":"03","lastMonthBalance":2090.00,"planMonthTargetValue":33.00,"planTotalReduceValue":166.00,"actualMonthTargetValue":-979.00,"
     * actualTotalReduceValue":1101.00,"monthIncrementalValue":-11013.75,"totalIncrementalValue":12386.25,"monthReward":-154412.78,"totalReward":173655.23,"createDate":"2019-05-16T07:59:11.000+0000",
     * "itemDept":null,"itemEmployee":null,"reportItemInstance":null},
     * {"id":553,"reportItemId":2,"year":"2019","month":"3","lastMonthBalance":50000.00,"planMonthTargetValue":83.33,"planTotalReduceValue":177.67,"actualMonthTargetValue":-47778.00,
     * "actualTotalReduceValue":2212.00,"monthIncrementalValue":-537502.50,"totalIncrementalValue":24885.00,"monthReward":-7535785.05,"totalReward":348887.70,"createDate":"2019-05-16T07:59:11.000+0000",
     * "itemDept":null,"itemEmployee":null,"reportItemInstance":null},
     * {"id":554,"reportItemId":3,"year":"2019","month":"3","lastMonthBalance":1020.00,"planMonthTargetValue":98777.00,"planTotalReduceValue":106554.00,"actualMonthTargetValue":4224.00,
     * "actualTotalReduceValue":5234.00,"monthIncrementalValue":47520.00,"totalIncrementalValue":58882.50,"monthReward":666230.40,"totalReward":825532.65,"createDate":"2019-05-16T07:59:11.000+0000",
     * "itemDept":null,"itemEmployee":null,"reportItemInstance":null},
     * {"id":555,"reportItemId":4,"year":"2019","month":"3","lastMonthBalance":5020.00,"planMonthTargetValue":6222.00,"planTotalReduceValue":6247.00,"actualMonthTargetValue":-576.00,
     * "actualTotalReduceValue":4434.00,"monthIncrementalValue":-6480.00,"totalIncrementalValue":49882.50,"monthReward":-90849.60,"totalReward":699352.65,"createDate":"2019-05-16T07:59:11.000+0000",
     * "itemDept":null,"itemEmployee":null,"reportItemInstance":null}]}
     * */
    @GetMapping("/calculateBalanceTargetValue")
    public BasicResponse<List<BalanceTargetValue>> calculateBalanceTargetValue(@RequestParam("year")String year, @RequestParam("month")String month,@RequestParam("reportId")BigInteger reportId) {
        return BusinessWrapper.wrap(response -> {
            List<BalanceTargetValue> result= balanceTargetValueService.calculate(year,month,reportId);
            ResponseUtil.set(response, 0, "执行计算", result);
        }, logger);
    }
}

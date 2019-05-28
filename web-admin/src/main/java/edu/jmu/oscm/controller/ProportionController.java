package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ProportionMapper;
import edu.jmu.oscm.model.Proportion;
import edu.jmu.oscm.service.ProportionService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zyx
 * @date 19-5-7 下午7:57
 * @email zhangyuxin2009@126.com
 */

@RestController
public class ProportionController {

    private static final Logger logger = LoggerFactory.getLogger(Proportion.class);

    @Autowired
    private ProportionMapper proportionMapper;

    @Autowired
    private ProportionService proportionService;

    /**
     * 查找项目占比表成功
     *
     * @api {GET} /selectProportionById?id=  查询指定项目占比
     * @apiName selectProportionById 查询项目占比信息
     * @apiGroup Proportion
     * @apiParam {int} id 指定项目占比表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /selectProportionById?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找项目占比表成功",
     * "data":{"id":1,"report_item_id":0,"year":"2019","month":"5","proportion":0.0,"accumulate_proportion":"1.0","asset_or_debt":"0","create_date":"2019-01"}}
     */
    @GetMapping("/selectProportionById")
    public BasicResponse<Proportion> selectProportionById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            Proportion proportion = proportionMapper.selectProportionById(id);
            ResponseUtil.set(response, 0, "查找项目占比表成功", proportion);
        }, logger);
    }

    /**
     * 查找项目占比表成功
     *
     * @api {GET} /selectProportionByYearAndMonth?year=year&&month=month  查询指定项目占比
     * @apiName selectProportionById 查询项目占比信息
     * @apiGroup Proportion
     * @apiParam {String} year 指定项目占比表年
     * @apiParam {String} month 指定项目占比表月
     * @apiParamExample {json} Request_Example:
     * GET: /selectProportionByYearAndMonth?year=&&month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找项目占比表成功",
     * "data":{"id":1,"report_item_id":0,"year":"2019","month":"5","proportion":0.0,"accumulate_proportion":"1.0","asset_or_debt":"0","create_date":"2019-01"}}
     */
    @GetMapping("/selectProportionByYearAndMonth")
    public BasicResponse<List<Proportion>> selectProportionByYearAndMonth(@RequestParam("year") String year, @RequestParam("month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<Proportion> proportions = proportionMapper.selectProportionByYearAndMonth(year, month);
            ResponseUtil.set(response, 0, "查找项目占比表成功", proportions);
        }, logger);
    }

    /**
     * 查找所有项目占比表记录
     *
     * @api {GET} /getAllProportion 查找所有项目占比表记录
     * @apiName getAllProportion 查找所有项目占比表记录
     * @apiGroup getAllProportion
     * @apiParamExample {json} Request_Example:
     * GET: /getAllProportion
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找所有项目占比表记录成功",
     * "data":[
     * {
     * "id":143,
     * "report_item_id":0,
     * "year":"",
     * "month":"",
     * "proportion":0.6196991,
     * "accumulate_proportion":0.6196991,
     * "asset_or_debt":0,
     * "create_date":"2019-01-01 00:00:00"},
     * {
     * "id":146,
     * "report_item_id":0,
     * "year":"",
     * "month":"",
     * "proportion":0,
     * "accumulate_proportion":0.75356704,
     * "asset_or_debt":0,
     * "create_date":"2019-01-01 00:00:00"
     * }
     * ]}
     */
    @GetMapping("/getAllProportion")
    public BasicResponse<List<Proportion>> getAllProportion() {
        return BusinessWrapper.wrap(response -> {
            List<Proportion> proportions = proportionMapper.getAllProportion();
            ResponseUtil.set(response, 0, "查找项目占比表成功", proportions);
        }, logger);
    }

    /**
     * 删除指定项目占比表记录
     *
     * @api {DELETE} /deleteProportionById 删除指定项目占比表记录
     * @apiName deleteImprovementPlanById 删除指定项目占比表记录
     * @apiGroup deleteProportionById
     * @apiParam {int} id 删除指定项目占比表记录id
     * @apiParamExample {json} Request_Example:
     * DELETE: /deleteProportionById?id=1
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除指定项目占比表记录成功"}
     */
    @GetMapping("/deleteProportionById")
    public BasicResponse<Boolean> deleteProportionById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除指定项目占比表成功");
        }, logger);
    }

    /**
     * 删除所有项目占比表记录
     *
     * @api {DELETE} /deleteAllProportion 删除所有项目占比表记录
     * @apiName deleteAllProportion 删除所有项目占比表记录
     * @apiGroup deleteAllProportion
     * @apiParamExample {json} Request_Example:
     * DELETE: /deleteAllProportion
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除所有项目占比表记录"}
     */
    @GetMapping("/deleteAllProportion")
    public BasicResponse<Boolean> deleteAllProportion() {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.deleteAll();
            ResponseUtil.set(response, 0, "删除所有项目占比表成功");
        }, logger);
    }

    /**
     * 插入项目占比表记录
     *
     * @api {POST} /insertProportion 插入项目占比表
     * @apiName insertProportion 插入项目占比表
     * @apiGroup insertProportion
     * @apiParam {bigint} report_item_id 报告条目id
     * @apiParam {String} year 年度
     * @apiParam {String} month 月份
     * @apiParam {String} proportion 比例
     * @apiParam {String} accumulate_proportion 累计比例
     * @apiParam {Boolean} asset_or_debt 资产或负债
     * @apiParam {Timestamp} create_date 创建时间
     * @apiParamExample {json} Request_Example:
     * {
     * "report_item_id":0,
     * "year":"",
     * "month":"",
     * "proportion":0,
     * "accumulate_proportion":0.75356704,
     * "asset_or_debt":0,
     * "create_date":"2019-01-01 00:00:00"
     * }
     * POST: /insertImprovementPlan
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"插入项目占比表成功"}
     */
    @PostMapping("/insertProportion")
    public BasicResponse<Boolean> insertProportion(@RequestBody Proportion proportion) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.insertProportion(proportion);
            if (flag) {
                ResponseUtil.set(response, 0, "插入项目占比表成功");
            } else {
                ResponseUtil.set(response, 100, "插入项目占比表失败");
            }
        }, logger);
    }

    /**
     * 查找项目占比表成功
     *
     * @api {GET} /selectProportionAndReport?year=year&&month=month&&reportId=reportId&&type=type  查询指定项目占比
     * @apiName selectProportionAndReport 查询项目占比信息
     * @apiGroup Proportion
     * @apiParam {String} year 指定项目占比表年
     * @apiParam {String} month 指定项目占比表月
     * @apiparam {int} reportId 指定报表的Id
     * @apiParam {int} type 查询指定项目占比（资产和负债）
     * @apiParamExample {json} Request_Example:
     * GET: /selectProportionAndReport?year=year&&month=month&&reportId=reportId&&type=type
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找项目占比表成功",
     * "data":{}
     */
    @GetMapping("/selectProportionAndReport")
    public BasicResponse<List<Proportion>> selectProportionAndReport(@RequestParam("year") String year, @RequestParam("month") String month,@RequestParam("reportId") int reportId,@RequestParam("type") int type) {
        return BusinessWrapper.wrap(response -> {

            List<Proportion> proportions = proportionMapper.selectProportionByYearAndMonthAndReportIdAndType(year, month,reportId,type);

            //List<Proportion> proportions = proportionMapper.selectProportionAndReportItemInstanceByYearAndMonth(year, month);

            //Map<String,Object> map = proportionService.getListByType(proportions,reportId);

            ResponseUtil.set(response, 0, "查找项目占比表成功", proportions);
        }, logger);
    }


}

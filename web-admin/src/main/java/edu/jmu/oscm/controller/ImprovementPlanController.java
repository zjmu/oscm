package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ImprovementPlanMapper;
import edu.jmu.oscm.model.ImprovementPlan;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ImprovementPlanController {
    private static final Logger logger = LoggerFactory.getLogger(ImprovementPlanController.class);

    @Autowired
    private ImprovementPlanMapper improvementPlanMapper;

    /**
     * 获取指定提升和改善计划表记录
     *
     * @api {GET} /improvementPlan?year=&&month=  查询指定提升和改善计划表信息
     * @apiName selectImprovementPlanByDate 查询指定提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParam {int} id 指定提升和改善计划表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /improvementPlan?year=2019 && month = 5
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,
     * "message":"查找指定提升和改善计划表成功",
     * "data":
     * {
     * {
     * "id":1,
     * "item_id":1,
     * "year":"2019",
     * "month":"5",
     * "ok":1,
     * "plan":"1",
     * "remark":"1",
     * "create_date":"2019-01-01 00:00:00"
     * "item":{
     *          "item_code"="短期投资"
     *          "item_name"="短期投资"
     *          "calc_expr="1101-1102"
     *          "calc_explain"="短期投资-短期投资跌价准备"
     *          "state"="1"
     *          "modify_time"= "2019-04-28 09:59:00"
     *          }
     * }
     * {
     * "id":2,
     * "item_id":1,
     * "year":"2019",
     * "month":"5",
     * "ok":1,
     * "plan":"1",
     * "remark":"1",
     * "create_date":"2019-01-01 00:00:00"
     * "item":{
     *          "item_code"="短期投资"
     *          "item_name"="短期投资"
     *          "calc_expr="1101-1102"
     *          "calc_explain"="短期投资-短期投资跌价准备"
     *          "state"="1"
     *          "modify_time"= "2019-04-28 09:59:00"
     *          }
     * }
     * }
     *
     * }
     */
    @GetMapping("/improvementPlan")
    public BasicResponse<List<ImprovementPlan>> selectImprovementPlanByDate(@RequestParam("year") String year,@RequestParam("month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<ImprovementPlan> improvementPlans = improvementPlanMapper.selectImprovementPlanByDate(year,month);
            ResponseUtil.set(response, 0, "查找指定提升和改善计划表成功",improvementPlans);
        }, logger);
    }

    /**
     * 查询所有提升和改善计划表记录
     * @api {GET} /improvementPlans 查询所有提升和改善计划表信息
     * @apiName queryAllImprovementPlan 查询所有提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParamExample {json} Request_Example:
     * GET: /improvementPlans
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查询提升和改善计划表成功",
     * "data":[
     *          {
     *              "id":1,
     *              "item_id":1,
     *              "year":"2019",
     *              "month":"5",
     *              "ok":1,
     *              "plan":"1",
     *              "remark":"1",
     *              "create_date":"2019-01-01 00:00:00"
     *              "item":{
     *                       "item_code"="短期投资"
     *                      "item_name"="短期投资"
     *                      "calc_expr="1101-1102"
     *                      "calc_explain"="短期投资-短期投资跌价准备"
     *                      "state"="1"
     *                      "modify_time"= "2019-04-28 09:59:00"
     *          }
     *              },
     *          {
     *              "id":2,
     *              "item_id":1,
     *              "year":"2019",
     *              "month":"5",
     *              "ok":1,
     *              "plan":"1",
     *              "remark":"1",
     *              "create_date":"2019-01-01 00:00:00"
     *              "item":{
     *                      "item_code"="短期投资"
     *                      "item_name"="短期投资"
     *                      "calc_expr="1101-1102"
     *                      "calc_explain"="短期投资-短期投资跌价准备"
     *                      "state"="1"
     *                      "modify_time"= "2019-04-28 09:59:00"
     *          }
     *            }
     *       ]}
     */
    @GetMapping("/improvementPlans")
    public BasicResponse<List<ImprovementPlan>> getAllImprovementPlan() {
        return BusinessWrapper.wrap(response -> {
            List<ImprovementPlan> improvementPlans = improvementPlanMapper.getAllImprovementPlan();
            ResponseUtil.set(response, 0, "查询提升和改善计划表成功", improvementPlans);
        }, logger);
    }



    /**
     * 删除指定提升和改善计划表记录
     *
     * @api {DELETE} /improvementPlan 删除指定提升和改善计划表信息
     * @apiName deleteImprovementPlan 删除指定提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParam {int} id 指定提升和改善计划表记录id
     * @apiParamExample {json} Request_Example:
     * DELETE: /improvementPlan?id=1
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除指定提升和改善计划表成功"}
     */
    @DeleteMapping("/improvementPlan")
    public BasicResponse<Boolean> deleteImprovementPlanById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = improvementPlanMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除指定提升和改善计划表成功");
        }, logger);
    }


    /**
     * 删除所有提升和改善计划表记录
     *
     * @api {DELETE} /improvementPlans 删除所有提升和改善计划表信息
     * @apiName deleteAllImprovementPlans删除所有提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParamExample {json} Request_Example:
     * DELETE: /improvementPlans
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除所有提升和改善计划表成功"}
     */
    @DeleteMapping("/improvementPlans")
    public BasicResponse<Boolean>  deleteAllImprovementPlan()
    {
        return BusinessWrapper.wrap(response -> {
            boolean flag = improvementPlanMapper.deleteAll();
            ResponseUtil.set(response, 0, "删除所有指定提升和改善计划表成功");
        }, logger);
    }

    /**
     * 插入提升和改善计划表记录
     *
     * @api {POST} /improvementPlan 插入提升和改善计划表信息
     * @apiName insertImprovementPlan 插入所有提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParam {bigint} item_id 报告条目id
     * @apiParam {String} year 年度
     * @apiParam {String} month 月份
     * @apiParam {int} ok 完成情况
     * @apiParam {String} plan 改善计划
     * @apiParam {String} remark 备注
     * @apiParam {Timestamp} create_date 创建时间
     * @apiParamExample {json} Request_Example:
     * {
     *  "item_id":1,
     *  "year":"2019",
     *  "month":"5",
     *  "ok":1,
     *  "plan":"1",
     *  "remark":"1",
     *  "create_date":"2019-01-01 00:00:00"
     *  }
     * POST: /improvementPlan
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"插入提升和改善计划表成功"}
     */
    @PostMapping("/improvementPlan")
    public BasicResponse<Boolean> insertImprovementPlan(@RequestBody  ImprovementPlan improvementPlan){
        return BusinessWrapper.wrap(response -> {
            System.out.println(improvementPlan.toString());
            boolean flag = improvementPlanMapper.insertImprovementPlan(improvementPlan);
            ResponseUtil.set(response, 0, "插入提升和改善计划表成功");
        }, logger);
    }


    /**
     * 更新指定提升和改善计划表记录
     *
     * @api {PUT} /improvementPlan 更新指定提升和改善计划表信息
     * @apiName updateImprovementPlan 更新指定提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParam {int} id 提升和改善计划表id
     * @apiParam {bigint} item_id 报告条目id
     * @apiParam {String} year 年度
     * @apiParam {String} month 月份
     * @apiParam {int} ok 完成情况
     * @apiParam {String} plan 改善计划
     * @apiParam {String} remark 备注
     * @apiParam {Timestamp} create_date 创建时间
     * @apiParamExample {json} Request_Example:
     * {
     *  "id":1,
     *  "item_id":1,
     *  "year":"2019",
     *  "month":"5",
     *  "ok":1,
     *  "plan":"1",
     *  "remark":"1",
     *  "create_date":"2019-01-01 00:00:00"
     *  }
     * POST: /improvementPlan
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更新提升和改善计划表成功"}
     */
    @PutMapping("/improvementPlan")
    public BasicResponse<Boolean> updateImprovementPlan(@RequestBody  ImprovementPlan improvementPlan){
        return BusinessWrapper.wrap(response -> {
            System.out.println(improvementPlan.toString());
            boolean flag = improvementPlanMapper.updateImprovementPlan(improvementPlan);
            ResponseUtil.set(response, 0, "更新提升和改善计划表成功");
        }, logger);
    }
}

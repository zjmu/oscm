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
     * @api {GET} /selectImprovementPlanById?id=  查询指定提升和改善计划表信息
     * @apiName selectImprovementPlanById 查询指定提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParam {int} id 指定提升和改善计划表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /deleteImprovementPlanById?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找指定提升和改善计划表成功",
     * "data":{"id":1,"report_item_id":0,"year":"2019","month":"5","ok":1,"plan":"1","remark":"1","date":"2019-01"}}
     */
    @GetMapping("/selectImprovementPlanById")
    public BasicResponse<ImprovementPlan> selectImprovementPlanById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            ImprovementPlan improvementPlan = improvementPlanMapper.selectImprovementPlanById(id);
            ResponseUtil.set(response, 0, "查找指定提升和改善计划表成功",improvementPlan);
        }, logger);
    }

    /**
     * 查询所有提升和改善计划表记录
     * @api {GET} /getAllImprovementPlan 查询所有提升和改善计划表信息
     * @apiName getAllImprovementPlan 查询所有提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParamExample {json} Request_Example:
     * GET: /getAllImprovementPlan
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查询提升和改善计划表成功","data":[
     * {"id":1,"report_item_id":0,"year":"2019","month":"5","ok":1,"plan":"1","remark":"1","date":"2019-01"},{
     *"id":2,"report_item_id":0,"year":"2019","month":"5","ok":1,"plan":"1","remark":"1","date":"2019-01"}]}
     */
    @GetMapping("/getAllImprovementPlan")
    public BasicResponse<List<ImprovementPlan>> getAllImprovementPlan() {
        return BusinessWrapper.wrap(response -> {
            List<ImprovementPlan> improvementPlans = improvementPlanMapper.getAllImprovementPlan();
            ResponseUtil.set(response, 0, "查询提升和改善计划表成功", improvementPlans);
        }, logger);
    }



    /**
     * 删除指定提升和改善计划表记录
     *
     * @api {GET} /deleteImprovementPlanById 删除指定提升和改善计划表信息
     * @apiName deleteImprovementPlanById 删除指定提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParam {int} id 指定提升和改善计划表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /deleteImprovementPlanById
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
    @GetMapping("/deleteImprovementPlanById")
    public BasicResponse<Boolean> deleteImprovementPlanById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = improvementPlanMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除指定提升和改善计划表成功");
        }, logger);
    }

    /**
     * 删除所有提升和改善计划表记录
     *
     * @api {GET} /deleteAllImprovementPlan 删除所有提升和改善计划表信息
     * @apiName deleteAllImprovementPlan 删除所有提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParamExample {json} Request_Example:
     * GET: /deleteAllImprovementPlan
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
    @GetMapping("/deleteAllImprovementPlan")
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
     * @api {Post} /insertImprovementPlan 插入提升和改善计划表信息
     * @apiName insertImprovementPlan 插入所有提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParamExample {json} Request_Example:
     * {
     *  "report_item_id":0,
     *  "year":"2019",
     *  "month":"5",
     *  "ok":1,
     *  "plan":"1",
     *  "remark":"1",
     *  "date":"2019-01"
     *  }
     * POST: /insertImprovementPlan
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
    @PostMapping("/insertImprovementPlan")
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
     * @api {Post} /updateImprovementPlan 更新指定提升和改善计划表信息
     * @apiName updateImprovementPlan 更新指定提升和改善计划表信息
     * @apiGroup ImprovementPlan
     * @apiParamExample {json} Request_Example:
     * {
     *  "id":1,
     *  "report_item_id":0,
     *  "year":"2019",
     *  "month":"5",
     *  "ok":1,
     *  "plan":"1",
     *  "remark":"1",
     *  "date":"2019-01"
     *  }
     * POST: /updateImprovementPlan
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
    @PostMapping("/updateImprovementPlan")
    public BasicResponse<Boolean> updateImprovementPlan(@RequestBody  ImprovementPlan improvementPlan){
        return BusinessWrapper.wrap(response -> {
            System.out.println(improvementPlan.toString());
            boolean flag = improvementPlanMapper.updateImprovementPlan(improvementPlan);
            ResponseUtil.set(response, 0, "更新提升和改善计划表成功");
        }, logger);
    }
}

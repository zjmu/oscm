package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ProportionMapper;
import edu.jmu.oscm.model.Proportion;
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

    /**
     * 查找项目占比表成功
     *
     * @api {GET} /selectProportionById?id=  查询指定项目占比
     * @apiName selectProportionById 查询项目占比信息
     * @apiGroup Proportion
     * @apiParam {int} id 指定项目占比表记录id
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
     * {"code":0,"message":"查找项目占比表成功",
     * "data":{"id":1,"report_item_id":0,"year":"2019","month":"5","proportion":0.0,"accumulate_proportion":"1.0","asset_or_debt":"0","create_date":"2019-01"}}
     */
    @GetMapping("/selectProportionById")
    public BasicResponse<Proportion> selectProportionById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            Proportion proportion = proportionMapper.selectProportionById(id);
            ResponseUtil.set(response, 0, "查找项目占比表成功",proportion);
        }, logger);
    }

    @GetMapping("/selectProportionByYearAndMonth")
    public BasicResponse<List<Proportion>> selectProportionByYearAndMonth(@RequestParam("year") String year,@RequestParam("month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<Proportion> proportions = proportionMapper.selectProportionByYearAndMonth(year,month);
            ResponseUtil.set(response, 0, "查找项目占比表成功",proportions);
        }, logger);
    }

    @GetMapping("/getAllProportion")
    public BasicResponse<List<Proportion>> getAllProportion() {
        return BusinessWrapper.wrap(response -> {
            List<Proportion> proportions = proportionMapper.getAllProportion();
            ResponseUtil.set(response, 0, "查找项目占比表成功", proportions);
        }, logger);
    }

    @GetMapping("/deleteProportionById")
    public BasicResponse<Boolean> deleteProportionById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除指定项目占比表成功");
        }, logger);
    }

    @GetMapping("/deleteAllProportion")
    public BasicResponse<Boolean>  deleteAllProportion()
    {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.deleteAll();
            ResponseUtil.set(response, 0, "删除所有项目占比表成功");
        }, logger);
    }

    @PostMapping("/insertProportion")
    public BasicResponse<Boolean> insertProportion(@RequestBody Proportion proportion){
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.insertProportion(proportion);
            ResponseUtil.set(response, 0, "插入项目占比表成功");
        }, logger);
    }

}

package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ReduceTargetMapper;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.service.ReduceTargetService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.NimbusStyle;
import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.List;


@RestController
public class ReduceTargetController {
    private static final Logger logger = LoggerFactory.getLogger(ReduceTargetController.class);

    @Autowired
    private ReduceTargetService reduceTargetService;

    /**
     * 查询所有项目降低目标设置
     * @api {GET} /reduceTargets 查询所有项目降低目标设置
     * @apiName queryAllReduceTargets 查询所有项目降低目标设置
     * @apiGroup ReduceTarget
     * @apiParamExample {json} Request_Example:
     * GET: /reduceTargets
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {"code":0,"message":"查询所有项目降低目标设置成功","data":[
     * "data":{"id":208,"
     *          item_id":1,
     *          "year":"2009",
     *          "year_percent":90,
     *          "year_value":571666.5000,
     *          "last_year_value":635185,
     *          "jan":47638.875,
     *          "feb":47638.875,
     *          "mar":47638.875,
     *          "apr":47638.875,
     *          "may":47638.875,
     *          "jun":47638.875,
     *          "jul":47638.875,
     *          "aug":47638.875,
     *          "sept":47638.875,
     *          "oct":47638.875,
     *          "nov":47638.875,
     *          "dec":47638.875,
     *          "asset_or_debt":true
     *          "create_date":2019-05-15T08:52:45.000+0000
     *          "item":{
     *              "item_code"="货币资金"
     *              "item_name"="货币资金"
     *              "calc_expr="1001+1002+1009"
     *              "calc_explain"="现金+银行存款+其他货币资金"
     *              "state"="1"
     *              "modify_time"= 2019-04-28T01:54:33.000+0000
     *          }
     *        },
     * "data":{"id":209,"
     *          item_id":2,
     *          "year":"2009",
     *          "year_percent":90,
     *          "year_value":90000.0000,
     *          "last_year_value":100000.0000,
     *          "jan":7500,
     *          "feb":7500,
     *          "mar":7500,
     *          "apr":7500,
     *          "may":7500,
     *          "jun":7500,
     *          "jul":7500,
     *          "aug":7500,
     *          "sept":7500,
     *          "oct":7500,
     *          "nov":7500,
     *          "dec":7500,
     *          "asset_or_debt":true
     *          "create_date":2019-05-15T08:53:10.000+0000
     *          "item":{
     *              "item_code"="短期投资"
     *              "item_name"="短期投资"
     *              "calc_expr="1101-1102"
     *              "calc_explain"="短期投资-短期投资跌价准备"
     *              "state"="1"
     *              "modify_time"= 2019-04-28T01:59:55.000+0000
     *          }
     *        }
     * }
     * */
    @GetMapping("/reduceTargets")
    public BasicResponse<List<ReduceTarget>> queryAll(){
        return BusinessWrapper.wrap(response -> {
            List<ReduceTarget> reduceTargets = reduceTargetService.queryAll();
            ResponseUtil.set(response,0,"查询所有项目降低目标设置成功",reduceTargets);
        }, logger);
    }

/*
    @ApiImplicitParam(name = "id" , value = "减少目标id" , required = true , dataType = "Integer" , paramType = "path")
    @GetMapping("/queryReduceTarget/{id}")
    public BasicResponse<ReduceTarget> queryByID(@PathVariable("id") int id){
        return BusinessWrapper.wrap(response ->{
            ReduceTarget rt =  reduceTargetService.queryByID(id);
            ResponseUtil.set(response,0,"根据ID查询一条记录成功",rt);
        }, logger);
    }
*/
    /**
     * 查询指定项目降低目标设置
     * @api {GET} /reduceTarget?id=  查询指定项目降低目标设置
     * @apiName queryReduceTarget 查询指定项目降低目标设置
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParamExample {json} Request_Example:
     * GET: /reduceTarget?id=208
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查询指定项目降低目标设置",
     * "data":{"id":208,"
     *          item_id":1,
     *          "year":"2009",
     *          "year_percent":90,
     *          "year_value":571666.5000,
     *          "last_year_value":635185,
     *          "jan":47638.875,
     *          "feb":47638.875,
     *          "mar":47638.875,
     *          "apr":47638.875,
     *          "may":47638.875,
     *          "jun":47638.875,
     *          "jul":47638.875,
     *          "aug":47638.875,
     *          "sept":47638.875,
     *          "oct":47638.875,
     *          "nov":47638.875,
     *          "dec":47638.875,
     *          "asset_or_debt":true
     *          "create_date":2019-05-15T08:52:45.000+0000
     *          "item":{
     *              "item_code"="货币资金"
     *              "item_name"="货币资金"
     *              "calc_expr="1001+1002+1009"
     *              "calc_explain"="现金+银行存款+其他货币资金"
     *              "state"="1"
     *              "modify_time"= 2019-04-28T01:54:33.000+0000
     *          }
     *        }
     * */
    @GetMapping("/reduceTarget")
    public BasicResponse<ReduceTarget> queryByID(@RequestParam("id") int id){
        return BusinessWrapper.wrap(response ->{
            ReduceTarget rt =  reduceTargetService.queryByID(id);
            ResponseUtil.set(response,0,"查询指定项目降低目标设置",rt);
        }, logger);
    }

    /**
     * 添加一条项目降低目标设置
     *
     * @api {POST} /reduceTarget 添加一条项目降低目标设置
     * @apiName insertReduceTarget 添加一条项目降低目标设置
     * @apiGroup ReduceTarget
     * @apiParam {BigInteger} item_id 报告条目id
     * @apiParam {String} year 年份
     * @apiParam {Double} year_percent 年度百分比，单位%
     * @apiParam {Boolean} asset_or_debt 资产或负债，0资产  1负债
     * @apiParamExample {json} Request_Example:
     * {
     * "item_id":1,
     * "year":"2013",
     * "year_percent":90,
     * "asset_or_debt":1
     * }
     * POST: /reduceTarget
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"添加一条项目降低目标设置成功","data":true}
     * */
    @PostMapping("/reduceTarget")
    public BasicResponse<Integer> add(@RequestBody ReduceTarget reduceTarget){
        return BusinessWrapper.wrap(response -> {
            Integer flag = reduceTargetService.add(reduceTarget);
            if(flag.intValue() == -1){
                ResponseUtil.set(response,0,"数据库中已存在该条项目降低目标设置",flag);
            }else if(flag.intValue() == 0){
                ResponseUtil.set(response,0,"获取不到去年实际降低额",flag);
            }else{
                ResponseUtil.set(response,0,"添加一条项目降低目标设置成功",flag);
            }
        }, logger);
    }


    /**
     * 删除指定项目降低目标设置
     *
     * @api {DELETE} /reduceTarget?id= 删除指定项目降低目标设置
     * @apiName deleteReduceTarget 删除指定项目降低目标设置
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParamExample {json} Request_Example:
     * DELETE: /reduceTarget?id=230
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"根据id删除一条指定项目降低目标设置成功","data":true}
     * */
    @DeleteMapping("/reduceTarget")
    public BasicResponse<Boolean> deleteByID(@RequestParam("id") int id){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = reduceTargetService.deleteByID(id);
            ResponseUtil.set(response,0,"根据id删除一条指定项目降低目标设置成功",flag);
        }, logger);
    }


    /**
     * 删除所有项目降低目标设置
     *
     * @api {DELETE} /reduceTargets 删除所有项目降低目标设置
     * @apiName deleteAllReduceTargets 删除所有项目降低目标设置
     * @apiGroup ReduceTarget
     * @apiParamExample {json} Request_Example:
     * DELETE: /reduceTargets
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除所有项目降低目标设置", "data":true}
     */
    @DeleteMapping("/reduceTargets")
    public BasicResponse<Boolean> deleteAll(){
        return BusinessWrapper.wrap(response->{
            Boolean flag = reduceTargetService.deleteAll();
            ResponseUtil.set(response,0,"删除所有项目降低目标设置",flag);
        },logger);
    }

    /**
     * 更改指定项目年降低目标值设置
     * @api {PUT} /reduceTarget_yearValue 更改指定项目年降低目标值设置
     * @apiName updateReduceTarget_yearValue 更改指定项目年降低目标值设置
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParam {BigDecimal}  year_value 计算后的年目标值
     * @apiParamExample {json} Request_Example:
     * {
     * "id":208,
     * "year_value":635184.7500
     * }
     * PUT: /reduceTarget_yearValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更改指定项目年降低目标值成功","data":true}
     * */
    @PutMapping("/reduceTarget_yearValue")
    public BasicResponse<Boolean> update(@RequestBody ReduceTarget reduceTarget){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = reduceTargetService.update(reduceTarget);
            ResponseUtil.set(response,0,"更改指定项目年降低目标值成功",flag);
        }, logger);
    }

    /**
     * 批量更改项目年降低目标值
     *
     * @api {PUT} /reduceTargets_yearValue 批量更改项目年降低目标值
     * @apiName updateReduceTargets_yearValue 批量更改项目年降低目标值
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParam {BigDecimal}  year_value 计算后的年目标值
     * @apiParamExample {json} Request_Example:
     *[
     * {"id":226,"year_value":5000},
     * {"id":227,"year_value":5000},
     * ]
     * PUT: /reduceTargets_yearValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"批量更改项目年降低目标值成功","data":true}
     */
    @PutMapping("/reduceTargets_yearValue")
    public BasicResponse<Boolean> updates(@RequestBody List<ReduceTarget> reduceTargets){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = reduceTargetService.updates(reduceTargets);
            ResponseUtil.set(response, 0 ,"批量更改项目年降低目标值成功",flag);
        }, logger);
    }

    /**
     * 更改指定项目年降低目标比例
     * @api {PUT} /reduceTarget_yearPercent 更改指定项目年降低目标比例
     * @apiName updateReduceTarget_yearPercent 更改指定项目年降低目标比例
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParam {BigDecimal}  year_percent 年度百分比，单位%
     * @apiParamExample {json} Request_Example:
     * {
     * "id":215,
     * "year_percent":60
     * }
     * PUT: /reduceTarget_yearPercent
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更改指定项目年降低目标成功","data":true}
     * */
    @PutMapping("/reduceTarget_yearPercent")
    public BasicResponse<Boolean> updateYearPercent(@RequestBody ReduceTarget reduceTarget){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = reduceTargetService.updateYearPercent(reduceTarget);
            ResponseUtil.set(response,0,"更改指定项目年降低目标比例成功",flag);
        }, logger);
    }


    /**
     * 更改指定项目月降低目标
     * @api {PUT} /reduceTarget_monthValue 更改指定项目月降低目标
     * @apiName updateReduceTarget_monthValue 更改指定项目月降低目标
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParam jan 一月份
     * @apiParam feb 二月份
     * @apiParam mar 三月份
     * @apiParam apr 四月份
     * @apiParam may 五月份
     * @apiParam jun 六月份
     * @apiParam jul 七月份
     * @apiParam aug 八月份
     * @apiParam sept 九月份
     * @apiParam oct 十月份
     * @apiParam nov 十一月份
     * @apiParam dec 十二月份
     * @apiParamExample {json} Request_Example:
     * {
     * "id":208,
     * "jan":83.3334
     * "feb":83.3332
     * "mar":83.3333
     * "apr":83.3333
     * "may":83.3333
     * "jun":83.3333
     * "jul":83.3333
     * "aug":83.3333
     * "sept":83.3333
     * "oct":83.3333
     * "nov":83.3333
     * "dec":83.3337
     * }
     * PUT: /reduceTarget_month
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更改指定项目年降低目标","data":true}
     * */
    @PutMapping("/reduceTarget_monthValue")
    public BasicResponse<Boolean> updateMonth(@RequestBody ReduceTarget reduceTarget){
        return BusinessWrapper.wrap(response->{
            Boolean flag = reduceTargetService.updateMonth(reduceTarget);
            ResponseUtil.set(response,0,"更改项目月降低目标成功",flag);
        },logger);
    }


}

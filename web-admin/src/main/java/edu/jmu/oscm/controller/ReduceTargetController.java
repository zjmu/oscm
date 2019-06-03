package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ReduceTargetMapper;
import edu.jmu.oscm.model.Item;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.Report;
import edu.jmu.oscm.service.ReduceTargetService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class ReduceTargetController {
    private static final Logger logger = LoggerFactory.getLogger(ReduceTargetController.class);

    @Autowired
    private ReduceTargetService reduceTargetService;

    /**
     * 查.查询所有项目降低目标设置
     * @api {GET} /reduceTargets 查——查询所有项目降低目标设置
     * @apiName queryAllReduceTargets 查——查询所有项目降低目标设置
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
     *         {"id":208,
     *          "item_id":1003,
     *          "year":"2018",
     *          "year_percent":99,
     *          "year_value":118.8000,
     *          "last_year_value":120,
     *          "jan":9.9,
     *          "feb":9.9,
     *          "mar":9.9,
     *          "apr":9.9,
     *          "may":9.9,
     *          "jun":9.9,
     *          "jul":9.9,
     *          "aug":9.9,
     *          "sept":9.9,
     *          "oct":9.9,
     *          "nov":9.9,
     *          "dec":9.9,
     *          "asset_or_debt":true,
     *          "create_date":2019-06-01T05:13:02.000+0000
     *          "item_name"="货币资金",
     *          "item":{
     *              "item_code"="货币资金",
     *              "item_name"="货币资金",
     *              "calc_expr"="$1001+$1002+$1009",
     *              "calc_explain"="现金+银行存款+其他货币资金",
     *              "state"="1",
     *              "modify_time"= 2019-04-28T01:54:33.000+0000
     *          }
     *        },
     *        .
     *        .
     *        .
     * {"id":233,
     *          "item_id":2015,
     *          "year":"2018",
     *          "year_percent":97,
     *          "year_value":116.4000,
     *          "last_year_value":120,
     *          "jan":9.7,
     *          "feb":9.7,
     *          "mar":9.7,
     *          "apr":9.7,
     *          "may":9.7,
     *          "jun":9.7,
     *          "jul":9.7,
     *          "aug":9.7,
     *          "sept":9.7,
     *          "oct":9.7,
     *          "nov":9.7,
     *          "dec":9.7,
     *          "asset_or_debt":true
     *          "create_date":2019-06-01T06:39:58.000+0000
     *          "item_name"="其他流动负债",
     *          "item":{
     *              "item_code"="其他流动负债",
     *              "item_name"="其他流动负债",
     *              "calc_expr="0",
     *              "calc_explain"="",
     *              "state"="1",
     *              "modify_time"=2019-05-06T09:31:40.000+0000
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

    /**
     * 查.根据年份查询项目降低目标（流动资产或流动负债）
     * @api {GET} /reduceTargets_year_type?year=&type= 查——根据年份查询项目降低目标（流动资产或流动负债）
     * @apiName reduceTargets_year_type 查——根据年份查询项目降低目标（流动资产或流动负债）
     * @apiGroup ReduceTarget
     * @apiParam {String} year 年份
     * @apiParam {Integer} type  1:流动资产 2;流动负债
     * @apiParamExample {json} Request_Example:
     * GET: /reduceTargets_year_type?year=2018&type=1
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {"code":0,"message":"查询所有项目降低目标设置成功","data":[
     *         {"id":208,
     *          "item_id":1003,
     *          "year":"2018",
     *          "year_percent":99,
     *          "year_value":118.8000,
     *          "last_year_value":120,
     *          "jan":9.9,
     *          "feb":9.9,
     *          "mar":9.9,
     *          "apr":9.9,
     *          "may":9.9,
     *          "jun":9.9,
     *          "jul":9.9,
     *          "aug":9.9,
     *          "sept":9.9,
     *          "oct":9.9,
     *          "nov":9.9,
     *          "dec":9.9,
     *          "asset_or_debt":true,
     *          "create_date":2019-06-01T05:13:02.000+0000
     *          "item_name"="货币资金",
     *          "item":{
     *              "item_code"="货币资金",
     *              "item_name"="货币资金",
     *              "calc_expr"="$1001+$1002+$1009",
     *              "calc_explain"="现金+银行存款+其他货币资金",
     *              "state"="1",
     *              "modify_time"= 2019-04-28T01:54:33.000+0000
     *          }
     *        },
     *        .
     *        .
     *        .
     * {"id":220,
     *          "item_id":1015,
     *          "year":"2018",
     *          "year_percent":97,
     *          "year_value":116.4000,
     *          "last_year_value":120,
     *          "jan":9.7,
     *          "feb":9.7,
     *          "mar":9.7,
     *          "apr":9.7,
     *          "may":9.7,
     *          "jun":9.7,
     *          "jul":9.7,
     *          "aug":9.7,
     *          "sept":9.7,
     *          "oct":9.7,
     *          "nov":9.7,
     *          "dec":9.7,
     *          "asset_or_debt":true
     *          "create_date":2019-05-06T02:43:09.000+0000
     *          "item_name"="待摊费用",
     *          "item":{
     *              "item_code"="待摊费用",
     *              "item_name"="待摊费用",
     *              "calc_expr="$1301",
     *              "calc_explain"="待摊费用",
     *              "state"="1",
     *              "modify_time"=2019-05-06T02:43:09.000+0000
     *          }
     *        }
     * }
     * */
    @GetMapping("/reduceTargets_year_type")
    public BasicResponse<List<ReduceTarget>> queryReduceTargetsByYear(@RequestParam("year") String year, @RequestParam("type") Integer type){
        return BusinessWrapper.wrap(response->{
            //获取当前年份的项目
            List<ReduceTarget> reduceTargets = reduceTargetService.queryReduceTargetsByYear(year,type);
            ResponseUtil.set(response,0,"根据年份查询项目降低目标成功",reduceTargets);
        },logger);
    }

    /**
     * 查.询指定项目降低目标设置
     * @api {GET} /reduceTarget?id=  查——查询指定项目降低目标设置
     * @apiName queryReduceTarget 查——查询指定项目降低目标设置
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
     *      {"id":208,
     *          "item_id":1003,
     *          "year":"2018",
     *          "year_percent":99,
     *          "year_value":118.8000,
     *          "last_year_value":120,
     *          "jan":9.9,
     *          "feb":9.9,
     *          "mar":9.9,
     *          "apr":9.9,
     *          "may":9.9,
     *          "jun":9.9,
     *          "jul":9.9,
     *          "aug":9.9,
     *          "sept":9.9,
     *          "oct":9.9,
     *          "nov":9.9,
     *          "dec":9.9,
     *          "asset_or_debt":true,
     *          "create_date":2019-06-01T05:13:02.000+0000
     *          "item_name"="货币资金",
     *          "item":{
     *              "item_code"="货币资金",
     *              "item_name"="货币资金",
     *              "calc_expr"="$1001+$1002+$1009",
     *              "calc_explain"="现金+银行存款+其他货币资金",
     *              "state"="1",
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
     * 增.添加项目降低目标设置
     *
     * @api {POST} /reduceTargets 增——添加项目降低目标设置
     * @apiName insertReduceTargets 增——添加项目降低目标设置
     * @apiGroup ReduceTarget
     * @apiParam {BigInteger} item_id 报告条目id
     * @apiParam {String} year 年份
     * @apiParam {Double} year_percent 年度百分比，单位%
     * @apiParam {Boolean} asset_or_debt 资产或负债，0资产  1负债
     * @apiParamExample {json} Request_Example:
     * [
     *      {"item_id":1003,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1004,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1005,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1006,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1007,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1008,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1009,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1010,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1011,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1012,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1013,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1014,"year":"2019","year_percent":90,"asset_or_debt":1},
     *      {"item_id":1015,"year":"2019","year_percent":90,"asset_or_debt":1}
     * ]
     * POST: /reduceTargets
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"添加项目降低目标设置成功","data":true}
     * */
    @PostMapping("/reduceTargets")
    public BasicResponse<Integer> add(@RequestBody List<ReduceTarget> reduceTargets){
        return BusinessWrapper.wrap(response -> {
            Integer flag = reduceTargetService.add(reduceTargets);
            String msg;
            if(flag.intValue() == -1){
                msg = "数据库中已存在该年份的项目降低目标设置";
            }else if(flag.intValue() == 0){
                //只能添加新一年的
                msg = "不合法的年份";
            } else{
                msg = "添加项目降低目标设置成功";
            }
            ResponseUtil.set(response,0,msg,flag);
        }, logger);
    }

    /**
     * 删.删除指定项目降低目标设置
     *
     * @api {DELETE} /reduceTarget?id= 删——删除指定项目降低目标设置
     * @apiName deleteReduceTarget 删——删除指定项目降低目标设置
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
     * 删.根据年份删除项目降低目标设置（流动资产或流动负债）
     *
     * @api {DELETE} /reduceTargets_year?year=type= 删——根据年份删除项目降低目标设置（流动资产或流动负债）
     * @apiName deleteReduceTarget 删——根据年份删除项目降低目标设置（流动资产或流动负债）
     * @apiGroup ReduceTarget
     * @apiParam {String} year 年份
     * @apiParam {Integer} type  1:流动资产 2;流动负债
     * @apiParamExample {json} Request_Example:
     * DELETE: /reduceTargets_year?year=2019?type=1
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"根据年份删除流动资产（流动负债）项目降低目标设置","data":true}
     * */
    @DeleteMapping("/reduceTargets_year")
    public BasicResponse<Boolean> deleteByYearAndType(@RequestParam("year") String year, @RequestParam("type") int type){
        return BusinessWrapper.wrap(response->{
            Boolean flag = reduceTargetService.deleteByYearAndType(year,type);
            ResponseUtil.set(response,0,"根据年份删除流动资产（流动负债）项目降低目标设置",flag);
        },logger);
    }

    /**
     * 删.删除所有项目降低目标设置
     *
     * @api {DELETE} /reduceTargets 删——删除所有项目降低目标设置
     * @apiName deleteAllReduceTargets 删——删除所有项目降低目标设置
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

/*    @PutMapping("/reduceTargets_yearValue")
    public BasicResponse<Boolean> updates(@RequestBody List<ReduceTarget> reduceTargets){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = reduceTargetService.updates(reduceTargets);
            ResponseUtil.set(response, 0 ,"批量更改项目年降低目标值成功",flag);
        }, logger);
    }*/

/*    @PutMapping("/reduceTarget_yearPercent")
    public BasicResponse<Boolean> updateYearPercent(@RequestBody ReduceTarget reduceTarget){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = reduceTargetService.updateYearPercent(reduceTarget);
            ResponseUtil.set(response,0,"更改指定项目年降低目标比例成功",flag);
        }, logger);
    }*/

    /**
     * 改.批量更改项目年降低目标
     * @api {PUT} /reduceTargets_yearPercent 改——批量更改项目年降低目标
     * @apiName updateReduceTargets_yearPercent 改——批量更改项目年降低目标
     * @apiGroup ReduceTarget
     * @apiParam {int}     id 指定项目降低目标设置id
     * @apiParam {Double}  year_percent 年度百分比，单位%
     * @apiParamExample {json} Request_Example:
     * [
     *      {"id":218,"year_percent":99},
     *      {"id":219,"year_percent":98},
     *      {"id":220,"year_percent":97},
     *      {"id":221,"year_percent":99},
     *      {"id":222,"year_percent":98},
     *      {"id":223,"year_percent":97},
     *      {"id":224,"year_percent":99},
     *      {"id":225,"year_percent":98},
     *      {"id":226,"year_percent":97},
     *      {"id":227,"year_percent":99},
     *      {"id":228,"year_percent":98},
     *      {"id":229,"year_percent":97},
     *      {"id":230,"year_percent":99},
     *      {"id":231,"year_percent":98},
     *      {"id":232,"year_percent":97},
     *      {"id":233,"year_percent":97}
     * ]
     * PUT: /reduceTargets_yearPercent
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更改项目年降低目标比例成功","data":true}
     * */
    @PutMapping("/reduceTargets_yearPercent")
    public BasicResponse<Boolean> updateYearPercents(@RequestBody List<ReduceTarget> reduceTargets){
        return BusinessWrapper.wrap(response ->{
            Boolean flag = reduceTargetService.updateYearPercents(reduceTargets);
            String msg = "";
            if(flag){
                msg = "更改项目年降低目标比例成功";
            }else{
                msg = "更改项目年降低目标比例失败";
            }
            ResponseUtil.set(response,0,msg,flag);
        }, logger);
    }

/*    @PutMapping("/reduceTarget_monthValue")
    public BasicResponse<Boolean> updateMonth(@RequestBody ReduceTarget reduceTarget){
        return BusinessWrapper.wrap(response->{
            Boolean flag = reduceTargetService.updateMonth(reduceTarget);
            ResponseUtil.set(response,0,"更改项目月降低目标",flag);
        },logger);
    }*/

    /**
     * 改.批量更改项目月降低目标
     * @api {PUT} /reduceTargets_monthValue 改——批量更改项目月降低目标
     * @apiName updateReduceTargets_monthValue 改——批量更改项目月降低目标
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
     * [
     *      {
     *       "id":208,
     *       "jan":10,
     *       "feb":9.8,
     *       "mar":9.9,
     *       "apr":9.9,
     *       "may":9.9,
     *       "jun":9.9,
     *       "jul":9.9,
     *       "aug":9.9,
     *       "sept":9.9,
     *       "oct":9.9,
     *       "nov":9.9,
     *       "dec":9.9
     *       },
     *      {
     *       "id":209,
     *       "jan":9.8,
     *       "feb":9.8,
     *       "mar":9.8,
     *       "apr":9.8,
     *       "may":9.8,
     *       "jun":9.8,
     *       "jul":9.7,
     *       "aug":9.8,
     *       "sept":9.7,
     *       "oct":9.8,
     *       "nov":10,
     *       "dec":9.8
     *       }
     * ]
     * PUT: /reduceTargets_monthValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"批量更改项目月降低目标","data":true}
     * */
    @PutMapping("/reduceTargets_monthValue")
    public BasicResponse<Boolean> updateMonths(@RequestBody List<ReduceTarget> reduceTargets){
        return BusinessWrapper.wrap(response->{
            Boolean flag = reduceTargetService.updateMonths(reduceTargets);
            ResponseUtil.set(response,0,"批量更改项目月降低目标",flag);
        },logger);
    }

    /**
     * 查.查询流动资产（或流动负债）条目
     * @api {GET} /items?type= 查——查询流动资产（或流动负债）条目
     * @apiName queryItemsByType 查——查询流动资产（或流动负债）条目
     * @apiGroup ReduceTarget
     * @apiParam {Integer} type  1:流动资产 2;流动负债
     * @apiParamExample {json} Request_Example:
     * GET: /items?type=1
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {"code":0,"message":"查询流动资产（或流动负债）条目成功","data":[
     * "data":{
     *          "id":1003,
     *          "item_code"="货币资金",
     *          "item_name"="货币资金",
     *          "calc_expr"="$1001+$1002+$1009",
     *          "calc_explain"="现金+银行存款+其他货币资金",
     *          "state"="1",
     *          "modify_time"= 2019-04-28T01:54:33.000+0000
     *        },
     *        .
     *        .
     *        .
     * "data":{
     *          "id":1015,
     *          "item_code"="待摊费用",
     *          "item_name"="待摊费用",
     *          "calc_expr="$1301",
     *          "calc_explain"="待摊费用",
     *          "state"="1",
     *          "modify_time"=2019-05-06T02:43:09.000+0000
     *        }
     * }
     * */
    @GetMapping("/items")
    public BasicResponse<List<Item>> queryItems(@RequestParam("type") int type){
        return BusinessWrapper.wrap(response->{
            List<Item> reports = reduceTargetService.queryItems(type);
            ResponseUtil.set(response,0,"查询流动资产（或流动负债）条目成功",reports);
        },logger);
    }

}

package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ReduceTargetMapper;
import edu.jmu.oscm.model.Item;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.Report;
import edu.jmu.oscm.model.ReportItemInstance;
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
     *          "year_percent":60,
     *          "year_value":72.0000,
     *          "last_year_value":120,
     *          "jan":5,
     *          "feb":5,
     *          "mar":5,
     *          "apr":5,
     *          "may":5,
     *          "jun":5,
     *          "jul":5,
     *          "aug":5,
     *          "sept":5,
     *          "oct":5,
     *          "nov":5,
     *          "dec":5,
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
     *          "year_percent":50,
     *          "year_value":60.0000,
     *          "last_year_value":120,
     *          "jan":4.1667,
     *          "feb":4.1667,
     *          "mar":4.1667,
     *          "apr":4.1667,
     *          "may":4.1667,
     *          "jun":4.1667,
     *          "jul":4.1667,
     *          "aug":4.1667,
     *          "sept":4.1667,
     *          "oct":4.1667,
     *          "nov":4.1667,
     *          "dec":4.1663,
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
     * @api {GET} /reduceTargets_year_type?year=year&type=type 查——根据年份查询项目降低目标（流动资产或流动负债）
     * @apiName reduceTargets_year_type 查——根据年份查询项目降低目标（流动资产或流动负债）
     * @apiGroup ReduceTarget
     * @apiParam {String} year 年份
     * @apiParam {Integer} type  1:流动资产 2;流动负债
     * @apiParamExample {json} Request_Example:
     * GET: /reduceTargets_year_type?year=2019&type=1
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {"code":0,"message":"根据年份查询项目降低目标成功","data":[
     *         {"id":19267,
     *          "item_id":1003,
     *          "year":"2019",
     *          "dept_code":"CO001",
     *          "dept_name":"四美达"
     *          "year_percent":0,
     *          "year_value":0,
     *          "last_year_value":188274,
     *          "jan":0,
     *          "feb":0,
     *          "mar":0,
     *          "apr":0,
     *          "may":0,
     *          "jun":0,
     *          "jul":0,
     *          "aug":0,
     *          "sept":0,
     *          "oct":0,
     *          "nov":0,
     *          "dec":0,
     *          "cnaModify"=False    false表示不可修改    true可修改
     *          "asset_or_debt":0,
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
     * {"id":19279,
     *          "item_id":1015,
     *          "year":"2019",
     *          "dept_code":"CO001",
     *          "dept_name":"四美达"
     *          "year_percent":0,
     *          "year_value":0,
     *          "last_year_value":188298,
     *          "jan":0，
     *          "feb":0，
     *          "mar":0，
     *          "apr":0，
     *          "may":0，
     *          "jun":0，
     *          "jul":0，
     *          "aug":0，
     *          "sept":0，
     *          "oct":0，
     *          "nov":0，
     *          "dec":0，
     *          "asset_or_debt":0,
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
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"没有数据","data":null}
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"没有数据","data":{}}
     * */
    @GetMapping("/reduceTargets_year_type")
    public BasicResponse<List<ReduceTarget>> queryReduceTargetsByYear(@RequestParam("year") String year, @RequestParam("type") Integer type){
        return BusinessWrapper.wrap(response->{
            //获取当前年份的项目
            List<ReduceTarget> reduceTargets = reduceTargetService.queryReduceTargetsByYear(year,type);
            String msg = "";
            if(reduceTargets == null || reduceTargets.size() == 0){
                msg = "没有数据";
            }else{
                msg = "根据年份查询项目降低目标成功";
            }
            ResponseUtil.set(response,0,msg,reduceTargets);
        },logger);
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
     *       [
     *            {"id":19267,"year_percent":50},
     *            {"id":19268,"year_percent":40},
     *            {"id":19269,"year_percent":40},
     *            {"id":19270,"year_percent":40},
     *            {"id":19271,"year_percent":40},
     *            {"id":19272,"year_percent":40},
     *            {"id":19273,"year_percent":40},
     *            {"id":19274,"year_percent":40},
     *            {"id":19275,"year_percent":40},
     *            {"id":19276,"year_percent":40},
     *            {"id":19277,"year_percent":40},
     *            {"id":19278,"year_percent":40},
     *            {"id":19279,"year_percent":40}
     *       ]
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
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更改项目年降低目标比例失败","data":false}
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
     * @apiParam {BigDecimal} jan 一月份
     * @apiParam {BigDecimal} feb 二月份
     * @apiParam {BigDecimal} mar 三月份
     * @apiParam {BigDecimal} apr 四月份
     * @apiParam {BigDecimal} may 五月份
     * @apiParam {BigDecimal} jun 六月份
     * @apiParam {BigDecimal} jul 七月份
     * @apiParam {BigDecimal} aug 八月份
     * @apiParam {BigDecimal} sept 九月份
     * @apiParam {BigDecimal} oct 十月份
     * @apiParam {BigDecimal} nov 十一月份
     * @apiParam {BigDecimal} dec 十二月份
     * @apiParamExample {json} Request_Example:
     * [
     *            {
     *             "id":19268,
     *             "jan":3.3330,
     *             "feb":3.3331,
     *             "mar":3.3332,
     *             "apr":3.3333,
     *             "may":3.3334,
     *             "jun":3.3335,
     *             "jul":3.3336,
     *             "aug":3.3337,
     *             "sept":3.3338,
     *             "oct":3.3339,
     *             "nov":3.3330,
     *             "dec":3.3325
     *             },
     *            {
     *             "id":19269,
     *             "jan":3.3331,
     *             "feb":3.3330,
     *             "mar":3.3332,
     *             "apr":3.3333,
     *             "may":3.3334,
     *             "jun":3.3335,
     *             "jul":3.3336,
     *             "aug":3.3337,
     *             "sept":3.3338,
     *             "oct":3.3339,
     *             "nov":3.3330,
     *             "dec":3.3325
     *             }
     *       ]
     * PUT: /reduceTargets_monthValue
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"批量更改项目月降低目标","data":1}
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"只允许修改今年的项目月降低目标","data":0}
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"总合不等于year_percent","data":-1}
     * */
    @PutMapping("/reduceTargets_monthValue")
    public BasicResponse<Integer> updateMonths(@RequestBody List<ReduceTarget> reduceTargets){
        return BusinessWrapper.wrap(response->{
            Integer flag = reduceTargetService.updateMonths(reduceTargets);
            String msg = "";
            if(flag == -1){
                msg = "总合不等于year_percent";
            }else if (flag == 0){
                msg = "只允许修改今年的项目月降低目标";
            }else{
                msg = "批量更改项目月降低目标成功";
            }
            ResponseUtil.set(response,0,msg,flag);
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


    /**
     * 查.查询子部门月降低目标
     * @api {GET} /reduceTargets_child?id=id 查——查询子部门月降低目标（新）
     * @apiName  queryReduceTargetByDepartmentAndItem 查——查询子部门月降低目标
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParamExample {json} Request_Example:
     * GET: /reduceTargets_child?19268
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {"code":0,"message":"查询成功，返回父部门及子部门记录","data":[
     *         {"id":19268,
     *          "item_id":1004,
     *          "year":"2019",
     *          "dept_code":"CO001",
     *          "dept_name":"四美达"
     *          "year_percent":50,
     *          "year_value":75310.4,
     *          "last_year_value":188276,
     *          "jan":3.3333，
     *          "feb":3.3333，
     *          "mar":3.3333，
     *          "apr":3.3333，
     *          "may":3.3333，
     *          "jun":3.3333，
     *          "jul":3.3333，
     *          "aug":3.3333，
     *          "sept":3.3333，
     *          "oct":3.3333，
     *          "nov":3.3333，
     *          "dec":3.3337，
     *          "cnaModify"=False    false表示不可修改    true可修改
     *          "asset_or_debt":0,
     *          "create_date":2019-06-21T12:16:52.000+0000
     *          "item_name"="短期投资",
     *          "item":{
     *              "item_code"="短期投资",
     *              "item_name"="短期投资",
     *              "calc_expr"="$1101-$1102",
     *              "calc_explain"="短期投资-短期投资跌价准备",
     *              "state"="1",
     *              "modify_time"= 2019-04-28T01:59:55.000+0000
     *          }
     *        },
     *        .
     *        .
     *        .
     * {"id":19424,
     *          "item_id":1004,
     *          "year":"2019",
     *          "dept_code":"BIZ01",
     *          "dept_name":"其他"
     *          "year_percent":0,
     *          "year_value":0,
     *          "last_year_value":188962,
     *          "jan":0.5555，
     *          "feb":0.5555，
     *          "mar":0.5555，
     *          "apr":0.5555，
     *          "may":0.5555，
     *          "jun":0.5555，
     *          "jul":0.5555，
     *          "aug":0.5555，
     *          "sept":0.5555，
     *          "oct":0.5555，
     *          "nov":0.5555，
     *          "dec":0.5556，
     *          "asset_or_debt":0
     *          "create_date":2019-06-21T12:16:53.000+0000
     *        }
     * }
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"没有下级部门记录","data":null}
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"输入id有误","data":{}}
     * */
    @GetMapping("/reduceTargets_child")
    public BasicResponse<List<ReduceTarget>> queryReduceTargetByDepartmentAndItem(@RequestParam("id") int id){
        return BusinessWrapper.wrap(response->{
            List<ReduceTarget>  reduceTargets = reduceTargetService.queryReduceTargetByDepartmentAndItem(id);
            String msg = "";
            if(reduceTargets == null){
                msg = "没有下级部门记录";
            }else if(reduceTargets.size() == 0){
                msg = "输入id有误";
            }else {
                msg = "查询成功，返回父部门及子部门记录";
            }
            ResponseUtil.set(response,0,msg,reduceTargets);
        },logger);
    }


    /**
     * 改.更改子部门月降低目标
     * @api {PUT} /reduceTarget_child 改——更改子部门月降低目标（新）
     * @apiName updateMonthByDepartmentAndItem 改——更改子部门月降低目标
     * @apiGroup ReduceTarget
     * @apiParam {int} id 指定项目降低目标设置id
     * @apiParam {BigDecimal} jan 一月份
     * @apiParam {BigDecimal} feb 二月份
     * @apiParam {BigDecimal} mar 三月份
     * @apiParam {BigDecimal} apr 四月份
     * @apiParam {BigDecimal} may 五月份
     * @apiParam {BigDecimal} jun 六月份
     * @apiParam {BigDecimal} jul 七月份
     * @apiParam {BigDecimal} aug 八月份
     * @apiParam {BigDecimal} sept 九月份
     * @apiParam {BigDecimal} oct 十月份
     * @apiParam {BigDecimal} nov 十一月份
     * @apiParam {BigDecimal} dec 十二月份
     * @apiParamExample {json} Request_Example:
     * [
     *          {
     * 	            "id":19268
     *          },
     *          {
     * 	          "id":19294,
     * 	          "jan":0.5559,
     *            "feb":0.5559,
     *             "mar":0.5559,
     *             "apr":0.5559,
     *             "may":0.5559,
     *             "jun":0.5559,
     *             "jul":0.5559,
     *             "aug":0.5559,
     *             "sept":0.5559,
     *             "oct":0.5559,
     *             "nov":0.5559,
     *             "dec":0.5558
     *      },
     *      {
     * 	            "id":19320,
     * 	            "jan":0.5554,
     *             "feb":0.5554,
     *             "mar":0.5554,
     *             "apr":0.5554,
     *             "may":0.5554,
     *             "jun":0.5554,
     *             "jul":0.5554,
     *             "aug":0.5554,
     *             "sept":0.5554,
     *             "oct":0.5554,
     *             "nov":0.5554,
     *             "dec":0.5555
     *      },
     *      {
     * 	            "id":19346,
     * 	            "jan":0.5556,
     *             "feb":0.5556,
     *             "mar":0.5556,
     *             "apr":0.5556,
     *             "may":0.5556,
     *             "jun":0.5556,
     *             "jul":0.5556,
     *             "aug":0.5556,
     *             "sept":0.5556,
     *             "oct":0.5556,
     *             "nov":0.5556,
     *             "dec":0.5557
     *      },
     *      {
     *          	"id":19372,
     * 	            "jan":0.5554,
     *             "feb":0.5554,
     *             "mar":0.5554,
     *             "apr":0.5554,
     *             "may":0.5554,
     *             "jun":0.5554,
     *             "jul":0.5554,
     *             "aug":0.5554,
     *             "sept":0.5554,
     *             "oct":0.5554,
     *             "nov":0.5554,
     *             "dec":0.5555
     *      },
     *      {
     * 	            "id":19398,
     * 	            "jan":0.5556,
     *             "feb":0.5556,
     *             "mar":0.5556,
     *             "apr":0.5556,
     *             "may":0.5556,
     *             "jun":0.5556,
     *             "jul":0.5556,
     *             "aug":0.5556,
     *             "sept":0.5556,
     *             "oct":0.5556,
     *             "nov":0.5556,
     *             "dec":0.5557
     *      },
     *      {
     *          	"id":19424,
     * 	            "jan":0.5554,
     *             "feb":0.5554,
     *             "mar":0.5554,
     *             "apr":0.5554,
     *             "may":0.5554,
     *             "jun":0.5554,
     *             "jul":0.5554,
     *             "aug":0.5554,
     *             "sept":0.5554,
     *             "oct":0.5554,
     *             "nov":0.5554,
     *             "dec":0.5555
     *      }
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
     * {"code":0,"message":"更改子部门月降低目标成功","data":1}
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"不存在","data":-2}
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"修改失败,总和不相等","data":-1}
     * <p>
     * @apiErrorExample  {json} Error-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更改子部门月降低目标成功","data":0}
     * */
    @PutMapping("reduceTarget_child")
    public BasicResponse<Integer> updateMonthByDepartmentAndItem(@RequestBody List<ReduceTarget> reduceTargets){
        return BusinessWrapper.wrap(response->{
            Integer flag = reduceTargetService.updateMonthByDepartmentAndItem(reduceTargets);
            String msg = "";
            if(flag == -2){
                msg = "不存在";
            }else if(flag == -1){
                msg = "修改失败,总和不相等";
            }else if(flag == 0){
                msg = "未作出修改";
            }else {
                msg = "更改子部门月降低目标成功";
            }
            ResponseUtil.set(response,0,msg,flag);
        },logger);
    }
}

package edu.jmu.oscm.controller;
import edu.jmu.oscm.model.MonthReport;
import edu.jmu.oscm.service.MonthReportService;
import edu.jmu.util.BasicResponse;
import edu.jmu.oscm.mapper.MonthReportMapper;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MonthReportController {
    private static final Logger logger = LoggerFactory.getLogger(MonthReportController.class);
    @Autowired
    private MonthReportService monthReportService;
    @Autowired
    private MonthReportMapper monthReportMapper;


    /**
     * 获取指定流动资金成本管控情况月度总结情况报告表记录
     *
     * @api {GET} /monthReport?year=&&month=  查询指定流动资金成本管控情况月度总结情况报告表信息
     * @apiName selectMonthReportByDate 查询指定流动资金成本管控情况月度总结情况报告表信息
     * @apiGroup MonthReport
     * @apiParam {int} id 指定流动资金成本管控情况月度总结情况报告表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /monthReport?year= 2019 && month = 5
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,
     * "message":"查找指定流动资金成本管控情况月度总结情况报告表成功",
     * "data":
     * {
     * {
     *      "id":1,
     *      "index":0,
     *      "item_id":1,
     *      "year":"2019",
     *      "month":"5",
     *      "ok":1,
     *      "plan":"1",
     *      "remark":"1",
     *      "create_date":"2019-01-01 00:00:00"
     *      "item_name":"短期投资"
     *       "item":{
     *                      "item_code"="短期投资"
     *                      "item_name"="短期投资"
     *                      "calc_expr="1101-1102"
     *                      "calc_explain"="短期投资-短期投资跌价准备"
     *                      "state"="1"
     *                      "modify_time"= "2019-04-28 09:59:00"
     *          }
     *       "responsibleDepartments":{
     *           "deptCode"="C500"
     *           "deptName"="战略客户部公共"
     *       }
     *       "responsibleEmployee":{
     *           "employeeName"="陈*坤"
     *           "id"="456"
     *       }
     *       "collaborativeDepartments":{
     *           "deptCode":"B101"
     *           "deptName":"桌面产品营销处"
     *       }
     *       "collaborativeEmployee":{
     *           "employeeName"="袁*娟"
     *           "id"="455"
     *       }
     *    }
     * {
     *      "id":2,
     *      "index:1,
     *      "item_id":1,
     *      "year":"2019",
     *      "month":"5",
     *      "ok":1,
     *      "plan":"1",
     *      "remark":"1",
     *      "create_date":"2019-01-01 00:00:00"
     *      "item_name":"短期投资"
     *       "item":{
     *                      "item_code"="短期投资"
     *                      "item_name"="短期投资"
     *                      "calc_expr="1101-1102"
     *                      "calc_explain"="短期投资-短期投资跌价准备"
     *                      "state"="1"
     *                      "modify_time"= "2019-04-28 09:59:00"
     *          }
     *       "responsibleDepartments":{
     *           "deptCode"="C500"
     *           "deptName"="战略客户部公共"
     *       }
     *       "responsibleEmployee":{
     *           "employeeName"="陈*坤"
     *           "id"="456"
     *       }
     *       "collaborativeDepartments":{
     *           "deptCode":"B101"
     *           "deptName":"桌面产品营销处"
     *       }
     *       "collaborativeEmployee":{
     *           "employeeName"="袁*娟"
     *           "id"="455"
     *       }
     *    }
     * }
     * }
     */
    @GetMapping("/monthReport")
    public BasicResponse<List<MonthReport>> selectMonthReportByDate(@RequestParam("year") String year,@RequestParam("month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<MonthReport> monthReports = monthReportService.selectMonthReportByDate(year,month);
            ResponseUtil.set(response, 0, "查找指定流动资金成本管控情况月度总结情况报告表成功",monthReports);
        }, logger);
    }



    /**
     * 查询所有流动资金成本管控情况月度总结情况报告表记录
     *
     * @api {GET} /monthReports 查询所有流动资金成本管控情况月度总结情况报告表信息
     * @apiName queryAllImonthReport 查询所有流动资金成本管控情况月度总结情况报告表信息
     * @apiGroup MonthReport
     * @apiParamExample {json} Request_Example:
     * GET: /monthReports
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查询所有流动资金成本管控情况月度总结情况报告表成功","data":
     * [
     *     {
     *      "id":1,
     *      "item_id":1,
     *      "year":"2019",
     *      "month":"5","
     *      "target":1000.1,
     *      "value":2000.1,
     *      "difference":3000.1,
     *      "measure":"1111",
     *      "experience":"111",
     *      "deficiency":"111",
     *      "evaluate":"111",
     *      "remark":"111",
     *      "create_date":"2019-01-01 00:00:00-01"
     *       "item":{
     *                      "item_code"="短期投资"
     *                      "item_name"="短期投资"
     *                      "calc_expr="1101-1102"
     *                      "calc_explain"="短期投资-短期投资跌价准备"
     *                      "state"="1"
     *                      "modify_time"= "2019-04-28 09:59:00"
     *          }
     *      },
     *     {
     *      "id":2,
     *      "item_id":1,
     *      "year":"2019",
     *      "month":"5","
     *      "target":1000.1,
     *      "value":2000.1,
     *      "difference":3000.1,
     *      "measure":"1111",
     *      "experience":"111",
     *      "deficiency":"111",
     *      "evaluate":"111",
     *      "remark":"111",
     *      "create_date":"2019-01-01 00:00:00"
     *       "item":{
     *                      "item_code"="短期投资"
     *                      "item_name"="短期投资"
     *                      "calc_expr="1101-1102"
     *                      "calc_explain"="短期投资-短期投资跌价准备"
     *                      "state"="1"
     *                      "modify_time"= "2019-04-28 09:59:00"
     *          }
     *      }
     *  ]
     *  }
     */
    @GetMapping("/monthReports")
    public BasicResponse<List<MonthReport>> getAllMonthReport() {
        return BusinessWrapper.wrap(response -> {
            List<MonthReport> monthReports = monthReportMapper.getAllMonthReport();
            ResponseUtil.set(response, 0, "查询所有流动资金成本管控情况月度总结情况报告表成功", monthReports);
        }, logger);
    }

    /**
     * 删除指定流动资金成本管控情况月度总结情况报告表记录
     * @api {DELETE} /monthReport?id=  删除指定流动资金成本管控情况月度总结情况报告表信息
     * @apiName deleteMonthReport 删除指定流动资金成本管控情况月度总结情况报告表信息
     * @apiGroup MonthReport
     * @apiParam {int} id 指定 流动资金成本管控情况月度总结情况报告表记录id
     * @apiParamExample {json} Request_Example:
     * DELETE: /monthReport?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {
     *      "code":0,
     *      "message":"删除指定流动资金成本管控情况月度总结情况报告表成功"
     * }
     */
    @DeleteMapping("/monthReport")
    public BasicResponse<Boolean> deleteMonthReportById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除指定流动资金成本管控情况月度总结情况报告表成功");
        }, logger);
    }

    /**
     * 删除所有流动资金成本管控情况月度总结情况报告表记录
     * @api {DELETE} /monthReports 删除所有流动资金成本管控情况月度总结情况报告表信息
     * @apiName deleteAllMonthReport 删除所有流动资金成本管控情况月度总结情况报告表信息
     * @apiGroup MonthReport
     * @apiParamExample {json} Request_Example:
     * DELETE: /monthReports
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {
     *      "code":0,
     *      "message":"删除所有流动资金成本管控情况月度总结情况报告表成功"
     * }
     */
    @DeleteMapping("/monthReports")
    public BasicResponse<Boolean>  deleteAllMonthReport()
    {
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.deleteAll();
            ResponseUtil.set(response, 0, "删除所有流动资金成本管控情况月度总结情况报告表成功");
        }, logger);
    }

    /**
     * 插入流动资金成本管控情况月度总结情况报告表记录
     * @api {POST} /monthReport 插入流动资金成本管控情况月度总结情况报告表信息
     * @apiName monthReport 插入流动资金成本管控情况月度总结情况报告表信息
     * @apiGroup MonthReport
     * @apiParam {bigint} item_id 报告条目id
     * @apiParam {String} year 年度
     * @apiParam {String} month 月份
     * @apiParam {BigDecimal} target 目标值
     * @apiParam {BigDecimal} value 末余额
     * @apiParam {BigDecimal} difference 偏差值
     * @apiParam {String} measure 本期主要管控措施
     * @apiParam {String} experience 经验
     * @apiParam {String} deficiency 不足
     * @apiParam {String} evaluate 考核人评价
     * @apiParam {String} remark 备注
     * @apiParam {Timestamp} create_date 创建时间
     * @apiParamExample {json} Request_Example:
     * {
     * "item_id":1,
     * "year":"2019",
     * "month":"5","
     * "target":1000.1,
     * "value":2000.1,
     * "difference":3000.1,
     * "measure":"1111",
     * "experience":"111",
     * "deficiency":"111",
     * "evaluate":"111",
     * "remark":"111",
     * "create_date":"2019-01-01 00:00:00"
     *  }
     * POST: /monthReport
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"插入流动资金成本管控情况月度总结情况报告表成功"}
     */
    @PostMapping("/monthReport")
    public BasicResponse<Boolean> insertMonthReport(@RequestBody  MonthReport monthReport){
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.insertMonthReport(monthReport);
            ResponseUtil.set(response, 0, "插入流动资金成本管控情况月度总结情况报告表成功");
        }, logger);
    }

    /**
     * 更新指定流动资金成本管控情况月度总结情况报告表记录
     * @api {PUT} /monthReport 更新指定流动资金成本管控情况月度总结情况报告表信息
     * @apiName monthReport 更新指定流动资金成本管控情况月度总结情况报告表信息
     * @apiParam {int} id 流动资金成本管控情况月度总结情况报告表id
     * @apiParam {String} measure 本期主要管控措施
     * @apiParam {String} experience 经验
     * @apiParam {String} deficiency 不足
     * @apiParam {String} evaluate 考核人评价
     * @apiParam {String} remark 备注
     * @apiGroup MonthReport
     * @apiParamExample {json} Request_Example:
     * {
     * "id":80,
     * "measure":"1",
     * "experience":"1",
     * "deficiency":"1",
     * "evaluate":"1",
     * "remark":"1"
     * }
     * PUT /monthReport
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更新流动资金成本管控情况月度总结情况报告表成功"}
     */
    @PutMapping("/monthReport")
    public BasicResponse<Boolean> updateMonthReport(@RequestBody  MonthReport monthReport){
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.updateMonthReport(monthReport);
            ResponseUtil.set(response, 0, "更新流动资金成本管控情况月度总结情况报告表成功");
        }, logger);
    }

}

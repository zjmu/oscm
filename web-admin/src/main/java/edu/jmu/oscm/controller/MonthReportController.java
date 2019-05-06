package edu.jmu.oscm.controller;
import edu.jmu.oscm.model.MonthReport;
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
    private MonthReportMapper monthReportMapper;


    /**
     * 获取指定月度总结报告表记录
     *
     * @api {GET} /selectMonthReportById?id=  查询指定月度总结报告表信息
     * @apiName selectMonthReportById 查询指定月度总结报告表信息
     * @apiGroup MonthReport
     * @apiParam {int} id 指定月度总结报告表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /selectMonthReportById?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找指定月度总结报告表成功",
     * "data":{"id":1,"report_item_id":0,"year":"2019","month":"5","ok":1,"plan":"1","remark":"1","date":"2019-01"}}
     */
    @GetMapping("/selectMonthReportById")
    public BasicResponse<MonthReport> selectMonthReportById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            MonthReport monthReport = monthReportMapper.selectMonthReportById(id);
            ResponseUtil.set(response, 0, "查找指定月度总结报告表成功",monthReport);
        }, logger);
    }

    
    /**
     * 查询所有月度总结报告表记录
     *
     * @api {GET} /getAllMonthReport 查询所有月度总结报告表信息
     * @apiName getAllMonthReport 查询所有月度总结报告表信息
     * @apiGroup MonthReport
     * @apiParamExample {json} Request_Example:
     * GET: /getAllMonthReport
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查询所有月度总结报告表成功","data":[
     * {"id":1,
     * "report_item_id":0,
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
     * "date":"2019-01-01"},
     * {"id":2,
     * "report_item_id":0,
     * "year":"2019",
     *  "month":"5","
     *  "target":1000.1,
     *  "value":2000.1,
     *  "difference":3000.1,
     *  "measure":"1111",
     *  "experience":"111",
     *  "deficiency":"111",
     *  "evaluate":"111",
     *  "remark":"111",
     *  "date":"2019-01-01"}]}
     */
    @GetMapping("/getAllMonthReport")
    public BasicResponse<List<MonthReport>> getAllMonthReport() {
        return BusinessWrapper.wrap(response -> {
            List<MonthReport> monthReports = monthReportMapper.getAllMonthReport();
            ResponseUtil.set(response, 0, "查询所有月度总结报告表成功", monthReports);
        }, logger);
    }

    /**
     * 删除指定月度总结报告表记录
     * @api {GET} /deleteMonthReportById?id=  删除指定月度总结报告表信息
     * @apiName deleteMonthReportById 删除指定月度总结报告表信息
     * @apiGroup MonthReport
     * @apiParam {int} id 指定 月度总结报告表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /deleteMonthReportById?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除指定月度总结报告表成功"}
     */
    @GetMapping("/deleteMonthReportById")
    public BasicResponse<Boolean> deleteMonthReportById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除指定月度总结报告表成功");
        }, logger);
    }

    /**
     * 删除所有月度总结报告表记录
     *
     * @api {GET} /deleteAllMonthReport 删除所有月度总结报告表信息
     * @apiName deleteAllMonthReport 删除所有月度总结报告表信息
     * @apiGroup MonthReport
     * @apiParamExample {json} Request_Example:
     * GET: /deleteAllMonthReport
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除所有月度总结报告表成功"}
     */
    @GetMapping("/deleteAllMonthReport")
    public BasicResponse<Boolean>  deleteAllMonthReport()
    {
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.deleteAll();
            ResponseUtil.set(response, 0, "删除所有月度总结报告表成功");
        }, logger);
    }

    /**
     * 插入月度总结报告表记录
     *
     * @api {Post} /insertMonthReport 插入月度总结报告表信息
     * @apiName insertMonthReport 插入所有月度总结报告表信息
     * @apiGroup MonthReport
     * @apiParamExample {json} Request_Example:
     * {
     * "report_item_id":0,
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
     * "date":"2019-01-01"
     *  }
     * POST: /insertMonthReport
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"插入月度总结报告表成功"}
     */
    @PostMapping("/insertMonthReport")
    public BasicResponse<Boolean> insertMonthReport(@RequestBody  MonthReport monthReport){
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.insertMonthReport(monthReport);
            ResponseUtil.set(response, 0, "插入月度总结报告表成功");
        }, logger);
    }

    /**
     * 更新指定月度总结报告表记录
     *
     * @api {Post} /updateMonthReport 更新指定月度总结报告表信息
     * @apiName updateMonthReport 更新指定月度总结报告表信息
     * @apiGroup MonthReport
     * @apiParamExample {json} Request_Example:
     * {
     * "id":1,
     * "report_item_id":0,
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
     * "date":"2019-01-01"
     *  }
     * POST: /updateMonthReport
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"更新月度总结报告表成功"}
     */
    @PostMapping("/updateMonthReport")
    public BasicResponse<Boolean> updateMonthReport(@RequestBody  MonthReport monthReport){
        return BusinessWrapper.wrap(response -> {
            boolean flag = monthReportMapper.updateMonthReport(monthReport);
            ResponseUtil.set(response, 0, "更新月度总结报告表成功");
        }, logger);
    }

}

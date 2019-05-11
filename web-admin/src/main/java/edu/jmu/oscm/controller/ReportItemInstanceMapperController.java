package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ReportItemInstanceMapper;
import edu.jmu.oscm.model.ReportItemInstance;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author zyx
 * @date 19-5-11 下午4:57
 * @email zhangyuxin2009@126.com
 */

@RestController
public class ReportItemInstanceMapperController {
    private static final Logger logger = LoggerFactory.getLogger(ReportItemInstance.class);

    @Autowired
    private ReportItemInstanceMapper reportItemInstanceMapper;

    /**
     * 查找reportItemInstance表成功
     *
     * @api {GET} /getAllReportItemInstance  查询所有reportItemInstance
     * @apiName getAllReportItemInstance 查询reportItemInstance信息
     * @apiGroup ReportItemInstance
     * @apiParamExample {json} Request_Example:
     * GET: /getAllReportItemInstance
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找reportItemInstance表成功",
     * "data":{"id":1,"report_item_id":0,"year":"2019","month":"5","proportion":0.0,"accumulate_proportion":"1.0","asset_or_debt":"0","create_date":"2019-01"}}
     */
    @GetMapping("/getAllReportItemInstance")
    public BasicResponse<List<ReportItemInstance>> getAllReportItemInstances() {
        return BusinessWrapper.wrap(response -> {
            List<ReportItemInstance> reportItemInstances = reportItemInstanceMapper.getAllReportItemInstance();
            ResponseUtil.set(response, 0, "查找reportItemInstance表成功", reportItemInstances);
        }, logger);
    }

    /**
     * 查找reportItemInstance表成功
     *
     * @api {GET} /selectReportItemInstanceByYearAndMonth  查询指定年月的reportItemInstance
     * @apiName selectReportItemInstanceByYearAndMonth 查询reportItemInstance信息
     * @apiGroup ReportItemInstance
     * @apiParamExample {json} Request_Example:
     * GET: /getAllReportItemInstance
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找reportItemInstance表成功",
     * "data":{"id":1,"report_item_id":0,"year":"2019","month":"5","proportion":0.0,"accumulate_proportion":"1.0","asset_or_debt":"0","create_date":"2019-01"}}
     */
    @GetMapping("/selectReportItemInstanceByYearAndMonth")
    public BasicResponse<List<ReportItemInstance>> selectReportItemInstanceByYearAndMonth(@RequestParam("year") String year, @RequestParam("month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<ReportItemInstance> reportItemInstances = reportItemInstanceMapper.getReportItemInstanceByYearAndMonth(year,month);
            ResponseUtil.set(response, 0, "查找reportItemInstance表成功", reportItemInstances);
        }, logger);
    }

}

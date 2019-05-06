package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ValueCreationMapper;
import edu.jmu.oscm.model.ValueCreation;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ValueCreationController {

    private static final Logger logger = LoggerFactory.getLogger(ValueCreationController.class);

    @Autowired
    private ValueCreationMapper valueCreationMapper;

    /**
     * 插入流动资金占用成本管控增创价值表
     *
     * @api {Post} /createValueCreation 插入流动资金占用成本管控增创价值表信息
     * @apiName createValueCreation 插入流动资金占用成本管控增创价值表信息
     * @apiGroup ValueCreation
     * @apiParamExample {json} Request_Example:
     *{
     *  "id":3,
     *  "reportItemId":46,
     *  "year":2018,
     *  "month":7,
     *  "lowerTarget":27.0,
     *  "totalLowerTarget":36.1,
     *  "realLowerTarget":15.2,
     *  "realTotalLowerTarget":68.2,
     *  "difference":28.0,
     *  "date":"2019-05-05"
     *}
     * POST: /createValueCreation
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"增加记录成功","data":true}
     */
    @PostMapping("/createValueCreation")
    public BasicResponse<Boolean> create(@RequestBody ValueCreation valueCreation) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = valueCreationMapper.insert(valueCreation);
            ResponseUtil.set(response, 0, "增加记录成功", isSuccess);
        }, logger);
    }

    /**
     * 删除所有流动资金占用成本管控增创价值表
     *
     * @api {Delete} /deleteAllValueCreation 删除所有流动资金占用成本管控增创价值表信息
     * @apiName deleteAllValueCreation  删除所有流动资金占用成本管控增创价值表信息
     * @apiGroup ValueCreation
     * @apiParamExample {json} Request_Example:
     * Delete: /deleteAllValueCreation
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"清空数据成功","data":true}
     */
    @DeleteMapping("/deleteAllValueCreation")
    public BasicResponse<Boolean> deleteAll() {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = valueCreationMapper.deleteAll();
            ResponseUtil.set(response, 0, "清空数据成功", isSuccess);
        }, logger);
    }


    /**
     * 根据ID删除流动资金占用成本管控增创价值表
     *
     * @api {Delete} /deleteValueCreation?id= 删除指定流动资金占用成本管控增创价值表信息
     * @apiName deleteValueCreation 删除指定流动资金占用成本管控增创价值表信息
     * @apiGroup ValueCreation
     * @apiParam {Integer} id 指定要删除的流动资金占用成本管控增创价值表记录id
     * @apiParamExample {json} Request_Example:
     * Delete: /deleteValueCreation?id=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除数据成功","data":true}
     */
    @DeleteMapping("/deleteValueCreation")
    public BasicResponse<Boolean> deleteAll(@RequestParam(value="id") Integer id) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = valueCreationMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除数据成功", isSuccess);
        }, logger);
    }


    /**
     * 更新流动资金占用成本管控增创价值表
     *
     * @api {Put} /updateValueCreation 更新流动资金占用成本管控增创价值表信息
     * @apiName updateValueCreation 更新流动资金占用成本管控增创价值表信息
     * @apiGroup ValueCreation
     * @apiParamExample {json} Request_Example:
     *{
     *  "id":1,
     *  "reportItemId":23,
     *  "year":2014,
     *  "month":5,
     *  "lowerTarget":25.0,
     *  "totalLowerTarget":16.1,
     *  "realLowerTarget":17.2,
     *  "realTotalLowerTarget":18.2,
     *  "difference":23.0,
     *  "date":"2019-05-05"
     *}
     * PUT: /updateValueCreation
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"修改数据成功","data":true}
     */
    @PutMapping("/updateValueCreation")
    public BasicResponse<Boolean> update(@RequestBody ValueCreation valueCreation) {
        return BusinessWrapper.wrap(response -> {
            Boolean isSuccess = valueCreationMapper.update(valueCreation);
            ResponseUtil.set(response, 0, "修改数据成功", isSuccess);
        }, logger);
    }

    /**
     * 查询所有流动资金占用成本管控增创价值表
     * @api {GET} /queryAllValueCreation 查询所有流动资金占用成本管控增创价值
     * @apiName queryAllValueCreation 查询所有流动资金占用成本管控增创价值
     * @apiGroup ValueCreation
     * @apiParamExample {json} Request_Example:
     * GET: /queryAllValueCreation
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {"code": 0,"message": "查询数据成功","data": [
     * {id": 1,"reportItemId": 1,"year": "2018","month": "9","lowerTarget": 74564,
     *  "totalLowerTarget": 311313,"realLowerTarget": 877878,"realTotalLowerTarget": 32323,
     *  "difference": 4545,date": "2019-05-06" },
     * {"id": 2,"reportItemId": 1,"year": "2019","month": "1","lowerTarget": 12121,
     *  "totalLowerTarget": 4545,"realLowerTarget": 45454,"realTotalLowerTarget": 87878,
     *  "difference": 542112,"date": "2019-05-04" }]
     * }
     * */
    @GetMapping("/queryAllValueCreation")
    public BasicResponse<List<ValueCreation>> queryAll() {
        return BusinessWrapper.wrap(response -> {
            List<ValueCreation> result = valueCreationMapper.selectAll();
            ResponseUtil.set(response, 0, "查询数据成功", result);
        }, logger);
    }

    /**
     * 根据年月查询流动资金占用成本管控增创价值表
     * @api {GET} /queryValueCreation?year=&month= 根据年月查询流动资金占用成本管控增创价值
     * @apiName queryValueCreation 根据年月查询流动资金占用成本管控增创价值
     * @apiGroup ValueCreation
     * @apiParam {String} year 指定流动资金占用成本管控增创价值表year值
     * @apiParam {String} month 指定流动资金占用成本管控增创价值表month值
     * @apiParamExample {json} Request_Example:
     * GET: /queryValueCreation?year= & month=
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *{"code":0,"message":"查询数据成功","data":[{
     * "id":2,"reportItemId":1,"year":"2019","month":"1","lowerTarget":12121.0000,"totalLowerTarget":4545.0000,
     * "realLowerTarget":45454.0000,"realTotalLowerTarget":87878.0000,"difference":542112.0000,"date":"2019-05-04"}]
     * }
     * */
    @GetMapping("/queryValueCreation")
    public BasicResponse<List<ValueCreation>> queryByDate(@RequestParam(value = "year") String year,@RequestParam(value = "month") String month) {
        return BusinessWrapper.wrap(response -> {
            List<ValueCreation> result = valueCreationMapper.selectByDate(year,month);
            ResponseUtil.set(response, 0, "查询数据成功", result);
        }, logger);
    }
}

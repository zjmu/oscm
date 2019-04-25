package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.IncomeStructMapper;
import edu.jmu.oscm.mapper.IncomeValueMapper;
import edu.jmu.oscm.model.Credence;
import edu.jmu.oscm.model.IncomeStruct;
import edu.jmu.oscm.model.IncomeValue;
import edu.jmu.oscm.model.Order;
import edu.jmu.oscm.service.IncomeService;
import edu.jmu.oscm.service.IncomeStructService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IncomeController {
    private static final Logger logger = LoggerFactory.getLogger(IncomeController.class);

    @Autowired
    private IncomeStructService incomeStructService;

    @Autowired
    private IncomeService incomeService;

    /**
     * 计算并生成损益表
     *
     * @api {GET} /incomes/2018-07 计算损益表的年月金额
     * @apiName getIncome 计算并生成损益表
     * @apiGroup api
     * @apiParamExample {json} Request_Example:
     * GET: /incomes
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查询成功","data":[{"id":0,"income_id":1,"year":2018,"month":07,"month_amount":19888,"year_amount":89998,"create_date":2019-04-18}]}
     */
    @GetMapping("/incomes")
    public BasicResponse<List<IncomeValue>> getIncome() {

        return BusinessWrapper.wrap(response -> {
//            List<IncomeStruct> incomeStructs = incomeStructMapper.findForum();
//            String s = incomeStructs.get(0).getMonthForum();
            String localDate = "2018-12";
            List<IncomeValue> result = incomeService.service(localDate);
            ResponseUtil.set(response, 0, "查询成功", result);
        }, logger);
    }

     /**
     * 对损益表结构的增删改
     *
     * @api {GET} /update 修改损益表结构
     * @apiName update
     * @apiGroup api
     * @apiParamExample {json} Request_Example:
     * GET: /orders
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"修改成功","data"}
     */
    @GetMapping("/update")
    public BasicResponse<String> update(@RequestBody List<IncomeStruct> incomeStruct){

        return BusinessWrapper.wrap(response -> {
            String result = incomeStructService.change(incomeStruct);

            ResponseUtil.set(response, 0, "修改成功", result);
        }, logger);
    }

//    @GetMapping("/incomeStruct-delete")
//    public BasicResponse<Boolean> delete(@RequestBody Integer income_id){
//
//        return BusinessWrapper.wrap(response -> {
//            Boolean result = incomeStructService.delete(income_id);
//
//            ResponseUtil.set(response, 0, "删除成功", result);
//        }, logger);
//    }
//
//    @GetMapping("incomeStruct-add")
//    public BasicResponse<Boolean> add(@RequestBody List<IncomeStruct> IncomeStructs){
//
//        return BusinessWrapper.wrap(response -> {
//            Boolean result = incomeStructService.add();
//
//            ResponseUtil.set(response, 0, "增加成功", result);
//        }, logger);
//    }
}
package edu.jmu.oscm.controller;

import edu.jmu.oscm.mapper.ProportionMapper;
import edu.jmu.oscm.model.Proportion;
import edu.jmu.oscm.model.ReportItemInstance;
import edu.jmu.oscm.service.ProportionService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private ProportionService proportionService;

    /**
     * 查找项目占比表成功
     *
     * @api {GET} /selectProportionById?id=  根据id查询指定项目占比
     * @apiName selectProportionById 查询项目占比信息
     * @apiGroup Proportion
     * @apiParam {int} id 指定项目占比表记录id
     * @apiParamExample {json} Request_Example:
     * GET: /selectProportionById?id=
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
            ResponseUtil.set(response, 0, "查找项目占比表成功", proportion);
        }, logger);
    }

    /**
     * 查找所有项目占比表记录
     *
     * @api {GET} /getAllProportion 查找所有项目占比表记录
     * @apiName getAllProportion 查找所有项目占比表记录
     * @apiGroup getAllProportion
     * @apiParamExample {json} Request_Example:
     * GET: /getAllProportion
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找所有项目占比表记录成功",
     * "data":[
     * {
     * "id":143,
     * "report_item_id":0,
     * "year":"",
     * "month":"",
     * "proportion":0.6196991,
     * "accumulate_proportion":0.6196991,
     * "asset_or_debt":0,
     * "create_date":"2019-01-01 00:00:00"},
     * {
     * "id":146,
     * "report_item_id":0,
     * "year":"",
     * "month":"",
     * "proportion":0,
     * "accumulate_proportion":0.75356704,
     * "asset_or_debt":0,
     * "create_date":"2019-01-01 00:00:00"
     * }
     * ]}
     */
    @GetMapping("/getAllProportion")
    public BasicResponse<List<Proportion>> getAllProportion() {
        return BusinessWrapper.wrap(response -> {


            List<Proportion> proportions = proportionMapper.getAllProportion();
            ResponseUtil.set(response, 0, "查找项目占比表成功", proportions);


            }, logger);
    }

    /**
     * 删除指定项目占比表记录
     *
     * @api {DELETE} /deleteProportionById 删除指定项目占比表记录
     * @apiName deleteImprovementPlanById 删除指定项目占比表记录
     * @apiGroup deleteProportionById
     * @apiParam {int} id 删除指定项目占比表记录id
     * @apiParamExample {json} Request_Example:
     * DELETE: /deleteProportionById?id=1
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除指定项目占比表记录成功"}
     */
    @GetMapping("/deleteProportionById")
    public BasicResponse<Boolean> deleteProportionById(@RequestParam("id") int id) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.deleteById(id);
            ResponseUtil.set(response, 0, "删除指定项目占比表成功");
        }, logger);
    }

    /**
     * 删除所有项目占比表记录
     *
     * @api {DELETE} /deleteAllProportion 删除所有项目占比表记录
     * @apiName deleteAllProportion 删除所有项目占比表记录
     * @apiGroup deleteAllProportion
     * @apiParamExample {json} Request_Example:
     * DELETE: /deleteAllProportion
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"删除所有项目占比表记录"}
     */
    @GetMapping("/deleteAllProportion")
    public BasicResponse<Boolean> deleteAllProportion() {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.deleteAll();
            ResponseUtil.set(response, 0, "删除所有项目占比表成功");
        }, logger);
    }

    /**
     * 插入项目占比表记录
     *
     * @api {POST} /insertProportion 插入项目占比表
     * @apiName insertProportion 插入项目占比表
     * @apiGroup insertProportion
     * @apiParam {bigint} report_item_id 报告条目id
     * @apiParam {String} year 年度
     * @apiParam {String} month 月份
     * @apiParam {String} proportion 比例
     * @apiParam {String} accumulate_proportion 累计比例
     * @apiParam {Boolean} asset_or_debt 资产或负债
     * @apiParam {Timestamp} create_date 创建时间
     * @apiParamExample {json} Request_Example:
     * {
     * "report_item_id":0,
     * "year":"",
     * "month":"",
     * "proportion":0,
     * "accumulate_proportion":0.75356704,
     * "asset_or_debt":0,
     * "create_date":"2019-01-01 00:00:00"
     * }
     * POST: /insertImprovementPlan
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"插入项目占比表成功"}
     */
    @PostMapping("/insertProportion")
    public BasicResponse<Boolean> insertProportion(@RequestBody Proportion proportion) {
        return BusinessWrapper.wrap(response -> {
            boolean flag = proportionMapper.insertProportion(proportion);
            if (flag) {
                ResponseUtil.set(response, 0, "插入项目占比表成功");
            } else {
                ResponseUtil.set(response, 100, "插入项目占比表失败");
            }
        }, logger);
    }

    /**
     * 查找项目占比表成功
     *
     * @api {GET} /selectProportionAndReport?year=year&&month=month&&type=type  查询指定项目占比
     * @apiName selectProportionAndReport 查询项目占比信息
     * @apiGroup Proportion
     * @apiParam {String} year 指定项目占比表年
     * @apiParam {String} month 指定项目占比表月
     * @apiparam {int} reportId 指定报表的Id
     * @apiParam {int} type 查询指定项目占比（资产和负债）
     * @apiParamExample {json} Request_Example:
     * GET: /selectProportionAndReport?year=year&&month=month&&type=type
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"查找项目占比表成功",
     * "data":{}
     */
    @GetMapping("/selectProportionAndReport")
    public BasicResponse<List<Proportion>> selectProportionAndReport(@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("type") boolean type) {
        return BusinessWrapper.wrap(response -> {

            List<Proportion> proportions = proportionMapper.selectProportionByYearAndMonthAndType(year, month, 1, type);

            ResponseUtil.set(response, 0, "查找项目占比表成功", proportions);
        }, logger);
    }

    /**
     * 判断是否计算
     *
     * @api {GET} /isCalculateProportion?year=year&&month=month&&type=type  判断是否计算
     * @apiName isCalculateProportion 判断项目占比是否计算
     * @apiGroup Proportion
     * @apiParam {String} year 指定项目占比表年
     * @apiParam {String} month 指定项目占比表月
     * @apiParam {int} type 查询指定项目占比（资产和负债）
     * @apiParamExample {json} Request_Example:
     * 如果已经计算，返回所有的信息。没有计算，提示用户进行计算
     * GET: /isCalculateProportion?year=year&&month=month&&type=type
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"本月已经计算",
     * "data":{}
     */
    @GetMapping("/isCalculateProportion")
    public BasicResponse<Map<String, Object>> isCalculateProportion(@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("type") boolean type) {
        return BusinessWrapper.wrap(response -> {

            // 得到的数据
            List<Proportion> proportions = proportionMapper.selectProportionByYearAndMonthAndType(year, month, 1, type);

            if (proportions.size() == 0) {
                ResponseUtil.set(response, 1, "本月尚未计算，请进行计算", null);
            } else {
                Map<String, Object> result = new HashMap<>();

                float[] total = new float[1];
                String name = null;
                //type为0 表示流动资产项目 type为1 表示流动负债项目
                if (!type) {
                    name = "流动资产";
                } else {
                    name = "流动负债";
                }

                // 得到数据
                List<ReportItemInstance> list = proportionMapper.calculateProportionOfYearAndMonth(year, month, name);

                // 查找到每一项的金额
                for (int i = 0; i < list.size(); i++) {
                    proportions.get(i).setValue(list.get(i).getEndValue());
                }

                // 获得总计
                for (ReportItemInstance value : list) {
                    total[0] = total[0] + Float.parseFloat(value.getEndValue());
                }

                result.put("list", proportions);
                result.put("total", total[0]);

                // 已经计算 直接返回本月的信息
                ResponseUtil.set(response, 0, "本月已经计算", result);
            }


        }, logger);
    }

    /**
     * 计算项目占比表成功
     *
     * @api {GET} /calculateProportionAndReport?year=year&&month=month&&type=type  计算指定项目占比（旧的，暂时不用）
     * @apiName calculateProportionAndReport 计算项目占比信息
     * @apiGroup Proportion
     * @apiParam {String} year 指定项目占比表年
     * @apiParam {String} month 指定项目占比表月
     * @apiParam {int} type 查询指定项目占比（资产和负债）
     * @apiParamExample {json} Request_Example:
     * 删掉数据库本月的所有记录并且重新生成、写入数据库中
     * GET: /calculateProportionAndReport?year=year&&month=month&&type=type
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"计算项目占比表成功,请查询",
     * "data":{}
     */
    @GetMapping("/calculateProportionAndReport")
    public BasicResponse<Boolean> calculateProportionData(@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("type") int type) {

        return BusinessWrapper.wrap(response -> {

            String name = null;
            //type为0 表示流动资产项目 type为1 表示流动负债项目
            if (type == 0) {
                name = "流动资产";
            } else {
                name = "流动负债";
            }

            // 先把原有的记录删掉 再重新进行计算
            Boolean flag1 = proportionMapper.deleteByYearAndMonthAndType(year, month, type);

            // 得到数据
            List<ReportItemInstance> list = proportionMapper.calculateProportionOfYearAndMonth(year, month, name);

            // 写入
            Boolean flag = proportionService.getList(list, true);

            if (flag) {
                ResponseUtil.set(response, 0, "计算项目占比表成功,请查询", null);
            } else {
                ResponseUtil.set(response, 0, "计算项目占比表失败,请检查数据库", null);
            }

        }, logger);
    }


    /**
     * 获取所有的部门名称接口
     *
     * @api {GET} /getAllDepartment  获取所有的部门名称
     * @apiName getAllDepartment 获取所有的部门名称
     * @apiGroup Proportion
     * @apiParamExample {json} Request_Example:
     * GET: /getAllDepartment
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"获取所有的部门名称成功,请查询",
     * "data":{}
     */
    @GetMapping("/getAllDepartment")
    public BasicResponse<List<ReportItemInstance>> getAllDepartment() {
        return BusinessWrapper.wrap(response -> {

            List<ReportItemInstance> list = proportionMapper.getAllDepartment();

            ResponseUtil.set(response, 0, "获取部门成功，请查询", list);

        }, logger);
    }


    /**
     * 计算项目占比成功（含部门信息），并且返回占比信息
     *
     * @api {GET} /calculateProportion  计算某部门某年月某类型项目占比信息并且返回
     * @apiName calculateProportion 生成项目占比表
     * @apiGroup Proportion
     * @apiParamExample {json} Request_Example:
     * GET: /calculateProportion
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"生成项目占比表成功（含部门信息）并返回",
     * "data":{}
     */
    @GetMapping("/calculateProportion")
    public BasicResponse<List<Proportion>> calculateProportion(@RequestParam("deptName") String deptName, @RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("type") int type) {
        return BusinessWrapper.wrap(response -> {

            // 初始化要用占比List和占比item
            List<Proportion> proportions = new ArrayList<>();
            Proportion proportion;

            // 总计、累计、单项
            float[] total = new float[1];
            float[] accumProp = new float[1];
            float[] prop = new float[1];

            // type
            boolean flagType;

            //获取相应的deptCode
            List<ReportItemInstance> result = proportionMapper.getAllDepartment();

            Map<String, String> map = new HashMap<>();

            for (ReportItemInstance reportItemInstance : result) {
                map.put(reportItemInstance.getDeptName(), reportItemInstance.getDeptCode());
            }

            final String deptCode = map.get(deptName);

            //判断是流动资产 or 流动负债
            String name = null;
            //type为0 表示流动资产项目 type为1 表示流动负债项目
            if (type == 0) {
                name = "流动资产";
            } else {
                name = "流动负债";
            }

            // 删除原有旧的记录
            // 先把原有的记录删掉 再重新进行计算
            proportionMapper.deleteByDeptAndYearAndMonthAndType(deptCode, year, month, type);

            // 找到所有新生成的记录
            List<ReportItemInstance> list = proportionMapper.selectProportionByDeptAndYearAndMonthAndType(deptCode, year, month, name);

            // 写入数据库中

            // 0.type格式处理
            flagType = type != 0;

            // 1.获得总计
            for (ReportItemInstance value : list) {
                total[0] = total[0] + Float.parseFloat(value.getEndValueSum());
            }

            System.out.println("总计值为：" + total[0]);

            //2.填充每一项
            for (ReportItemInstance value : list) {
                prop[0] = Float.valueOf(value.getEndValueSum()) / total[0];
                accumProp[0] = accumProp[0] + prop[0];

                proportion = new Proportion();

                proportion.setItemId(new BigInteger(value.getItemId(), 10));
                proportion.setItemCode(value.getItemCode());
                proportion.setItemName(value.getItemCode());
                proportion.setDeptCode(deptCode);
                proportion.setDeptName(deptName);
                proportion.setYear(value.getYear());
                proportion.setMonth(value.getMonth());
                proportion.setProportion(String.valueOf(prop[0]));
                proportion.setAccumulateProportion(String.valueOf(accumProp[0]));
                proportion.setAssetOrDebt(flagType);
                proportion.setCreateDate(new Timestamp(new java.util.Date().getTime()).toString());

                proportions.add(proportion);
            }

            System.out.println("总列表为：" + proportions);

            //3. 插入输入库中
            boolean flag = proportionMapper.insertProportions(proportions);

            List<Proportion> returnList = proportionMapper.selectProportionByDeptAndYearAndMonthAndTypeFromProportion(deptCode, year, month, flagType);

            ResponseUtil.set(response, 0, "生成" + deptName + "部门" + year + "年" + month + "月" + name + "表成功", returnList);

        }, logger);
    }

    /**
     * 探测项目占比表是否计算（含部门信息）
     *
     * @api {GET} /selectProportion  探测项目占比表是否计算
     * @apiName selectProportion 探测项目占比表是否计算
     * @apiGroup Proportion
     * @apiParamExample {json} Request_Example:
     * GET: /selectProportion
     * <p>
     * Request Header 如下
     * Content-Type:application/json;charset=utf-8
     * Authorization:Bearer {jwt}
     * <p>
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * <p>
     * {"code":0,"message":"探测项目占比表是否计算成功（含部门信息）",
     * "data":{}
     */
    @GetMapping("/selectProportion")
    public BasicResponse<List<Proportion>> selectProportion(@RequestParam("deptName") String deptName, @RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("type") int type) {

        return BusinessWrapper.wrap(response -> {

            //获取相应的deptCode
            List<ReportItemInstance> result = proportionMapper.getAllDepartment();

            Map<String, String> map = new HashMap<>();

            for (ReportItemInstance reportItemInstance : result) {
                map.put(reportItemInstance.getDeptName(), reportItemInstance.getDeptCode());
            }

            final String deptCode = map.get(deptName);

            // type格式处理
            Boolean flagType = type != 0;

            // 获取所有的proportion
            List<Proportion> list = proportionMapper.selectProportionByDeptAndYearAndMonthAndTypeFromProportion(deptCode, year, month, flagType);

            if (list.size()==0){
                //本月还未计算
                ResponseUtil.set(response, -1, "请先进行计算" , list);
            }else{
                //本月已经计算
                ResponseUtil.set(response, 0, "查询" + deptName + "部门" + year + "年" + month + "月信息成功" , list);
            }

        }, logger);
    }
}

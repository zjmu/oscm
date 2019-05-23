package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ReduceTarget;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ReduceTargetMapper {
    /**
     * 查找所有项目降低目标设置
     * @return 返回所有项目降低目标设置
     * */
    List<ReduceTarget> queryAll();

    /**
     * 添加一条项目降低目标设置
     * @param reduceTarget
     * @return true or false
     * */
    Boolean add(ReduceTarget reduceTarget);

    /**
     * 删除指定项目降低目标设置
     * @param id
     * @return true or false
     * */
    Boolean deleteByID(int id);

    /**
     * 删除所有项目降低目标设置
     * @return true or false
     * */
    Boolean deleteAll();

    /**
     * 查询一条项目降低目标设置
     * @param id
     * @return 一条项目降低目标设置
     * */
    ReduceTarget queryByID(int id);

    /**
     * 更新指定项目降低目标设置
     * @param reduceTarget
     * @return true or false
     * */
    Boolean update(ReduceTarget reduceTarget);

    /**
     * 批量更新项目降低目标设置
     * @param reduceTargets
     * @return true or false
     * */
    Boolean updates(List<ReduceTarget> reduceTargets);

    /**
     * 更改指定项目年降低目标比例
     * @param reduceTarget ReduceTarget
     * @return true or false
     * */
    Boolean updateYearPercent(ReduceTarget reduceTarget);

    /**
     * 更改项目月降低目标成功
     * @param reduceTarget ReduceTarget
     * @return true or false
     * */
    Boolean updateMonth(ReduceTarget reduceTarget);

    /**
     * 查询去年实际降低额
     * @param year String
     * @param item_id BigInteger
     * @return true or false
     * */
    BigDecimal selectLastYearValue(@Param("year") String year, @Param("item_id") BigInteger item_id);

    /**
     * 查看数据库是否存在该year和report_item_id
     * @param year String
     * @param item_id BigInteger
     * @return true or false
     * */
    Boolean selectYearAndReportID(@Param("year") String year, @Param("item_id") BigInteger item_id);
}

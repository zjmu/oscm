package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Item;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.Report;
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

    /***
     * 根据年份查询所有降低目标设置 type=1 查询资产； type=2 查询负债
     * @param year String
     * @param itemCodes List<String>
     * @return 所有资产降低目标设置 or 所有负债降低目标设置
     */
    List<ReduceTarget> queryReduceTargetsByYear(@Param("year") String year, @Param("itemCodes") List<String> itemCodes);

    /**
     * 添加一条项目降低目标设置
     * @param reduceTargets List<ReduceTarget>
     * @return true or false
     * */
    Boolean add(List<ReduceTarget> reduceTargets);

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

    /***
     * 根据年份删除流动资产(type = 1)或流动负债表(type = 2)
     * @param year String
     * @param type Integer
     * @return true or false
     */
    Boolean deleteByYearAndType(@Param("year") String year, @Param("type") Integer type);

    /**
     * 查询一条项目降低目标设置
     * @param id
     * @return 一条项目降低目标设置
     * */
    ReduceTarget queryByID(int id);

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

    /***
     * 批量更改项目降低目标比例
     * @param reduceTargets List<ReduceTarget>
     * @return true or false
     */
    Boolean updateYearPercents(List<ReduceTarget> reduceTargets);

    /**
     * 更改项目月降低目标
     * @param reduceTarget ReduceTarget
     * @return true or false
     * */
    Boolean updateMonth(ReduceTarget reduceTarget);

    /***
     * 批量更改项目月降低目标
     * @param reduceTargets
     * @return
     */
    Boolean updateMonths(List<ReduceTarget> reduceTargets);

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
    Boolean selectYearAndItemID(@Param("year") String year, @Param("item_id") BigInteger item_id);

    /***
     * 查询所有流动资产项目或者流动负债项目
     * @param itemCodes List<String>
     * @return 所有流动资产项目或者流动负债项目
     */
    List<Item> queryItems(@Param("itemCodes") List<String> itemCodes );

    /***
     * 群钊数据库最新的年份
     * @return 年份
     */
    String queryMaxYear();

    /***
     * 查找流动资产或流动负债item_code
     * @param type String
     * @return 流动资产或流动负债item_code
     */
    List<String> queryItemCode(@Param("type") String type);
}

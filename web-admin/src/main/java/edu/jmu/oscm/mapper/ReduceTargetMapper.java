package edu.jmu.oscm.mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.jmu.oscm.model.ReduceTarget;
import org.apache.ibatis.annotations.Mapper;

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

    Boolean updateMonth(ReduceTarget reduceTarget);
}

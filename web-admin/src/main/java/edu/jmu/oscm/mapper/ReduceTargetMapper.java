package edu.jmu.oscm.mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.jmu.oscm.model.ReduceTarget;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReduceTargetMapper {
    /***
     * 查找全部数据
     * @return 返回查找的全部数据
     * */
    List<ReduceTarget> queryAll();

    Boolean add(ReduceTarget reduceTarget);

    Boolean deleteByID(int id);

    ReduceTarget queryByID(int id);

    Boolean update(ReduceTarget reduceTarget);

    Boolean updates(List<ReduceTarget> reduceTargets);
}

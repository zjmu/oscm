package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.IncentiveRatio;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncentiveRatioMapper {

    /**
     * 查询所有部门奖励比例
     * @return 所有部门奖励比例
     * */
    List<IncentiveRatio> queryAll();

    /**
     * 根据id查询一条部门奖励比例
     * @param id
     * @return 一条部门奖励比例
     * */
    IncentiveRatio queryByID(int id);

    /**
     * 插入一条部门奖励比例
     * @param incentiveRatio
     * @return true or false
     * */
    Boolean add(IncentiveRatio incentiveRatio);

    /**
     * 清空部门奖励比例表
     * @return true or false
     * */
    Boolean deleteAll();

    /**
     * 删除指定部门奖励比例
     * @param id
     * @return true or false
     * */
    Boolean deleteByID(int id);

    /**
     * 更改指定部门奖励比例
     * @param incentiveRatio
     * @return true or false
     **/
    Boolean update(IncentiveRatio incentiveRatio);

    /**
     * 批量更新部门奖励比例
     * @param incentiveRatios
     * @return true or false
     * */
    Boolean updates(List<IncentiveRatio> incentiveRatios);
}

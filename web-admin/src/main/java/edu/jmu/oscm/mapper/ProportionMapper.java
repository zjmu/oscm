package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Proportion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProportionMapper {
    /**
     * 清空
     * @return
     */
    Boolean deleteAll();

    /**
     * 根据id删除一条
     * @param id
     * @return
     */
    Boolean deleteById(int id);

    /**
     * 增加一条
     * @param proportion
     * @return
     */
    Boolean insertProportion(Proportion proportion);

    /**
     * 根据id查找一条
     * @param id
     * @return
     */
    Proportion selectProportionById(int id);

    /**
     * 根据年月查找相关的记录
     * @param year
     * @param month
     * @return
     */
    List<Proportion> selectProportionByYearAndMonth(String year,String month);

    /**
     * 查找所有记录
     * @return
     */
    List<Proportion> getAllProportion();
}

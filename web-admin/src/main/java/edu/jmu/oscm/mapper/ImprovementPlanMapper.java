package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ImprovementPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImprovementPlanMapper {

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
     * @param improvementPlan
     * @return
     */
    Boolean insertImprovementPlan(ImprovementPlan improvementPlan);

    /**
     * 根据日期查找一条
     * @return
     */
    List<ImprovementPlan> selectImprovementPlanByDate(String year,String month);

    /**
     * 查找所有记录
     * @return
     */
    List<ImprovementPlan> getAllImprovementPlan();

    /**
     * 更新某条记录
     * @return
     */
    Boolean updateImprovementPlan(ImprovementPlan improvementPlan);




}

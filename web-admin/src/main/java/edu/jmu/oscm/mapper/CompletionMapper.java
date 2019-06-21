package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Completion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CompletionMapper {

    /**
     * @description 通过日期查询成本管控目标完成情况分析表
     * @param year
     * @param month
     * @param reportId
     * @author zjm
     */
    List<Completion> selectByDate(@Param(value = "year") String year, @Param(value = "month") String month,@Param("reportId")BigInteger reportId);

    /**
     * @description 根据部门获取查询成本管控目标完成情况分析表
     * @param year
     * @param month
     * @param  reportId
     * @param  deptCode
     * @author zjm
     */
    List<Completion> selectByDateAndDeptCode(@Param("year")String year, @Param("month")String month, @Param("reportId") BigInteger reportId, @Param("deptCode")String deptCode);
}

package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ResponsibilityIndicator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ResponsibilityIndicatorMapper {

    /**
     * @description 根据日期查询流动资金占用成本管控责任指标
     * @param year
     * @param month
     * @param reportId
     * @author zjm
     */
    List<ResponsibilityIndicator> getResponsibilityIndicator(@Param("year")String year, @Param("month")String month, @Param("reportId")BigInteger reportId);

    /**
     * @description 根据日期和部门询流动资金占用成本管控责任指标
     * @param year
     * @param month
     * @param deptCode
     * @param reportId
     * @author zjm
     */
    List<ResponsibilityIndicator> getResponsibilityIndicatorByDeptCode(@Param("year")String year, @Param("month")String month,@Param("reportId")BigInteger reportId,@Param("deptCode")String deptCode);
}

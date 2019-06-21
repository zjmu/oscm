package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.TargetMatching;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface TargetMatchingMapper {
    
    /**
     * @description 根据日期查找流动资产项目
     * @param year
     * @param month
     * @param reportId
     * @author zjm
     */
    List<TargetMatching> getTargetMatching(@Param("year")String year, @Param("month")String month, @Param("reportId")BigInteger reportId);

    /**
     * @description 根据日期和部门查找流动资产项目
     * @param year
     * @param month
     * @param deptCode
     * @param reportId
     * @author zjm
     */
    List<TargetMatching> getTargetMatchingByDeptCode(@Param("year")String year, @Param("month")String month,@Param("reportId")BigInteger reportId,@Param("deptCode")String deptCode);
}

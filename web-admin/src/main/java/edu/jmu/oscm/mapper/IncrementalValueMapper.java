package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.IncrementalValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface IncrementalValueMapper {

    /**
     * @description 根据日期查询增创价值表
     * @param year
     * @param month
     * @param reportId
     * @author zjm
     */
    List<IncrementalValue> selectByDate(@Param(value = "year") String year, @Param(value = "month") String month, @Param("reportId")BigInteger reportId);

    /**
     * @description 根据日期和部门查询增创价值表
     * @param year
     * @param month
     * @param deptCode
     * @param reportId
     * @author zjm
     */
    List<IncrementalValue> selectByDateAndDeptCode(@Param(value = "year") String year, @Param(value = "month") String month,@Param("reportId")BigInteger reportId, @Param("deptCode")String deptCode);
}

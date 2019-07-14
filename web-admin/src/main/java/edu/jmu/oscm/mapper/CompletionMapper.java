package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Completion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Mapper
public interface CompletionMapper {

    /**
     * @description 根据部门获取查询成本管控目标完成情况分析表
     * @param year
     * @param month
     * @param  reportId
     * @param  deptCode
     * @author zjm
     */
    List<Completion> selectForSameYear(@Param("year")String year, @Param("beginMonth")String beginMonth,@Param("endMonth")String endMonth,
                                             @Param("reportId") BigInteger reportId, @Param("deptCode")String deptCode);


    List<Completion> selectForDifferentYear(@Param("beginYear")String beginYear, @Param("beginMonth")String beginMonth,@Param("endYear")String endYear,
                                            @Param("endMonth")String endMonth,@Param("reportId") BigInteger reportId, @Param("deptCode")String deptCode);


//    List<Completion> getSameQuarterPlanValue(@Param("year")String year,@Param("reportId") BigInteger reportId,@Param("deptCode")String deptCode,@Param("monthValue")Integer monthValue);
}


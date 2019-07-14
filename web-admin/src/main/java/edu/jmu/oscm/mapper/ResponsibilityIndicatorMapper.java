package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ResponsibilityIndicator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ResponsibilityIndicatorMapper {

    /**
     * @description 根据日期和部门询流动资金占用成本管控责任指标
     * @param year
     * @param month
     * @param deptCode
     * @param reportId
     * @author zjm
     */
    List<ResponsibilityIndicator> getResponsibilityIndicatorForSameYear(@Param("lastQuarterEndYear")String lastQuarterEndYear,@Param("lastQuarterEndMonth")String lastQuarterEndMonth,
                                                                        @Param("lastQuarterBeginYear")String lastQuarterBeginYear,@Param("lastQuarterBeginMonth")String lastQuarterBeginMonth,
                                                                        @Param("thisQuarterEndYear")String thisQuarterEndYear,@Param("thisQuarterEndMonth")String thisQuarterEndMonth,
                                                                        @Param("reportId")BigInteger reportId,@Param("deptCode")String deptCode);


    List<ResponsibilityIndicator> getResponsibilityIndicatorForDifferentYear(@Param("lastQuarterEndYear")String lastQuarterEndYear,@Param("lastQuarterEndMonth")String lastQuarterEndMonth,
                                                                        @Param("lastQuarterBeginYear")String lastQuarterBeginYear,@Param("lastQuarterBeginMonth")String lastQuarterBeginMonth,
                                                                        @Param("thisQuarterEndYear")String thisQuarterEndYear,@Param("thisQuarterEndMonth")String thisQuarterEndMonth,
                                                                        @Param("reportId")BigInteger reportId,@Param("deptCode")String deptCode);
}

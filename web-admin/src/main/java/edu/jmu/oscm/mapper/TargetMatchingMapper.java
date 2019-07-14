package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.TargetMatching;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface TargetMatchingMapper {

    /**
     * @description 获取季度在同一年的目标匹配表
     * @param lastQuarterEndYear
     * @param lastQuarterEndMonth
     * @param lastQuarterBeginYear
     * @param lastQuarterBeginMonth
     * @param thisQuarterEndYear
     * @param thisQuarterEndMonth
     * @param deptCode
     * @param reportId
     * @author zjm
     */
    List<TargetMatching> getTargetMatchingForSameYear(@Param("lastQuarterEndYear")String lastQuarterEndYear,@Param("lastQuarterEndMonth")String lastQuarterEndMonth,
                                                      @Param("lastQuarterBeginYear")String lastQuarterBeginYear,@Param("lastQuarterBeginMonth")String lastQuarterBeginMonth,
                                                      @Param("thisQuarterEndYear")String thisQuarterEndYear,@Param("thisQuarterEndMonth")String thisQuarterEndMonth,
                                                      @Param("reportId")BigInteger reportId,@Param("deptCode")String deptCode);


    /**
     * @description 获取季度不在同一年的目标匹配表
     * @param lastQuarterEndYear
     * @param lastQuarterEndMonth
     * @param lastQuarterBeginYear
     * @param lastQuarterBeginMonth
     * @param thisQuarterEndYear
     * @param thisQuarterEndMonth
     * @param deptCode
     * @param reportId
     * @author zjm
     */
    List<TargetMatching> getTargetMatchingForDifferentYear(@Param("lastQuarterEndYear")String lastQuarterEndYear,@Param("lastQuarterEndMonth")String lastQuarterEndMonth,
                                                           @Param("lastQuarterBeginYear")String lastQuarterBeginYear,@Param("lastQuarterBeginMonth")String lastQuarterBeginMonth,
                                                           @Param("thisQuarterEndYear")String thisQuarterEndYear,@Param("thisQuarterEndMonth")String thisQuarterEndMonth,
                                                           @Param("reportId")BigInteger reportId,@Param("deptCode")String deptCode);
}

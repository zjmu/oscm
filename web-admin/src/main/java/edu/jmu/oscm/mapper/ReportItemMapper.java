package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ItemReduceTarget;
import edu.jmu.oscm.model.PlanTotalReduceValue;
import edu.jmu.oscm.model.ReduceTarget;
import edu.jmu.oscm.model.ReportItem;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zjm
 * @Description ReportItemMapper
 * @date Create in 10:23 2019/5/26
 */
@Mapper
public interface ReportItemMapper {

    /**
     * @description 关联获取ReportItemInstance
     * @param reportId
     * @param year
     * @param month
     * @author zjm
     */
    List<ReportItem> getReportItemAndReportItemInstance(@Param("reportId")BigInteger reportId,@Param("year")String year,@Param("month")String month,@Param("deptCode")String deptCode);

    /**
     * @description 关联获取ItemReduceTarget
     * @param reportId
     * @param year
     * @author zjm
     */
    List<ItemReduceTarget> getItemReduceTarget(@Param("reportId")BigInteger reportId, @Param("year")String year,@Param("deptCode")String deptCode);

    /**
     * @description 子查询item_reduce_target表
     * @param itemId
     * @param year
     * @author zjm
     */
    List<PlanTotalReduceValue> getSameYearPlanTotalTargetValue(@Param("reportId")BigInteger reportId, @Param("year")String year, @Param("monthValue")Integer monthValue, @Param("deptCode")String deptCode);

    List<PlanTotalReduceValue> getDifferentYearPlanTotalTargetValue(@Param("reportId")BigInteger reportId, @Param("year")String year,@Param("lastYear")String lastYeaar,@Param("monthValue")Integer monthValue,@Param("deptCode")String deptCode);
}

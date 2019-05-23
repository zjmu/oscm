package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Report;
import edu.jmu.oscm.model.ReportItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ReportItemMapper {

    /**
     * @
     * @description 关联查询report_item_instance
     * @parament reportId
     * @parament year
     * @parament month
     * @return reportItem与reportItemInstance值
     */
    List<ReportItem> getReportItemList(@Param("reportId") BigInteger reportId, @Param("year")String year, @Param("month")String month);
}

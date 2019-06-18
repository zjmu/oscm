package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ReportItem;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

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
    List<ReportItem> getReportItemAndReportItemInstance(@RequestParam("reportId")BigInteger reportId,@RequestParam("year")String year,@RequestParam("month")String month);

    /**
     * @description 关联获取ItemReduceTarget
     * @param reportId
     * @param year
     * @author zjm
     */
    List<ReportItem> getReportItemAndItemReduceTarget(@RequestParam("reportId")BigInteger reportId,@RequestParam("year")String year);

}

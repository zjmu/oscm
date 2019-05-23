package edu.jmu.oscm.mapper;


import edu.jmu.oscm.model.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    /**
     * 获取所有Report记录
     * @return
     */
    List<Report> getAllReport();

    /**
     * 清空Report表
     * @return
     */
    Boolean deleteAllReport();

    Boolean deleteByReportCode(@Param("ReportCode")String ReportCode);

    /**
     * 插入一条report记录
     * @param report
     * @return
     */
    Boolean insertReport(Report report);

    /**
     * 根据ReportCode找到相应的Report记录
     * @param ReportCode
     * @return
     */
    List<Report> getReportByReportCode(@Param("ReportCode")String ReportCode);
}

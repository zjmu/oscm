package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.ReportItemInstance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

import java.util.List;

@Mapper
public interface ReportItemInstanceMapper {

    /**
     * 查找所有记录
     * @return
     */
    List<ReportItemInstance> getAllReportItemInstance();

    /**
     * 按年月查找记录
     * @return
     */
    List<ReportItemInstance> getReportItemInstanceByYearAndMonth(String year,String month);

    /**
     * 按id查找记录
     * @return
     */
    List<ReportItemInstance> getReportItemInstanceById(int id);

    /**
     * 按条件关联查询项目名称
     * @return
     */
    ReportItemInstance getReportItemInstance(@Param("reportItemId") BigInteger reportItemId,@Param("year")String year,@Param("month")String month);


}

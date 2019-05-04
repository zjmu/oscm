package edu.jmu.oscm.mapper;
import org.apache.ibatis.annotations.Mapper;
import edu.jmu.oscm.model.MonthReport;
import java.util.List;

/**
 * @author zhangwenlong
 * @date 2019/5/4
 */
@Mapper
public interface MonthReportMapper {
    /**
     * 清空
     * @return
     */
    Boolean deleteAll();


    /**
     * 根据id删除一条
     * @param id
     * @return
     */
    Boolean deleteById(int id);


    /**
     * 增加一条
     * @param monthReport
     * @return
     */
    Boolean insertMonthReport(MonthReport monthReport);

    /**
     * 根据id查找一条
     * @param id
     * @return
     */
    MonthReport selectMonthReportById(int id);

    /**
     * 查找所有记录
     * @return
     */
    List<MonthReport> getAllMonthReport();

    /**
     * 更新某条记录
     * @return
     */
    Boolean updateMonthReport(MonthReport monthReport);

}

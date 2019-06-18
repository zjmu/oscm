package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Proportion;
import edu.jmu.oscm.model.ReportItemInstance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ProportionMapper {
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
     * 重新计算的时候调用
     * 把原有的数据删掉
     * @param year
     * @param month
     * @param type
     * @return
     */
    Boolean deleteByYearAndMonthAndType(@Param("year") String year, @Param("month") String month, @Param("type") int type);

    /**
     * 增加一条
     * @param proportion
     * @return
     */
    Boolean insertProportion(Proportion proportion);

    /**
     * 批量增加
     * @param list
     * @return
     */
    Boolean insertProportions(List<Proportion> list);

    /**
     * 根据指定id更新信息
     * @param id
     * @param prop
     * @param accumProp
     * @return
     */
    Boolean updateProportion(BigInteger id,String prop,String accumProp);

    /**
     * 根据id查找一条
     * @param id
     * @return
     */
    Proportion selectProportionById(int id);

    /**
     * 根据年月查找相关的记录
     * @param year
     * @param month
     * @param reportId
     * @param type
     * @return
     */
    List<Proportion> selectProportionByYearAndMonthAndType(String year,String month,int reportId,Boolean type);

    /**
     * 查找所有记录
     * @return
     */
    List<Proportion> getAllProportion();


    /**
     * 级联查找相关记录
     * @param year
     * @param month
     * @param reportId
     * @return
     */
    List<Proportion> selectProportionByYearAndMonthAndReportIdAndType(String year, String month,int reportId,int type);


    /**
     * 占比计算接口
     * @param year
     * @param month
     * @param type
     * @return
     */
    List<ReportItemInstance> calculateProportionOfYearAndMonth(@Param("year") String year, @Param("month") String month, @Param("type") String type);
}

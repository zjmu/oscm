package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.TargetMatching;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TargetMatchingMapper {
    
    /**
     * @description 查找流动资产项目
     * @param year
     * @param month
     * @author zjm
     */
    List<TargetMatching> getTargetMatching(@Param("year")String year, @Param("month")String month);

}

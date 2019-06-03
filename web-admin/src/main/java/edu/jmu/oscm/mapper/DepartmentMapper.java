package edu.jmu.oscm.mapper;

import org.apache.ibatis.annotations.Mapper;
import edu.jmu.oscm.model.Department;
import java.util.List;

@Mapper
public interface DepartmentMapper {

    Department selectDepartment(String deptCode);
}

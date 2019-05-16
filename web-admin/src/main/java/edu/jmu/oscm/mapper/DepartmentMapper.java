package edu.jmu.oscm.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper selectDepartment(String deptCode);
}

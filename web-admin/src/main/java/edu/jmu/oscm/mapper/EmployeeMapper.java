package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee selectEmployee(BigInteger employeeId);
}

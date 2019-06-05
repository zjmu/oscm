package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.*;
import edu.jmu.oscm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class MonthReportService {
    @Autowired
    private EmployeeMapper employeeMapper;



    @Autowired
    private ItemEmployeeMapper itemEmployeeMapper;

    @Autowired
    private MonthReportMapper monthReportMapper;

    @Autowired
    private ItemDeptMapper itemDeptMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<MonthReport> selectMonthReportByDate(String year,String month)
    {
        List<MonthReport> monthReports = monthReportMapper.selectMonthReportByDate(year, month);
        for(MonthReport monthReport:monthReports){
            monthReport.setItem_name(monthReport.getItem().getItem_name());
            BigInteger item_id=monthReport.getItem_id();
            List<ItemEmployee> itemEmployees=itemEmployeeMapper.selectAllItemEmployee(item_id);
            List<Employee> responsibleEmployee=new ArrayList<>();
            List<Employee> collaborativeEmployee=new ArrayList<>();
            for(ItemEmployee itemEmployee:itemEmployees)
            {
                if(itemEmployee.getIsCharge()==0)
                {
                    collaborativeEmployee.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
                }
                else if(itemEmployee.getIsCharge()==1)
                {
                    responsibleEmployee.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
                }
            }
            monthReport.setResponsibleEmployee(responsibleEmployee);
            monthReport.setCollaborativeEmployee(collaborativeEmployee);

            List<ItemDept> itemDepts=itemDeptMapper.selectItemDept(item_id);
            List<Department> responsibleDept=new ArrayList<>();
            List<Department> collaborativeDept=new ArrayList<>();
            for(ItemDept itemDept:itemDepts)
            {
                if(itemDept.getIsCharge()==0)
                {
                    collaborativeDept.add(departmentMapper.selectDepartment(itemDept.getDeptCode()));
                }
                else  if(itemDept.getIsCharge()==1)
                {
                    responsibleDept.add((departmentMapper.selectDepartment(itemDept.getDeptCode())));
                }
            }
            monthReport.setCollaborativeDepartments(collaborativeDept);
            monthReport.setResponsibleDepartments(responsibleDept);

        }
        return  monthReports;
    }
}

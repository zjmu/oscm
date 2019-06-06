package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.*;
import edu.jmu.oscm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class MonthReportService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemEmployeeMapper itemEmployeeMapper;

    @Autowired
    private MonthReportMapper monthReportMapper;

    @Autowired
    private ItemDeptMapper itemDeptMapper;

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<MonthReport> selectMonthReportByDate(String year,String month)
    {
        ArrayList<MonthReport> monthReports=new ArrayList<MonthReport>();
        List<BalanceTargetValue> balanceTargetValues=balanceTargetValueMapper.selectByDate(year, month);
        for(BalanceTargetValue balanceTargetValue:balanceTargetValues) {
            if(monthReportMapper.selectMonthReportByDateAndItemId(balanceTargetValue.getItemId(),year,month)!=null)
            {
                MonthReport monthReport1=monthReportMapper.selectMonthReportByDateAndItemId(balanceTargetValue.getItemId(),year,month);
                BigInteger item_id=monthReport1.getItem_id();
                monthReport1.setItem(itemMapper.getItemByItemId(item_id));

                List<ItemEmployee> responsibleItemEmployees=itemEmployeeMapper.selectItemEmployee(item_id);
                List<Employee> responsibleEmployees =new ArrayList<>();
                for(ItemEmployee itemEmployee:responsibleItemEmployees)
                {
                    responsibleEmployees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
                }
                monthReport1.setResponsibleEmployee(responsibleEmployees);

                List<ItemEmployee> collaborativeItemEmployees=itemEmployeeMapper.selectCollaborativeEmployee(item_id);
                List<Employee> collaborativeEmployees =new ArrayList<>();
                for(ItemEmployee itemEmployee:collaborativeItemEmployees)
                {
                    collaborativeEmployees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
                }
                monthReport1.setCollaborativeEmployee(collaborativeEmployees);

                List<Department> responsibleDepartmentsDepartments=new ArrayList<>();
                List<ItemDept> responsibleItemDepts=itemDeptMapper.getResponsibleItemDept(item_id);
                for(ItemDept itemDept: responsibleItemDepts)
                {
                    responsibleDepartmentsDepartments.add(departmentMapper.selectDepartment(itemDept.getDeptCode()));
                }
                monthReport1.setResponsibleDepartments(responsibleDepartmentsDepartments);

                List<Department> collaborativeDepartmentsDepartments=new ArrayList<>();
                List<ItemDept> collaborativeItemDepts=itemDeptMapper.getCollaborativeDepartments(item_id);
                for(ItemDept itemDept: collaborativeItemDepts)
                {
                    collaborativeDepartmentsDepartments.add(departmentMapper.selectDepartment(itemDept.getDeptCode()));
                }
                monthReport1.setCollaborativeDepartments(collaborativeDepartmentsDepartments);
                monthReport1.setItem_name(monthReport1.getItem().getItem_name());
                monthReports.add(monthReport1);
            }
            else
            {

                MonthReport monthReport2=new MonthReport();
                monthReport2.setTarget(balanceTargetValue.getPlanMonthTargetValue());
                BigDecimal value=balanceTargetValue.getActualMonthTargetValue().add(balanceTargetValue.getLastMonthBalance());
                monthReport2.setValue(value);
                monthReport2.setDifference(value.subtract(monthReport2.getTarget()));
                monthReport2.setItem_id(balanceTargetValue.getItemId());
                BigInteger item_id=monthReport2.getItem_id();
                monthReport2.setItem(itemMapper.getItemByItemId(item_id));
                monthReport2.setMonth(month);
                monthReport2.setYear(year);
                monthReport2.setCreate_date(new Timestamp(System.currentTimeMillis()));
                monthReportMapper.insertMonthReport(monthReport2);
                List<ItemEmployee> responsibleItemEmployees=itemEmployeeMapper.selectItemEmployee(item_id);
                List<Employee> responsibleEmployees =new ArrayList<>();
                for(ItemEmployee itemEmployee:responsibleItemEmployees)
                {
                    responsibleEmployees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
                }
                monthReport2.setResponsibleEmployee(responsibleEmployees);

                List<ItemEmployee> collaborativeItemEmployees=itemEmployeeMapper.selectCollaborativeEmployee(item_id);
                List<Employee> collaborativeEmployees =new ArrayList<>();
                for(ItemEmployee itemEmployee:collaborativeItemEmployees)
                {
                    collaborativeEmployees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
                }
                monthReport2.setCollaborativeEmployee(collaborativeEmployees);

                List<Department> responsibleDepartmentsDepartments=new ArrayList<>();
                List<ItemDept> responsibleItemDepts=itemDeptMapper.getResponsibleItemDept(item_id);
                for(ItemDept itemDept: responsibleItemDepts)
                {
                    responsibleDepartmentsDepartments.add(departmentMapper.selectDepartment(itemDept.getDeptCode()));
                }
                monthReport2.setResponsibleDepartments(responsibleDepartmentsDepartments);

                List<Department> collaborativeDepartmentsDepartments=new ArrayList<>();
                List<ItemDept> collaborativeItemDepts=itemDeptMapper.getCollaborativeDepartments(item_id);
                for(ItemDept itemDept: collaborativeItemDepts)
                {
                    collaborativeDepartmentsDepartments.add(departmentMapper.selectDepartment(itemDept.getDeptCode()));
                }
                monthReport2.setCollaborativeDepartments(collaborativeDepartmentsDepartments);
                monthReport2.setItem_name(monthReport2.getItem().getItem_name());
                monthReports.add(monthReport2);
            }

        }
        return monthReports;
    }

}

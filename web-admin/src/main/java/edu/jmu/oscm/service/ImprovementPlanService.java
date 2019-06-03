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
public class ImprovementPlanService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private BalanceTargetValueMapper balanceTargetValueMapper;

    @Autowired
    private ItemEmployeeMapper itemEmployeeMapper;

    @Autowired
    private ImprovementPlanMapper improvementPlanMapper;

    @Autowired
    private ItemDeptMapper itemDeptMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<ImprovementPlan> selectImprovementPlanByDate(String year,String month)
    {
        int ok=0;
        ArrayList<ImprovementPlan> improvementPlans=new ArrayList<ImprovementPlan>();
        List<BalanceTargetValue> balanceTargetValues=balanceTargetValueMapper.selectByDate(year, month);
        for(BalanceTargetValue balanceTargetValue:balanceTargetValues) {
           if(improvementPlanMapper.selectImprovementPlanByDateAndItemId(balanceTargetValue.getItemId(),year,month)!=null)
           {
               ImprovementPlan improvementPlan1=improvementPlanMapper.selectImprovementPlanByDateAndItemId(balanceTargetValue.getItemId(),year,month);
               BigInteger item_id=improvementPlan1.getItem_id();
               improvementPlan1.setItem(itemMapper.getItemByItemId(item_id));
               List<ItemEmployee> itemEmployees=itemEmployeeMapper.selectItemEmployee(item_id);
               List<Employee> employees =new ArrayList<>();
               for(ItemEmployee itemEmployee:itemEmployees)
               {
                   employees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
               }
               improvementPlan1.setEmployee(employees);

               List<Department> departments=new ArrayList<>();
               List<ItemDept> itemDepts=itemDeptMapper.getResponsibleItemDept(item_id);
               for(ItemDept itemDept:itemDepts)
               {
                   departments.add(departmentMapper.selectDepartment(itemDept.getDeptCode()));
               }
               improvementPlan1.setDepartments(departments);

               improvementPlans.add(improvementPlan1);
           }
           else
           {
               if((balanceTargetValue.getActualMonthTargetValue().compareTo(balanceTargetValue.getPlanMonthTargetValue()))>=0)
               {
                   ok=1;
               }
               else
               {
                   ok=0;
               }
               ImprovementPlan improvementPlan2=new ImprovementPlan();
               improvementPlan2.setItem_id(balanceTargetValue.getItemId());
               BigInteger item_id=improvementPlan2.getItem_id();
               improvementPlan2.setOk(ok);
               improvementPlan2.setItem(itemMapper.getItemByItemId(item_id));
               improvementPlan2.setMonth(month);
               improvementPlan2.setYear(year);
               improvementPlan2.setCreate_date(new Timestamp(System.currentTimeMillis()));
               improvementPlanMapper.insertImprovementPlan(improvementPlan2);
               List<ItemEmployee> itemEmployees=itemEmployeeMapper.selectItemEmployee(item_id);
               List<Employee> employees =new ArrayList<>();
               for(ItemEmployee itemEmployee:itemEmployees)
               {
                   employees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
               }
               improvementPlan2.setEmployee(employees);

               List<Department> departments=new ArrayList<>();
               List<ItemDept> itemDepts=itemDeptMapper.getResponsibleItemDept(item_id);
               for(ItemDept itemDept:itemDepts)
               {
                   departments.add(departmentMapper.selectDepartment(itemDept.getDeptCode()));
               }
               improvementPlan2.setDepartments(departments);

               improvementPlans.add(improvementPlan2);
           }

        }
        return improvementPlans;
    }

}

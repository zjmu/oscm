package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.*;
import edu.jmu.oscm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<ImprovementPlan> selectImprovementPlanByDate(String year,String month)
    {
        int ok=0;
        ArrayList<ImprovementPlan> improvementPlans=new ArrayList<ImprovementPlan>();
        List<BalanceTargetValue> balanceTargetValues=balanceTargetValueMapper.selectAll();
        for(BalanceTargetValue balanceTargetValue:balanceTargetValues) {
           if(improvementPlanMapper.selectImprovementPlanByDateAndItemId(balanceTargetValue.getItemId(),year,month)!=null)
           {
               ImprovementPlan improvementPlan1=improvementPlanMapper.selectImprovementPlanByDateAndItemId(balanceTargetValue.getItemId(),year,month);
               improvementPlan1.setItem(itemMapper.getItemByItemId(balanceTargetValue.getItemId()));
               List<ItemEmployee> itemEmployees=itemEmployeeMapper.selectItemEmployee(balanceTargetValue.getItemId());
               List<Employee> employees =new ArrayList<>();
               for(ItemEmployee itemEmployee:itemEmployees)
               {
                   employees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
               }
               improvementPlan1.setEmployee(employees);
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
               improvementPlan2.setOk(ok);
               improvementPlan2.setItem(itemMapper.getItemByItemId(balanceTargetValue.getItemId()));
               improvementPlan2.setMonth(month);
               improvementPlan2.setYear(year);
               improvementPlan2.setCreate_date(new Timestamp(System.currentTimeMillis()));
               improvementPlanMapper.insertImprovementPlan(improvementPlan2);
               List<ItemEmployee> itemEmployees=itemEmployeeMapper.selectItemEmployee(balanceTargetValue.getItemId());
               List<Employee> employees =new ArrayList<>();
               for(ItemEmployee itemEmployee:itemEmployees)
               {
                   employees.add(employeeMapper.selectEmployee(itemEmployee.getEmployeeId()));
               }
               improvementPlan2.setEmployee(employees);
               improvementPlans.add(improvementPlan2);
           }

        }
        return improvementPlans;
    }

}

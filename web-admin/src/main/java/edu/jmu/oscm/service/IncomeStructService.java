package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.IncomeStructMapper;
import edu.jmu.oscm.model.IncomeStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class IncomeStructService {

    @Autowired
    private IncomeStructMapper incomeStructMapper;

//    public List<IncomeStruct> update(List<IncomeStruct> incomeStructs){
//        incomeStructMapper.deleteAll();
//        incomeStructMapper.add(incomeStructs);
//    }
//
//    public Boolean add(){
//
//    }
//
//    public String delete(Integer income_id){
//
//        incomeStructMapper.delete(income_id);
//        Integer maxId = incomeStructMapper.searchMaxId();
//        incomeStructMapper.updateById(income_id);
//
//        return "删除记录成功";
//

    public String change(List<IncomeStruct> incomeStructs){

        Boolean isSuccess1 = incomeStructMapper.deleteAll();
        Boolean isSuccess2 = incomeStructMapper.addAll(incomeStructs);

        if(isSuccess1 && isSuccess2){
            return "修改成功";
        }
        else{
            return "修改失败";
        }
    }


}

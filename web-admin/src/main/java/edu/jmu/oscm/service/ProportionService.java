package edu.jmu.oscm.service;

import edu.jmu.oscm.model.Proportion;
import edu.jmu.oscm.modelView.ProportionView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyx
 * @date 19-5-9 上午12:38
 * @email zhangyuxin2009@126.com
 */

@Service
public class ProportionService {

    private List<Proportion> proportions = new ArrayList<>();

//    private ProportionView balanceProportionTable,debtProportionTable;
//
//    public ProportionView fullProportions(List<Proportion> proportions,int choose){
//
//        balanceProportionTable = new ProportionView();
//        debtProportionTable = new ProportionView();
//
//        for (Proportion value : proportions) {
//            if (value.getAsset_or_debt()) {
//                // TRUE表示资产
//                balanceProportion.add(value);
//            } else {
//                // FALSE表示负债
//                debtProportion.add(value);
//            }
//        }
//
//
//
//        balanceProportionTable = generator(new ProportionView(),balanceProportion);
//        debtProportionTable = generator(new ProportionView(),debtProportion);
//
//
//
//    }



//    private ProportionView generator(ProportionView tableImpl, List<Proportion> proportions){
//
//        float total = 0;
//
//        System.out.println(proportions);
//
//        // 获得总计
//        for (Proportion proportion : proportions) {
//            total = total + Float.valueOf(proportion.getReportItemInstance().getEND_VALUE());
//            tableImpl.total = String.valueOf(total);
//        }
//
//        int i = 0;
//        //填充
//        for (Proportion proportion : proportions) {
//            if(i==proportions.size()){
//                break;
//            }else {
//                // 填充累计比例
//                total = Float.parseFloat(total + proportion.getProportion());
//                tableImpl.itemList.add(new ProportionItem(proportion.getReportItemInstance().getITEM_NAME(),proportion.getReportItemInstance().getEND_VALUE(),proportion.getProportion(),String.valueOf(total)));
//                i++;
//            }
//        }
//
//        return tableImpl;
//    }

    public Map<String,Object> getListByType(List<Proportion> proportions, int type) {

        Map<String,Object> map = new HashMap<>();

        List<ProportionView> proportionViewList = new ArrayList<>();
        ProportionView proportionView;
        float total = 0;
        float accumProp = 0;
        boolean flag = type != 0;

        // 获得总计
        for(int i = 0;i<proportions.size();i++){
            if (proportions.get(i).getAssetOrDebt()==flag) {
                total = total + Float.valueOf(proportions.get(i).getReportItemInstanceList().get(0).getValue());
                if (i == proportions.size() - 1) {
                    break;
                }
            }
        }

        // 填充每一项
        for (Proportion proportion : proportions) {
            if (proportion.getAssetOrDebt()==flag) {
                accumProp = accumProp + Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()) / total;
                proportionView = new ProportionView(proportion.getReportItemInstanceList().get(0).getItemName(), Float.valueOf(proportion.getReportItemInstanceList().get(0).getValue()), Float.valueOf(proportion.getReportItemInstanceList().get(0).getValue()) / total, accumProp);
                proportionViewList.add(proportionView);
            }
        }

        map.put("totalValue",total);
        map.put("list",proportionViewList);

        return map;
    }
}

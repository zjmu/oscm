package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.ProportionMapper;
import edu.jmu.oscm.model.Proportion;
import edu.jmu.oscm.modelView.ProportionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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

    @Autowired
    private ProportionMapper proportionMapper;

    private List<Proportion> proportions = new ArrayList<>();
    private List<ProportionView> proportionViewList = new ArrayList<>();

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

    private void updateInfo(BigInteger proportionId, float proportion, float accumProp){
        proportionMapper.updateProportion(proportionId,String.valueOf(proportion),String.valueOf(accumProp));
    }

    public Map<String, Object> getListByType(List<Proportion> proportions, int type,String year,String month) {

        Map<String, Object> map = new HashMap<>();

        ProportionView proportionView;
        float[] total = new float[1];
        float[] accumProp = new float[1];
        boolean flag = type != 0;

        // 获得总计
        for (Proportion value : proportions) {
            if (value.getAssetOrDebt() == flag) {
                total[0] = total[0] + Float.parseFloat(value.getReportItemInstanceList().get(0).getEndValue());
            }
        }

        // 填充每一项
        for (Proportion proportion : proportions) {
            if (proportion.getAssetOrDebt() == flag) {
                accumProp[0] = accumProp[0] + Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()) / total[0];
                System.out.println(accumProp[0] + proportion.getReportItem().getItem().getItem_name()+Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue())+Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()) / total[0]);
                proportionView = new ProportionView(proportion.getReportItem().getItem().getItem_name(), Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()), Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()) / total[0], accumProp[0]);
                proportionViewList.add(proportionView);
                updateInfo(proportion.getId(),Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()) / total[0], accumProp[0]);
            }
        }

        map.put("totalValue",total);
        map.put("list",proportionViewList);

        return map;
    }
}

package edu.jmu.oscm.service;

import edu.jmu.oscm.mapper.ProportionMapper;
import edu.jmu.oscm.model.Proportion;
import edu.jmu.oscm.model.ReportItemInstance;
import edu.jmu.oscm.modelView.ProportionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author zyx
 * @date 19-5-9 上午12:38
 * @email zhangyuxin2009@126.com
 */

@Service
public class ProportionService {

    @Autowired
    private ProportionMapper proportionMapper;

    private List<ReportItemInstance> ReportItemInstanceList = new ArrayList<>();

    private List<Proportion> proportions = new ArrayList<>();
    private List<ProportionView> proportionViewList = new ArrayList<>();

    private void updateInfo(BigInteger proportionId, float proportion, float accumProp){
        proportionMapper.updateProportion(proportionId,String.valueOf(proportion),String.valueOf(accumProp));
    }

    public Boolean getList(List<ReportItemInstance> ReportItemInstanceList,boolean type) {

        this.ReportItemInstanceList = ReportItemInstanceList;

        Proportion proportion;
        ProportionView proportionView;
        float[] total = new float[1];
        float[] accumProp = new float[1];
        float[] prop = new float[1];

        // 获得总计
        for (ReportItemInstance value : ReportItemInstanceList) {
            total[0] = total[0] + Float.parseFloat(value.getEndValue());
        }

        System.out.println("总计为："+total[0]);

        // 填充每一项
        for (ReportItemInstance value : ReportItemInstanceList) {
            prop[0] = Float.valueOf(value.getEndValue()) / total[0];
            accumProp[0] = accumProp[0] + prop[0];

            //System.out.println("我的prop是"+prop[0]+",accumProp是"+accumProp[0]+",itemID是:"+value.getItemId());
            proportion = new Proportion();

            proportion.setItemId( new BigInteger(value.getItemId(),10));
            proportion.setItemCode(value.getItemCode());
            proportion.setItemName(value.getItemCode());
            proportion.setYear(value.getYear());
            proportion.setMonth(value.getMonth());
            proportion.setProportion(String.valueOf(prop[0]));
            proportion.setAccumulateProportion(String.valueOf(accumProp[0]));
            proportion.setAssetOrDebt(type);
            proportion.setCreateDate(new Timestamp(new java.util.Date().getTime()).toString());

            proportions.add(proportion);
//                proportionView = new ProportionView(proportion.getReportItem().getItem().getItem_name(), Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()), Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()) / total[0], accumProp[0]);
//                proportionViewList.add(proportionView);
//                updateInfo(proportion.getId(),Float.valueOf(proportion.getReportItemInstanceList().get(0).getEndValue()) / total[0], accumProp[0]);

        }

        System.out.println(proportions);

        return proportionMapper.insertProportions(proportions);
    }
}

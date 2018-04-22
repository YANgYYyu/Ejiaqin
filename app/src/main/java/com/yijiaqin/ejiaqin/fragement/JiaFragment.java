package com.yijiaqin.ejiaqin.fragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.adapter.JiaAdapter;
import com.yijiaqin.ejiaqin.entity.Food;
import com.yijiaqin.ejiaqin.entity.Hospital;
import com.yijiaqin.ejiaqin.entity.Jia;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/2
 * <p>
 * 文件描述:家,养老院
 * <p>
 * 备注:
 */
public class JiaFragment extends Fragment {
    private Spinner provinceSpinner = null;  //省级（省、直辖市）
    private Spinner citySpinner = null;     //地级市
    ArrayAdapter<String> provinceAdapter = null;  //省级适配器
    ArrayAdapter<String> cityAdapter = null;    //地级适配器

    private ListView jiaLv;
    private List<Jia> hefei = new ArrayList<>();
    private List<Jia> wuhu = new ArrayList<>();
    private List<Jia> kong = new ArrayList<>();
    JiaAdapter adapter = null;

    int proviceID;  //用来后面切换省份的时候的判定
    int cityID;
    //省级选项值
    private String[] province = new String[]{"安徽", "北京", "上海"};   //,"重庆","黑龙江","江苏","山东","浙江","香港","澳门"};
    //地级选项值
    private String[][] city = new String[][]{
            //                    安徽
            {"合肥", "芜湖", "安庆", "蚌埠", "淮南", "马鞍山", "淮北", "铜陵", "黄山", "阜阳", "宿州", "滁州", "六安", "宣城", "池州", "亳州"},
            //                    北京
            {"东城区", "西城区", "朝阳区", "丰台区", "石景山区", "海淀区", "顺义区", "通州区", "大兴区", "房山区", "门头沟区", "昌平区", "平谷区", "密云区", "怀柔区", "延庆区"},
            //                    浙江
            {"杭州", "宁波", "温州", "绍兴", "湖州", "嘉兴", "金华", "衢州", "台州", "丽水", "舟山"}};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jia, null);
        jiaLv = (ListView) view.findViewById(R.id.jia_lv);
        initData();
        setSpinner(view);
        return view;
    }

    /*
  * 设置下拉框
  */
    private void setSpinner(View view) {
        provinceSpinner = (Spinner) view.findViewById(R.id.spin_province);
        citySpinner = (Spinner) view.findViewById(R.id.spin_city);

        //绑定适配器和值
        provinceAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, province);
        provinceSpinner.setAdapter(provinceAdapter);
        provinceSpinner.setSelection(0, true);  //设置默认选中项，此处为默认选中第1个值

        cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, city[0]);
        citySpinner.setAdapter(cityAdapter);
        citySpinner.setSelection(3, true);  //默认选中第4个

        //省级下拉框监听
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 表示选项被改变的时候触发此方法，主要实现办法：动态改变地级适配器的绑定值
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                //position为当前省级选中的值的序号
                //将地级适配器的值改变为city[position]中的值
                cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, city[position]);
                // 设置二级下拉列表的选项内容适配器
                citySpinner.setAdapter(cityAdapter);
                proviceID = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(proviceID == 0) {
                    switch (i) {
                        case 0:
                            adapter = new JiaAdapter(getActivity(), R.layout.jia_item, hefei);
                            jiaLv.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                            break;
                        case 1:
                            adapter = new JiaAdapter(getActivity(), R.layout.jia_item, wuhu);
                            jiaLv.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                            break;
                        default:
                            adapter = new JiaAdapter(getActivity(), R.layout.jia_item, kong);
                            jiaLv.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    private void initData() {
        Jia hefei1 = new Jia(R.drawable.jia_item, "合肥医健新安护理院",
                "地址：安徽省合肥市蜀山区青阳路与高刘路交叉口，元祥广场", "床位数：421张", "收费区间：2580-13680");
        hefei.add(hefei1);
        Jia hefei2 = new Jia(R.drawable.jia_item, "合肥市庐阳区常春藤养老院",
                "地址：安徽合肥市庐阳区阜阳北路与汲桥路交口西南角", "床位数：88张", "收费区间：3000-5000");
        hefei.add(hefei2);
        Jia hefei3 = new Jia(R.drawable.jia_item, "合肥市包河区万寿老年公寓",
                "地址：合肥市包河区合巢路101号", "床位数：446张", "收费区间：1800-5000");
        hefei.add(hefei3);
        Jia hefei4 = new Jia(R.drawable.jia_item, "悠南山养老中心",
                "地址：合肥市经济开发区紫云路245号", "床位数：300张", "收费区间：1500-5000");
        hefei.add(hefei4);
        Jia hefei5 = new Jia(R.drawable.jia_item, "合肥市丰盛爱心养老中心",
                "地址：合肥市肥东县金阳南路和新安江路路口", "床位数：800张", "收费区间：1500-9999");
        hefei.add(hefei5);
        Jia hefei6 = new Jia(R.drawable.jia_item, "东海南山老年公寓",
                "地址：合肥市瑶海区长淮街道板桥社区龙兴苑6号楼", "床位数：88张", "收费区间：800-2500");
        hefei.add(hefei6);
        Jia hefei7 = new Jia(R.drawable.jia_item, "合肥明珠晚晴老年公寓",
                "地址：合肥市经开区桃花工业园金凤路18号", "床位数：240张", "收费区间：1200-2600");
        hefei.add(hefei7);
        Jia hefei8 = new Jia(R.drawable.jia_item, "合肥市蜀山区光明老年护理院",
                "地址：合肥市长江西路与西二环交叉口往南500米", "床位数：500张", "收费区间：1500-6000");
        hefei.add(hefei8);

        Jia wuhu1 = new Jia(R.drawable.jia_item, "南陵华義幸福养老服务有限公司",
                "地址：芜湖市南陵县阳光小区惠明中学旁", "床位数：1200张", "收费区间：21600-65535");
        wuhu.add(wuhu1);
        Jia wuhu2 = new Jia(R.drawable.jia_item, "芜湖康达护理院（芜湖县康达老年护理中心）",
                "地址：芜湖县六郎镇殷港快速通道旁芜湖康达护理院", "床位数：100张", "收费区间：1000-4000");
        wuhu.add(wuhu2);
        Jia wuhu3 = new Jia(R.drawable.jia_item, "芜湖红林老年公寓",
                "地址：安徽省芜湖市芜湖县六郎镇洪桥社区（原周皋镇政府大楼）", "床位数：150张", "收费区间：1500-3500");
        wuhu.add(wuhu3);
        Jia wuhu4 = new Jia(R.drawable.jia_item, "红梅老年公寓",
                "地址：安徽省芜湖市鸠江区齐落山路，澳然天成小区31幢1单元101-102", "床位数：21张", "收费区间：1600-3500");
        wuhu.add(wuhu4);
        Jia wuhu5 = new Jia(R.drawable.jia_item, "鸠江区长寿源养老服务中心",
                "地址：芜湖市鸠江区官陡街道鲁李社区南200米", "床位数：260张", "收费区间：21600-2350");
        wuhu.add(wuhu5);
        Jia wuhu6 = new Jia(R.drawable.jia_item, "真爱敬老院",
                "地址：安徽省无为县同心小区7栋103室", "床位数：15张", "收费区间：800-1000");
        wuhu.add(wuhu6);
        Jia wuhu7 = new Jia(R.drawable.jia_item, "颐康苑老年公寓",
                "地址：安徽省芜湖市鸠江区后李小区鱼塘边", "床位数：16张", "收费区间：1000-2500");
        wuhu.add(wuhu7);
    }

}



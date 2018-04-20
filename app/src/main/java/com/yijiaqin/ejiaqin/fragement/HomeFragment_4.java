package com.yijiaqin.ejiaqin.fragement;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.adapter.HospitalAdapter;
import com.yijiaqin.ejiaqin.entity.Hospital;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/2
 * <p>
 * 文件描述:第三个fragment，掌上医院
 * <p>
 * 备注:
 */
public class HomeFragment_4 extends Fragment {
    private List<Hospital> hospitalList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_4, null);

//        初始化医院数据
        initHospital();
        HospitalAdapter adapter = new HospitalAdapter(getActivity(), R.layout.hospital_item, hospitalList);
        ListView listView = (ListView) view.findViewById(R.id.hospital_lv);
//        todo 加载图片过于卡顿，只能加载一个图片了
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                switch (i) {
                    case 0:
                        intent.setData(Uri.parse("http://www.ayfy.com/"));
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setData(Uri.parse("http://www.ahslyy.com.cn/"));
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setData(Uri.parse("http://www.byyfy.net/index.jsp"));
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setData(Uri.parse("http://www.yjsyy.com/web/index.aspx"));
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setData(Uri.parse("http://www.hfyy.cn/default.asp"));
                        startActivity(intent);
                        break;
                }
            }
        });
        return view;
    }

    private void initHospital() {
        Hospital hospital1 = new Hospital(R.drawable.hospital1, "安徽医科大学第一附属医院", "地址：安徽省合肥市安徽省蜀山区绩溪路218号");
        hospitalList.add(hospital1);
        Hospital hospital2 = new Hospital(R.drawable.hospital1, "国科学技术大学附属第一医院 安徽省立医院", "地址：安徽省合肥市庐江区17号");
        hospitalList.add(hospital2);
        Hospital hospital3 = new Hospital(R.drawable.hospital1, "蚌埠医学院第一附属医院（蚌埠医学院附属肿瘤医院）", "地址：安徽省蚌埠市长淮路287号");
        hospitalList.add(hospital3);
        Hospital hospital4 = new Hospital(R.drawable.hospital1, "皖南医学院弋矶山医院", "地址：安徽省芜湖市赭山西路2号");
        hospitalList.add(hospital4);
        Hospital hospital5 = new Hospital(R.drawable.hospital1, "合肥市第一人民集团医院", "地址：本部：合肥市庐阳区淮河路390号");
        hospitalList.add(hospital5);
    }

}

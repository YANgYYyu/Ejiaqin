package com.yijiaqin.ejiaqin.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.adapter.MianduimianAdapter;
import com.yijiaqin.ejiaqin.entity.Mianduimian;
import com.yijiaqin.ejiaqin.util.TimeUtil;
import com.yijiaqin.ejiaqin.view.MessageActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/2
 *
 * 文件描述:面对面
 *
 * 备注:
 */
public class MianDuiMianFragment extends Fragment {
    private List<Mianduimian> mianduimianList = new ArrayList<>();

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mianduimian, null);
//        初始化数据
        initData();
        MianduimianAdapter adapter = new MianduimianAdapter(getActivity(),R.layout.mainduimian_item,mianduimianList);
        ListView  lv= (ListView) view.findViewById(R.id.mianduimian_lv);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(), MessageActivity.class);
                    intent.putExtra("name",mianduimianList.get(i).getName());
                    intent.putExtra("content",mianduimianList.get(i).getContent());
                    intent.putExtra("iv",mianduimianList.get(i).getImageView());
                    intent.putExtra("time",mianduimianList.get(i).getTime());
                    startActivity(intent);
                }
            });
        return view;
    }

    private void initData() {
        Mianduimian mianduimian1 = new Mianduimian(R.drawable.mianduimian_touxiang_erzi,"儿子","爸，您吃饭了没", TimeUtil.getTime(0));
        mianduimianList.add(mianduimian1);
        Mianduimian mianduimian2 = new Mianduimian(R.drawable.mianduimian_touxiang_nveer,"女儿","老爸，最近有流感，注意身体", TimeUtil.getTime(-1));
        mianduimianList.add(mianduimian2);
        Mianduimian mianduimian3 = new Mianduimian(R.drawable.mianduimian_touxiang_laoluo,"老罗","过会下棋去？", TimeUtil.getTime(0));
        mianduimianList.add(mianduimian3);
        Mianduimian mianduimian4 = new Mianduimian(R.drawable.mianduimian_touxiang_wangjie,"王姐","我家孩子刚给我送了点见过，给你和老罗送过去点？", TimeUtil.getTime(0));
        mianduimianList.add(mianduimian4);
    }

}

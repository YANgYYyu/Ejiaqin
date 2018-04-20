package com.yijiaqin.ejiaqin.fragement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.adapter.XinyuanqiangAdapter;
import com.yijiaqin.ejiaqin.entity.Xinyuanqiang;
import com.yijiaqin.ejiaqin.view.MainActivity;
import com.yijiaqin.ejiaqin.view.NewxyqActivity;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/2
 * <p>
 * 文件描述:心愿墙
 * <p>
 * 备注:留言板一样的功能.通过查询数据库来获得数据，在输入留言的activity里存入数据
 */
public class XinYuanQiangFragment extends Fragment {
    private LinearLayout bianji;    //编辑的按钮
    private ListView listView;
    private List<Xinyuanqiang> xinyuanqiangList;
    private XinyuanqiangAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xinyuanqiang, null);
        initView(view);
        bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                跳转到写留言的activity
                startActivityForResult(new Intent(getActivity(), NewxyqActivity.class), 10);
            }
        });
        xinyuanqiangList = DataSupport.order("time desc").find(Xinyuanqiang.class);
        adapter = new XinyuanqiangAdapter(getActivity(), R.layout.xinyuanqiang_item, xinyuanqiangList);
        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
        return view;
    }


    private void initView(View view) {
        bianji = (LinearLayout) view.findViewById(R.id.xinyuanqiang_bianji);
        listView = (ListView) view.findViewById(R.id.xinyuanqiang_lv);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 2) {
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.setSelect(3);
        }
    }
}

package com.yijiaqin.ejiaqin.fragement;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xinyuanqiang, null);
        initView(view);
        bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                跳转到写留言的activity
                startActivity(new Intent(getActivity(), NewxyqActivity.class));
            }
        });
        if (xinyuanqiangList != null) {
            xinyuanqiangList.clear();
        }
        xinyuanqiangList = DataSupport.order("time desc").find(Xinyuanqiang.class);
        adapter = new XinyuanqiangAdapter(getActivity(), R.layout.xinyuanqiang_item, xinyuanqiangList);
        listView.setAdapter(adapter);

//        删除留言
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, final int position, long l) {
                //定义AlertDialog.Builder对象，当长按列表项的时候弹出确认删除对话框
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("确定删除?");
                builder.setTitle("提示");

                //添加AlertDialog.Builder对象的setPositiveButton()方法
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                      移除list中的数据，并且在数据库中删除
                        DataSupport.deleteAll(Xinyuanqiang.class, "time = ?", xinyuanqiangList.get(position).getTime());
                        xinyuanqiangList.remove(position);
                        Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                    }
                });

                //添加AlertDialog.Builder对象的setNegativeButton()方法
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder.create().show();
                return false;
            }
        });
        return view;
    }


    private void initView(View view) {
        bianji = (LinearLayout) view.findViewById(R.id.xinyuanqiang_bianji);
        listView = (ListView) view.findViewById(R.id.xinyuanqiang_lv);
    }

    //    刷新xinyuanqiangList数据
    @Override
    public void onResume() {
        super.onResume();
        if (xinyuanqiangList != null) {
            xinyuanqiangList.clear();
        }
        xinyuanqiangList = DataSupport.order("time desc").find(Xinyuanqiang.class);
        adapter = new XinyuanqiangAdapter(getActivity(), R.layout.xinyuanqiang_item, xinyuanqiangList);
        listView.setAdapter(adapter);
    }

}

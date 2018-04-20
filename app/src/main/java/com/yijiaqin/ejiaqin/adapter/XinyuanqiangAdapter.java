package com.yijiaqin.ejiaqin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.entity.Mianduimian;
import com.yijiaqin.ejiaqin.entity.Xinyuanqiang;

import java.util.List;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/9
 * <p>
 * 文件描述:面对面那个fragment的适配器
 * <p>
 * 备注:
 */
public class XinyuanqiangAdapter extends ArrayAdapter<Xinyuanqiang> {
    private int resourceId;

    public XinyuanqiangAdapter(@NonNull Context context, int resource, @NonNull List<Xinyuanqiang> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Xinyuanqiang xinyuanqiang = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.content = (TextView) convertView.findViewById(R.id.xinyuanqiang_content);
            viewHolder.time = (TextView) convertView.findViewById(R.id.xinyuanqiang_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.content.setText(xinyuanqiang.getContent());
        viewHolder.time.setText(xinyuanqiang.getTime());
        return convertView;
    }

    class ViewHolder {
        TextView content;
        TextView time;
    }

}

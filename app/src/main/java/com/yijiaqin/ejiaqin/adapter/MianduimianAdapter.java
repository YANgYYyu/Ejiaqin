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
import com.yijiaqin.ejiaqin.entity.Jia;
import com.yijiaqin.ejiaqin.entity.Mianduimian;

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
public class MianduimianAdapter extends ArrayAdapter<Mianduimian> {
    private int resourceId;

    public MianduimianAdapter(@NonNull Context context, int resource, @NonNull List<Mianduimian> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Mianduimian mianduimian = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.content = (TextView) convertView.findViewById(R.id.mianduimian_item_content);
            viewHolder.name = (TextView) convertView.findViewById(R.id.mianduimian_item_name);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.mianduimian_item_iv);
            viewHolder.time = (TextView) convertView.findViewById(R.id.mianduimian_item_time_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(mianduimian.getName());
        viewHolder.content.setText(mianduimian.getContent());
        viewHolder.imageView.setImageResource(mianduimian.getImageView());
        viewHolder.time.setText(mianduimian.getTime());
        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView content;
        ImageView imageView;
        TextView time;
    }

}

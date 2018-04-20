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

import java.util.List;

/**
 * Created by 平塔岛象龟
 * 2018/4/2.
 */

public class JiaAdapter extends ArrayAdapter<Jia> {
    private int resourceId;

    public JiaAdapter(@NonNull Context context, int resource, @NonNull List<Jia> objects) {
        super(context, resource, objects);
        resourceId= resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Jia jia = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.jia_item_title);
            viewHolder.location = (TextView) convertView.findViewById(R.id.jia_item_location);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.jia_item_iv);
            viewHolder.bed = (TextView) convertView.findViewById(R.id.jia_item_bed);
            viewHolder.cost = (TextView) convertView.findViewById(R.id.jia_item_cost);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(jia.getTitle());
        viewHolder.location.setText(jia.getLocation());
        viewHolder.imageView.setImageResource(jia.getImageView());
        viewHolder.bed.setText(jia.getBed());
        viewHolder.cost.setText(jia.getCost());
        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView location;
        ImageView imageView;
        TextView cost;
        TextView bed;
    }

}

package com.yijiaqin.ejiaqin.adapter;

import android.annotation.SuppressLint;
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
import com.yijiaqin.ejiaqin.entity.Food;
import com.yijiaqin.ejiaqin.entity.Hospital;

import java.util.List;

/**
 * Created by 平塔岛象龟
 * 2018/4/2.
 */

public class HospitalAdapter extends ArrayAdapter<Hospital> {
    private int resourceId;

    public HospitalAdapter(@NonNull Context context, int resource, @NonNull List<Hospital> objects) {
        super(context, resource, objects);
        resourceId= resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hospital hospital = getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.hospital_item_title);
            viewHolder.location = (TextView) convertView.findViewById(R.id.hospital_item_location);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.hospital_item_iv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(hospital.getTitle());
        viewHolder.location.setText(hospital.getLocation());
        viewHolder.imageView.setImageResource(hospital.getimageView());
        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView location;
        ImageView imageView;
    }

}

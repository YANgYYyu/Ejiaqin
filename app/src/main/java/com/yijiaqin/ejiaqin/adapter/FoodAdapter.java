package com.yijiaqin.ejiaqin.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.entity.Food;

import java.util.List;

/**
 * Created by 平塔岛象龟
 * 2018/4/2.
 */

public class FoodAdapter extends ArrayAdapter<Food> {
    private int resourceId;

    public FoodAdapter(@NonNull Context context, int resource, @NonNull List<Food> objects) {
        super(context, resource, objects);
        resourceId= resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Food food = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView title = (TextView) view.findViewById(R.id.food_item_title);
        TextView description = (TextView) view.findViewById(R.id.food_item_material);
        title.setText(food.getTitle());
        description.setText(food.getmaterial());
        return view;
    }
}

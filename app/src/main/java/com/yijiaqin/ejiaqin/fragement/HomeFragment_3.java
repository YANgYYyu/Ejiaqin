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
import com.yijiaqin.ejiaqin.adapter.FoodAdapter;
import com.yijiaqin.ejiaqin.entity.Food;
import com.yijiaqin.ejiaqin.foodsDetail.food1Activity;
import com.yijiaqin.ejiaqin.foodsDetail.food2Activity;
import com.yijiaqin.ejiaqin.foodsDetail.food3Activity;
import com.yijiaqin.ejiaqin.foodsDetail.food4Activity;
import com.yijiaqin.ejiaqin.foodsDetail.food5Activity;
import com.yijiaqin.ejiaqin.foodsDetail.food6Activity;
import com.yijiaqin.ejiaqin.foodsDetail.food7Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/2
 * <p>
 * 文件描述:第二个fragment，养生食谱,都是假数据
 * <p>
 * 备注:
 */
public class HomeFragment_3 extends Fragment {
    private List<Food> foodList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_3, null);
        //        为防止重复添加数据，先清除数据
        foodList.clear();
//		初始话食谱数据
        initFood();
        FoodAdapter adapter = new FoodAdapter(getActivity(), R.layout.food_item, foodList);
        ListView listView = (ListView) view.findViewById(R.id.food_lv);
//        设置适配器
        listView.setAdapter(adapter);
//        设置监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getActivity(),);
                // TODO: 2018/4/4 为了省事，跳转的每个菜品都是静态的，已经写好的
//                intent.putExtra("title",foodList.get(i).getTitle());
//                intent.putExtra("material",foodList.get(i).getmaterial());
                switch (i) {
                    case 0:
                        startActivity(new Intent(getActivity(), food1Activity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), food2Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), food3Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), food4Activity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), food5Activity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), food6Activity.class));
                        break;
                    case 6:
                        startActivity(new Intent(getActivity(), food7Activity.class));
                        break;
                }

            }
        });
        return view;
    }

    private void initFood() {
        Food food1 = new Food("话梅芸豆", "原料：白芸豆、话梅、冰糖、蜂蜜。");
        foodList.add(food1);
        Food food2 = new Food("滋补养胃----营养米糊", "原料：玉米片、燕麦片、核桃仁、花生米、黄豆、白芸豆、红小豆、红腰豆、黑芝麻。");
        foodList.add(food2);
        Food food3 = new Food("【鲁菜】：诗礼银杏", "原料：银杏、白糖、蜂蜜、糖桂花、猪油。");
        foodList.add(food3);
        Food food4 = new Food("【川菜】---紫云鸡豆花", "原料：鸡胸肉、蛋清、紫菜、盐、胡椒粉、鸡汤。");
        foodList.add(food4);
        Food food5 = new Food("【川菜】双椒炒猪心", "原料：猪心、青椒、红椒、蒜梗、姜、蒜。");
        foodList.add(food5);
        Food food6 = new Food("西式牛尾汤", "原料：牛尾、白菜、胡萝卜、洋葱、番茄、土豆、芹菜、葱、姜、盐、胡椒粉、香油。");
        foodList.add(food6);
        Food food7 = new Food("边解馋边养生—芝麻奶黄包", "原料：面粉、牛奶、白糖、酵母、芝麻、鸡蛋、淀粉 、吉士粉、牛奶 、糖。");
        foodList.add(food7);
    }


}

package com.yijiaqin.ejiaqin.fragement;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.adapter.MyFragmentPagerAdapter;


import java.util.ArrayList;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/2
 *
 * 文件描述:主activity里第一个fragment里的fragment
 *
 * 备注:
 */
public class HomeFragment extends Fragment {

    Resources resources;
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private ImageView ivBottomLine; //标题下面的下划线
//    private TextView tvTabGps;
    private TextView  tvTabTianqi, tvTabYangsheng, tvTabZhangshang; //标题

    private int currIndex = 0;  //当前fragment
    private int bottomLineWidth;    //下划线的长度
    private int offset = 0; //偏移量
    private int position_one, position_two; //下划线的目标坐标
    private int  position_three;
//    public final static int num = 4;
    public final static int num = 3;
//    Fragment home1;
    Fragment home2;
    Fragment home3;
    Fragment home4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        resources = getResources();
//        初始化下划线
        InitWidth(view);
//        初始化控件
        InitTextView(view);
//        初始化viewpager
        InitViewPager(view);
//        第一次进入到此fragment时设置到的动画
        TranslateAnimation animation = new TranslateAnimation(offset, offset, 0, 0);
   //     tvTabGps.setTextColor(resources.getColor(R.color.colorPrimary));
        animation.setFillAfter(true);
        animation.setDuration(300);
        ivBottomLine.startAnimation(animation);
        return view;
    }

    private void InitTextView(View parentView) {
//        tvTabGps = (TextView) parentView.findViewById(R.id.tv_shouye_1);
        tvTabTianqi = (TextView) parentView.findViewById(R.id.tv_shouye_2);
        tvTabYangsheng = (TextView) parentView.findViewById(R.id.tv_shouye_3);
        tvTabZhangshang = (TextView) parentView.findViewById(R.id.tv_shouye_4);

//        tvTabGps.setOnClickListener(new MyOnClickListener(0));
//        tvTabTianqi.setOnClickListener(new MyOnClickListener(1));
//        tvTabYangsheng.setOnClickListener(new MyOnClickListener(2));
//        tvTabZhangshang.setOnClickListener(new MyOnClickListener(3));
        tvTabTianqi.setOnClickListener(new MyOnClickListener(0));
        tvTabYangsheng.setOnClickListener(new MyOnClickListener(1));
        tvTabZhangshang.setOnClickListener(new MyOnClickListener(2));

    }

    private void InitViewPager(View parentView) {
        mPager = (ViewPager) parentView.findViewById(R.id.vPager);
        fragmentsList = new ArrayList<Fragment>();

//        home1 = new HomeFragment_1();
        home2 = new HomeFragment_2();
        home3 = new HomeFragment_3();
        home4 = new HomeFragment_4();

//        fragmentsList.add(home1);
        fragmentsList.add(home2);
        fragmentsList.add(home3);
        fragmentsList.add(home4);

        mPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentsList));
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
        mPager.setCurrentItem(0);

    }

    private void InitWidth(View parentView) {
        ivBottomLine = (ImageView) parentView.findViewById(R.id.iv_bottom_line);    //移动的那个下划线
        bottomLineWidth = ivBottomLine.getLayoutParams().width; //下划线的长度
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / num - bottomLineWidth) / 2; //屏幕的宽度除子项数量，减去宽度再除以2，得到偏移量
        int avg = screenW / num;    //每个子项的宽度
        position_one = avg + offset;
        position_two = position_one +avg;
        position_three = position_two +avg;

    }

//    自定义标题监听器
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    }

//    自定义viewpager监听器
    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, offset, 0, 0);
                     //   tvTabTianqi.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, offset, 0, 0);
                   //     tvTabYangsheng.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    } //else if (currIndex == 3) {
//                        animation = new TranslateAnimation(position_three,offset, 0, 0);
//                   //     tvTabZhangshang.setTextColor(resources.getColor(R.color.colorPrimaryDark));
//                    }
//                  //  tvTabGps.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_one, 0, 0);
                    //    tvTabGps.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, position_one, 0, 0);
                    //    tvTabYangsheng.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    } //else if (currIndex == 3) {
//                        animation = new TranslateAnimation(position_three, position_one, 0, 0);
//                     //   tvTabZhangshang.setTextColor(resources.getColor(R.color.colorPrimaryDark));
//                    }
                   // tvTabTianqi.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, position_two, 0, 0);
                     ///   tvTabGps.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, position_two, 0, 0);
                    //    tvTabTianqi.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    } //else if (currIndex == 3) {
//                        animation = new TranslateAnimation(position_three, position_two, 0, 0);
//                     //   tvTabZhangshang.setTextColor(resources.getColor(R.color.colorPrimaryDark));
//                    }
                   // tvTabYangsheng.setTextColor(resources.getColor(R.color.colorPrimaryDark));
                    break;
//                case 3:
//                    if (currIndex == 0) {
//                        animation = new TranslateAnimation(offset, position_three, 0, 0);
//                     //   tvTabGps.setTextColor(resources.getColor(R.color.colorPrimaryDark));
//                    } else if (currIndex == 1) {
//                        animation = new TranslateAnimation(position_one, position_three, 0, 0);
//                    //    tvTabTianqi.setTextColor(resources.getColor(R.color.colorPrimaryDark));
//                    } else if (currIndex == 2) {
//                        animation = new TranslateAnimation(position_two, position_three, 0, 0);
//                    //    tvTabYangsheng.setTextColor(resources.getColor(R.color.colorPrimaryDark));
//                    }
//                  //  tvTabZhangshang.setTextColor(resources.getColor(R.color.colorPrimaryDark));
//                    break;
            }
            currIndex = arg0;
            if (animation != null) {
                animation.setFillAfter(true);
            }

            ivBottomLine.startAnimation(animation);
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }


        public void onPageScrollStateChanged(int arg0) {
        }
    }


}
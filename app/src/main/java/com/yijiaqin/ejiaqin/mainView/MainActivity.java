package com.yijiaqin.ejiaqin.mainView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yijiaqin.ejiaqin.R;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/2
 *
 * 文件描述:主activity
 *
 * 备注:里面嵌套了4个fragment，第一个fragment里又嵌套了3个fragment
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private LinearLayout mTabShouye;
    private LinearLayout mTabJia;
    private LinearLayout mTabMianduimian;
    private LinearLayout mTabXinyuanqiang;

    private ImageButton mImgShouye;
    private ImageButton mImgJia;
    private ImageButton mImgMianduimian;
    private ImageButton mImgXinyuanqiang;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;


    private DrawerLayout drawerLayout;  //侧滑栏
    private ImageView actionbar_img;    //唤出侧滑栏的图标
    private Button btn_left1, btn_left2, btn_left3, btn_left4, btn_left5, btn_left6;    //侧滑栏的按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
//      初始化试图
        initView();
//       初始化点击事件
        initEvent();
//        fragment的切换
        setSelect(0);
//        初始化第一个fragment
        initData();
    }

    private void initEvent() {
//        底部栏
        mTabShouye.setOnClickListener(this);
        mTabJia.setOnClickListener(this);
        mTabMianduimian.setOnClickListener(this);
        mTabXinyuanqiang.setOnClickListener(this);

//      标题的头像
        actionbar_img.setOnClickListener(this);

//        侧滑栏里的点item
        btn_left1.setOnClickListener(this);
        btn_left2.setOnClickListener(this);
        btn_left3.setOnClickListener(this);
        btn_left4.setOnClickListener(this);
        btn_left5.setOnClickListener(this);
        btn_left6.setOnClickListener(this);
    }

    private void initView() {
//        底部栏里的每一个子项
        mTabShouye = (LinearLayout) findViewById(R.id.id_tab_shouye);
        mTabJia = (LinearLayout) findViewById(R.id.id_tab_jia);
        mTabMianduimian = (LinearLayout) findViewById(R.id.id_tab_mianduimian);
        mTabXinyuanqiang = (LinearLayout) findViewById(R.id.id_tab_xinyuanqiang);
//        底部栏里的每一个子项的图片
        mImgShouye = (ImageButton) findViewById(R.id.id_tab_shouye_img);
        mImgJia = (ImageButton) findViewById(R.id.id_tab_jia_img);
        mImgMianduimian = (ImageButton) findViewById(R.id.id_tab_mianduimian_img);
        mImgXinyuanqiang = (ImageButton) findViewById(R.id.id_tab_xinyuanqiang_img);
//      侧滑栏
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionbar_img = (ImageView) findViewById(R.id.actionbar_img);
        btn_left1 = (Button) findViewById(R.id.btn_left1);
        btn_left2 = (Button) findViewById(R.id.btn_left2);
        btn_left3 = (Button) findViewById(R.id.btn_left3);
        btn_left4 = (Button) findViewById(R.id.btn_left4);
        btn_left5 = (Button) findViewById(R.id.btn_left5);
        btn_left6 = (Button) findViewById(R.id.btn_left6);

    }

    /**
     * 切换activity里的fragment，默认为0，即第一个
     * @param i 切换的fragment的序号
     */
    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i) {
            case 0:
                Fragment homeFragment = new com.yijiaqin.ejiaqin.fragement.HomeFragment();
                transaction.replace(R.id.id_content, homeFragment);
                mImgShouye.setImageResource(R.drawable.shouye_pressed);
                transaction.commit();
                break;
            case 1:
                Fragment jiaFragment = new com.yijiaqin.ejiaqin.fragement.JiaFragment();
                transaction.replace(R.id.id_content, jiaFragment);
                mImgJia.setImageResource(R.drawable.jia_pressed);
                transaction.commit();
                break;
            case 2:
                Fragment mianduimianFragment = new com.yijiaqin.ejiaqin.fragement.MianDuiMianFragment();
                transaction.replace(R.id.id_content, mianduimianFragment);
                mImgMianduimian.setImageResource(R.drawable.mianduimian_pressed);
                transaction.commit();
                break;
            case 3:
                Fragment xinyuanqiangFragment = new com.yijiaqin.ejiaqin.fragement.XinYuanQiangFragment();
                transaction.replace(R.id.id_content, xinyuanqiangFragment);
                mImgXinyuanqiang.setImageResource(R.drawable.xinyuanqiang_pressed);
                transaction.commit();
                break;
            default:
                break;
        }
    }

//    隐藏对应的fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }
    }

//    初始化第一个fragment
    private void initData() {
        addFragmentToStack(new com.yijiaqin.ejiaqin.fragement.HomeFragment());
    }

    private void addFragmentToStack(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.id_content, fragment).commit();
    }

//  对底部栏按钮进行监听，切换到对应fragment
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()) {
            case R.id.id_tab_shouye:
                setSelect(0);
                break;
            case R.id.id_tab_jia:
                setSelect(1);
                break;
            case R.id.id_tab_mianduimian:
                setSelect(2);
                break;
            case R.id.id_tab_xinyuanqiang:
                setSelect(3);
                break;
            case R.id.actionbar_img:
                drawerLayout.openDrawer(Gravity.START);
                mImgShouye.setImageResource(R.drawable.shouye_pressed);
                break;
            default:
                break;

        }
    }

    /**
     * 切换图片至暗色
     */
    private void resetImgs() {
        mImgShouye.setImageResource(R.drawable.shouye);
        mImgJia.setImageResource(R.drawable.jia);
        mImgMianduimian.setImageResource(R.drawable.mianduimian);
        mImgXinyuanqiang.setImageResource(R.drawable.xinyuanqiang);
    }


}

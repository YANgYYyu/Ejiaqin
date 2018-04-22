package com.yijiaqin.ejiaqin.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.entity.Xinyuanqiang;
import com.yijiaqin.ejiaqin.util.TimeUtil;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/10
 * <p>
 * 文件描述:心愿墙的输入的activty
 * <p>
 * 备注:
 */
public class NewxyqActivity extends AppCompatActivity {
    private EditText contentEt; //输入内容的editText
    private TextView numTv; //可输入字符的textView
    private int num = 150;    //可输入的最大字符数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newxyq);
//        标题栏的标题和返回键的设置
        TextView titleTV = (TextView) findViewById(R.id.topbar_title_tv);
        titleTV.setText("心愿");
        Button cancelBtn = (Button) findViewById(R.id.topbar_left_btn);
        cancelBtn.setText(R.string.main_cancel);
        cancelBtn.setVisibility(View.VISIBLE);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backAction();
            }
        });
        Button confirmBtn = (Button) findViewById(R.id.topbar_right_btn);
        confirmBtn.setText(R.string.main_confirm);
        confirmBtn.setVisibility(View.VISIBLE);
//        初始化试图
        initView();
        contentEt.addTextChangedListener(new TextWatcher() {
            private CharSequence wordNum;//记录输入的字数
            private int selectionStart;
            private int selectionEnd;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                wordNum = s;//实时记录输入的字数
            }

            @Override
            public void afterTextChanged(Editable s) {
                int number = num - s.length();
                //TextView显示剩余字数
                numTv.setText("还可再输入" + number + "字");
                selectionStart = contentEt.getSelectionStart();
                selectionEnd = contentEt.getSelectionEnd();
                if (wordNum.length() > num) {
                    //删除多余输入的字（不会显示出来）
                    s.delete(selectionStart - 1, selectionEnd);
                    contentEt.setText(s);
                    contentEt.setSelection(selectionEnd);//设置光标在最后
                }
            }
        });
//        保存编辑框里的内容和发布时间
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = contentEt.getText().toString();
                if (!"".equals(text)) {
//                把数据存到数据库中
                    Xinyuanqiang xinyuanqiang = new Xinyuanqiang();
                    xinyuanqiang.setContent(contentEt.getText().toString());
                    xinyuanqiang.setTime(TimeUtil.getTime(0));
                    xinyuanqiang.save();
                    backAction();
                } else {
                    backAction();
                }
            }
        });
    }

    private void initView() {
        contentEt = (EditText) findViewById(R.id.newxyq_et);
        numTv = (TextView) findViewById(R.id.newxyq_num);
    }

    //    点击返回时，直接finish掉activity
    private void backAction() {
        finish();
    }

//    重写返回键

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            backAction();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}

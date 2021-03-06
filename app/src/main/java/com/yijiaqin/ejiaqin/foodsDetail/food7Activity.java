package com.yijiaqin.ejiaqin.foodsDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yijiaqin.ejiaqin.R;

public class food7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food7);
        //        标题栏的标题和返回键的设置
        TextView titleTV = (TextView) findViewById(R.id.topbar_title_tv);
        titleTV.setText("边解馋边养生—芝麻奶黄包");
        Button cancelBtn = (Button) findViewById(R.id.topbar_left_btn);
        cancelBtn.setText(R.string.main_cancel);
        cancelBtn.setVisibility(View.VISIBLE);

        TextView textView = (TextView) findViewById(R.id.food7_tv);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backAction();
            }
        });
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

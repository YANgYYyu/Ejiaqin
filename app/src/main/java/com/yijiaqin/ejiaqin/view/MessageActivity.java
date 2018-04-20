package com.yijiaqin.ejiaqin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.adapter.MsgAdapter;
import com.yijiaqin.ejiaqin.entity.Msg;
import com.yijiaqin.ejiaqin.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：平塔岛象龟
 * <p>
 * 邮箱：454941261@qq.com
 * <p>
 * 创建日期：2018/4/9
 * <p>
 * 文件描述:具体的聊天界面
 * <p>
 * 备注:
 */
public class MessageActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
//        取出intent的数据
        Intent intent = getIntent();
        //        标题栏的标题和返回键的设置。不需要在消息的实体类里设置title，直接从intent里取出数据进行设置
        TextView titleTV = (TextView) findViewById(R.id.topbar_title_tv);
        titleTV.setText(intent.getStringExtra("name"));
        Button cancelBtn = (Button) findViewById(R.id.topbar_right_btn);
        cancelBtn.setText(R.string.main_cancel);
        cancelBtn.setVisibility(View.VISIBLE);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backAction();
            }
        });

//        初始化数据，获取传过来的值
        msgList.add(new Msg(intent.getExtras().getInt("iv"), intent.getStringExtra("content"),
                intent.getStringExtra("time"), intent.getStringExtra("name"), Msg.TYPE_RECEIVER));
//      拿到控件
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
//        初始化适配器
        adapter = new MsgAdapter(msgList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
//        设置适配器
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(R.drawable.laoren, content, TimeUtil.getTime(0), "测试用户", Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
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

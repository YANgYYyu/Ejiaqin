package com.yijiaqin.ejiaqin.mainView;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.yijiaqin.ejiaqin.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者：平塔岛象龟
 *
 * 邮箱：454941261@qq.com
 *
 * 创建日期：2018/4/2
 *
 * 文件描述:登陆界面
 *
 * 备注:
 */

public class LogInActivity extends AppCompatActivity {
    private Button login, logup;    //登陆和注册按钮
    private EditText username, password;
    private SharedPreferences share;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
//        初始化控件
        initView();
//        保存一个账号密码都为123的用户
        saveuser();
        //注册的监听事件
        logup.setOnClickListener(new LogUpLinstenerimp());
        //登录的事件监听内部处理类
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pass = password.getText().toString();
                //判断账号密码是否为空
                if (name.trim().equals("") || pass.trim().equals("")) {
                    Toast.makeText(LogInActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                //获取保存文件中的账号和密码
                String savedUsername = share.getString("username", "");
                String savedPassword = share.getString("password", "");
                //查看输入的账号和密码是否一致
                if (name.trim().equals(savedUsername) && pass.trim().equals(savedPassword)) {
                    Toast.makeText(LogInActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    //切换界面
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            startActivity(new Intent(LogInActivity.this, MainActivity.class));
                            finish();
                        }
                    }, 0500);
                } else {
                    //账号密码错误
                    Toast.makeText(LogInActivity.this, "账号密码错误，请确认后再次尝试登陆", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void initView() {
        login = (Button) findViewById(R.id.id_login);
        logup = (Button) findViewById(R.id.id_logup);
        username = (EditText) findViewById(R.id.id_login_id);
        password = (EditText) findViewById(R.id.id_login_psd);
    }

    //设置一个123用户
    private void saveuser() {
        share = getSharedPreferences("info", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putString("username", "123");
        edit.putString("password", String.valueOf(123));
        edit.commit();   //提交信息
    }

//    自定义监听器
    private class LogUpLinstenerimp implements OnClickListener {
        public void onClick(View v) {
            //注册两个字符串常量，并获取对应的信息
            final String nam = username.getText().toString();
            final String pas = password.getText().toString();
            //判断信息是否为空
            if (nam.trim().equals("") || pas.trim().equals("")) {
                Toast.makeText(LogInActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            Dialog dialog = new AlertDialog.Builder(LogInActivity.this)
                    .setTitle("注册")
                    .setMessage("你确定注册信息吗?")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        //保存输入的信息 edit.commit();提交信息
                        public void onClick(DialogInterface dialog, int which) {
                            share = getSharedPreferences("info", Activity.MODE_PRIVATE);
                            Editor edit = share.edit();
                            edit.putString("username", nam);
                            edit.putString("password", pas);
                            edit.commit();
                            //提示注册成功
                            Toast.makeText(LogInActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).create();
            dialog.show();
        }
    }


}




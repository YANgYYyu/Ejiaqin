package com.yijiaqin.ejiaqin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yijiaqin.ejiaqin.R;

import java.util.Timer;
import java.util.TimerTask;

public class FirstBackGround_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstbackground);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(FirstBackGround_Activity.this, LogInActivity.class));
                finish();
            }
        }, 2000);

    }
}

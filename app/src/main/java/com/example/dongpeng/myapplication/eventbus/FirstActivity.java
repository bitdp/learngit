package com.example.dongpeng.myapplication.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dongpeng.myapplication.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dongpeng on 2016/8/30.
 */
public class FirstActivity extends Activity {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.button_next)
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getevent_lay);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

    }

    /**
     * threadMode:POSTING 默认，跟发送消息的地方同一个线程
     *            MAIN 在主线程接收
     *            BACKGROUND 在子线程接收
     *            ASYNC 独立的子线程（另开一新线程）
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    //这个方法可以自己定义
    public void onEvent(String s) {
//        String s = (String) msgEvent.getO();
        tv.setText(s);
        Toast.makeText(FirstActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_next)
    public void onClick() {
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

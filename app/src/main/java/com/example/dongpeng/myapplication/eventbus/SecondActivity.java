package com.example.dongpeng.myapplication.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.example.dongpeng.myapplication.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dongpeng on 2016/8/30.
 */
public class SecondActivity extends Activity {
    @BindView(R.id.button_next)
    Button buttonNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getevent_lay);
        ButterKnife.bind(this);
        buttonNext.setText("回传数据");
    }

    @OnClick(R.id.button_next)
    public void onClick() {
        EventBus.getDefault().post("zhangsan");
//        EventBus.getDefault().post(new MsgEvent("小明"));
        this.finish();
    }
}

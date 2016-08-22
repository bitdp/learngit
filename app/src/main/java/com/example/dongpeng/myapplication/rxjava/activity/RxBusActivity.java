package com.example.dongpeng.myapplication.rxjava.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.dongpeng.myapplication.R;
import com.example.dongpeng.myapplication.rxjava.util.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dongpeng on 2016/8/22.
 */
public class RxBusActivity extends Activity {
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
        RxBus.getInstance().post("7777777");
        Intent intent=new Intent(RxBusActivity.this,TestActivity.class);
        startActivity(intent);
    }
}

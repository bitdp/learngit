package com.example.dongpeng.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dongpeng.myapplication.fresco.FrescoActivity;
import com.example.dongpeng.myapplication.rxjava.activity.RxBusActivity;
import com.example.dongpeng.myapplication.tab_viewpager.Tab_ViewPager_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    @BindView(R.id.button_tab)
    Button button_tab;
    @BindView(R.id.button_rx)
    Button buttonRx;
    @BindView(R.id.button_fresco)
    Button buttonFresco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button_tab, R.id.button_rx, R.id.button_fresco})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button_tab:
                intent = new Intent(MainActivity.this, Tab_ViewPager_Activity.class);
                startActivity(intent);
                break;
            case R.id.button_rx:
                intent = new Intent(MainActivity.this, RxBusActivity.class);
                startActivity(intent);
                break;
            case R.id.button_fresco:
                intent = new Intent(MainActivity.this, FrescoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
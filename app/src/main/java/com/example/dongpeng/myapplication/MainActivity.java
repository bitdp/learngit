package com.example.dongpeng.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.dongpeng.myapplication.tab_viewpager.Tab_ViewPager_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    @BindView(R.id.button_tab)
    Button button_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_tab)
    public void onClick() {
        Intent intent=new Intent(MainActivity.this, Tab_ViewPager_Activity.class);
        startActivity(intent);
    }
}

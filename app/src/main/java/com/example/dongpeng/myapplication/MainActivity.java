package com.example.dongpeng.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dongpeng.myapplication.android_js.Android_JS_Activity;
import com.example.dongpeng.myapplication.animation.PropertyAnimationActivity;
import com.example.dongpeng.myapplication.appbar.NestedActivity;
import com.example.dongpeng.myapplication.bottomsheet.BottomSheetActivity;
import com.example.dongpeng.myapplication.eventbus.FirstActivity;
import com.example.dongpeng.myapplication.fresco.FrescoActivity;
import com.example.dongpeng.myapplication.immergestate.ImmergestateActivity;
import com.example.dongpeng.myapplication.mvp.view.LoginActivity;
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
    @BindView(R.id.button_immergestate)
    Button buttonImmergestate;
    @BindView(R.id.button_bottomdialog)
    Button buttonBottomdialog;
    @BindView(R.id.button_appBar)
    Button buttonAppBar;
    @BindView(R.id.button_animation)
    Button buttonAnimation;
    @BindView(R.id.button_databinding)
    Button buttonDatabinding;
    @BindView(R.id.button_js)
    Button buttonJs;
    @BindView(R.id.button_mvp)
    Button buttonMvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button_tab, R.id.button_rx, R.id.button_fresco, R.id.button_immergestate, R.id.button_bottomdialog,
            R.id.button_appBar, R.id.button_animation, R.id.button_databinding, R.id.button_js,R.id.button_mvp})
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
            case R.id.button_immergestate:
                intent = new Intent(MainActivity.this, ImmergestateActivity.class);
                startActivity(intent);
                break;
            case R.id.button_bottomdialog:
                intent = new Intent(MainActivity.this, BottomSheetActivity.class);
                startActivity(intent);
                break;
            case R.id.button_appBar:
                intent = new Intent(MainActivity.this, NestedActivity.class);
                startActivity(intent);
                break;
            case R.id.button_animation:
                intent = new Intent(MainActivity.this, PropertyAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.button_databinding:
                intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.button_js:
                intent = new Intent(MainActivity.this, Android_JS_Activity.class);
                startActivity(intent);
                break;
            case R.id.button_mvp:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

}
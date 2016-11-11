package com.example.dongpeng.myapplication.spannablestring;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dongpeng.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dongpeng on 2016/9/14.
 */
public class SpannableStringActivity extends Activity {
    @BindView(R.id.bt_1)
    Button bt1;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spannable_lay);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_1)
    public void onClick() {
        String s="嘉和美康科技有限公司";
        SpannableString spannableString = new SpannableString(s);
        //设置背景色
        spannableString.setSpan(new BackgroundColorSpan(Color.RED), 3, spannableString.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //添加点击事件，
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);// false为去掉下划线
                ds.setColor(Color.GRAY);//设置字体跟下划线的颜色
            }

            @Override
            public void onClick(View widget) {
                Toast.makeText(SpannableStringActivity.this,"前几个字",Toast.LENGTH_SHORT).show();
            }
        },0,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);// false为去掉下划线
                ds.setColor(Color.BLUE);//设置字体跟下划线的颜色
            }

            @Override
            public void onClick(View widget) {
                Toast.makeText(SpannableStringActivity.this,"后几个字",Toast.LENGTH_SHORT).show();
            }
        },6,s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体大小，new AbsoluteSizeSpan(20,true)，第二个参数为true时，单位为dp
        spannableString.setSpan(new AbsoluteSizeSpan(20,true),0,s.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //改变选中文本的高亮颜色，有点击事件时用
        tv.setHighlightColor(Color.TRANSPARENT);
        //设置字体样式
        spannableString.setSpan(new TextAppearanceSpan(this,R.style.spannableStyle), 0, spannableString.length()-3,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setMovementMethod(LinkMovementMethod.getInstance());//开始响应点击事件
        tv.setText(spannableString);
    }
}

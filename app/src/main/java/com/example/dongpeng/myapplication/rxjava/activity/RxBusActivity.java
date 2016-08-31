package com.example.dongpeng.myapplication.rxjava.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dongpeng.myapplication.R;
import com.example.dongpeng.myapplication.rxjava.util.RxBus;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dongpeng on 2016/8/22.
 */
public class RxBusActivity extends Activity {
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.button_debounce)
    Button buttonDebounce;
    @BindView(R.id.et)
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_layout);
        ButterKnife.bind(this);

        showEt();
    }

    private void showEt() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                et.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        subscriber.onNext(et.getText().toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        }).subscribeOn(Schedulers.io()).debounce(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                tv.setText("完成");
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(final String s) {
                tv.setText(s);
            }
        });
    }

    @OnClick({R.id.button, R.id.button_debounce})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                RxBus.getInstance().post("7777777");
                Intent intent = new Intent(RxBusActivity.this, TestActivity.class);
                startActivity(intent);
                break;
            case R.id.button_debounce:
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(final Subscriber<? super String> subscriber) {
                        et.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                    subscriber.onNext(et.getText().toString());
                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                    }
                }).debounce(1000, TimeUnit.MILLISECONDS).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        tv.setText(s);
                    }
                });
                break;
        }

    }
}

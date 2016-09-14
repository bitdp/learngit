package com.example.dongpeng.myapplication.mvp.view;

/**
 * Created by dongpeng on 2016/9/1.
 */
public interface ILoginView {
    void onClear();
    void onLoginResult(String name,String age);
    void loginFailed();
}

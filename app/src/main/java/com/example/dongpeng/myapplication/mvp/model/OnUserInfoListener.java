package com.example.dongpeng.myapplication.mvp.model;

import com.example.dongpeng.myapplication.mvp.bean.User;

/**
 * Created by dongpeng on 2016/9/1.
 */
public interface OnUserInfoListener {
    void getUserInfoSuccess(User user);
    void getUserInfoFailed();
}

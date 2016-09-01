package com.example.dongpeng.myapplication.mvp.model;

import com.example.dongpeng.myapplication.mvp.bean.User;

/**
 * Created by dongpeng on 2016/9/1.
 */
public class GetUserInfo implements IGetUser {
    @Override
    public void getUserInfo(String name,OnUserInfoListener listener) {
        if (name.equals("111")){
            User user=new User("张三","21");
            listener.getUserInfoSuccess(user);
        }else{
            listener.getUserInfoFailed();
        }
    }
}

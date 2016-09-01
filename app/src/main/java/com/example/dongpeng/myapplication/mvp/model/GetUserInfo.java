package com.example.dongpeng.myapplication.mvp.model;

import com.example.dongpeng.myapplication.mvp.bean.User;

/**
 * Created by dongpeng on 2016/9/1.
 */
public class GetUserInfo implements IGetUser {
    int i=1;
    @Override
    public void getUserInfo(OnUserInfoListener listener) {
        if (i==0){
            User user=new User("","");
            listener.getUserInfoSuccess(user);
        }else{
            listener.getUserInfoFailed();
        }
    }
}

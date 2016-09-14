package com.example.dongpeng.myapplication.mvp.presenter;

import com.example.dongpeng.myapplication.mvp.bean.User;
import com.example.dongpeng.myapplication.mvp.model.GetUserInfo;
import com.example.dongpeng.myapplication.mvp.model.IGetUser;
import com.example.dongpeng.myapplication.mvp.model.OnUserInfoListener;
import com.example.dongpeng.myapplication.mvp.view.ILoginView;

/**
 * Created by dongpeng on 2016/9/1.
 */
public class LoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;
    IGetUser iGetUser;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iGetUser=new GetUserInfo();
    }

    @Override
    public void clearText() {
        iLoginView.onClear();
    }

    @Override
    public void getLoginResult(String name,String age) {
        iGetUser.getUserInfo(name,new OnUserInfoListener() {
            @Override
            public void getUserInfoSuccess(User user) {
                iLoginView.onLoginResult(user.getName(),user.getAge());
            }

            @Override
            public void getUserInfoFailed() {
                iLoginView.loginFailed();
            }
        });
    }
}

package com.example.dongpeng.myapplication.mvp.presenter;

import com.example.dongpeng.myapplication.mvp.bean.User;
import com.example.dongpeng.myapplication.mvp.model.GetUserInfo;
import com.example.dongpeng.myapplication.mvp.model.IGetUser;
import com.example.dongpeng.myapplication.mvp.model.OnUserInfoListener;
import com.example.dongpeng.myapplication.mvp.view.ILoginView;

/**
 * Created by dongpeng on 2016/9/1.
 */
public class ILoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;
    IGetUser iGetUser;

    public ILoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iGetUser=new GetUserInfo();
    }

    @Override
    public void clearText() {
        iLoginView.onClear();
    }

    @Override
    public void loginResult(String name,String age) {
        iGetUser.getUserInfo(new OnUserInfoListener() {
            @Override
            public void getUserInfoSuccess(User user) {
                iLoginView.onLoginResult("","");
            }

            @Override
            public void getUserInfoFailed() {
                iLoginView.loginFailed();
            }
        });
//        if (name.equals("zhangsan")&&age.equals("111")){
//
//        }else{
//
//        }
    }
}

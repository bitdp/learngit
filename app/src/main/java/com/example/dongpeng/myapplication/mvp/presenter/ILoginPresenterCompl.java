package com.example.dongpeng.myapplication.mvp.presenter;

import com.example.dongpeng.myapplication.mvp.view.ILoginView;

/**
 * Created by dongpeng on 2016/9/1.
 */
public class ILoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;

    public ILoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void clearText() {
        iLoginView.onClear();
    }

    @Override
    public void loginResult(String name,String age) {
        if (name.equals("zhangsan")&&age.equals("111")){
            iLoginView.onLoginResult("","");
        }else{
            iLoginView.loginFailed();
        }
    }
}

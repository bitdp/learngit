package com.example.dongpeng.myapplication.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by douhaoqiang on 2016/8/19.
 */

public abstract class BaseActivity<V,T extends BasePrestener<V>> extends Activity  {

    private T mPrestener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPrestener=createPresenter();
    }


    /**
     * 获取布局文件id
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化数据
     */
    public abstract void initialize();

    /**
     * 创建该视图的Prestener
     * @return
     */
    public abstract T createPresenter();


    @Override
    protected void onDestroy() {
        //解绑view
        mPrestener.detachView();
        super.onDestroy();
    }
}

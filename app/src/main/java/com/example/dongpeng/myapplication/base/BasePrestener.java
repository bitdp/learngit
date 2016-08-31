package com.example.dongpeng.myapplication.base;

import java.lang.ref.WeakReference;

/**
 * Created by douhaoqiang on 2016/8/19.
 */

public class BasePrestener<V> {

    private WeakReference<V> viewRef;


    /**
     * 绑定对应view
     * @param view
     */
    public void attachView(V view){
        viewRef=new WeakReference<V>(view);
    }

    /**
     * 获取绑定的view
     * @return
     */
    public V getView(){
        return viewRef.get();
    }

    /**
     * 解绑定对应view
     */
    public void detachView(){

        if(viewRef!=null){
            viewRef.clear();
            viewRef=null;
        }

    }

}

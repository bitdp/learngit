package com.example.dongpeng.myapplication.rxjava.util;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by dongpeng on 2016/8/22.
 */
public class RxBus {
    private static RxBus rxBus;
    private final Subject<Object, Object> BUS=new SerializedSubject<>(PublishSubject.create());
    public static RxBus getInstance(){
        if (rxBus==null){
            rxBus=new RxBus();
        }
        return rxBus;
    }
    //post 方法发布一个 Event 对象给 bus，然后由 bus 转发给订阅者们。
    public void post(Object object) {
        BUS.onNext(object);
    }

    //toObserverable 方法能够获得一个包含目标事件的 Observable，订阅者对其订阅即可响应。
    public <T>Observable<T> toObservable(Class<T> eventType){
        //ofType操作符类似于filter操作符，区别在于ofType操作符是按照类型对结果进行过滤,例如ofType(String.class);
        return BUS.ofType(eventType);
    }
}

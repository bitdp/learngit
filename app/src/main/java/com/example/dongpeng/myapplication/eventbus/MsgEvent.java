package com.example.dongpeng.myapplication.eventbus;

/**
 * Created by dongpeng on 2016/8/30.
 */
public class MsgEvent {
   public static Object o = null;

    public MsgEvent(Object o) {
        this.o = o;
    }

    public static Object getO() {
        return o;
    }

    public static void setO(Object o) {
        MsgEvent.o = o;
    }
}

package com.example.dongpeng.myapplication.mvp.bean;

/**
 * Created by dongpeng on 2016/9/1.
 */
public class User {
    String name;
    String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

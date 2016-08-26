package com.example.dongpeng.myapplication.animation;

import android.animation.TypeEvaluator;

/**
 * Created by dongpeng on 2016/8/26.
 */
public class MyTypeEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startP= (Point) startValue;
        Point endP= (Point) endValue;
        float x=startP.getX()+fraction*(endP.getX()-startP.getX());
        float y=startP.getY()+fraction*(endP.getY()-startP.getY());
        return new Point(x,y);
    }
}

package com.example.dongpeng.myapplication.animation;

import android.animation.TypeEvaluator;

/**
 * Created by dongpeng on 2016/8/26.
 */
public class MyColorTypeEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        String startC = (String) startValue;
        String endC = (String) endValue;
        int startR = Integer.parseInt(startC.substring(1, 3), 16);
        int startG = Integer.parseInt(startC.substring(3, 5), 16);
        int startB = Integer.parseInt(startC.substring(5, 7), 16);
        int endR = Integer.parseInt(endC.substring(1, 3), 16);
        int endG = Integer.parseInt(endC.substring(3, 5), 16);
        int endB = Integer.parseInt(endC.substring(5, 7), 16);

        int tempR = -1;
        int tempG = -1;
        int tempB = -1;
        if (startR > endR) {
            tempR = (int) (startR - fraction * (startR - endR));
        } else {
            tempR = (int) (startR + fraction * (endR - startR));
        }
        if (startG > endG) {
            tempG = (int) (startG - fraction * (startG - endG));
        } else {
            tempG = (int) (startG + fraction * (endG - startG));
        }
        if (startB > endB) {
            tempB = (int) (startB - fraction * (startB - endB));
        } else {
            tempB = (int) (startB + fraction * (endB - startB));
        }

        String tempC="#"+getString(tempR)+getString(tempG)+getString(tempB);
        return tempC;
    }
    String getString(int temp){
        String s=Integer.toHexString(temp);
        if(s.length()==1){
            s="0"+s;
        }
        return s;
    }
}

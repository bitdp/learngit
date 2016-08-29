package com.example.dongpeng.myapplication.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dongpeng on 2016/8/26.
 */
public class MyAnimatorView extends View {
    String color="ffffff";
    Point point;
    static final int RADIUS=50;//半径
    Paint mPaint;
    public MyAnimatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        point = new Point(RADIUS, RADIUS);
        mPaint=new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (point==null) {
//            point = new Point(RADIUS, RADIUS);
//            canvas.drawCircle(point.getX(), point.getY(), RADIUS, mPaint);
//        }else {
//            canvas.drawCircle(point.getX(), point.getY(), RADIUS, mPaint);
//        }
        canvas.drawCircle(point.getX(), point.getY(), RADIUS, mPaint);
    }


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        invalidate();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }
}

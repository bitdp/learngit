package com.example.dongpeng.myapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by dongpeng on 2016/8/31.
 */
public class TemperatureView extends View {
    private Paint mPaint;
    int strokeWidth=2;//线宽
    int mWidth;
    public TemperatureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("ssss","onDrawonDrawonDrawonDraw");
//        drawCircle(canvas);
        drawArc(canvas);
        drawText(canvas);
        drawSpace(canvas);
        drawLine(canvas);
    }

    private void drawLine(Canvas canvas) {
        mPaint.setStrokeWidth(6);
        mPaint.setColor(Color.BLUE);
        canvas.translate(mWidth/2,mWidth/2);
        canvas.rotate((float) (-135+30*6.75));
        canvas.drawLine(0,0,0,-40,mPaint);
    }

    private void drawSpace(Canvas canvas) {
        canvas.save();

        canvas.rotate(-135,mWidth/2,mWidth/2);
        for(int i=0;i<=40;i++){
            if (i%5==0){
                canvas.drawText(i+"",mWidth/2-mPaint.measureText(i+"")/2,120,mPaint);
                canvas.drawLine(mWidth/2,50,mWidth/2,70,mPaint);
            }else {
                canvas.drawLine(mWidth/2,50,mWidth/2,60,mPaint);
            }
            canvas.rotate(6.75f,mWidth/2,mWidth/2);
        }
        canvas.restore();
    }

    private void drawText(Canvas canvas) {
        mPaint.setTextSize(30);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.BLACK);
        Rect rect=new Rect();
        String s="正常";
        mPaint.getTextBounds(s,0,s.length(),rect);
        canvas.rotate(-90,mWidth/2,mWidth/2);
        canvas.drawText(s,mWidth/2-rect.width()/2,25+rect.height()/2,mPaint);
        s="预警";
        canvas.rotate(90,mWidth/2,mWidth/2);
        canvas.drawText(s,mWidth/2-rect.width()/2,25+rect.height()/2,mPaint);
        s="警告";
        canvas.rotate(90,mWidth/2,mWidth/2);
        canvas.drawText(s,mWidth/2-rect.width()/2,25+rect.height()/2,mPaint);
        canvas.restore();
    }

    private void drawArc(Canvas canvas) {
        RectF rectF=new RectF(25,25,mWidth-25,mWidth-25);
        mPaint.setStrokeWidth(50);
        mPaint.setColor(Color.parseColor("#cccccc"));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF,135,120,false,mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(rectF,270,130,false,mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawArc(rectF,230,110,false,mPaint);
        canvas.save();
    }

    private void drawCircle(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(6);
        canvas.drawCircle(mWidth/2,mWidth/2,mWidth/2-3,mPaint);
        canvas.save();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth=getWidth()<getHeight()?getWidth():getHeight();
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

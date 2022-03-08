package com.hqu.achievement.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.hqu.achievement.R;


public class RectProBarView extends View {
    private float progress=0,maxProgress=100,mRadius;
    private int mWidth,mHeight,mStrokeWidth;
    private Paint proPaint,fillPaint,strokePaint;
    private Boolean isHorizontal,reverse;
    private RectF backRect,proRect,strokeRect;

    public RectProBarView(Context context) {
        this(context,null);
    }

    public RectProBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RectProBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        proPaint=new Paint();
        fillPaint=new Paint();
        strokePaint=new Paint();
        proPaint.setAntiAlias(true);
        fillPaint.setAntiAlias(true);
        strokePaint.setAntiAlias(true);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.ProBarView);
        TypedArray typedArrayRect=context.obtainStyledAttributes(attrs, R.styleable.RectProBarView);
        int proColor=typedArray.getColor(R.styleable.ProBarView_ProBarColor, Color.BLACK);
        int fillColor=typedArray.getColor(R.styleable.ProBarView_FillBarColor,Color.WHITE);
        int strokeColor=typedArray.getColor(R.styleable.ProBarView_StrokeColor,Color.GRAY);
        float strokeWidth=typedArray.getDimension(R.styleable.ProBarView_StrokeWidth,0);
        maxProgress=typedArray.getFloat(R.styleable.ProBarView_MaxProgress,100);
        progress=typedArray.getFloat(R.styleable.ProBarView_DefaultProgress,0);
        isHorizontal=typedArrayRect.getBoolean(R.styleable.RectProBarView_IsHorizontal,true);
        mRadius=typedArrayRect.getDimension(R.styleable.RectProBarView_Radius,0);
        reverse=typedArray.getBoolean(R.styleable.ProBarView_Reverse,false);
        proPaint.setColor(proColor);
        fillPaint.setColor(fillColor);
        strokePaint.setColor(strokeColor);
        proPaint.setStyle(Paint.Style.FILL);
        fillPaint.setStyle(Paint.Style.FILL);
        strokePaint.setStyle(Paint.Style.FILL);
        strokePaint.setStrokeWidth(strokeWidth);
        typedArray.recycle();
        typedArrayRect.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mWidthSize=MeasureSpec.getSize(widthMeasureSpec);
        int mWidthMode=MeasureSpec.getMode(widthMeasureSpec);
        int mHeightSize=MeasureSpec.getSize(heightMeasureSpec);
        int mHeightMode=MeasureSpec.getMode(heightMeasureSpec);
        if(mWidthMode==MeasureSpec.AT_MOST||mWidthMode==MeasureSpec.EXACTLY){
            mWidth=mWidthSize;
        }else{
            mWidth=0;
        }

        if(mHeightMode==MeasureSpec.AT_MOST||mHeightMode==MeasureSpec.EXACTLY){
            mHeight=mHeightSize;
        }else{
            mHeight=0;
        }
        setMeasuredDimension(mWidth,mHeight);

        if(strokePaint.getStrokeWidth()==0){
            backRect=new RectF(0,0,mWidth,mHeight);
            proRect=new RectF(0,0,mWidth,mHeight);
        }else{
            backRect=new RectF(0+mRadius,0+mRadius,mWidth-mRadius,mHeight-mRadius);
            proRect=new RectF(0+mRadius,0+mRadius,mWidth-mRadius,mHeight-mRadius);
        }
        strokeRect=new RectF(0,0,mWidth,mHeight);

    }

    public void setProgress(float progress){
        if(progress<0){
            this.progress=0;
        }
        if (progress>maxProgress){
            this.progress=maxProgress;
        }else{
            this.progress=progress;
        }
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(strokePaint.getStrokeWidth()!=0){
            canvas.drawRoundRect(strokeRect,mRadius,mRadius,strokePaint);
        }
        if(isHorizontal){
            float proRadius=mRadius*((mHeight-2*mRadius)/mHeight);
            canvas.drawRoundRect(backRect,proRadius,proRadius,fillPaint);
            if (reverse){
                proRect.left=(maxProgress-progress)/maxProgress*(mWidth-2*mRadius)+mRadius;
            }else{
                proRect.right=progress/maxProgress*(mWidth-2*mRadius)+mRadius;
            }
            canvas.drawRoundRect(proRect,proRadius,proRadius,proPaint);
        }else{
            float proRadius=mRadius*((mWidth-2*mRadius)/mWidth);
            canvas.drawRoundRect(backRect,proRadius,proRadius,fillPaint);
            if (reverse){
                proRect.bottom=(progress)/maxProgress*(mHeight-2*mRadius)+mRadius;
            }else{
                proRect.top=(maxProgress-progress)/maxProgress*(mHeight-2*mRadius)+mRadius;
            }
            canvas.drawRoundRect(proRect,proRadius,proRadius,proPaint);
        }

    }
}

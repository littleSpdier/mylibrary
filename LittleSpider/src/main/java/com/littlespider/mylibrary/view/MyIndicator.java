package com.littlespider.mylibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @description :Viewpage指示器
 * @create ： wang on 2017/7/10.
 */
public class MyIndicator extends View {

    private static final int RADIUS = 3;
    private static final float PADDING = 15;
    private int mPosition;
    private int mDisWidth;
    private Paint p;
    private int mInitX = 0;
    private float density;
    private int count;

    private Context context;
    private int colorNormal;
    private int colorPressed;

    public MyIndicator(Context context) {
        super(context);
        initView(context);
    }


    public MyIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    public MyIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        this.context = context;
        density = context.getResources().getDisplayMetrics().density;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, (int) (RADIUS * density) * 2);
        lp.gravity = Gravity.CENTER;
        mDisWidth = context.getResources().getDisplayMetrics().widthPixels;
        this.setLayoutParams(lp);
    }

    /**
     * 初始化指示器控件
     * 在初始化控件时调用
     * @param count viewPager的总页数
     */
    public void initCount(int count){
        this.count = count;
        mInitX = (mDisWidth - (count - 1) * (int) (density * PADDING)) / 2;
        invalidate();
    }

    /**
     * 设置指示器需要显示位置
     *
     * @param position indicator需要显示的位置
     */
    public void setPos(int position) {
        this.mPosition = position;
        invalidate();
    }

    /**
     * 设置指示器的颜色
     *
     * @param colorNormal  背景颜色
     * @param colorPressed 当前颜色
     */
    public void setColor(int colorNormal, int colorPressed) {
        this.colorNormal = colorNormal;
        this.colorPressed = colorPressed;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p = new Paint();
        for (int i = 0; i < count; i++) {
            if (i == mPosition) {
                if (colorPressed != 0) {
                    p.setColor(colorPressed);
                } else {
                    p.setColor(Color.WHITE);
                }
                canvas.drawCircle(i * (int) (density * PADDING) + mInitX,
                        (int) (RADIUS * density), (int) (RADIUS * density), p);
            } else {
                if (colorNormal != 0) {
                    p.setColor(colorNormal);
                } else {
                    p.setColor(Color.GRAY);
                }
                canvas.drawCircle(i * (int) (density * PADDING) + mInitX,
                        (int) (RADIUS * density), (int) (RADIUS * density), p);
            }
        }
    }
}
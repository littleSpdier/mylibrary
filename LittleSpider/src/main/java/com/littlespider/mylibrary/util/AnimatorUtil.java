package com.littlespider.mylibrary.util;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 控制view的动画效果
 * Created by abc on 2016/12/27.
 * @author littleSpider
 */
public class AnimatorUtil {

    //使图片向下旋转
    public static void rotation(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",180f);
        animator.setDuration(300)
                .start();
    }

    public static void rotation(View view,int time){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",180f);
        animator.setDuration(time)
                .start();
    }

    //使图片回复到先前状态的动画
    public static void rotationRegain(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0f);
        animator.setDuration(300)
                .start();
    }

    public static void rotationRegain(View view,int time){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0f);
        animator.setDuration(time)
                .start();
    }

    public void viewDown(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", 0f, 2000f);
        animator.setDuration(500);
        animator.start();
    }

    public void viewTranslationYRegain(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", 0f);
        animator.setDuration(500);
        animator.start();
    }

    public void viewInit(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", 0f,2000f);
        animator.setDuration(0);
        animator.start();
    }
}

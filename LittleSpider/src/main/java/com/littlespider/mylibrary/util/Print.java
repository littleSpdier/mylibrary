package com.littlespider.mylibrary.util;

import android.util.Log;

/**
 * Created by abc on 2017/9/5.
 */

public class Print {

    private static boolean isNeedPrint = true;

    public static void i(String textContent){
        if (isNeedPrint){
            Log.i("littleKiss", textContent);
        }
    }
}

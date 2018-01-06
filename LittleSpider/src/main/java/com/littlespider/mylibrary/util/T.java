package com.littlespider.mylibrary.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by littleSpider on 2017/12/13.
 */

public class T {

    private static Toast toast;

    public static void show(Context context, String toastContent){
        if (toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(context, toastContent, Toast.LENGTH_SHORT);
        toast.show();
    }

}

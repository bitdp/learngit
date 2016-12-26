package com.example.commonlibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by dongpeng on 2016/12/26.
 */

public class ToastUtil {
    public static void show(Context context,String str){
        Toast.makeText(context, str,Toast.LENGTH_SHORT).show();
    }
}

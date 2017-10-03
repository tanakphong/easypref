package com.wesoft.easypref.Class;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


/**
 * Created by USER275 on 9/6/2017.
 */

public  class Utils {
    public static void ShowToast(Context context,String content){
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}

package com.zhoug.widget.module.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zhoug.android.common.utils.ActivityUtils;

/**
 * @Author HK-LJJ
 * @Date 2019/9/20
 * @Description TODO
 */
public class BaseActivity extends AppCompatActivity {

    protected void toast(String msg){
         Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void toActivity(Class cls){
        ActivityUtils.startActivity(this,cls );
    }

}

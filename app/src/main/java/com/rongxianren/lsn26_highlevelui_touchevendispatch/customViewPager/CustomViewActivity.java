package com.rongxianren.lsn26_highlevelui_touchevendispatch.customViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.rongxianren.lsn26_highlevelui_touchevendispatch.R;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        System.out.println("------onTouchEvent-----CustomViewActivity-----" + event.getAction());
        return true;
    }
}

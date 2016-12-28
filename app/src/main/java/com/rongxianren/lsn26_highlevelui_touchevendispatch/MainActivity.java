package com.rongxianren.lsn26_highlevelui_touchevendispatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rongxianren.lsn26_highlevelui_touchevendispatch.customViewPager.CustomViewActivity;
import com.rongxianren.lsn26_highlevelui_touchevendispatch.evendispatch.TouchEventDispatchActivity;
import com.rongxianren.lsn26_highlevelui_touchevendispatch.scroll_test.ScrollTestActivity;
import com.rongxianren.lsn26_highlevelui_touchevendispatch.touchEventConflict.TouchEventConflictActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void touchEventDispatch(View view) {
        Intent intent = new Intent(this, TouchEventDispatchActivity.class);
        startActivity(intent);
    }

    public void touchEventConflict(View view) {
        Intent intent = new Intent(this, TouchEventConflictActivity.class);
        startActivity(intent);
    }

    public void customViewPager(View view) {
        Intent intent = new Intent(this, CustomViewActivity.class);
        startActivity(intent);
    }

    public void scrollTest(View view) {
        Intent intent = new Intent(this, ScrollTestActivity.class);
        startActivity(intent);
    }
}

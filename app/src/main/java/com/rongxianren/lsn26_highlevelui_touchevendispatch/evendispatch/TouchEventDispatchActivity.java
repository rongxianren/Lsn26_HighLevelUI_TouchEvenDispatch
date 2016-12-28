package com.rongxianren.lsn26_highlevelui_touchevendispatch.evendispatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.rongxianren.lsn26_highlevelui_touchevendispatch.R;

public class TouchEventDispatchActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {


    private RelativeLayout relativeLayout;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event_dispatch);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_touch_event_dispatch);
        btn = (Button) findViewById(R.id.my_button);
        relativeLayout.setOnTouchListener(this);
        btn.setOnTouchListener(this);

        relativeLayout.setOnClickListener(this);
        btn.setOnClickListener(this);


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        System.out.println("-------onTouch-------view = " + view.getClass().getSimpleName() + "-----event---- = " + motionEvent.getAction());
        return true;
    }

    @Override
    public void onClick(View v) {
        System.out.println("-------onClick-------view = " + v.getClass().getSimpleName());
    }

}

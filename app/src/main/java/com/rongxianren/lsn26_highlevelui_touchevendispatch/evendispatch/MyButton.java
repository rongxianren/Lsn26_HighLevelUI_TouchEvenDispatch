package com.rongxianren.lsn26_highlevelui_touchevendispatch.evendispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by wty on 2016/12/22.
 */

public class MyButton extends Button {
    public MyButton(Context context) {
        this(context, null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        System.out.println("------onTouchEvent-------view = " + this.getClass().getSimpleName() + " ------event------ = " + event.getAction());
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                return true;
            case MotionEvent.ACTION_UP:
                return true;
        }
        return true;

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        System.out.println("------dispatchTouchEvent-------view = " + this.getClass().getSimpleName() + " ------event------ = " + event.getAction());
        super.dispatchTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                return true;
            case MotionEvent.ACTION_UP:
                return true;
        }

        return true;
    }
}

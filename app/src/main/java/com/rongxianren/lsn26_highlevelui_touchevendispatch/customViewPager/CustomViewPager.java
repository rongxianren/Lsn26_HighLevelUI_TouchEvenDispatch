package com.rongxianren.lsn26_highlevelui_touchevendispatch.customViewPager;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;

/**
 * Created by wty on 2016/12/27.
 */

public class CustomViewPager extends ViewGroup {
    public CustomViewPager(Context context) {
        this(context, null);
    }

    private int mTouchSlop;
    private float downX;
    private float moveX;
    private float lastMoveX;
    private int leftBound;
    private int rightBound;
    private String TAG = "Ray";

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewPager(context);
    }

    private void initViewPager(Context context) {
        final ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
        this.setClickable(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = getChildCount();
        for (int i = 0; i < size; ++i) {
            final View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int size = getChildCount();
            for (int i = 0; i < size; ++i) {
                final View child = getChildAt(i);
                child.layout(i * child.getMeasuredWidth(), 0, (i + 1) * child.getMeasuredWidth(), child.getMeasuredHeight());
                child.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "------点我干嘛----？？", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        //×ó±ß½ç
        leftBound = getChildAt(0).getLeft();
        //ÓÒ±ß½ç
        rightBound = getChildAt(getChildCount() - 1).getRight();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("ray", "-----------onIntercept-----------" + ev.getAction());
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = ev.getRawX();
                lastMoveX = downX;
                return false;
            case MotionEvent.ACTION_MOVE:
                moveX = ev.getRawX();
                float xDiff = Math.abs(moveX - downX);
                lastMoveX = moveX;
                Log.i(TAG, "moveX:" + moveX + ", xDiff:" + xDiff + ", mTouchSlop:" + mTouchSlop);
                if (xDiff > mTouchSlop) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                return false;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "-------------onTouchEvent------------- = " + event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                moveX = event.getRawX();
                int scrollDx = (int) (lastMoveX - moveX);
//                Log.i(TAG, "~~~~moveX:" + moveX + ", scrollDx:" + scrollDx + ", lastMoveX:" + lastMoveX + ", leftBound" + leftBound);
                if (getScrollX() + scrollDx < leftBound) {
                    scrollTo(leftBound, 0);
                    return true;
                } else if (getScrollX() + scrollDx + getWidth() > rightBound) {
                    scrollTo(rightBound - getWidth(), 0);
                    return true;
                }
                scrollBy(scrollDx, 0);
                lastMoveX = moveX;
                break;
            case MotionEvent.ACTION_UP:

                break;

            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}

package com.rongxianren.lsn26_highlevelui_touchevendispatch.touchEventConflict;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by wty on 2016/12/27.
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        this(context, null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}

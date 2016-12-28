package com.rongxianren.lsn26_highlevelui_touchevendispatch.scroll_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rongxianren.lsn26_highlevelui_touchevendispatch.R;

public class ScrollTestActivity extends AppCompatActivity implements View.OnClickListener {


//    private View imageView_1;
//    private View imageView_2;
//
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scroll_test);
//
//        imageView_1 = findViewById(R.id.image1);
//        imageView_2 = findViewById(R.id.image2);
//
//    }
//
//
//    public void sroll_by(View view) {
//        imageView_2.scrollBy(0 - 50, 0 - 50);
//    }
//
//
//    public void sroll_to(View view) {
//        imageView_1.scrollTo(0 - 50, 0 - 50);
//    }

    private TextView tv_hi;
    private ImageView img_icon;
    private Button btn_scrollTo;
    private Button btn_scrollBy;
    private Button btn_reset;
    ScrollView mScrollView;
    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_test);
        initView();
    }

    private void initView() {
        tv_hi = (TextView) findViewById(R.id.tv_hi);
        img_icon = (ImageView) findViewById(R.id.img_icon);
        mScrollView = (ScrollView) findViewById(R.id.mScrollView);
        btn_scrollTo = (Button) findViewById(R.id.btn_scrollTo);
        btn_scrollBy = (Button) findViewById(R.id.btn_scrollBy);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_scrollTo.setOnClickListener(this);
        btn_scrollBy.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
        root = (LinearLayout) findViewById(R.id.root);

    }

    @Override
    public void onClick(View v) {


        System.out.println("---------mScrollView.getScrollX()--------- = " + mScrollView.getScrollX());
        System.out.println("---------mScrollView.getScrollY()--------- = " + mScrollView.getScrollY());

        System.out.println("---------tv_hi.getScrollX()--------- = " + tv_hi.getScrollX());
        System.out.println("---------tv_hi.getScrollY()--------- = " + tv_hi.getScrollY());

        System.out.println("---------img_icon.getScrollX()--------- = " + img_icon.getScrollX());
        System.out.println("---------img_icon.getScrollY()--------- = " + img_icon.getScrollY());
        switch (v.getId()) {
            case R.id.btn_scrollTo:
                img_icon.scrollTo(-10, -10);
                tv_hi.scrollTo(-10, -10);
                mScrollView.scrollTo();
                root.scrollTo(-10, -10);
                break;
            case R.id.btn_scrollBy:
                img_icon.scrollBy(-10, -10);
                tv_hi.scrollBy(-10, -10);
                mScrollView.scrollBy();
                root.scrollBy(0, -10);
                break;
            case R.id.btn_reset:
                img_icon.scrollTo(0, 0);
                tv_hi.scrollTo(0, 0);
                mScrollView.reset();
                root.scrollTo(0, 0);
                break;
            default:
                break;
        }
    }
}

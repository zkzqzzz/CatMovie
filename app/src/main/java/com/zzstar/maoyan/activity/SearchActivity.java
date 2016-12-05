package com.zzstar.maoyan.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.utils.DisplayUtil;
import com.zzstar.maoyan.view.FlowLayout;

public class SearchActivity extends Activity {
    private TextView et_search;
    private TextView quxiao;


    private FlowLayout flowLayout;
    private String[] datas = new String[]{"魔兽", "佩小姐的奇幻城堡", "愤怒的小鸟", "你的名字", "我不是潘金莲", "银河护卫队"};
    private TextView tv;

    public static GradientDrawable getDrawable(int rgb, float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(rgb);//设置颜色
        gradientDrawable.setGradientType(GradientDrawable.RECTANGLE);//设置显示的样式
        gradientDrawable.setCornerRadius(radius);//设置圆角的半径
        gradientDrawable.setStroke(3, rgb);//描边
        return gradientDrawable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        et_search = (TextView) findViewById(R.id.et_search);
        quxiao = (TextView) findViewById(R.id.quxiao);
        flowLayout = (FlowLayout) findViewById(R.id.flow_layout);
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();

    }

    private void initData() {

        for (int i = 0; i < datas.length; i++) {
            tv = new TextView(this);
            tv.setText(datas[i]);
            tv.setTextColor(Color.GRAY);
            //提供边距的对象，并设置到textView中
            ViewGroup.MarginLayoutParams mp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mp.leftMargin = DisplayUtil.dip2px(this, 4);
            mp.rightMargin = DisplayUtil.dip2px(this, 4);
            mp.topMargin = DisplayUtil.dip2px(this, 4);
            mp.bottomMargin = DisplayUtil.dip2px(this, 4);
            tv.setLayoutParams(mp);


            int red = 230;
            int green = 230;
            int blue = 230;
            tv.setBackground(getDrawable(Color.rgb(red, green, blue), DisplayUtil.dip2px(this, 1)));
            int padding = DisplayUtil.dip2px(this, 5);
            tv.setPadding(padding, padding, padding, padding);
            flowLayout.addView(tv);
        }

    }


}

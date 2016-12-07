package com.zzstar.maoyan.activity.shopapp;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.adapter.FenLeiGridAdapter;
import com.zzstar.maoyan.bean.ShumaBean;
import com.zzstar.maoyan.utils.DisplayUtil;

import okhttp3.Call;

public class FenLeiActivity extends Activity {
    private LinearLayout xi_lie;
    private LinearLayout gao_wan;
    private LinearLayout pai_xu;
    private PopupWindow popupWindow;
    private TextView fenlei_black;
    private GridView fenlei_gridview;
    private ShumaBean shumaBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);
        xi_lie = (LinearLayout) findViewById(R.id.xi_lie);
        gao_wan = (LinearLayout) findViewById(R.id.gao_wan);
        pai_xu = (LinearLayout) findViewById(R.id.pai_xu);
        fenlei_black = (TextView) findViewById(R.id.fenlei_black);
        fenlei_gridview = (GridView) findViewById(R.id.fenlei_gridview);
        View view = View.inflate(FenLeiActivity.this, R.layout.pop_xilie, null);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(FenLeiActivity.this, 200), true);
        popupWindow.setTouchable(true);
        ColorDrawable colorDrawable = new ColorDrawable(0x000000);
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setOutsideTouchable(true);
        initListener();
        initData();
    }

    private void initListener() {
        fenlei_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xi_lie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow.showAsDropDown(v);
                }
            }
        });
    }

    private void initData() {
        String shuma = getIntent().getStringExtra("shuma");
        OkHttpUtils.get().url(shuma).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                shumaBean = JSON.parseObject(response, ShumaBean.class);
                FenLeiGridAdapter adapter = new FenLeiGridAdapter(FenLeiActivity.this, shumaBean);
                fenlei_gridview.setAdapter(adapter);

            }
        });

    }
}

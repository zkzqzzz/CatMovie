package com.zzstar.maoyan.adapter;

import android.app.Activity;
import android.os.Bundle;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;

import okhttp3.Call;

public class FenLeiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);

        initData();
    }

    private void initData() {

        String shuma = getIntent().getStringExtra("shuma");
        OkHttpUtils.get().url(shuma).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {


            }
        });

    }
}

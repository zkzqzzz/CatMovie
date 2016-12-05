package com.zzstar.maoyan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.adapter.ShapAdapter;
import com.zzstar.maoyan.utils.Constants;

import okhttp3.Call;

public class ShopActivity extends Activity {
    private ImageView back;
    private RecyclerView recycle_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        back = (ImageView) findViewById(R.id.back);
        recycle_shop = (RecyclerView) findViewById(R.id.recycle_shop);
        initData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycle_shop.setLayoutManager(manager);
        recycle_shop.setAdapter(new ShapAdapter(this));
    }

    private void initData() {
        OkHttpUtils.get().url(Constants.SHOPVIEWPAGER).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {


            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);


            }

            private void processData(String response) {


            }
        });


    }
}

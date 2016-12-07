package com.zzstar.maoyan.activity.shopapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.adapter.ShopAdapter;
import com.zzstar.maoyan.bean.ShopLikeBean;
import com.zzstar.maoyan.utils.Constants;
import com.zzstar.maoyan.utils.DisplayUtil;

import okhttp3.Call;

public class ShopActivity extends Activity {
    private ImageView back;
    private RecyclerView recycle_shop;
    private ShopLikeBean shopLikeBean;
    private LinearLayout ll_title_shop;
    private int mDistanceY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        back = (ImageView) findViewById(R.id.back);
        recycle_shop = (RecyclerView) findViewById(R.id.recycle_shop);
        ll_title_shop = (LinearLayout) findViewById(R.id.ll_title_shop);
        initData();
        initListener();
        GridLayoutManager manager = new GridLayoutManager(ShopActivity.this, 2, LinearLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recycle_shop.setLayoutManager(manager);
    }

    private void initListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recycle_shop.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mDistanceY += dy;
                if (mDistanceY <= DisplayUtil.dip2px(ShopActivity.this, 175)) {
                    float scale = (float) mDistanceY / DisplayUtil.dip2px(ShopActivity.this, 175);
                    float alpha = scale * 255;
                    ll_title_shop.setBackgroundColor(Color.argb((int) alpha, 255, 0, 0));
                } else {
                    ll_title_shop.setBackgroundColor(Color.argb(255, 255, 0, 0));
                }

            }
        });
    }

    private void initData() {
        OkHttpUtils.get().url(Constants.YOUMAYLIKE).id(100).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                shopLikeBean = JSON.parseObject(response, ShopLikeBean.class);
                recycle_shop.setAdapter(new ShopAdapter(ShopActivity.this, shopLikeBean));
            }
        });
    }
}

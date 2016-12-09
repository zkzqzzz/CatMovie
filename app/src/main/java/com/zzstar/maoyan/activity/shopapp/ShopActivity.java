package com.zzstar.maoyan.activity.shopapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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


        if (Build.VERSION.SDK_INT > 21) {
            Log.e("TAG", Build.VERSION.SDK_INT + "rr");

            Window window = this.getWindow();
//取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置状态栏颜色
            window.setStatusBarColor(Color.parseColor("#832522"));

            ViewGroup mContentView = (ViewGroup) this.findViewById(Window.ID_ANDROID_CONTENT);
            View mChildView = mContentView.getChildAt(0);
            if (mChildView != null) {
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
                ViewCompat.setFitsSystemWindows(mChildView, true);
            }
        }



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

package com.zzstar.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.bean.FirstAdvertise;
import com.zzstar.maoyan.utils.Constants;
import com.zzstar.maoyan.utils.NetworkUtil;

import okhttp3.Call;

public class SplashActivity extends Activity {
    ImageView cover;
    ImageView advertise;
    private FirstAdvertise firstAdvertise;
    private FirstAdvertise.PostersBean postersBean;
    private int duringTime;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    gotoMainActivity();
                    finish();
                    break;
                case 1:
                    advertise.setVisibility(View.VISIBLE);
                    cover.setVisibility(View.GONE);
                    handler.sendEmptyMessageDelayed(0,duringTime) ;

                    break;


            }
        }
    };

    private void gotoMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cover = (ImageView) findViewById(R.id.cover);
        advertise= (ImageView) findViewById(R.id.advertise);
        showCover();
        checkInfo();
    }


    public void checkInfo() {
        if (NetworkUtil.isConnected(this)) {
            OkHttpUtils
                    .get()
                    .url(Constants.FIRST_ADVERTISE)
                    .id(100)
                    .build()
                    .execute(new MyStringCallback());


        } else {
            return;
        }
    }

    private void showCover() {
        handler.sendEmptyMessageDelayed(0, 4000);

    }

    private void processData(String response) {
        firstAdvertise = JSON.parseObject(response, FirstAdvertise.class);
        //    showAdvertise();
    }

    private void showAdvertise() {

        postersBean = firstAdvertise.getPosters().get(0);
        Picasso.with(this).load(postersBean.getPic()).into(advertise);
        duringTime = postersBean.getDuration();
        handler.removeMessages(0);
        handler.sendEmptyMessageDelayed(1, 2000);


    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeMessages(0);

    }

    private class MyStringCallback extends StringCallback {


        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            switch (id) {
                case 100:
                    if (response != null) {
                        processData(response);

                    }
                    break;
                case 101:
                    Toast.makeText(SplashActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }
}


package com.zzstar.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
    ImageView cover_advertise;
    private FirstAdvertise firstAdvertise;
    private FirstAdvertise.PostersBean postersBean;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    gotoMainActivity();
                    finish();
                    break;
                case 1:
                    if (isConnected) {
                        showAdvertise();
                    }
                    break;

            }
        }
    };
    private boolean isConnected = false;

    private void gotoMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cover_advertise = (ImageView) findViewById(R.id.cover_advertise);
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

            isConnected = true;
        } else {
            isConnected = false;
        }
    }

    private void showCover() {
        cover_advertise.setImageResource(R.drawable.splash);
        handler.sendEmptyMessageDelayed(1, 1000);

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

    private void processData(String response) {
        firstAdvertise = JSON.parseObject(response, FirstAdvertise.class);

    }

    private void showAdvertise() {
        postersBean = firstAdvertise.getPosters().get(0);
        Picasso.with(this).load(postersBean.getPic()).into(cover_advertise);
        int duringTime = postersBean.getDuration();
        handler.sendEmptyMessageDelayed(0, duringTime);


    }
}


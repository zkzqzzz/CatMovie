package com.zzstar.maoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.bean.ShopBean;
import com.zzstar.maoyan.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by zzstar on 2016/12/5.
 */
public class ShapAdapter extends RecyclerView.Adapter {

    private Context context;

    public ShapAdapter(Context context) {
        this.context = context;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.banner_shop, null);
            return new BannerHolder(view);
        }
        //else if (viewType == 1) {
        View view = LayoutInflater.from(context).inflate(R.layout.chanl_shop, parent, false);
        return new ChanlHolder(view);
        // }else if(){

        //  }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    private class BannerHolder extends RecyclerView.ViewHolder {

        private Banner banner;
        private ShopBean shopBean;

        public BannerHolder(View view) {
            super(view);
            banner = (Banner) view.findViewById(R.id.banner_shop);
            initData();
        }

        private void initData() {


            OkHttpUtils.get().url(Constants.SHOPVIEWPAGER).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                }

                @Override
                public void onResponse(String response, int id) {
                    shopBean = JSON.parseObject(response, ShopBean.class);
                    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                    //设置图片加载器
                    banner.setImageLoader(new GlideImageLoader());
                    int imagesSize = shopBean.getData().size();
                    List<String> imageUrl = new ArrayList<String>(imagesSize);
                    for (int i = 0; i < imagesSize; i++) {
                        imageUrl.add(shopBean.getData().get(i).getImgUrl());
                    }
                    //设置图片集合
                    banner.setImages(imageUrl);
                    //设置banner动画效果
                    // banner.setBannerAnimation(Transformer.DepthPage);
                    //设置自动轮播，默认为true
                    banner.isAutoPlay(true);
                    //设置轮播时间
                    banner.setDelayTime(1500);
                    banner.setBannerStyle(Banner.SCROLLBAR_POSITION_DEFAULT);
                    //设置指示器位置（当banner模式中有指示器时）
                    // banner.setIndicatorGravity(BannerConfig.CENTER);
                    //banner设置方法全部调用完毕时最后调用
                    banner.start();
                }
            });
        }

        private class GlideImageLoader extends ImageLoader {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(context).load((String) path).into(imageView);
            }
        }
    }

    private class ChanlHolder extends RecyclerView.ViewHolder {

        private TextView shuma;

        public ChanlHolder(View view) {
            super(view);
            shuma = (TextView) view.findViewById(R.id.shuma);

            shuma.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FenLeiActivity.class);
                    intent.putExtra("shuma", Constants.SHUMA);
                    context.startActivity(intent);

                }
            });

        }
    }
}

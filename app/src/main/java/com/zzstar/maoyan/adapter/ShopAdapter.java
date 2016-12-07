package com.zzstar.maoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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
import com.zzstar.maoyan.activity.shopapp.FenLeiActivity;
import com.zzstar.maoyan.bean.ShopBean;
import com.zzstar.maoyan.bean.ShopLikeBean;
import com.zzstar.maoyan.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by zzstar on 2016/12/5.
 */
public class ShopAdapter extends RecyclerView.Adapter {

    private Context context;
    private ShopLikeBean shopLikeBean;

    public ShopAdapter(Context context, ShopLikeBean shopLikeBean) {
        this.context = context;
        this.shopLikeBean = shopLikeBean;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.banner_shop, null);
            return new BannerHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.chanl_shop, parent, false);
            return new ChanlHolder(view);
        } else {
            View view = View.inflate(context, R.layout.shop_grid_view, null);
            return new MayLikeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (getItemViewType(position) == 2) {
            ShopLikeBean.DataBean.ListBean listBean = shopLikeBean.getData().getList().get(position - 2);

            MayLikeViewHolder mayLikeViewHolder = (MayLikeViewHolder) holder;
            Picasso.with(context).load(listBean.getPic()).into(mayLikeViewHolder.iv_shop_gridview);
            mayLikeViewHolder.name.setText(listBean.getTitle());
            mayLikeViewHolder.price.setText(listBean.getPrice() + "");
            mayLikeViewHolder.old_price.setText(listBean.getValue() + "元");
            mayLikeViewHolder.old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

    }

    @Override
    public int getItemCount() {
        return shopLikeBean.getData().getList().size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
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
                    banner.setImageLoader(new GlideImageLoader());
                    int imagesSize = shopBean.getData().size();
                    List<String> imageUrl = new ArrayList<String>(imagesSize);
                    for (int i = 0; i < imagesSize; i++) {
                        imageUrl.add(shopBean.getData().get(i).getImgUrl());
                    }
                    banner.setImages(imageUrl);
                    banner.isAutoPlay(true);
                    banner.setDelayTime(1500);
                    banner.setBannerStyle(Banner.SCROLLBAR_POSITION_DEFAULT);
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

    private class MayLikeViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_shop_gridview;
        private TextView name;
        private TextView price;
        private TextView old_price;

        public MayLikeViewHolder(View view) {
            super(view);
            iv_shop_gridview = (ImageView) view.findViewById(R.id.iv_shop_gridview);
            price = (TextView) view.findViewById(R.id.price);
            name = (TextView) view.findViewById(R.id.name);
            old_price = (TextView) view.findViewById(R.id.old_price);


        }
    }
}

package com.zzstar.maoyan.movie.view.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.adapter.MyListViewAdapter;
import com.zzstar.maoyan.movie.bean.ListViewBean;
import com.zzstar.maoyan.movie.bean.ViewPagerBean;
import com.zzstar.maoyan.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by zzstar on 2016/11/30.
 */
public class FirstFragment extends BaseFragment {
    private ListView lv_first;
    private Banner banner;
    private ViewPagerBean viewPagerBean;
    private ListViewBean listViewBean;
    private MaterialRefreshLayout materialRefreshLayout;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_first, null);
        lv_first = (ListView) view.findViewById(R.id.lv_first);
        materialRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        View headview = View.inflate(context, R.layout.page1_view, null);
        banner = (Banner) headview.findViewById(R.id.banner);
        lv_first.addHeaderView(headview);
      materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
          @Override
          public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
              initData();
              Toast.makeText(context, "加载更多", Toast.LENGTH_SHORT).show();
          }
      });


        return view;
    }

    @Override
    public void initData() {
        initListData();
        OkHttpUtils
                .get()
                .url(Constants.MOVIEFIRSTBANNER)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    private void initListData() {
        OkHttpUtils
                .get()
                .url(Constants.LISTDATA)
                .id(100)
                .build()
                .execute(new MyListStringCallback());


    }

    private class MyStringCallback extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            materialRefreshLayout.finishRefresh();
            switch (id) {
                case 100:
                    if (response != null) {
                        processData(response);
                        initBanner();

                    }
                    break;
                case 101:
                    Toast.makeText(context, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private void initBanner() {


        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        int imagesSize = viewPagerBean.getData().size();
        List<String> imageUrl = new ArrayList<String>(imagesSize);
        for (int i = 0; i < imagesSize; i++) {
            imageUrl.add(viewPagerBean.getData().get(i).getImgUrl());
        }
        //设置图片集合
        banner.setImages(imageUrl);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void processData(String response) {
        viewPagerBean = JSON.parseObject(response, ViewPagerBean.class);

    }

    private class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context).load((String) path).into(imageView);
        }
    }


    private class MyListStringCallback extends StringCallback {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {

            processListData(response);
            MyListViewAdapter adapter = new MyListViewAdapter(context, listViewBean);
            lv_first.setAdapter(adapter);

        }
    }

    private void processListData(String json) {

        listViewBean = JSON.parseObject(json, ListViewBean.class);

    }
}

package com.zzstar.maoyan.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.activity.MainActivity;
import com.zzstar.maoyan.activity.SearchActivity;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.MovieFragment;
import com.zzstar.maoyan.movie.adapter.MyListViewAdapter;
import com.zzstar.maoyan.movie.bean.ListViewBean;
import com.zzstar.maoyan.movie.bean.ViewPagerBean;
import com.zzstar.maoyan.utils.Constants;
import com.zzstar.maoyan.utils.DisplayUtil;

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
    private TextView et_search;
    private LinearLayout ll_pr;


    @Override
    public View initView() {

        View view = View.inflate(context, R.layout.fragment_first, null);

        View headview2 = View.inflate(context, R.layout.movie_fragment_title, null);
        View headview = View.inflate(context, R.layout.page1_view, null);
        lv_first = (ListView) view.findViewById(R.id.lv_first);
        materialRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        et_search = (TextView) headview2.findViewById(R.id.et_search);
        ll_pr = (LinearLayout) view.findViewById(R.id.ll_pr);
        banner = (Banner) headview.findViewById(R.id.banner);
        lv_first.addHeaderView(headview2);
        lv_first.addHeaderView(headview);
        initListener();
        return view;
    }

    private void initListener() {
        et_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity(intent);

            }
        });

        lv_first.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    position = 0;
                } else if (position == 3) {
                    return;
                } else {
                    position = position - 2;
                }
                Intent intent = new Intent(context, WebViewActivity.class);
                String data = " http://m.maoyan.com/movie/" + listViewBean.getData().getMovies().get(position).getId() + "?_v_=1111";
                intent.putExtra("url", data);
                context.startActivity(intent);
            }
        });

        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                initData();
            }
        });

        lv_first.setOnScrollListener(new AbsListView.OnScrollListener() {
            int height = DisplayUtil.dip2px(context, 40);
            int change = DisplayUtil.dip2px(context, 40);
            int change2 = DisplayUtil.dip2px(context, 70);
            int left = DisplayUtil.dip2px(context, 110);
            int top = DisplayUtil.dip2px(context, 11);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtil.dip2px(context, 30), DisplayUtil.dip2px(context, 30));
            Fragment movieFragmentTag = ((MainActivity) context).getSupportFragmentManager().findFragmentByTag("movieFragmentTag");

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem == 0) {
                    int scrollY = getScrollY();
                    if (0 <= scrollY && scrollY < height) {
                        ((MovieFragment) movieFragmentTag).search.setClickable(false);
                        layoutParams.setMargins((int) (left - (scrollY / (height + 0.01) * change2)), top, 0, 0);
                        ((MovieFragment) movieFragmentTag).search.setLayoutParams(layoutParams);
                        ((MovieFragment) movieFragmentTag).search.getBackground().setAlpha((int) (scrollY / (height + 0.01) * 255));
                    }
                } else {
                    ((MovieFragment) movieFragmentTag).search.setClickable(true);

                    layoutParams.setMargins(change, top, 0, 0);
                    ((MovieFragment) movieFragmentTag).search.setLayoutParams(layoutParams);
                    ((MovieFragment) movieFragmentTag).search.getBackground().setAlpha(255);

                }
            }
        });

    }


    public int getScrollY() {
        View c = lv_first.getChildAt(0);
        if (c == null) {
            return 0;
        }
        int top = c.getTop();
        return -top;
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

    private void initBanner() {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        int imagesSize = viewPagerBean.getData().size();
        List<String> imageUrl = new ArrayList<String>(imagesSize);
        for (int i = 0; i < imagesSize; i++) {
            imageUrl.add(viewPagerBean.getData().get(i).getImgUrl());
        }
        banner.setImages(imageUrl);
        banner.isAutoPlay(true);
        banner.setDelayTime(1500);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();


    }

    private void processData(String response) {
        viewPagerBean = JSON.parseObject(response, ViewPagerBean.class);

    }

    private void processListData(String json) {

        listViewBean = JSON.parseObject(json, ListViewBean.class);

    }
    private class MyStringCallback extends StringCallback {
        @Override
        public void onError(Call call, Exception e, int i) {
            materialRefreshLayout.finishRefresh();
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
            ll_pr.setVisibility(View.GONE);
        }
    }


}

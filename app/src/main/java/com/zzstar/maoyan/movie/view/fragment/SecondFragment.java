package com.zzstar.maoyan.movie.view.fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.adapter.MyRecyclerViewAdapter;
import com.zzstar.maoyan.movie.bean.MovieHotBean;
import com.zzstar.maoyan.utils.Constants;

import okhttp3.Call;

/**
 * Created by zzstar on 2016/11/30.
 */
public class SecondFragment extends BaseFragment {

   private RecyclerView rc_view;
    private MovieHotBean movieHotBean;
    private View view;
    private SwipeRefreshLayout swiperefreshlayout;

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.second_fragment_hot, null);
        rc_view = (RecyclerView) view.findViewById(R.id.rc_view);
        swiperefreshlayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                initData();

            }
        });


        return view;
    }

    @Override
    public void initData() {
        OkHttpUtils
                .get()
                .url(Constants.HOTMOVIE)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    private class MyStringCallback extends StringCallback {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            swiperefreshlayout.setRefreshing(false);
            processData(response);
            MyRecyclerViewAdapter adapter= new MyRecyclerViewAdapter(context,movieHotBean);
            LinearLayoutManager manager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
            rc_view.setLayoutManager(manager);
            rc_view.setAdapter(adapter);

        }
    }

    private void processData(String response) {
        movieHotBean = JSON.parseObject(response, MovieHotBean.class);

    }
}

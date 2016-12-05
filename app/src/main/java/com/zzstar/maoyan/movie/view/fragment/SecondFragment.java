package com.zzstar.maoyan.movie.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.adapter.MyRecyclerViewAdapter;
import com.zzstar.maoyan.movie.adapter.SectionDecoration;
import com.zzstar.maoyan.movie.bean.MovieHotBean;
import com.zzstar.maoyan.utils.Constants;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * Created by zzstar on 2016/11/30.
 */
public class SecondFragment extends BaseFragment {

    private RecyclerView rc_view;
    private MovieHotBean movieHotBean;
    private View view;
    private MaterialRefreshLayout refresh;
    private SectionDecoration sectionDecoration;
    private boolean haveDirection = false;

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.second_fragment_hot, null);
        rc_view = (RecyclerView) view.findViewById(R.id.rc_view);
        refresh = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
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

    private void processData(String response) {
        movieHotBean = JSON.parseObject(response, MovieHotBean.class);

    }

    private class MyStringCallback extends StringCallback {

        int j;
        private ArrayList<String> groupFirstLine;
        private ArrayList<String> groupId;

        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {

            processData(response);
            refresh.finishRefresh();

            initItemdirectionData();

            sectionDecoration = new SectionDecoration(context, new SectionDecoration.DecorationCallback() {
                @Override
                public long getGroupId(int position) {
                    return Integer.parseInt(groupId.get(position));
                }

                @Override
                public String getGroupFirstLine(int position) {
                    return groupFirstLine.get(position);
                }
            });

            MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(context, movieHotBean);
            rc_view.setAdapter(adapter);
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            rc_view.setLayoutManager(manager);
            if (!haveDirection) {
                haveDirection = true;
                rc_view.addItemDecoration(sectionDecoration);
            }

        }

        private void initItemdirectionData() {

            groupFirstLine = new ArrayList<>();
            groupFirstLine.add("");
            groupFirstLine.add("预告片推荐");
            groupFirstLine.add("近期最受期待");
            groupFirstLine.add(movieHotBean.getData().getComing().get(0).getComingTitle());
            groupId = new ArrayList<>();
            groupId.add("-1");
            groupId.add("1");
            groupId.add("2");
            groupId.add("3");
            for (int i = 1; i < movieHotBean.getData().getComing().size(); i++) {
                String comingTitleA = movieHotBean.getData().getComing().get(i).getComingTitle();
                String comingTitleB = movieHotBean.getData().getComing().get(i - 1).getComingTitle();

                if (!comingTitleA.equals(comingTitleB)) {
                    groupFirstLine.add(comingTitleA);
                    groupId.add(3 + i + "");//4  5
                    j = 3 + i;
                } else {
                    groupFirstLine.add(comingTitleB);
                    groupId.add(j + "");
                }
            }
        }
    }
}

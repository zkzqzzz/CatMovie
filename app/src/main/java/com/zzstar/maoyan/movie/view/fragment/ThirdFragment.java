package com.zzstar.maoyan.movie.view.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.adapter.ZhaoPianAdapter;

/**
 * Created by zzstar on 2016/11/30.
 */
public class ThirdFragment extends BaseFragment {
    private RecyclerView zhaopian_main;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.zhao_pian_rc, null);
        zhaopian_main = (RecyclerView) view.findViewById(R.id.zhaopian_main);
        return view;
    }

    @Override
    public void initData() {
        ZhaoPianAdapter adapter = new ZhaoPianAdapter();

        zhaopian_main.setAdapter(adapter);
        zhaopian_main.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));



    }
}

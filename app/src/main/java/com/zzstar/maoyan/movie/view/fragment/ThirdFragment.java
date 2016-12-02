package com.zzstar.maoyan.movie.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.adapter.ZhaoPianAdapter;

/**
 * Created by zzstar on 2016/11/30.
 */
public class ThirdFragment extends BaseFragment {
    private RecyclerView zhaopian_rc;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.zhao_pian_rc, null);
        zhaopian_rc = (RecyclerView) view.findViewById(R.id.zhaopian_rc);

        return view;
    }

    @Override
    public void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        zhaopian_rc.setLayoutManager(manager);
        ZhaoPianAdapter adapter = new ZhaoPianAdapter(context);
        zhaopian_rc.setAdapter(adapter);
    }
}

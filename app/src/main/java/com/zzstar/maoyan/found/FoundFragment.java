package com.zzstar.maoyan.found;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.found.adapter.FoundAdapter;

/**
 * Created by zzstar on 2016/11/30.
 */

public class FoundFragment extends BaseFragment {
    private RecyclerView recyclerView;
    @Override
    public View initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.found_rc, null, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        return view;

    }

    @Override
    public void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        FoundAdapter adapter = new FoundAdapter(context);
        recyclerView.setAdapter(adapter);

    }
}

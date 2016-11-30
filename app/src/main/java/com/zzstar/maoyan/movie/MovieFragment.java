package com.zzstar.maoyan.movie;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.adapter.MyViewPagerAdapter;

/**
 * Created by zzstar on 2016/11/30.
 */

public class MovieFragment extends BaseFragment {
private SlidingTabLayout sliding_tab;
    private ViewPager view_pager;


    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_movie, null);
        sliding_tab = (SlidingTabLayout) view.findViewById(R.id.sliding_tab);
        view_pager = (ViewPager) view.findViewById(R.id.view_pager);
        return view;
    }

    @Override
    public void initData() {
        MyViewPagerAdapter adapter= new MyViewPagerAdapter(context);
        view_pager.setAdapter(adapter);
        String[] titles = {"热映", "待映","找片"};
        sliding_tab.setViewPager(view_pager,titles);

    }
}

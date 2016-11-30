package com.zzstar.maoyan.movie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.view.ViewPagerIndicator;
import com.zzstar.maoyan.movie.view.fragment.FirstFragment;
import com.zzstar.maoyan.movie.view.fragment.SecondFragment;
import com.zzstar.maoyan.movie.view.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzstar on 2016/11/30.
 */

public class MovieFragment extends BaseFragment {
    private List<Fragment> mList;
    private List<String> mDatas;
    private ViewPager vp;
    private ViewPagerIndicator indicator;
    private FragmentPagerAdapter mAdapter;
    private int itemCount = 3;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_movie, null);
        indicator = (ViewPagerIndicator)view. findViewById(R.id.indicator);
        vp = (ViewPager) view.findViewById(R.id.vp);
        return view;
    }

    @Override
    public void initData() {
        mList = new ArrayList<Fragment>();
            Fragment firstFragment = new FirstFragment();
            Fragment secondFragment = new SecondFragment();
            Fragment thirdFragment = new ThirdFragment();
            mList.add(firstFragment);
            mList.add(secondFragment);
            mList.add(thirdFragment);
        mDatas=new ArrayList<>();
        mDatas.add("热映");
        mDatas.add("待映");
        mDatas.add("找片");
        mAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mList.get(position);
            }
            @Override
            public int getCount() {
                return mList.size();
            }
        };
        vp.setAdapter(mAdapter);
        indicator.setDatas(mDatas);
        indicator.setViewPager(vp);

    }
}

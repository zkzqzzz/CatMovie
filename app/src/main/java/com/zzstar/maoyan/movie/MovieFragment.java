package com.zzstar.maoyan.movie;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zaaach.citypicker.CityPickerActivity;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.activity.SearchActivity;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.movie.view.ViewPagerIndicator;
import com.zzstar.maoyan.movie.view.fragment.FirstFragment;
import com.zzstar.maoyan.movie.view.fragment.SecondFragment;
import com.zzstar.maoyan.movie.view.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by zzstar on 2016/11/30.
 */

public class MovieFragment extends BaseFragment {
    public TextView search;
    public LinearLayout ll_movef;
    private List<Fragment> mList;
    private List<String> mDatas;
    private ViewPager vp;
    private ViewPagerIndicator indicator;
    private FragmentPagerAdapter mAdapter;
    private TextView city;
    private Fragment firstFragment;
    private Fragment secondFragment;
    private Fragment thirdFragment;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_movie, null);
        indicator = (ViewPagerIndicator)view. findViewById(R.id.indicator);
        vp = (ViewPager) view.findViewById(R.id.vp);
        city = (TextView) view.findViewById(R.id.city);
        search = (TextView) view.findViewById(R.id.search);
        ll_movef = (LinearLayout) view.findViewById(R.id.ll_movef);
        return view;
    }

    private void initListener() {
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CityPickerActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity(intent);

            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            city.setText(data.getStringExtra("picked_city").toString());
        }
    }
    @Override
    public void initData() {
        mList = new ArrayList<>();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        thirdFragment = new ThirdFragment();
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
        initListener();
    }
}

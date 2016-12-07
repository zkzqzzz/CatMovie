package com.zzstar.maoyan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.cinema.CinemaFragment;
import com.zzstar.maoyan.found.FoundFragment;
import com.zzstar.maoyan.mine.UserFragment;
import com.zzstar.maoyan.movie.MovieFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    int position;
    private FrameLayout fl_main;
    private RadioGroup rg_main;
    private RadioButton bt_movie;
    private RadioButton bt_cinema;
    private RadioButton bt_found;
    private RadioButton bt_mine;
    private List<Fragment> fragments;
    private MovieFragment movieFragment;
    private CinemaFragment cinemaFragment;
    private FoundFragment foundFragment;
    private UserFragment userFragment;
    private BaseFragment mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initData();
        initListener();
    }

    private void initListener() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt_movie:
                        position = 0;
                        break;
                    case R.id.bt_cinema:
                        position = 1;
                        break;
                    case R.id.bt_found:
                        position = 2;
                        break;
                    case R.id.bt_mine:
                        position = 3;
                        break;
                }

                BaseFragment baseFragment = (BaseFragment) fragments.get(position);
                switchFragment(mContext, baseFragment);
            }
        });

        rg_main.check(R.id.bt_movie);

    }


    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (mContext != nextFragment) {
            mContext = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    if (nextFragment == movieFragment) {
                        transaction.add(R.id.fl_main, movieFragment, "movieFragmentTag").commit();

                    } else {
                        transaction.add(R.id.fl_main, nextFragment).commit();
                    }
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

    private void findViews() {
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        bt_movie = (RadioButton) findViewById(R.id.bt_movie);
        bt_movie = (RadioButton) findViewById(R.id.bt_cinema);
        bt_movie = (RadioButton) findViewById(R.id.bt_found);
        bt_movie = (RadioButton) findViewById(R.id.bt_mine);
    }

    private void initData() {
        fragments = new ArrayList<>();
        movieFragment = new MovieFragment();
        cinemaFragment = new CinemaFragment();
        foundFragment = new FoundFragment();
        userFragment = new UserFragment();
        fragments.add(movieFragment);
        fragments.add(cinemaFragment);
        fragments.add(foundFragment);
        fragments.add(userFragment);
    }
}

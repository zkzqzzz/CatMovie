package com.zzstar.maoyan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.cinema.CinemaFragment;
import com.zzstar.maoyan.found.FoundFragment;
import com.zzstar.maoyan.mine.UserFragment;
import com.zzstar.maoyan.movie.MovieFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Fragment> fragments;
    private MovieFragment movieFragment;
    private CinemaFragment cinemaFragment;
    private FoundFragment foundFragment;
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

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

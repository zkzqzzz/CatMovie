package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.zzstar.maoyan.R;

/**
 * Created by zzstar on 2016/11/30.
 */
public class MyViewPagerAdapter extends PagerAdapter {

private Context context;
    public MyViewPagerAdapter(Context context) {

        this.context=context;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.page1_view, null);


        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
}

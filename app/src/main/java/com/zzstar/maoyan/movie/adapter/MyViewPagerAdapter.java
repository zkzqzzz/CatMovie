package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzstar on 2016/12/2.
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<String> imageUrls;
    private Context context;
    private ArrayList<ImageView> imageViews;

    public MyViewPagerAdapter(List<String> imageUrls, Context context) {
        this.imageUrls = imageUrls;
        this.context = context;
        initImageView();

    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imageViews.get(position);
        container.addView(imageView);
        return imageView;
    }

    private ArrayList<ImageView> initImageView() {

        imageViews = new ArrayList<>();

        for (int i = 0; i < imageUrls.size(); i++) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(context).load(imageUrls.get(i)).into(imageView);
            imageViews.add(imageView);
        }
        return imageViews;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

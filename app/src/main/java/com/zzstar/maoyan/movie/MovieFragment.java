package com.zzstar.maoyan.movie;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zzstar.maoyan.base.BaseFragment;

/**
 * Created by zzstar on 2016/11/30.
 */

public class MovieFragment extends BaseFragment {


    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("MovieFragment");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}

package com.zzstar.maoyan.movie.view.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zzstar.maoyan.base.BaseFragment;

/**
 * Created by zzstar on 2016/11/30.
 */
public class SecondFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("SecondFragment");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}

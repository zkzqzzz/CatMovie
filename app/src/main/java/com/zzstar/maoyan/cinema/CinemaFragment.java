package com.zzstar.maoyan.cinema;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zzstar.maoyan.base.BaseFragment;

/**
 * Created by zzstar on 2016/11/30.
 */

public class CinemaFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("CinemaFragment");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}

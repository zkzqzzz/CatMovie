package com.zzstar.maoyan.activity.login;

import android.view.View;
import android.widget.TextView;

import com.zzstar.maoyan.base.BaseFragment;

/**
 * Created by zzstar on 2016/12/8.
 */
public class PhoneLoginFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("222222222222222");

        return textView;
    }
}

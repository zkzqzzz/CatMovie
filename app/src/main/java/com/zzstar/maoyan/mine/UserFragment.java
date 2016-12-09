package com.zzstar.maoyan.mine;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.activity.LoginActivity;
import com.zzstar.maoyan.base.BaseFragment;

/**
 * Created by zzstar on 2016/11/30.
 */

public class UserFragment extends BaseFragment {

    private TextView login;
    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_mine, null);
        login = (TextView) view.findViewById(R.id.login);

        return view;
    }

    @Override
    public void initData() {

        initListener();
    }

    private void initListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
        });

    }
}

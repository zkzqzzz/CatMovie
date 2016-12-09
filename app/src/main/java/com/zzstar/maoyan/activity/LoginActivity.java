package com.zzstar.maoyan.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.activity.login.LoginFragment;

public class LoginActivity extends FragmentActivity {
    private FrameLayout fl_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fl_login = (FrameLayout) findViewById(R.id.fl_login);
        initData();

    }

    private void initData() {
        LoginFragment loginFragment = new LoginFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_login, loginFragment).commit();


    }


}

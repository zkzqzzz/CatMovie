package com.zzstar.maoyan.activity.login;

import android.animation.ObjectAnimator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.utils.DisplayUtil;

import java.util.ArrayList;

/**
 * Created by zzstar on 2016/12/8.
 */
public class LoginFragment extends BaseFragment {
    private TabLayout tab_layout;
    private ViewPager vp_pager;
    private LinearLayout ll_down;
    private TextView up_down;
    private boolean down;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.log_fragment, null);
        tab_layout = (TabLayout) view.findViewById(R.id.tab_layout);
        vp_pager = (ViewPager) view.findViewById(R.id.vp_pager);
        ll_down = (LinearLayout) view.findViewById(R.id.ll_down);
        up_down = (TextView) view.findViewById(R.id.up_down);

        return view;
    }

    @Override
    public void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        LoginPageFragment loginPageFragment = new LoginPageFragment();
        PhoneLoginFragment phoneLoginFragment = new PhoneLoginFragment();
        fragments.add(loginPageFragment);
        fragments.add(phoneLoginFragment);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("账号密码登录");
        titles.add("手机号快捷登录");
        VPadapter adapter = new VPadapter(getActivity().getSupportFragmentManager(), fragments, titles);
        vp_pager.setAdapter(adapter);
        tab_layout.setupWithViewPager(vp_pager);
        initListener();

    }

    private void initListener() {
        up_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimate();
            }
        });

        vp_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 1) {
                    ll_down.setVisibility(View.GONE);
                } else {
                    ll_down.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void performAnimate() {
        if (!down) {
            down = true;
            ObjectAnimator.ofFloat(ll_down, "translationY", 0, DisplayUtil.dip2px(context, 120)).setDuration(300).start();
            ObjectAnimator.ofFloat(up_down, "rotation", 0f, 180f).setDuration(300).start();
        } else {
            down = false;
            ObjectAnimator.ofFloat(ll_down, "translationY", DisplayUtil.dip2px(context, 120), 0).setDuration(300).start();
            ObjectAnimator.ofFloat(up_down, "rotation", 180f, 360f).setDuration(300).start();
        }
    }
}



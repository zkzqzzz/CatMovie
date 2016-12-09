package com.zzstar.maoyan.activity.login;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;

/**
 * Created by zzstar on 2016/12/8.
 */
public class LoginPageFragment extends BaseFragment {
    private EditText mima;
    private ImageView mimamoshi;
    private boolean show;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.shuru_info, null);
        mima = (EditText) view.findViewById(R.id.mima);
        mimamoshi = (ImageView) view.findViewById(R.id.mimamoshi);
        return view;
    }

    @Override
    public void initData() {
        mima.setTransformationMethod(PasswordTransformationMethod.getInstance());
        mimamoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!show) {
                    mimamoshi.setBackground(context.getResources().getDrawable(R.drawable.a4n));

                    mima.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    show = true;
                } else {
                    mimamoshi.setBackground(context.getResources().getDrawable(R.drawable.a4m));
                    mima.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());

                    show = false;

                }


            }
        });

    }
}

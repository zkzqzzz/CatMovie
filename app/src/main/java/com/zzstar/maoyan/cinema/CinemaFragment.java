package com.zzstar.maoyan.cinema;

import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.bean.CinemaData;
import com.zzstar.maoyan.cinema.adapter.ListViewAdapter;
import com.zzstar.maoyan.utils.Constants;

import java.util.List;

import okhttp3.Call;

/**
 * Created by zzstar on 2016/11/30.
 */

public class CinemaFragment extends BaseFragment {

    private ListView ciema_listview;


    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.cinema_1, null);
        ciema_listview = (ListView) view.findViewById(R.id.ciema_listview);
        return view;
    }

    @Override
    public void initData() {

        OkHttpUtils.
                get().
                url(Constants.CINEMA).
                id(100).build().
                execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        processData(response);
                    }
                });
    }

    private void processData(String response) {

        JSONObject jsonObject = JSON.parseObject(response);
        String data = jsonObject.getString("data");
        JSONObject jsonObject1 = JSON.parseObject(data);
        String chaoYang = jsonObject1.getString("朝阳区");

        List<CinemaData.DataBean.CinemaBean> cinemaBeen = JSON.parseArray(chaoYang, CinemaData.DataBean.CinemaBean.class);

        if (cinemaBeen != null) {
            ListViewAdapter adapter = new ListViewAdapter(context, cinemaBeen);
            ciema_listview.setAdapter(adapter);
        }
    }
}

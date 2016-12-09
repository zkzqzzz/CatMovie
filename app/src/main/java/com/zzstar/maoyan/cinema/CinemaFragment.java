package com.zzstar.maoyan.cinema;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.base.BaseFragment;
import com.zzstar.maoyan.bean.Cinema;
import com.zzstar.maoyan.cinema.adapter.ListRightAdapter;
import com.zzstar.maoyan.cinema.adapter.ListViewAdapter;
import com.zzstar.maoyan.cinema.adapter.PopListViewAdapter;
import com.zzstar.maoyan.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by zzstar on 2016/11/30.
 */

public class CinemaFragment extends BaseFragment {

    private ListView ciema_listview;
    private LinearLayout title_gone;
    private TextView quyu;
    private PopupWindow popupWindow;
    private ListView list_pop;
    private View popview;
    private TextView shangquan;
    private TextView ditiezhan;
    private ListView list_right;
    private ArrayList<List<Cinema.DataBean.CinemaBean>> cinemas;
    private LinearLayout quyuhead;
    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.cinema_1, null);
        View shaixuan = View.inflate(context, R.layout.text_view_head, null);
        quyuhead = (LinearLayout) shaixuan.findViewById(R.id.quyuhead);


        quyuhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();

                } else {
                    popupWindow.showAsDropDown(v);
                    WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                    params.alpha = 0.5f;
                    getActivity().getWindow().setAttributes(params);
                }
            }
        });
        popview = View.inflate(context, R.layout.pop_list, null);
        shangquan = (TextView) popview.findViewById(R.id.shangquan);
        ditiezhan = (TextView) popview.findViewById(R.id.ditiezhan);
        shangquan.setTextColor(0xffff0000);
        shangquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ditiezhan.setTextColor(0xffcccccc);
                shangquan.setTextColor(0xffff0000);

            }
        });
        ditiezhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shangquan.setTextColor(0xffcccccc);
                ditiezhan.setTextColor(0xffff0000);

            }
        });
        View head = View.inflate(context, R.layout.image_view_head, null);
        title_gone = (LinearLayout) view.findViewById(R.id.title_gone);
        ciema_listview = (ListView) view.findViewById(R.id.ciema_listview);
        quyu = (TextView) view.findViewById(R.id.quyu);
        ciema_listview.addHeaderView(head);
        ciema_listview.addHeaderView(shaixuan);

        return view;
    }

    private void initListener() {
        popupWindow = new PopupWindow(popview, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        list_pop = (ListView) popview.findViewById(R.id.list_pop);
        list_right = (ListView) popview.findViewById(R.id.list_right);
        PopListViewAdapter adapter = new PopListViewAdapter(cinemas, context);
        final ListRightAdapter adapterRight = new ListRightAdapter(context, cinemas);

        list_pop.setAdapter(adapter);
        list_pop.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    return;
                } else {
                    adapterRight.setPosition(position - 1);
                    list_right.setAdapter(adapterRight);
                }
            }
        });


        ColorDrawable colorDrawable = new ColorDrawable(0xff0000);
        popupWindow.setBackgroundDrawable(colorDrawable);
        quyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();

                } else {
                    popupWindow.showAsDropDown(v);
                    WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                    params.alpha = 0.5f;
                    getActivity().getWindow().setAttributes(params);
                }

            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                params.alpha = 1f;
                getActivity().getWindow().setAttributes(params);
            }
        });
        ciema_listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem != 0) {
                    title_gone.setVisibility(View.VISIBLE);

                } else {
                    title_gone.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void initData() {
        OkHttpUtils.get().
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
        cinemas = new ArrayList<>();
//创建dataBean对象，封装解析的数据
        Cinema.DataBean dataBean = new Cinema.DataBean();
        JSONObject dataObject = JSON.parseObject(data);
//朝阳
        String chaoyang = dataObject.getString("朝阳区");
        List<Cinema.DataBean.CinemaBean> chaoYangBeen = JSON.parseArray(chaoyang, Cinema.DataBean.CinemaBean.class);
        dataBean.setchaoyang(chaoYangBeen);
//添加进集合
        cinemas.add(chaoYangBeen);
//海淀区
        String haidian = dataObject.getString("海淀区");
        List<Cinema.DataBean.CinemaBean> haidianBeen = JSON.parseArray(haidian, Cinema.DataBean.CinemaBean.class);
        dataBean.sethaidian(haidianBeen);
//添加进集合
        cinemas.add(haidianBeen);
//大兴区
        String daxing = dataObject.getString("大兴区");
        List<Cinema.DataBean.CinemaBean> daxingBeen = JSON.parseArray(daxing, Cinema.DataBean.CinemaBean.class);
        dataBean.setdaxing(daxingBeen);
//添加进集合
        cinemas.add(daxingBeen);
//东城区
        String dongcheng = dataObject.getString("东城区");
        List<Cinema.DataBean.CinemaBean> dongchengBeen = JSON.parseArray(dongcheng, Cinema.DataBean.CinemaBean.class);
        dataBean.setdongcheng(dongchengBeen);
//添加进集合
        cinemas.add(dongchengBeen);
//丰台区
        String fengtai = dataObject.getString("丰台区");
        List<Cinema.DataBean.CinemaBean> fengtaiBeen = JSON.parseArray(fengtai, Cinema.DataBean.CinemaBean.class);
        dataBean.setfengtai(fengtaiBeen);
//添加进集合
        cinemas.add(fengtaiBeen);
//西城区
        String xicheng = dataObject.getString("西城区");
        List<Cinema.DataBean.CinemaBean> xichengBeen = JSON.parseArray(xicheng, Cinema.DataBean.CinemaBean.class);
        dataBean.setxicheng(xichengBeen);
//添加进集合
        cinemas.add(xichengBeen);
//通州区
        String tongzhou = dataObject.getString("通州区");
        List<Cinema.DataBean.CinemaBean> tongzhouBeen = JSON.parseArray(tongzhou, Cinema.DataBean.CinemaBean.class);
        dataBean.settongzhou(tongzhouBeen);
//添加进集合
        cinemas.add(tongzhouBeen);
//昌平区
        String changping = dataObject.getString("昌平区");
        List<Cinema.DataBean.CinemaBean> changpingBeen = JSON.parseArray(changping, Cinema.DataBean.CinemaBean.class);
        dataBean.setchangping(changpingBeen);
//添加进集合
        cinemas.add(changpingBeen);
//房山区
        String fangshan = dataObject.getString("房山区");
        List<Cinema.DataBean.CinemaBean> fangshanBeen = JSON.parseArray(fangshan, Cinema.DataBean.CinemaBean.class);
        dataBean.setfangshan(fangshanBeen);
//添加进集合
        cinemas.add(fangshanBeen);
//顺义区
        String shunyi = dataObject.getString("顺义区");
        List<Cinema.DataBean.CinemaBean> shunyiBeen = JSON.parseArray(shunyi, Cinema.DataBean.CinemaBean.class);
        dataBean.setshunyi(shunyiBeen);
//添加进集合
        cinemas.add(shunyiBeen);
//门头沟区
        String mentougou = dataObject.getString("门头沟区");
        List<Cinema.DataBean.CinemaBean> mentougouBeen = JSON.parseArray(mentougou, Cinema.DataBean.CinemaBean.class);
        dataBean.setmentougou(mentougouBeen);
//添加进集合
        cinemas.add(mentougouBeen);
//石景山区
        String shijingshan = dataObject.getString("石景山区");
        List<Cinema.DataBean.CinemaBean> shijingshanBeen = JSON.parseArray(shijingshan, Cinema.DataBean.CinemaBean.class);
        dataBean.setshijingshan(shijingshanBeen);
//添加进集合
        cinemas.add(shijingshanBeen);
//怀柔区
        String huairou = dataObject.getString("怀柔区");
        List<Cinema.DataBean.CinemaBean> huairouBeen = JSON.parseArray(huairou, Cinema.DataBean.CinemaBean.class);
        dataBean.sethuairou(huairouBeen);
//添加进集合
        cinemas.add(huairouBeen);
//平谷区
        String pinggu = dataObject.getString("平谷区");
        List<Cinema.DataBean.CinemaBean> pingguBeen = JSON.parseArray(pinggu, Cinema.DataBean.CinemaBean.class);
        dataBean.setpinggu(pingguBeen);
//添加进集合
        cinemas.add(pingguBeen);
//密云县
        String miyun = dataObject.getString("密云县");
        List<Cinema.DataBean.CinemaBean> miyunBeen = JSON.parseArray(miyun, Cinema.DataBean.CinemaBean.class);
        dataBean.setmiyun(miyunBeen);
//添加进集合
        cinemas.add(miyunBeen);
//延庆县
        String yanqing = dataObject.getString("延庆县");
        List<Cinema.DataBean.CinemaBean> yanqingBeen = JSON.parseArray(yanqing, Cinema.DataBean.CinemaBean.class);
        dataBean.setyanqing(yanqingBeen);
        cinemas.add(yanqingBeen);
        initListener();


        if (cinemas.get(0) != null) {
            ListViewAdapter adapter = new ListViewAdapter(context, cinemas.get(0));
            ciema_listview.setAdapter(adapter);
        }
    }


}

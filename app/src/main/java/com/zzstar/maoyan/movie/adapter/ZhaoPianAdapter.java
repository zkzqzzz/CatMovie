package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.utils.DisplayUtil;


/**
 * Created by zzstar on 2016/12/1.
 */
public class ZhaoPianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public ZhaoPianAdapter(Context context) {
        this.context = context;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.movie_fragment_title, parent, false);
            return new TitleViewHolder(view);
        } else if (viewType == 1) {
            View view = View.inflate(context, R.layout.zp_scroll_1, null);
            SrollTypeViewHolder srollTypeViewHolder = new SrollTypeViewHolder(view);
            return srollTypeViewHolder;
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.girdview_2, parent, false);
            GirdViewHolder girdViewHolder = new GirdViewHolder(view);
            return girdViewHolder;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.recy_view3, parent, false);
            RecyclerView3 recyclerView3 = new RecyclerView3(view);
            return recyclerView3;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 1) {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, DisplayUtil.dip2px(context, 29));
            int pad = DisplayUtil.dip2px(context, 4);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10, 10, 10, 20);
            SrollTypeViewHolder srollTypeViewHolder = (SrollTypeViewHolder) holder;
            String[] s1 = {"类型", "爱情片", "剧情片", "喜剧片", "家庭片", "伦理片", " 文艺片", "音乐片", "歌舞片", "动漫片",
                    " 西部片", "武侠片", "古装片", "动作片", "其他"};
            for (int i = 0; i < s1.length; i++) {
                TextView textView = new TextView(context);
                textView.setText(s1[i]);
                textView.setBackground(context.getResources().getDrawable(R.drawable.tbg));
                textView.setPadding(pad, pad, 0, 0);
                textView.setTextSize(DisplayUtil.sp2px(context, 9));
                textView.setLayoutParams(params);
                textView.setLayoutParams(lp);
                textView.setTextColor(Color.DKGRAY);
                srollTypeViewHolder.ll_hscrv1.addView(textView);
            }
            TextView t1 = (TextView) srollTypeViewHolder.ll_hscrv1.getChildAt(0);
            t1.setTextColor(Color.GRAY);
            String[] s2 = {"地区", "中国大陆 ", "中国香港 ", "中国台湾 ", "美国 ", "韩国 ", "英国 ", "法国", " 日本", " 印度 ", "德国 ", "芬兰", " 意大利", "丹麦", " 其他"};
            for (int i = 0; i < s2.length; i++) {
                TextView textView = new TextView(context);
                textView.setText(s2[i]);
                textView.setBackground(context.getResources().getDrawable(R.drawable.tbg));
                textView.setPadding(pad, pad, 0, 0);
                textView.setTextSize(DisplayUtil.sp2px(context, 9));
                textView.setLayoutParams(params);
                textView.setLayoutParams(lp);
                textView.setTextColor(Color.DKGRAY);
                srollTypeViewHolder.ll_hscrv2.addView(textView);
            }
            TextView t2 = (TextView) srollTypeViewHolder.ll_hscrv2.getChildAt(0);
            t2.setTextColor(Color.GRAY);
            String[] s3 = {"年代 ", "2006 ", "2005", " 2004 ", "2003", " 2002", "2001", "2000", "1999 ", "1998", "1997 ", "1996", " 1995"};
            for (int i = 0; i < s3.length; i++) {
                TextView textView = new TextView(context);
                textView.setText(s3[i]);
                textView.setBackground(context.getResources().getDrawable(R.drawable.tbg));
                textView.setPadding(pad, pad, 0, 0);
                textView.setTextSize(DisplayUtil.sp2px(context, 9));
                textView.setLayoutParams(params);
                textView.setLayoutParams(lp);
                textView.setTextColor(Color.DKGRAY);
                srollTypeViewHolder.ll_hscrv3.addView(textView);
            }
            TextView t3 = (TextView) srollTypeViewHolder.ll_hscrv3.getChildAt(0);
            t3.setTextColor(Color.GRAY);

        }
        if (position == 2) {
            GirdViewHolder girdViewHolder = (GirdViewHolder) holder;
            GridAdapter adapter = new GridAdapter(context);
            girdViewHolder.grid_view.setAdapter(adapter);
        }
        if(position==3) {
            RecyclerView3 recyclerView3 = (RecyclerView3) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

            recyclerView3.item_rc_zhaopian.setLayoutManager(manager);

            RecyclerView3Adapter adapter = new RecyclerView3Adapter(context);
            recyclerView3.item_rc_zhaopian.setAdapter(adapter);
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else {
            return 3;
        }
    }


    class SrollTypeViewHolder extends RecyclerView.ViewHolder {


        private LinearLayout ll_hscrv1;
        private LinearLayout ll_hscrv2;
        private LinearLayout ll_hscrv3;

        public SrollTypeViewHolder(View itemView) {
            super(itemView);

            ll_hscrv1 = (LinearLayout) itemView.findViewById(R.id.ll_hscrv1);
            ll_hscrv2 = (LinearLayout) itemView.findViewById(R.id.ll_hscrv2);
            ll_hscrv3 = (LinearLayout) itemView.findViewById(R.id.ll_hscrv3);
        }
    }

    private class TitleViewHolder extends RecyclerView.ViewHolder {
        public TitleViewHolder(View view) {
            super(view);
        }
    }

    private class GirdViewHolder extends RecyclerView.ViewHolder {

        GridView grid_view;

        public GirdViewHolder(View view) {
            super(view);
            grid_view = (GridView) view.findViewById(R.id.gird_view);

        }
    }

    private class RecyclerView3 extends RecyclerView.ViewHolder {

        private RecyclerView item_rc_zhaopian;

        public RecyclerView3(View view) {
            super(view);
            item_rc_zhaopian = (RecyclerView) view.findViewById(R.id.item_rc_zhaopian);
        }
    }
}

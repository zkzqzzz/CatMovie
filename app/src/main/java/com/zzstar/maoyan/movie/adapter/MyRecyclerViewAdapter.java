package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.movie.bean.MovieHotBean;

/**
 * Created by zzstar on 2016/11/30.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private MovieHotBean movieHotBean;

    public MyRecyclerViewAdapter(Context context, MovieHotBean movieHotBean) {

        this.movieHotBean = movieHotBean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.movie_fragment_title, parent, false);
            return new TitleViewHolder(view);
        } else if (viewType == 1) {
            View view = View.inflate(context, R.layout.second_fragment_item1, null);
            return new FirstViewHolder(view);
        } else if (viewType == 2) {
            View view = View.inflate(context, R.layout.second_fragment_item2, null);
            return new SecondViewHolder(view);
        } else {
            View view = View.inflate(context, R.layout.second_fragment_hot_rv, null);
            return new ThirdViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1) {
            FirstViewHolder firstViewHolder = (FirstViewHolder) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            firstViewHolder.rc_view_1.setLayoutManager(manager);
            MyRecyclerViewAdapter_hot adapter_hot = new MyRecyclerViewAdapter_hot(context, movieHotBean);
            firstViewHolder.rc_view_1.setAdapter(adapter_hot);
        } else if (getItemViewType(position) == 2) {
            SecondViewHolder secondViewHolder = (SecondViewHolder) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            secondViewHolder.rc_view_2.setLayoutManager(manager);
            MyRecyclerViewAdapter_hot2 adapter_hot = new MyRecyclerViewAdapter_hot2(context, movieHotBean);
            secondViewHolder.rc_view_2.setAdapter(adapter_hot);
        } else if (getItemViewType(position) == 3) {
            ThirdViewHolder thirdViewHolder = (ThirdViewHolder) holder;
            thirdViewHolder.setData(movieHotBean.getData().getComing().get(position - 3));
        }

    }

    @Override
    public int getItemCount() {

        return movieHotBean.getData().getComing().size() + 3;
    }


    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        }
        return 3;


    }

    private class FirstViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rc_view_1;


        public FirstViewHolder(View view) {
            super(view);
            rc_view_1 = (RecyclerView) view.findViewById(R.id.rc_view_1);

        }
    }

    private class SecondViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rc_view_2;

        public SecondViewHolder(View view) {
            super(view);
            rc_view_2 = (RecyclerView) view.findViewById(R.id.rc_view_2);
        }
    }

    private class ThirdViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_move_head;
        private TextView movie_name;
        private TextView sc;
        private TextView movie_descript;
        private TextView show_info;


        public ThirdViewHolder(View view) {
            super(view);
            iv_move_head = (ImageView) view.findViewById(R.id.iv_move_head);
            movie_name = (TextView) view.findViewById(R.id.movie_name);
            sc = (TextView) view.findViewById(R.id.sc);
            movie_descript = (TextView) view.findViewById(R.id.movie_descript);
            show_info = (TextView) view.findViewById(R.id.show_info);
        }

        private void setData(MovieHotBean.DataBean.ComingBean comingBean) {
            Picasso.with(context).load(comingBean.getImg().replace("w.h", "200.200")).into(iv_move_head);
            movie_name.setText(comingBean.getNm());
            movie_descript.setText(comingBean.getScm());
            show_info.setText(comingBean.getStar());
            sc.setText(comingBean.getWish() + "");


        }

        ;

    }

    private class TitleViewHolder extends RecyclerView.ViewHolder {
        public TitleViewHolder(View view) {
            super(view);
        }
    }
}

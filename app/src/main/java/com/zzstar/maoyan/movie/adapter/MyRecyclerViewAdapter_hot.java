package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.movie.bean.MovieHotBean;

import java.util.List;

/**
 * Created by zzstar on 2016/12/1.
 */
public class MyRecyclerViewAdapter_hot extends RecyclerView.Adapter<MyRecyclerViewAdapter_hot.ViewHolder> {

    private Context context;
    private  MovieHotBean movieHotBean;
    private final List<MovieHotBean.DataBean.ComingBean> coming;

    public MyRecyclerViewAdapter_hot(Context context, MovieHotBean movieHotBean) {
        this.context = context;
        this.movieHotBean=movieHotBean;
        coming = movieHotBean.getData().getComing();

    }

    @Override
    public MyRecyclerViewAdapter_hot.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_hot, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter_hot.ViewHolder holder, int position) {
        Picasso.with(context).load(coming.get(position).getImg()).into(holder.iv_hot);
        holder.hot_up.setText(coming.get(position).getNm());
        holder.hot_down.setText(coming.get(position).getScm());
    }

    @Override
    public int getItemCount() {
        return coming.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_hot;
        private TextView hot_up;
        private TextView hot_down;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_hot = (ImageView) itemView.findViewById(R.id.iv_hot);
            hot_up = (TextView) itemView.findViewById(R.id.hot_up);
            hot_down = (TextView) itemView.findViewById(R.id.hot_down);

        }
    }
}

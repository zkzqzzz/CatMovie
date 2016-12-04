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
public class MyRecyclerViewAdapter_hot2 extends RecyclerView.Adapter<MyRecyclerViewAdapter_hot2.ViewHolder> {

    private final List<MovieHotBean.DataBean.ComingBean> coming;
    private Context context;

    public MyRecyclerViewAdapter_hot2(Context context, MovieHotBean movieHotBean) {
        this.context = context;
        coming = movieHotBean.getData().getComing();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_hot2, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.head_text.setText(coming.get(position).getRt());
            holder.below_text.setText(coming.get(position).getNm());
            holder.below_text_down.setText(coming.get(position).getWish()+"人想看");
        Picasso.with(context).load(coming.get(position).getImg().replace("w.h", "160.180")).into(holder.iv_mid);
    }

    @Override
    public int getItemCount() {
        return coming.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView head_text;
        private TextView below_text;
        private TextView below_text_down;
        private ImageView iv_mid;
        private ImageView iv_care;

        public ViewHolder(View itemView) {
            super(itemView);
            below_text = (TextView) itemView.findViewById(R.id.below_text);
            head_text = (TextView) itemView.findViewById(R.id.head_text);
            below_text_down = (TextView) itemView.findViewById(R.id.below_text_down);
            iv_mid = (ImageView) itemView.findViewById(R.id.iv_mid);
            iv_care = (ImageView) itemView.findViewById(R.id.iv_care);

        }
    }
}

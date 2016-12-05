package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.movie.bean.DaiyingFirstBean;

import java.util.List;

/**
 * Created by zzstar on 2016/12/1.
 */
public class MyRecyclerViewAdapter_hot extends RecyclerView.Adapter<MyRecyclerViewAdapter_hot.ViewHolder> {

    private final List<DaiyingFirstBean.DataBean> data;
    private Context context;


    public MyRecyclerViewAdapter_hot(Context context, DaiyingFirstBean daiyingFirstBean) {
        this.context = context;
        data = daiyingFirstBean.getData();

    }

    @Override
    public MyRecyclerViewAdapter_hot.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_hot, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter_hot.ViewHolder holder, int position) {
        Picasso.with(context).load(data.get(position).getImg()).into(holder.iv_hot);
        holder.hot_up.setText(data.get(position).getMovieName());
        holder.hot_down.setText(data.get(position).getOriginName());
    }

    @Override
    public int getItemCount() {
        return data.size();
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

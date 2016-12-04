package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.movie.bean.DianyingJiangBean;
import com.zzstar.maoyan.utils.LogUtil;

import java.util.List;

/**
 * Created by zzstar on 2016/12/2.
 */
public class RecyclerView3Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<DianyingJiangBean.DataBean> data;
    private Context context;

    public RecyclerView3Adapter(Context context, DianyingJiangBean jiangBean) {
        this.context = context;
        data = jiangBean.getData();
        LogUtil.e("11111111111111111111111111111111");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_rc_3_down, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder holder1 = (ViewHolder) holder;
        Picasso.with(context).load(data.get(position).getImg().replace("w.h", "200.200")).into(holder1.iv_movie);
        holder1.time.setText("-----" + data.get(position).getHeldDate() + "-----");
        holder1.name.setText(data.get(position).getMovieName());
        holder1.title_jiang.setText(data.get(position).getFestivalName());
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
   class  ViewHolder extends  RecyclerView.ViewHolder{
       private TextView title_jiang;
       private TextView time;
       private TextView name;
       private ImageView iv_movie;

       public ViewHolder(View view) {
           super(view);
           title_jiang = (TextView) view.findViewById(R.id.title_jiang);
           time = (TextView) view.findViewById(R.id.time);
           name = (TextView) view.findViewById(R.id.name);
           iv_movie = (ImageView) view.findViewById(R.id.iv_movie);
       }


   }
}

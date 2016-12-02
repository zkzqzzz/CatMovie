package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.movie.bean.MovieHotBean;

import java.util.List;

/**
 * Created by zzstar on 2016/12/1.
 */
public class MyRecyclerViewAdapter1 extends BaseAdapter{
    private Context context;
    private final List<MovieHotBean.DataBean.ComingBean> coming;

    public MyRecyclerViewAdapter1(Context context, MovieHotBean movieHotBean) {
        coming = movieHotBean.getData().getComing();
        this.context=context;
        Log.e("TAG", "----------------------");
    }

    @Override
    public int getCount() {
        return coming.size();
    }

    @Override
    public Object getItem(int position) {
        return coming.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder viewHolder;
        if(convertView==null) {
            convertView=View.inflate(context,R.layout.second_fragment_item3,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        MovieHotBean.DataBean.ComingBean comingBean = coming.get(position);
        Picasso.with(context).load(comingBean.getImg()).into(viewHolder.iv_move_head);
        viewHolder.movie_name.setText(comingBean.getNm());
        viewHolder.movie_descript.setText(comingBean.getScm());
        viewHolder.show_info.setText(comingBean.getStar());
        viewHolder.sc.setText(comingBean.getWish()+"");
        return convertView;
    }


    //
//    @Override
//    public MyRecyclerViewAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = View.inflate(context, R.layout.second_fragment_item3, null);
//
//            return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(MyRecyclerViewAdapter1.ViewHolder holder, int position) {
//        MovieHotBean.DataBean.ComingBean comingBean = coming.get(position);
//        Picasso.with(context).load(comingBean.getImg()).into(holder.iv_move_head);
//            holder.movie_name.setText(comingBean.getNm());
//        holder.movie_descript.setText(comingBean.getScm());
//        holder.show_info.setText(comingBean.getStar());
//        holder.sc.setText(comingBean.getWish()+"");
//    }
//
//    @Override
//    public int getItemCount() {
//        return coming.size();
//    }
    class  ViewHolder{
        private ImageView iv_move_head;
        private TextView movie_name;
        private TextView sc;
        private TextView movie_descript;
        private TextView show_info;

        public ViewHolder(View view) {

            iv_move_head = (ImageView) view.findViewById(R.id.iv_move_head);
            movie_name = (TextView) view.findViewById(R.id.movie_name);
            sc = (TextView) view.findViewById(R.id.sc);
            movie_descript = (TextView) view.findViewById(R.id.movie_descript);
            show_info = (TextView) view.findViewById(R.id.show_info);
        }
    }
}

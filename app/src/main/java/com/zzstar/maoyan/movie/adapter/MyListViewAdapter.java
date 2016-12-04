package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.movie.bean.ListViewBean;

import java.util.List;

/**
 * Created by zzstar on 2016/11/30.
 */
public class MyListViewAdapter extends BaseAdapter {
    private final List<ListViewBean.DataBean.MoviesBean> movies;
    ListViewBean listViewBean;
    private Context context;

    public MyListViewAdapter(Context context, ListViewBean listViewBean) {
        this.context = context;
        this.listViewBean = listViewBean;
        movies = listViewBean.getData().getMovies();
    }

    @Override
    public int getCount() {
        return movies.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewBean.DataBean.MoviesBean moviesBean;

        if (position != 0 && position != 1) {
            moviesBean = movies.get(position - 1);
        } else {
            moviesBean = movies.get(position);
        }
        if (getItemViewType(position) == 1) {
            convertView = View.inflate(context, R.layout.item_list2, null);
        } else {

            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(context, R.layout.item_list, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (moviesBean.getPreSale() == 1) {
                viewHolder.buy_ticket.setText("预售");
                viewHolder.buy_ticket.setTextColor(Color.rgb(63, 81, 181));

            } else {
                viewHolder.buy_ticket.setText("购票");

            }

            viewHolder.sc.setText(moviesBean.getSc() + "");
            viewHolder.movie_name.setText(moviesBean.getNm());
            viewHolder.movie_descript.setText(moviesBean.getScm());
            viewHolder.show_info.setText(moviesBean.getShowInfo());
            Picasso.with(context).load(moviesBean.getImg()).into(viewHolder.iv_move_head);
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    class ViewHolder {
        private ImageView iv_move_head;
        private TextView movie_name;
        private TextView movie_descript;
        private TextView show_info;
        private TextView buy_ticket;
        private TextView sc;

        public ViewHolder(View convertView) {
            iv_move_head = (ImageView) convertView.findViewById(R.id.iv_move_head);
            movie_name = (TextView) convertView.findViewById(R.id.movie_name);
            movie_name = (TextView) convertView.findViewById(R.id.movie_name);
            movie_descript = (TextView) convertView.findViewById(R.id.movie_descript);
            show_info = (TextView) convertView.findViewById(R.id.show_info);
            buy_ticket = (TextView) convertView.findViewById(R.id.buy_ticket);
            sc = (TextView) convertView.findViewById(R.id.sc);

        }
    }
}

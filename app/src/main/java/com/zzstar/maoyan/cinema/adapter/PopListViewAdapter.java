package com.zzstar.maoyan.cinema.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.bean.Cinema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzstar on 2016/12/8.
 */

public class PopListViewAdapter extends BaseAdapter {
    private ArrayList<List<Cinema.DataBean.CinemaBean>> cinemas;
    private Context context;

    public PopListViewAdapter(ArrayList<List<Cinema.DataBean.CinemaBean>> cinemas, Context context) {
        this.cinemas = cinemas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cinemas.size() + 1;
    }

    @Override
    public Object getItem(int position) {

        if (position == 0) {
            return null;
        } else {
            return cinemas.get(position - 1);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.pop_list_tv, null);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            viewHolder.text_pop.setText("全部");
            viewHolder.text_pop_end.setText("");

        } else {
            viewHolder.text_pop.setText(cinemas.get(position - 1).get(0).getArea());
            viewHolder.text_pop_end.setText(cinemas.get(position - 1).size() + "");
        }
        return convertView;
    }

    class ViewHolder {
        private TextView text_pop;
        private TextView text_pop_end;

        public ViewHolder(View view) {
            text_pop = (TextView) view.findViewById(R.id.text_pop);
            text_pop_end = (TextView) view.findViewById(R.id.text_pop_end);
        }
    }
}


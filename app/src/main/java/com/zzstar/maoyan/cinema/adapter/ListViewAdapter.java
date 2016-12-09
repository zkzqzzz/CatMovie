package com.zzstar.maoyan.cinema.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.bean.Cinema;

import java.util.List;

/**
 * Created by zzstar on 2016/12/3.
 */
public class ListViewAdapter extends BaseAdapter {


    private Context context;
    private List<Cinema.DataBean.CinemaBean> cinemaBeen;

    public ListViewAdapter(Context context, List<Cinema.DataBean.CinemaBean> cinemaBeen) {
        this.context = context;
        this.cinemaBeen = cinemaBeen;
    }

    @Override
    public int getCount() {
        return cinemaBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_list_cinema, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.cinema_item_title.setText(cinemaBeen.get(position).getNm());
        viewHolder.loacaale.setText(cinemaBeen.get(position).getAddr());
        viewHolder.juli.setText(cinemaBeen.get(position).getDistance() + "");
        viewHolder.piaojia.setText(cinemaBeen.get(position).getSellPrice() + "");
        return convertView;
    }

    class ViewHolder {
        private TextView cinema_item_title;
        private TextView piaojia;
        private TextView loacaale;
        private TextView juli;

        public ViewHolder(View convertView) {
            cinema_item_title = (TextView) convertView.findViewById(R.id.cinema_item_title);
            loacaale = (TextView) convertView.findViewById(R.id.loacaale);
            piaojia = (TextView) convertView.findViewById(R.id.piaojia);
            juli = (TextView) convertView.findViewById(R.id.juli);
        }
    }
}

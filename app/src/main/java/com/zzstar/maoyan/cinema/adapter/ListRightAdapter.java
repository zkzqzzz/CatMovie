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
public class ListRightAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<List<Cinema.DataBean.CinemaBean>> cinemas;
    private int positionLeft;

    public ListRightAdapter(Context context, ArrayList<List<Cinema.DataBean.CinemaBean>> cinemas) {
        this.context = context;
        this.cinemas = cinemas;

    }

    @Override
    public int getCount() {
        return cinemas.get(positionLeft).size();
    }

    @Override
    public Object getItem(int position) {
        return cinemas.get(positionLeft).get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_right, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text_right.setText(cinemas.get(positionLeft).get(position).getDis());
        viewHolder.text_pright_end.setText(cinemas.get(positionLeft).get(position).getReferencePrice() + "");

        return convertView;
    }

    public void setPosition(int pos) {
        this.positionLeft = pos;
    }

    class ViewHolder {
        private TextView text_right;
        private TextView text_pright_end;

        public ViewHolder(View view) {
            text_right = (TextView) view.findViewById(R.id.text_right);
            text_pright_end = (TextView) view.findViewById(R.id.text_pright_end);
        }
    }
}

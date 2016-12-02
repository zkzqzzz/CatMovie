package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zzstar.maoyan.R;

/**
 * Created by zzstar on 2016/12/2.
 */
public class GridAdapter extends BaseAdapter {

    Context context;

    public GridAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 4;

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
        if(convertView==null) {
            convertView=View.inflate(context, R.layout.item_gird,null);
        }
        return convertView;
    }
}

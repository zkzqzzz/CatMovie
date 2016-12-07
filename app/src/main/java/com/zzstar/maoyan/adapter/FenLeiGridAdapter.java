package com.zzstar.maoyan.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.bean.ShumaBean;

/**
 * Created by zzstar on 2016/12/6.
 */
public class FenLeiGridAdapter extends BaseAdapter {

    private Context context;
    private ShumaBean shumaBean;

    public FenLeiGridAdapter(Context context, ShumaBean shumaBean) {
        this.context = context;
        this.shumaBean = shumaBean;
    }

    @Override
    public int getCount() {
        return shumaBean.getData().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return shumaBean.getData().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShumaBean.DataBean.ListBean listBean = shumaBean.getData().getList().get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.shop_grid_view, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        Picasso.with(context).load(listBean.getPic()).into(viewHolder.iv_shop_gridview);
        viewHolder.name.setText(listBean.getTitle());
        viewHolder.price.setText(listBean.getPrice() + "");
        viewHolder.old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        viewHolder.old_price.setText(listBean.getValue() + "元");
        return convertView;
    }

    class ViewHolder {

        private ImageView iv_shop_gridview;
        private TextView name;
        private TextView price;
        private TextView old_price;

        public ViewHolder(View view) {
            iv_shop_gridview = (ImageView) view.findViewById(R.id.iv_shop_gridview);
            name = (TextView) view.findViewById(R.id.name);
            price = (TextView) view.findViewById(R.id.price);
            old_price = (TextView) view.findViewById(R.id.old_price);
        }
    }
}

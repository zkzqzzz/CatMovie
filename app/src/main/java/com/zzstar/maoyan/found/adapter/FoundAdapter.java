package com.zzstar.maoyan.found.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzstar.maoyan.R;
import com.zzstar.maoyan.activity.ShopActivity;

/**
 * Created by zzstar on 2016/12/5.
 */
public class FoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public FoundAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_0, parent, false);
            return new Found1_Holder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;

        } else if (position == 1) {
            return 1;
        }
        return 2;
    }

    private class Found1_Holder extends RecyclerView.ViewHolder {
        private TextView shop_found;

        public Found1_Holder(View view) {
            super(view);
            shop_found = (TextView) view.findViewById(R.id.shop_found);

            shop_found.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ShopActivity.class);
                    context.startActivity(intent);
                }
            });

        }
    }
}

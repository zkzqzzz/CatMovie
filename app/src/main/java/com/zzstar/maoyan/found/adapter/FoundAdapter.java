package com.zzstar.maoyan.found.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzstar.maoyan.R;

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

        View view = LayoutInflater.from(context).inflate(R.layout.item_0, parent, false);

        return new Found1_Holder(view);
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

        return 1;
    }

    private class Found1_Holder extends RecyclerView.ViewHolder {
        public Found1_Holder(View view) {
            super(view);
        }
    }
}

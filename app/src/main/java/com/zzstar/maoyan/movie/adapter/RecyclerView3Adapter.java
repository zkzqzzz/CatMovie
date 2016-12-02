package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zzstar.maoyan.R;

/**
 * Created by zzstar on 2016/12/2.
 */
public class RecyclerView3Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public RecyclerView3Adapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_rc_3_down, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 11;
    }
   class  ViewHolder extends  RecyclerView.ViewHolder{

       public ViewHolder(View itemView) {
           super(itemView);
       }
   }
}

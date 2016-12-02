package com.zzstar.maoyan.movie.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.zzstar.maoyan.R;
import com.zzstar.maoyan.movie.bean.MovieHotBean;

/**
 * Created by zzstar on 2016/11/30.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private MovieHotBean movieHotBean;

    public MyRecyclerViewAdapter(Context context, MovieHotBean movieHotBean) {

        this.movieHotBean = movieHotBean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.movie_fragment_title, parent, false);

            return  new TitleViewHolder(view);
        }
       else if (viewType == 1) {
            View view = View.inflate(context, R.layout.second_fragment_item1, null);
            return new FirstViewHolder(view);
        } else if(viewType==2) {
            View view = View.inflate(context, R.layout.second_fragment_item2, null);
            return new SecondViewHolder(view);
        }else {
            View view = View.inflate(context, R.layout.second_fragment_hot_rv, null);
            return new ThirdViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1) {
            FirstViewHolder firstViewHolder = (FirstViewHolder) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            firstViewHolder.rc_view_1.setLayoutManager(manager);
            MyRecyclerViewAdapter_hot adapter_hot = new MyRecyclerViewAdapter_hot(context, movieHotBean);
            firstViewHolder.rc_view_1.setAdapter(adapter_hot);
        } else if (getItemViewType(position) == 2) {
            SecondViewHolder secondViewHolder = (SecondViewHolder) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            secondViewHolder.rc_view_2.setLayoutManager(manager);
            MyRecyclerViewAdapter_hot2 adapter_hot = new MyRecyclerViewAdapter_hot2(context, movieHotBean);
            secondViewHolder.rc_view_2.setAdapter(adapter_hot);
        } else if (getItemViewType(position) == 3) {
            ThirdViewHolder thirdViewHolder = (ThirdViewHolder) holder;
            MyRecyclerViewAdapter1 adapter1 = new MyRecyclerViewAdapter1(context, movieHotBean);
            thirdViewHolder.fragment_hot_rv.setAdapter(adapter1);

        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    int currentPostion;

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            currentPostion = 0;
        } else if (position == 1) {
            currentPostion = 1;
        } else if (position == 2){
            currentPostion = 2;
        }else if(position==3) {
            currentPostion=3;
        }
        return currentPostion;


    }

    private class FirstViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rc_view_1;


        public FirstViewHolder(View view) {
            super(view);
            rc_view_1 = (RecyclerView) view.findViewById(R.id.rc_view_1);

        }
    }

    private class SecondViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rc_view_2;

        public SecondViewHolder(View view) {
            super(view);
            rc_view_2 = (RecyclerView) view.findViewById(R.id.rc_view_2);
        }
    }

    private class ThirdViewHolder extends RecyclerView.ViewHolder {


        private   ListView fragment_hot_rv;
        public ThirdViewHolder(View view) {
            super(view);
            fragment_hot_rv = (ListView) view.findViewById(R.id.fragment_hot_rv);

        }


    }

    private class TitleViewHolder extends RecyclerView.ViewHolder {
        public TitleViewHolder(View view) {
            super(view);
        }
    }
}

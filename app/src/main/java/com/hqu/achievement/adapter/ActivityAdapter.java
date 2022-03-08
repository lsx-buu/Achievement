package com.hqu.achievement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hqu.achievement.R;
import com.hqu.achievement.bean.ActivityBean;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.Hodler> {
    private List<ActivityBean> activityBeans;
    private Context context;
    public ActivityAdapter(List<ActivityBean> activityBeans,Context context){
        this.activityBeans=activityBeans;
        this.context=context;
    }


    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item_activity,null);
        Hodler hodler=new Hodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {
        holder.imageView.setImageDrawable(activityBeans.get(position).getBacbground());
        holder.title.setText(activityBeans.get(position).getTitle());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return activityBeans.size();
    }


    public class Hodler extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;

        public Hodler(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.title_tx);
        }
    }
}

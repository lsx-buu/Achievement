package com.hqu.achievement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.hqu.achievement.R;
import com.hqu.achievement.bean.AchievementBean;
import com.hqu.achievement.widget.RectProBarView;

import java.util.List;


public class AchievementAdapter extends BaseAdapter {
    private List<AchievementBean> achievementBeans;
    private Context context;

    public AchievementAdapter(Context context, List<AchievementBean> achievementBeans){
        this.context=context;
        this.achievementBeans=achievementBeans;
    }
    @Override
    public int getCount() {
        return achievementBeans!=null?achievementBeans.size():0;
    }

    @Override
    public Object getItem(int position) {
        return achievementBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodler hodler=null;
        if(convertView==null){
            hodler=new Hodler();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_achievement,parent,false);
            hodler.status=convertView.findViewById(R.id.status_icon);
            hodler.name=convertView.findViewById(R.id.name_tx);
            hodler.about=convertView.findViewById(R.id.about_tx);
            hodler.nums=convertView.findViewById(R.id.star_nums_tx);
            hodler.progress=convertView.findViewById(R.id.progress_tx);
            hodler.proBarView=convertView.findViewById(R.id.rectProgress);
            hodler.finish=convertView.findViewById(R.id.finish_icon);
            hodler.layout=convertView.findViewById(R.id.layout);
            convertView.setTag(hodler);
        }else{
            hodler= (Hodler) convertView.getTag();
        }
        AchievementBean achievementBean=achievementBeans.get(position);
        hodler.name.setText(achievementBean.getName());
        hodler.about.setText(achievementBean.getAbout());
        hodler.nums.setText("x"+achievementBean.getNums());
        if(achievementBean.isLocked()){
            hodler.status.setImageDrawable(context.getDrawable(R.drawable.locked));
            hodler.layout.setBackground(context.getDrawable(R.drawable.corners_not_finish_8));
            hodler.finish.setVisibility(View.GONE);
            hodler.proBarView.setVisibility(View.VISIBLE);
        }else{
            hodler.status.setImageDrawable(context.getDrawable(R.drawable.unlocked));
            hodler.layout.setBackground(context.getDrawable(R.drawable.corners_finish_8));
            hodler.finish.setVisibility(View.VISIBLE);
            hodler.proBarView.setVisibility(View.INVISIBLE);
        }
        hodler.progress.setText(achievementBean.getProgress()+"/"+ achievementBean.getMax());
        hodler.proBarView.setProgress(achievementBean.getProgress()*100/achievementBean.getMax());
        return convertView;
    }

    static class Hodler{
        TextView name;
        TextView about;
        ImageView status;
        TextView nums;
        TextView progress;
        RectProBarView proBarView;
        ConstraintLayout layout;
        ImageView finish;
    }
}

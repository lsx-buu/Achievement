package com.hqu.achievement.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.hqu.achievement.R;
import com.hqu.achievement.adapter.ActivityAdapter;
import com.hqu.achievement.bean.ActivityBean;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        return view;
    }

    private void initView(){
        recyclerView=view.findViewById(R.id.recycleView);

        List<ActivityBean> activityBeans=new ArrayList<>();
        for (int i=0;i<6;i++){
            ActivityBean activityBean=new ActivityBean(getResources().getDrawable(R.drawable.iu_three),"傍晚的阳光刚刚好，让我好好放松一下");
            activityBeans.add(activityBean);
            ActivityBean activityBean1=new ActivityBean(getResources().getDrawable(R.drawable.iu_two),"虽然天空很阴沉，但是微风让人感到清爽");
            activityBeans.add(activityBean1);
            ActivityBean activityBean2=new ActivityBean(getResources().getDrawable(R.drawable.iu_one),"工作是歌手");
            activityBeans.add(activityBean2);
        }
        ActivityAdapter adapter=new ActivityAdapter(activityBeans,getContext());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);


    }
}

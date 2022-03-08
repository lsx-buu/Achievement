package com.hqu.achievement.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.hqu.achievement.R;
import com.hqu.achievement.constant.Constants;
import com.hqu.achievement.ui.achievement.AchievementActivity;

public class StarFragment  extends Fragment implements View.OnClickListener {
    private View view;
    private ConstraintLayout study_btn,honor_btn,activity_btn,explore_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_star,container,false);
        initView();
        return view;
    }

    private void initView(){
        study_btn=view.findViewById(R.id.study_btn);
        honor_btn=view.findViewById(R.id.honor_btn);
        activity_btn=view.findViewById(R.id.activity_btn);
        explore_btn=view.findViewById(R.id.explore_btn);

        study_btn.setOnClickListener(this);
        honor_btn.setOnClickListener(this);
        activity_btn.setOnClickListener(this);
        explore_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.study_btn:
                toAchievement(Constants.STUDYACHIEVEMENT);
                break;
            case R.id.honor_btn:
                toAchievement(Constants.HONORACHIEVEMENT);
                break;
            case R.id.activity_btn:
                toAchievement(Constants.ACTIVITYACHIEVEMENT);
                break;
            case R.id.explore_btn:
                toAchievement(Constants.EXPLOREACHIEVEMENT);
                break;
        }
    }

    private void toAchievement(int type){
        Intent intent=new Intent();
        intent.setClass(getContext(), AchievementActivity.class);
        intent.putExtra("type",type);
        startActivity(intent);
    }
}

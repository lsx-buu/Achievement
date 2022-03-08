package com.hqu.achievement.ui.achievement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hqu.achievement.R;
import com.hqu.achievement.adapter.AchievementAdapter;
import com.hqu.achievement.bean.AchievementBean;

import java.util.ArrayList;
import java.util.List;

public class AchievementActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title_tx;
    private ImageView back_btn;
    private ListView achievement_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        initView();
        Intent intent=getIntent();
        if(intent!=null){
            int type=intent.getIntExtra("type",0);
            initTitle(type);
            initList(type);
        }
    }

    private void initView(){
        title_tx=findViewById(R.id.title_tx);
        back_btn=findViewById(R.id.back_btn);
        achievement_list=findViewById(R.id.achievement_list);

        back_btn.setOnClickListener(this);
    }

    private void initTitle(int type){
        switch (type){
            case 0:
                title_tx.setText(getResources().getString(R.string.study_achievement));
                break;
            case 1:
                title_tx.setText(getResources().getString(R.string.honor_achievement));
                break;
            case 2:
                title_tx.setText(getResources().getString(R.string.activity_achievement));
                break;
            case 3:
                title_tx.setText(getResources().getString(R.string.explore_achievement));
                break;
        }
    }

    private void initList(int type){
        switch (type){
            case 0:
            case 1:
            case 2:
            case 3:
                takeList();
                break;
        }
    }

    private void takeList(){
        List<AchievementBean> achievementBeanList=new ArrayList<>();
        for (int i=0;i<6;i++){
            AchievementBean achievementBean=new AchievementBean("名列前茅","绩点为5的课程达到20门",true,20,20,10);
            achievementBeanList.add(achievementBean);
        }
        for (int i=0;i<6;i++){
            AchievementBean achievementBean=new AchievementBean("名列前茅","绩点为5的课程达到20门",false,20,20,20);
            achievementBeanList.add(achievementBean);
        }
        AchievementAdapter achievementAdapter=new AchievementAdapter(this,achievementBeanList);
        achievement_list.setAdapter(achievementAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_btn:
                finish();
                break;
        }
    }
}
package com.hqu.achievement.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hqu.achievement.R;
import com.hqu.achievement.constant.Constants;
import com.hqu.achievement.ui.login.LoginActivity;
import com.hqu.achievement.ui.main.viewModel.MainViewModel;
import com.hqu.achievement.util.SharedUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment homeFragment,mineFragment,starFragment;
    private MainViewModel mainViewModel;
    private ViewModelProvider viewModelProvider;
    public static Activity mainActivity;
    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private int fragmentIndex;
    private ImageView home_icon,star_icon,mine_icon;
    private TextView home_tx,star_tx,mine_tx;
    private LinearLayout home_btn,star_btn,mine_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedUtil.getInstance(this);
        //Checking whether to Log in
        if(SharedUtil.getString(Constants.STUDENTID,null)==null){
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        mainActivity=this;
        init();
        initView();
        addFragment();
        showFragment(null,homeFragment);
        fragmentIndex=0;
    }

    private void init(){
        fragments=new Fragment[3];
        homeFragment=new HomeFragment();
        mineFragment=new MineFragment();
        starFragment=new StarFragment();
        fragments[0]=homeFragment;
        fragments[1]=starFragment;
        fragments[2]=mineFragment;
        fragmentManager=getSupportFragmentManager();
        viewModelProvider=new ViewModelProvider(this);
        mainViewModel=viewModelProvider.get(MainViewModel.class);
    }

    private void initView(){
        home_icon=findViewById(R.id.home_icon);
        home_tx=findViewById(R.id.home_tx);
        star_tx=findViewById(R.id.star_tx);
        star_icon=findViewById(R.id.star_icon);
        mine_icon=findViewById(R.id.mine_icon);
        mine_tx=findViewById(R.id.mine_tx);
        home_btn=findViewById(R.id.home_btn);
        star_btn=findViewById(R.id.star_btn);
        mine_btn=findViewById(R.id.mine_btn);

        home_btn.setOnClickListener(this);
        star_btn.setOnClickListener(this);
        mine_btn.setOnClickListener(this);

    }

    private void addFragment(){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment,homeFragment);
        fragmentTransaction.add(R.id.fragment,starFragment);
        fragmentTransaction.add(R.id.fragment,mineFragment);
        fragmentTransaction.hide(homeFragment);
        fragmentTransaction.hide(starFragment);
        fragmentTransaction.hide(mineFragment);
        fragmentTransaction.commit();
    }

    private void showFragment(Fragment oldFragment,Fragment newFragment){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(oldFragment!=null){
            fragmentTransaction.hide(oldFragment);
        }
        fragmentTransaction.show(newFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_btn:
                if(fragmentIndex!=0){
                    showFragment(fragments[fragmentIndex],homeFragment);
                    home_tx.setTextColor(getColor(R.color.select_color_tx));
                    changeView(fragmentIndex);
                    home_icon.setImageDrawable(getDrawable(R.drawable.house));
                    fragmentIndex=0;
                }
                break;
            case R.id.star_btn:
                if(fragmentIndex!=1){
                    showFragment(fragments[fragmentIndex],starFragment);
                    star_tx.setTextColor(getColor(R.color.select_color_tx));
                    changeView(fragmentIndex);
                    star_icon.setImageDrawable(getDrawable(R.drawable.star));
                    fragmentIndex=1;
                }
                break;
            case R.id.mine_btn:
                if(fragmentIndex!=2){
                    showFragment(fragments[fragmentIndex],mineFragment);
                    mine_tx.setTextColor(getColor(R.color.select_color_tx));
                    changeView(fragmentIndex);
                    mine_icon.setImageDrawable(getDrawable(R.drawable.mine));
                    fragmentIndex=2;
                }
                break;
        }
    }

    private void changeView(int fragmentIndex){
        switch (fragmentIndex){
            case 0:
                home_icon.setImageDrawable(getDrawable(R.drawable.house_not));
                home_tx.setTextColor(getColor(R.color.not_select_color_tx));
                break;
            case 1:
                star_icon.setImageDrawable(getDrawable(R.drawable.star_not));
                star_tx.setTextColor(getColor(R.color.not_select_color_tx));
                break;
            case 2:
                mine_icon.setImageDrawable(getDrawable(R.drawable.mine_not));
                mine_tx.setTextColor(getColor(R.color.not_select_color_tx));
                break;
        }
    }
}
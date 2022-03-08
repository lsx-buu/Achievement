package com.hqu.achievement.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.hqu.achievement.R;
import com.hqu.achievement.ui.login.LoginActivity;
import com.hqu.achievement.ui.main.viewModel.MainViewModel;
import com.hqu.achievement.ui.setting.SettingActivity;

public class MineFragment  extends Fragment implements View.OnClickListener {
    private View view;
    private MainViewModel mainViewModel;
    private ViewModelProvider viewModelProvider;
    private TextView setting_btn,login_out_btn,person_word_tx;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mine,container,false);
        init();
        initView();
        return view;
    }

    private void init(){
        viewModelProvider=new ViewModelProvider((ViewModelStoreOwner) MainActivity.mainActivity);
        mainViewModel=viewModelProvider.get(MainViewModel.class);
    }

    private void initView(){
        setting_btn=view.findViewById(R.id.setting_btn);
        login_out_btn=view.findViewById(R.id.login_out_btn);
        person_word_tx=view.findViewById(R.id.person_word_tx);
        mainViewModel.personWord.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                person_word_tx.setText(s);
            }
        });
        login_out_btn.setOnClickListener(this);
        setting_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_btn:
                Intent intent=new Intent(getContext(),SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.login_out_btn:
                Intent intent1=new Intent(getContext(), LoginActivity.class);
                startActivity(intent1);
                MainActivity.mainActivity.finish();
                break;
        }
    }
}

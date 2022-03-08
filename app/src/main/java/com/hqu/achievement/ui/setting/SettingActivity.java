package com.hqu.achievement.ui.setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqu.achievement.R;
import com.hqu.achievement.constant.Constants;
import com.hqu.achievement.ui.main.MainActivity;
import com.hqu.achievement.ui.main.viewModel.MainViewModel;
import com.hqu.achievement.ui.personWord.PersonWordActivity;
import com.hqu.achievement.util.SharedUtil;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back_btn;
    private ConstraintLayout person_word;
    private TextView person_word_tx;
    private ViewModelProvider viewModelProvider;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
        initView();
    }

    private void init(){
        viewModelProvider=new ViewModelProvider((ViewModelStoreOwner) MainActivity.mainActivity);
        viewModel=viewModelProvider.get(MainViewModel.class);
    }

    private void initView(){
        back_btn=findViewById(R.id.back_btn);
        person_word_tx=findViewById(R.id.person_word_tx);
        person_word_tx.setText(SharedUtil.getString(Constants.PERSONWORD,"努力才会成功"));
        viewModel.personWord.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                person_word_tx.setText(s);
            }
        });
        person_word=findViewById(R.id.person_word);
        back_btn.setOnClickListener(this);
        person_word.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.person_word:
                Intent intent=new Intent(this, PersonWordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
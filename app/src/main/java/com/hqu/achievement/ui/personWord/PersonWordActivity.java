package com.hqu.achievement.ui.personWord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqu.achievement.R;
import com.hqu.achievement.constant.Constants;
import com.hqu.achievement.ui.main.MainActivity;
import com.hqu.achievement.ui.main.viewModel.MainViewModel;
import com.hqu.achievement.util.SharedUtil;

public class PersonWordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private TextView keep_btn;
    private ImageView back_btn;
    private ViewModelProvider viewModelProvider;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_word);
        init();
        initView();
    }

    private void init(){
        viewModelProvider=new ViewModelProvider((ViewModelStoreOwner) MainActivity.mainActivity);
        viewModel=viewModelProvider.get(MainViewModel.class);
    }

    private void initView(){
        editText=findViewById(R.id.editText);
        keep_btn=findViewById(R.id.keep_btn);
        back_btn=findViewById(R.id.back_btn);
        editText.setText(SharedUtil.getString(Constants.PERSONWORD,"努力才会成功"));
        keep_btn.setOnClickListener(this);
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.keep_btn:
                change();
                break;
            case R.id.back_btn:
                finish();
                break;
        }

    }
    private void change(){
        String new_word=editText.getText().toString();
        SharedUtil.put(Constants.PERSONWORD,new_word);
        viewModel.personWord.postValue(new_word);
    }
}
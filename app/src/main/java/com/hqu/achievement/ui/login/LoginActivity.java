package com.hqu.achievement.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hqu.achievement.R;
import com.hqu.achievement.constant.Constants;
import com.hqu.achievement.ui.main.MainActivity;
import com.hqu.achievement.util.SharedUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText studyId_ed,password_ed;
    private TextView login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        studyId_ed=findViewById(R.id.studyId_ed);
        password_ed=findViewById(R.id.password_ed);
        login_btn=findViewById(R.id.login_btn);

        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                String stduyId=studyId_ed.getText().toString();
                String password=password_ed.getText().toString();
                login(stduyId,password);
                break;
        }
    }

    private void login(String studyId,String password){
        if(studyId.equals("123456")&&password.equals("123456")){
            SharedUtil.put(Constants.STUDENTID,studyId);
            SharedUtil.put(Constants.USERPASSWORD,password);
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
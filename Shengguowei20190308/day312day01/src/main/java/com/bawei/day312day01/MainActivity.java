package com.bawei.day312day01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.day312day01.presenter.LoginPresenter;
import com.bawei.day312day01.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginView {

    private EditText ed_phone;
    private EditText ed_pwd;
    private Button login;
    private LoginPresenter loginPresenter;
    private Button zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        login.setOnClickListener(this);
        zhuce.setOnClickListener(this);
    }

    private void initView() {
        ed_phone = findViewById(R.id.ed1);
        ed_pwd = findViewById(R.id.ed2);
        login = findViewById(R.id.login);
        zhuce = findViewById(R.id.zhuce);
        loginPresenter = new LoginPresenter(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String phone = ed_phone.getText().toString();
                String pwd = ed_pwd.getText().toString();
                if (phone.length()<11){
                    Toast.makeText(this, "您输入的手机号格式不对！", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    if (pwd.length()<3){
                        Toast.makeText(this, "密码格式不对", Toast.LENGTH_SHORT).show();
                    }else {
                        loginPresenter.getData(phone,pwd);
                    }
                }
                break;
            case R.id.zhuce:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onZhuoge(String yyy) {
        int i = Integer.parseInt(yyy);
        if (i==0000){
            Toast.makeText(this, "登录成功！么么哒", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "登录失败，傻逼，草拟吗", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}

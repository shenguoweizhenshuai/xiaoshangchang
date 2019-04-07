package com.bawei.mvpdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.mvpdemo1.di.presenter.IRegisterPresenter;
import com.bawei.mvpdemo1.di.presenter.ReginsterPresenterImpl;
import com.bawei.mvpdemo1.di.view.IRegisterView;

public class MainActivity extends AppCompatActivity implements IRegisterView {

    private EditText name;
    private EditText pwd;
    private Button btn1;
    private IRegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);
        btn1 = findViewById(R.id.btn1);
        //创建p层对象
        presenter = new ReginsterPresenterImpl();
        //创建v层对象
        presenter.attahView(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName  = name.getText().toString();
                String pswd = pwd.getText().toString();
                //点击触发，p层请求M层的动作
                presenter.requsetData(userName,pswd);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(this);
    }

    @Override
    public void showData(String resposne) {
        Toast.makeText(this, resposne, Toast.LENGTH_SHORT).show();
    }
}

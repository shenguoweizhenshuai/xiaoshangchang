package com.bawei.day312day01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.day312day01.presenter.ZhucePresenter;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed3,ed4;
    private Button back;
    private ZhucePresenter zhucePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        back.setOnClickListener(this);
    }

    private void initView() {
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        zhucePresenter = new ZhucePresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                String ed3 = this.ed3.getText().toString();
                String ed4 = this.ed4.getText().toString();
                if (ed3.length()<11){
                    Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    if (ed4.length()<3){
                        Toast.makeText(this, "密码格式不对", Toast.LENGTH_SHORT).show();
                    }else {
                        zhucePresenter.getData(ed3,ed4);
                    }
                }
                break;
        }
    }
}

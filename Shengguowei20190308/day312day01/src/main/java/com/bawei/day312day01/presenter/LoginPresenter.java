package com.bawei.day312day01.presenter;

import com.bawei.day312day01.MainActivity;
import com.bawei.day312day01.model.LoginModel;
import com.bawei.day312day01.view.LoginView;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/12 11:53
 * @Description：描述信息
 */
public class LoginPresenter {

    private final LoginModel loginModel;
    private final LoginView loginview;

    public LoginPresenter(LoginView loginView) {

        loginModel = new LoginModel();
        loginview = loginView;
    }

    public void getData(String phone, String pwd) {
        loginModel.getData(phone,pwd);
        loginModel.setOnResultListener(new LoginModel.OnResultListener() {
            @Override
            public void onresult(String xxx) {
                loginview.onZhuoge(xxx);
            }
        });
    }
}

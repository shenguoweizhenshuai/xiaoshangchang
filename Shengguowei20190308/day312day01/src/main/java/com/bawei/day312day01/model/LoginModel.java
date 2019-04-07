package com.bawei.day312day01.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bawei.day312day01.utils.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/12 11:55
 * @Description：描述信息
 */
public class LoginModel {
private String url="http://172.17.8.100/small/user/v1/login";
//创建接口
    public interface OnResultListener{
        void onresult(String xxx);
}
//声明接口
    private OnResultListener onResultListener;
    //赋值

    public void setOnResultListener(OnResultListener onResultListener) {
        this.onResultListener = onResultListener;
    }

    private Handler myHandler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case 0:
                String ss = (String) msg.obj;
                try {
                    JSONObject jsonObject = new JSONObject(ss);
                    String status = jsonObject.getString("status");
                    Log.i("status",status);
                    if (onResultListener!=null){
                        onResultListener.onresult(status);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
};
    public void getData(String phone, String pwd) {
        OkHttpUtils.getInstance().doPost(url, phone, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Message message = new Message();
                message.what=0;
                message.obj=s;
                myHandler.sendMessage(message);

            }
        });
    }
}

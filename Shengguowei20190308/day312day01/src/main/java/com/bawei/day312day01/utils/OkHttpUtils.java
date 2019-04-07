package com.bawei.day312day01.utils;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/12 14:55
 * @Description：描述信息
 */
public class OkHttpUtils {

    private static OkHttpUtils okHttpUtils=null;

    //无参构造
    private OkHttpUtils(){

    }
    //单例模式
    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils==null){
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    //添加日志拦截
    public synchronized static OkHttpClient okHttpClient(){
        //创建拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", message);
            }
        });
        //设置拦截模式
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        return okHttpClient;
    }

    //做post请求
    public static void doPost(String url, String phone, String pwd, Callback callback){
        OkHttpClient okHttpClient = okHttpClient();
        //请求体
        RequestBody requestBody=new FormBody.Builder()
                .add("phone",phone)
                .add("pwd",pwd)
                .build();
        //请求
        Request request=new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        //发起异步请求
        okHttpClient.newCall(request).enqueue(callback);
    }

}

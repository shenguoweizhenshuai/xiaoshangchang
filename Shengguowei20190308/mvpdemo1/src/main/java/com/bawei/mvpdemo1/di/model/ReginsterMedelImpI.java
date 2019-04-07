package com.bawei.mvpdemo1.di.model;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * @Author：苏羡c
 * @E-mail：
 * @Date：2019/3/15 13:42
 * @Description：描述信息
 */
public class ReginsterMedelImpI implements IReginsterModel {
    public static final String REQUEST_URL = "http://172.17.8.100/small/user/v1/register";
    private OkHttpClient okHttpClient;

    @Override
    public void getData(String name, String pswd, CallBack callBack) {

        okHttpClient = new OkHttpClient();


        //请求数据
      /*  new SubAysncTask(name,pswd,callBack).execute(REQUEST_URL);*/
    }
  /*  class SubAysncTask extends AsyncTask<String, Integer, String> {
        String userName;
        String pwd;
        CallBack callBack;

        public SubAysncTask(String userName, String pwd, CallBack callBack) {
            this.userName = userName;
            this.pwd = pwd;
            this.callBack = callBack;
        }

        @Override
        protected String doInBackground(String... urlStrings) {
            try {
                //请求的URL字串
                String urlString = urlStrings[0];
                //String completeUrlString = urlString + "?phone=\'userName\'+pwd=\'pwd\'";
                String completeUrlString = urlString + "?phone="+userName+"&pwd="+pwd;
                //请求的URL地址
                URL url = new URL(completeUrlString);
                //请求对象
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //设置请求方法
                //参数提交
                //提交的数据有phone、pwd
                connection.setRequestMethod("POST");
                //连接
                connection.connect();
                //判断请求码
                if (connection.getResponseCode() == 200) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;
                    //输入流读取
                    InputStream inputStream = connection.getInputStream();
                    //搞笑字节流
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    while ((line = br.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    //把读取的内容转换成字串
                    return stringBuilder.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(String resposne) {
            super.onPostExecute(resposne);
            // 数据回传给P层，接口回调
            callBack.responseData(resposne);
        }
    }*/
}

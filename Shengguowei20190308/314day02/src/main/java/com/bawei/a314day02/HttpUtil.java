package com.bawei.a314day02;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/14 9:06
 * @Description：描述信息
 */
public class HttpUtil {
    public interface CallBackA {
        //写方法
        void getData(String s);
    }

    //封装异步
    public static void getAsyncTask(String url, final CallBackA backA) {

        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return httpGet(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backA.getData(s);

            }
        }.execute(url);
    }


    //====================================================================
    /*
     * 网络判断
     * */
    public static boolean isNetworkConnected(Context context) {

        if (context != null) {
            //获取连接管理器
            ConnectivityManager mConnectivityManager = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            //获取网络状态
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                //判断网络是否可用
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }


    public static String httpGet(String strUrl) {
        //设置url
        try {
            URL url = new URL(strUrl);
            //获取HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置为get请求
            connection.setRequestMethod("GET");
            //设置连接主机超时时间
            connection.setConnectTimeout(5000);
            //设置从主机读取数据超时
            connection.setReadTimeout(5000);
            //得到数据
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            //拼接数据
            StringBuilder builder = new StringBuilder();
            String str = "";
            while ((str = reader.readLine()) != null) {
                builder.append(str);
            }
            //关闭连接
            connection.disconnect();
            //返回数据
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

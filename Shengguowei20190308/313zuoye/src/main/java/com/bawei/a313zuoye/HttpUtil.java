package com.bawei.a313zuoye;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/13 19:02
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
                return httpget(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backA.getData(s);

            }
        }.execute(url);
    }

    public static boolean isNetworkConnected(Context context){
        if (context!=null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    public static String httpget(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder =  new StringBuilder();
            String str = "";
            while ((str = reader.readLine())!=null){
                builder.append(str);
            }
            connection.disconnect();
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


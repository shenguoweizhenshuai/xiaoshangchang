package com.bawei.a313zuoye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bawei.a313zuoye.adapter.PullAdapter;
import com.bawei.a313zuoye.bean.JsonBean;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url = "https://www.apiopen.top/novelApi";
    private PullAdapter pullAdapter;
    private PullToRefreshListView pull;
    private List<JsonBean.DataBean> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pull = findViewById(R.id.pull);
        pull.setPullToRefreshOverScrollEnabled(true);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        initData();
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (HttpUtil.isNetworkConnected(MainActivity.this)){
                    HttpUtil.getAsyncTask(url, new HttpUtil.CallBackA() {
                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            JsonBean bean = gson.fromJson(s,JsonBean.class);
                            list = bean.getData();
                            pullAdapter = new PullAdapter(MainActivity.this, list);
                            pull.setAdapter(pullAdapter);
                            pull.onRefreshComplete();
                        }
                    });
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (HttpUtil.isNetworkConnected(MainActivity.this)){
                    HttpUtil.getAsyncTask(url, new HttpUtil.CallBackA() {
                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            JsonBean bean = gson.fromJson(s,JsonBean.class);
                            List<JsonBean.DataBean> list2 = bean.getData();
                            list.addAll(list2);
                           pullAdapter.notifyDataSetChanged();;
                            pull.onRefreshComplete();
                        }
                    });
                }
            }
        });
    }

    private void initData() {
        if (HttpUtil.isNetworkConnected(this)){
            HttpUtil.getAsyncTask(url, new HttpUtil.CallBackA() {
                @Override
                public void getData(String s) {
                    Gson gson = new Gson();
                    JsonBean bean = gson.fromJson(s,JsonBean.class);
                    list = bean.getData();
                    pullAdapter = new PullAdapter(MainActivity.this, list);
                    pull.setAdapter(pullAdapter);
                }
            });
        }
    }
}

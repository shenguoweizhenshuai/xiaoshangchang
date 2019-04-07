package com.bawei.shengguowei20190308.tab;

import android.widget.ListView;

import com.bawei.shengguowei20190308.R;
import com.bawei.shengguowei20190308.adapter.PullAdapter;
import com.bawei.shengguowei20190308.base.BaseFragment;
import com.bawei.shengguowei20190308.bean.Fore;
import com.bawei.shengguowei20190308.bean.One;
import com.bawei.shengguowei20190308.bean.Three;
import com.bawei.shengguowei20190308.util.HttpUtil;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/8 9:14
 * @Description：描述信息
 */
public class Tab01 extends BaseFragment {

    private PullToRefreshListView pull;
    private String url ="http://172.17.8.100/small/commodity/v1/commodityList";
    private PullAdapter adapter;
    private ArrayList<One> lista;


    @Override
    protected int bindLayout() {
        return R.layout.tab01;
    }

    @Override
    protected void initView() {
        pull = bindView(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (HttpUtil.isNetworkConnected(getActivity())){
                    HttpUtil.getAsyncTask(url, new HttpUtil.CallBackA() {
                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            Fore fore = gson.fromJson(s,Fore.class);
                            Three result = fore.getResult();
                            ArrayList<One> list1 =result.getMlss().getCommodityList();
                            ArrayList<One> list2 =result.getPzsh().getCommodityList();
                            ArrayList<One> list3 =result.getRxxp().getCommodityList();
                            lista = new ArrayList<>();
                            lista.addAll(list1);
                            lista.addAll(list2);
                            lista.addAll(list3);
                            adapter = new PullAdapter(lista,getActivity());
                            pull.setAdapter(adapter);
                            pull.onRefreshComplete();
                        }
                    });
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                if (HttpUtil.isNetworkConnected(getActivity())){
                    HttpUtil.getAsyncTask(url, new HttpUtil.CallBackA() {



                        @Override
                        public void getData(String s) {
                            Gson gson = new Gson();
                            Fore bean = gson.fromJson(s, Fore.class);
                            Three result = bean.getResult();
                            ArrayList<One> list1 = result.getMlss().getCommodityList();
                            ArrayList<One> list2 = result.getPzsh().getCommodityList();
                            ArrayList<One> list3 = result.getRxxp().getCommodityList();
                            ArrayList<One> listM = new ArrayList<>();
                            listM.addAll(list1);
                            listM.addAll(list2);
                            listM.addAll(list3);
                            lista.addAll(listM);
                            adapter.notifyDataSetChanged();
                            pull.onRefreshComplete();
                        }
                    });
                }
            }
        });

    }

    @Override
    protected void initData() {

        HttpUtil.getAsyncTask(url, new HttpUtil.CallBackA() {

            @Override
            public void getData(String s) {
                Gson gson = new Gson();
                Fore fore = gson.fromJson(s,Fore.class);
                Three result = fore.getResult();
                ArrayList<One> list1 =result.getMlss().getCommodityList();
                ArrayList<One> list2 =result.getPzsh().getCommodityList();
                ArrayList<One> list3 =result.getRxxp().getCommodityList();
                lista = new ArrayList<>();
                lista.addAll(list1);
                lista.addAll(list2);
                lista.addAll(list3);
                adapter = new PullAdapter(lista,getActivity());
                pull.setAdapter(adapter);


            }
        });
    }

    @Override
    protected void bindEvent() {

    }
}

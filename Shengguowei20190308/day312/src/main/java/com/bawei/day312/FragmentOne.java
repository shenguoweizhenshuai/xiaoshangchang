package com.bawei.day312;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/12 10:59
 * @Description：描述信息
 */
public class FragmentOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        Log.i("xxx","fragment_onCreateView");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("xxx","fragment_onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("xxx","fragment_onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("xxx","fragment_onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("xxx","fragment_onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("xxx","fragment_onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("xxx","fragment_onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("xxx","fragment_onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("xxx","fragment_onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("xxx","fragment_onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("xxx","fragment_onDetach");
    }
}

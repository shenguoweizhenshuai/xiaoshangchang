package com.bawei.day312;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragme,new FragmentOne());
        transaction.show(new FragmentOne());
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("xxx","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("xxx","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("xxx","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("xxx","onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("xxx","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("xxx","onDestroy");
    }
}

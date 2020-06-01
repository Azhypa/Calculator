package com.lab.taxi.presentation.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.LayoutRes;

import butterknife.ButterKnife;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract String getTag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        Log.d(getTag(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getTag(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getTag(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getTag(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getTag(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getTag(), "onDestroy");
    }
}

package com.bawei.as.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initLayout()!=0){
            setContentView(initLayout());
            initView();
            initData();
        }

    }
    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract void initData();



}

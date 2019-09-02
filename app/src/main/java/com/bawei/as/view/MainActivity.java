package com.bawei.as.view;

import android.widget.ListView;

import com.bawei.as.R;
import com.bawei.as.base.BaseActivity;
import com.bawei.as.contract.LogContract;
import com.bawei.as.model.Bean;
import com.bawei.as.model.ListAdapter;
import com.bawei.as.presenter.LogPresenter;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements LogContract.Iview {

    String path="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=1&page=1&count=5";
    private LogPresenter logPresenter;
    private ListView list;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        list = findViewById(R.id.list);
    }

    @Override
    protected void initData() {
        //presenter
        logPresenter = new LogPresenter();
        //判空
        if (logPresenter != null) {
            //查看试图
            logPresenter.attachView(MainActivity.this);
            logPresenter.getPresenter(path);
        }
    }

    @Override
    public void onHomeSuccess(String data) {
        Gson gson=new Gson();
        Bean bean = gson.fromJson(data.toString(), Bean.class);
        List<Bean.ResultBean> result = bean.getResult();
        ListAdapter adapter=new ListAdapter(result,this);
        list.setAdapter(adapter);
    }

    @Override
    public void onHomeFailure(String e) {

    }
}

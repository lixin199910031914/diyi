package com.bawei.as.presenter;

import android.util.Log;

import com.bawei.as.contract.LogContract;
import com.bawei.as.model.LogModel;


import java.io.IOException;
import java.lang.ref.WeakReference;

public class LogPresenter implements LogContract.Ipresenter {
    private static final String TAG = "LogPresenter";
    private LogModel logModel;
    private WeakReference<LogContract.Iview> viewWeakReference;

    @Override
    public void attachView(LogContract.Iview view) {
        logModel = new LogModel();
        viewWeakReference = new  WeakReference<LogContract.Iview>((LogContract.Iview) view);

    }
    public LogContract.Iview getView(){
        return viewWeakReference.get();
    }
    @Override
    public void detachView() {
        // 如何解绑view
        if (viewWeakReference != null) {
            viewWeakReference.clear();//清空
            viewWeakReference = null;
        }

    }

    @Override
    public void getPresenter(String path) {
        try {
            logModel.getHomeData(path, new LogContract.Imodel.IModelCallback() {
                @Override
                public void onHomeSuccess(String data) {
                    Log.d(TAG, "onHomeSuccess: ");
                getView().onHomeSuccess(data);
                }

                @Override
                public void onHomeFailure(String railure) {
                    Log.d(TAG, "onHomeFailure: ");
                    getView().onHomeFailure(railure);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

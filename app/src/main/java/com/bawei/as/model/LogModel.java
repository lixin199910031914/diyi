package com.bawei.as.model;

import android.util.Log;

import com.bawei.as.contract.LogContract;
import com.bawei.as.ustil.NewUstil;
import java.io.IOException;

public class LogModel implements LogContract.Imodel {
    private static final String TAG = "LogModel";
    @Override
    public  void getHomeData(String path, final IModelCallback iModelCallback) throws IOException {
        NewUstil.getInstance().doGet(path, new NewUstil.ICallBack() {
            @Override
            public void onCheng(Object obj) {
                Log.d(TAG, "onCheng: ");
                if (iModelCallback != null) {
                    iModelCallback.onHomeSuccess(obj.toString());
                }
            }

            @Override
            public void onShibai(String meg) {
                Log.d(TAG, "onShibai: ");
                if (iModelCallback != null) {
                    iModelCallback.onHomeFailure(meg.toString());
                }
            }
        });
    }
}

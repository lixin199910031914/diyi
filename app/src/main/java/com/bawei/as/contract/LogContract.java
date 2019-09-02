package com.bawei.as.contract;

import java.io.IOException;

//契约类
public interface LogContract {
    //view与presenter 交互获取presenter的数据传递给View
    interface Iview{
        void onHomeSuccess(String data);
        void onHomeFailure(String e);
    }
    //model 接口
  interface Imodel{
        void getHomeData(String path, IModelCallback iModelCallback)throws IOException;
      interface IModelCallback {
          void onHomeSuccess(String data);
          void onHomeFailure(String railure);
        }
    }
  //presenter 接口
    interface  Ipresenter{
        //绑定视图
      void  attachView(LogContract.Iview view);
      //解绑
      void  detachView();
      //初始化
      void  getPresenter(String path) throws IOException;
  }
}

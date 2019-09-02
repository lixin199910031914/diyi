package com.bawei.as.ustil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.as.app.App;


public class NewUstil {
    private static final String TAG = "NewUstil";
    private  static  NewUstil newUstil=null;
    private NewUstil(){}
    public  static  NewUstil getInstance(){
        if (newUstil==null){
            synchronized (NewUstil.class){
                if (newUstil==null){
                    newUstil=new NewUstil();
                }
            }
        }
        return newUstil;
    }
    public  interface  ICallBack{
        void  onCheng(Object obj);
        void onShibai(String meg);
    }
    public boolean wan(){
        ConnectivityManager cm= (ConnectivityManager) App.sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info!=null){
            return info.isAvailable();
        }
        return false;
    }
    public  void  doGet(String path, final ICallBack iCallBack){
        RequestQueue requestQueue = Volley.newRequestQueue(App.sContext);
        StringRequest request=new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "onResponse: "+response.toString());
                if (iCallBack != null) {
                    iCallBack.onCheng(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (iCallBack != null) {
                    iCallBack.onShibai(error.getMessage());
                }
            }
        });
        requestQueue.add(request);
    }
}

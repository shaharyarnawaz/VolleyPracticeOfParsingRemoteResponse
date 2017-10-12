package com.example.shery.volleypracticeofparsingremoteresponse;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by SHERY on 9/23/2017.
 */

public class MySingleton {
    private Context mContext;
    private static RequestQueue requestQueue;
    private static MySingleton mInstance;

    private MySingleton(Context context)
    {
        mContext=context;
        requestQueue=getRequestQue();
    }

    private RequestQueue getRequestQue() {
        if (requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mContext.getApplicationContext());
        }

        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context)
        {   if (mInstance==null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }

    public<T> void addToRequestQue(Request<T> request)
    {
        requestQueue.add(request);

    }


}

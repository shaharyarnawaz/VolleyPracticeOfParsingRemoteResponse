package com.example.shery.volleypracticeofparsingremoteresponse;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by SHERY on 10/10/2017.
 */

public class NewSingleton {
        private Context mContext;
        private static RequestQueue requestQueue;
        private static NewSingleton mInstance;

        private NewSingleton(Context context)
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

        public static synchronized NewSingleton getInstance(Context context)
        {   if (mInstance==null) {
            mInstance = new NewSingleton(context);
        }
            return mInstance;
        }

        public<T> void addToRequestQue(Request<T> request)
        {
            requestQueue.add(request);

        }


    }


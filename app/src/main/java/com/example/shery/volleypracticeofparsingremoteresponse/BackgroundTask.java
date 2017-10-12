package com.example.shery.volleypracticeofparsingremoteresponse;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SHERY on 10/4/2017.
 */

public class BackgroundTask {
    Context context;
    ArrayList<Contact> list=new ArrayList<>();
    String url="http://192.168.0.100/getAll.php";

    public BackgroundTask(Context context)
    {
        this.context=context;
    }


    public ArrayList<Contact> getList()
    {

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count=0;
                while (count<response.length())
                {
                    try {
                        JSONObject jsonObject=response.getJSONObject(count);
                        Contact contact=new Contact(jsonObject.getString("Name"),jsonObject.getString("Email"));

                        list.add(contact);
                        count++;



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, ""+error, Toast.LENGTH_SHORT).show();
            }

        });

        MySingleton.getInstance(context).addToRequestQue(jsonArrayRequest);
        return list;
    }
}

package com.example.shery.volleypracticeofparsingremoteresponse;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String url="http://192.168.56.1/getAll.php";
    Button btn,btnMove;
    EditText Name,Email;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMove=(Button) findViewById(R.id.moveToNext);
        btn= (Button) findViewById(R.id.bn);
        Name= (EditText) findViewById(R.id.name);
        Email= (EditText) findViewById(R.id.email);
        builder=new AlertDialog.Builder(MainActivity.this);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShowAll.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Wait . . .", Toast.LENGTH_SHORT).show();
                final String nameString,EmailString;

                nameString=Name.getText().toString();
                EmailString=Email.getText().toString();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("Server Response");
                        builder.setMessage("Server Message"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Name.setText("");
                                Email.setText("");
                            }
                        });

                        AlertDialog dialog=builder.create();
                        dialog.show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something wents wrong", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<String, String>();
                        param.put("name",nameString);
                        param.put("email",EmailString);
                        return param;
                    }
                } ;






                NewSingleton.getInstance(MainActivity.this).addToRequestQue(stringRequest);

            }
        });





    }

}





//
////        name= (TextView) findViewById(R.id.name);
////        Email= (TextView) findViewById(R.id.email);
////        phone= (TextView) findViewById(R.id.cell);
//
//
//        JsonObjectRequest rs=new JsonObjectRequest
//                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
//                        Log.i("++--++",""+response);
////                        try {
////                            name.setText(response.getString("Name"));
////                            Email.setText(response.getString("Email"));
////                            phone.setText(response.getString("Phone"));
////                        }catch (Exception ex)
////                        {
////                            Log.i("++--++",""+ex);
////                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
//                        Log.i("++--++",""+error);
//                    }
//                }
//
//
//                );
//
//        MySingleton.getInstance(MainActivity.this).addToRequestQue(rs);
//
//// Access the RequestQueue through your singleton class.
//
//
//
//
//
//
//
//    }
//
//
//
//}

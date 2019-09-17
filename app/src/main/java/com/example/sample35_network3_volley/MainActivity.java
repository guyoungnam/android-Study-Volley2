package com.example.sample35_network3_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrl = findViewById(R.id.editUrl);
        txtResult = findViewById(R.id.txtResult);

        //코드로 스크롤 가능
        txtResult.setMovementMethod(new ScrollingMovementMethod());
    }
    public void send(View v){

        RequestQueue queue =Volley.newRequestQueue(this);
        //
        StringRequest req = new StringRequest(
                Request.Method.GET,
                editUrl.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        txtResult.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(req);
    }//end send
}//end class


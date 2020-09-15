package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class State_Total_Case extends AppCompatActivity {
    TextView t1, t2, t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state__total__case);
        t1 = findViewById(R.id.set_maharastra);
        t2 = findViewById(R.id.set_tamil);
        t3 = findViewById(R.id.set_delhi);
        t4 = findViewById(R.id.set_guj);
        fetch_Total_Case();
    }

    private void fetch_Total_Case() {
        String url = "https://api.covidindiatracker.com/state_data.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    JSONObject jsonObject1 = jsonArray.getJSONObject(1);
                    JSONObject jsonObject2 = jsonArray.getJSONObject(2);
                    JSONObject jsonObject3 = jsonArray.getJSONObject(3);

                    t1.setText(jsonObject.getString("confirmed"));
                    t2.setText(jsonObject1.getString("confirmed"));
                    t3.setText(jsonObject2.getString("confirmed"));
                    t4.setText(jsonObject3.getString("confirmed"));


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(State_Total_Case.this, e.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(State_Total_Case.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
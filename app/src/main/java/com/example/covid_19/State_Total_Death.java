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

public class State_Total_Death extends AppCompatActivity {
    TextView t11, t12, t13, t14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state__total__death);
        t11 = findViewById(R.id.death_maharastra);
        t12 = findViewById(R.id.death_tamil);
        t13 = findViewById(R.id.death_delhi);
        t14 = findViewById(R.id.death_guj);
        fetch_Total_Death();
    }

    private void fetch_Total_Death() {
        String url = "https://api.covidindiatracker.com/state_data.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject11 = jsonArray.getJSONObject(0);
                    JSONObject jsonObject12 = jsonArray.getJSONObject(1);
                    JSONObject jsonObject13 = jsonArray.getJSONObject(2);
                    JSONObject jsonObject14 = jsonArray.getJSONObject(3);

                    t11.setText(jsonObject11.getString("deaths"));
                    t12.setText(jsonObject12.getString("deaths"));
                    t13.setText(jsonObject13.getString("deaths"));
                    t14.setText(jsonObject14.getString("deaths"));


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(State_Total_Death.this, e.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(State_Total_Death.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
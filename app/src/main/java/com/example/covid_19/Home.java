package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Home extends AppCompatActivity {

    CardView c1, c2, c3, c4, c5, c6, c7, c8;
    TextView t1, t2,t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        c1 = findViewById(R.id.card_total_cases);
        c2 = findViewById(R.id.card_recovered);
        c3 = findViewById(R.id.card_total_death);
        c4 = findViewById(R.id.card_active);
        c5 = findViewById(R.id.card_help_india);
        c6 = findViewById(R.id.card_login);
        c7 = findViewById(R.id.card_download);
        c8 = findViewById(R.id.card_state_wise);

        t1 = findViewById(R.id.set_total_cases);
        t2 = findViewById(R.id.set_recovered);
        t3 = findViewById(R.id.set_total_death);
        t4 = findViewById(R.id.set_active);

        fetchData();

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation animTogether = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
                t1.startAnimation(animTogether);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation animTogether = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
                t2.startAnimation(animTogether);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation animTogether = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
                t3.startAnimation(animTogether);
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation animTogether = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
                t4.startAnimation(animTogether);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Home.this, State_Total_Case.class);
                startActivity(a);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Home.this, State_Recovered.class);
                startActivity(b);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Home.this, State_Total_Death.class);
                startActivity(c);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Home.this, State_Active.class);
                startActivity(d);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void fetchData(){
        String url = "https://api.covidindiatracker.com/total.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        t1.setText(jsonObject.getString("confirmed"));
                        t2.setText(jsonObject.getString("recovered"));
                        t3.setText(jsonObject.getString("deaths"));
                        t4.setText(jsonObject.getString("active"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Home.this, e.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Home.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
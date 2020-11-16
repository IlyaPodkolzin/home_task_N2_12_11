package com.example.myapplication987654;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    private Button btn2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        tv = findViewById(R.id.result);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String initial = bundle.getString("init");
            String currency = bundle.getString("curr");
            String term = bundle.getString("term");
            String percent = bundle.getString("perc");
            String capitalisation = bundle.getString("capi");

            double i1 = Double.parseDouble(initial);
            double t1 = Double.parseDouble(term) / 12;
            double p1 = Double.parseDouble(percent);
            double c1 = Double.parseDouble(capitalisation);

            double res = i1 * Math.pow(1 + p1 / 100 / c1, t1 * c1);

            DecimalFormat F = new DecimalFormat("############.#######");
            tv.setText(res + " " + currency);
        }
    }
}
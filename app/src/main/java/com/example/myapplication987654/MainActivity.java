package com.example.myapplication987654;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText t1, t2, t3, t4, t5;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.edit1);
        t2 = findViewById(R.id.edit2);
        t3 = findViewById(R.id.edit3);
        t4 = findViewById(R.id.edit4);
        t5 = findViewById(R.id.edit5);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = t1.getText().toString();
                String b1 = t3.getText().toString();
                String c1 = t4.getText().toString();
                String d1 = t5.getText().toString();

                String abc [] = {a1, b1, c1, d1};
                boolean flag = true;
                for (String i: abc) {
                    try {
                        double check = Double.parseDouble(i);
                    }
                    catch (NumberFormatException nfe) {
                        flag = false;
                    }
                }

                if (flag) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("init", a1);
                    intent.putExtra("curr", t2.getText().toString());
                    intent.putExtra("term", b1);
                    intent.putExtra("perc", c1);
                    intent.putExtra("capi", d1);
                    startActivity(intent);
                }
            }
        });

    }
}
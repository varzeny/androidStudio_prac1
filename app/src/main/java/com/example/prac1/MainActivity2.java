package com.example.prac1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView text_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_1 = findViewById(R.id.text_1);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg_from_activity1");

        text_1.setText(msg);
    }
}
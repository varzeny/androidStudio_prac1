package com.example.prac1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edit_1, edit_shared_1;
    Button btn_1;
    String str_1;
    ImageView img_1;
    ListView list_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // sharedPreference
        edit_shared_1 = findViewById(R.id.edit_shared_1);

        SharedPreferences shared_1 = getSharedPreferences("save",0);
        String val = shared_1.getString("data","아직 데이터가 없습니다.");
        edit_shared_1.setText(val);


        // 인탠트
        edit_1 = findViewById(R.id.edit_1);
        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                str_1 = edit_1.getText().toString();
                intent.putExtra("msg_from_activity1",str_1);
                startActivity(intent);
            }
        });


        // 이미지
        img_1 = findViewById(R.id.img_1);
        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"토스트 메세지 입니다.",Toast.LENGTH_SHORT).show();
            }
        });


        // 리스트
        list_1 = findViewById(R.id.list_1);
        List<String> list_data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list_data);
        list_1.setAdapter(adapter);
        list_data.add("hello");
        list_data.add("world");
        adapter.notifyDataSetChanged();

    }

    
    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences shared_1 = getSharedPreferences("save",0);
        SharedPreferences.Editor editor = shared_1.edit();
        String val = edit_shared_1.getText().toString();
        editor.putString("data",val);
        editor.commit();
    }
}
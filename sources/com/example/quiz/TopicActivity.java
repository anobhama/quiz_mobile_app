package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TopicActivity extends AppCompatActivity {
    Button aptitude;
    Button cn;
    Button dbms;
    Button os;
    Button pds;
    Button python;
    TextView tv;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_topic);
        this.tv = (TextView) findViewById(R.id.textView6);
        this.dbms = (Button) findViewById(R.id.button6);
        this.cn = (Button) findViewById(R.id.button7);
        this.os = (Button) findViewById(R.id.button8);
        this.python = (Button) findViewById(R.id.button9);
        this.pds = (Button) findViewById(R.id.button10);
        Button button = (Button) findViewById(R.id.button11);
        this.aptitude = button;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TopicActivity.this.startActivity(new Intent(TopicActivity.this.getApplicationContext(), QActivity.class));
            }
        });
        this.dbms.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TopicActivity.this.startActivity(new Intent(TopicActivity.this.getApplicationContext(), DbmsActivity.class));
            }
        });
        this.cn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TopicActivity.this.startActivity(new Intent(TopicActivity.this.getApplicationContext(), CnActivity.class));
            }
        });
        this.os.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TopicActivity.this.startActivity(new Intent(TopicActivity.this.getApplicationContext(), OsActivity.class));
            }
        });
        this.python.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TopicActivity.this.startActivity(new Intent(TopicActivity.this.getApplicationContext(), PythonActivity.class));
            }
        });
        this.pds.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TopicActivity.this.startActivity(new Intent(TopicActivity.this.getApplicationContext(), PdsActivity.class));
            }
        });
    }
}

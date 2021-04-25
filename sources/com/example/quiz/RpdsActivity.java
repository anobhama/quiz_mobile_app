package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RpdsActivity extends AppCompatActivity {
    TextView crtans;
    TextView fscore;
    Button restart;
    Button show;
    TextView wrgans;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_rpds);
        this.crtans = (TextView) findViewById(R.id.textView42);
        this.wrgans = (TextView) findViewById(R.id.textView43);
        this.fscore = (TextView) findViewById(R.id.textView44);
        this.restart = (Button) findViewById(R.id.button31);
        this.show = (Button) findViewById(R.id.button30);
        StringBuffer sb = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Correct answers: ");
        sb2.append(PdsActivity.crt);
        String str = "\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuffer sb22 = new StringBuffer();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Wrong Answers: ");
        sb3.append(PdsActivity.wrg);
        sb3.append(str);
        sb22.append(sb3.toString());
        StringBuffer sb32 = new StringBuffer();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Final Score: ");
        sb4.append(PdsActivity.crt);
        sb4.append(str);
        sb32.append(sb4.toString());
        this.crtans.setText(sb);
        this.wrgans.setText(sb22);
        this.fscore.setText(sb32);
        PdsActivity.crt = 0;
        PdsActivity.wrg = 0;
        this.restart.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RpdsActivity.this.startActivity(new Intent(RpdsActivity.this.getApplicationContext(), MainActivity.class));
            }
        });
        this.show.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(RpdsActivity.this.getApplicationContext(), "1.Ancestor node\n2.Single ended queue\n3.Last in first out\n4.vertices, edges\n5.Linear search\n6.Depth First\n7.Tree\n8.Stack\n9.Binary tree\n10.Arrays", 1).show();
            }
        });
    }
}

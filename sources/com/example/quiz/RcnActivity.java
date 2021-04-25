package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RcnActivity extends AppCompatActivity {
    TextView crtans;
    TextView fscore;
    Button restart;
    Button show;
    TextView wrgans;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_rcn);
        this.crtans = (TextView) findViewById(R.id.textView33);
        this.wrgans = (TextView) findViewById(R.id.textView34);
        this.fscore = (TextView) findViewById(R.id.textView35);
        this.restart = (Button) findViewById(R.id.button25);
        this.show = (Button) findViewById(R.id.button24);
        StringBuffer sb = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Correct answers: ");
        sb2.append(CnActivity.crt);
        String str = "\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuffer sb22 = new StringBuffer();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Wrong Answers: ");
        sb3.append(CnActivity.wrg);
        sb3.append(str);
        sb22.append(sb3.toString());
        StringBuffer sb32 = new StringBuffer();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Final Score: ");
        sb4.append(CnActivity.crt);
        sb4.append(str);
        sb32.append(sb4.toString());
        this.crtans.setText(sb);
        this.wrgans.setText(sb22);
        this.fscore.setText(sb32);
        CnActivity.crt = 0;
        CnActivity.wrg = 0;
        this.restart.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RcnActivity.this.startActivity(new Intent(RcnActivity.this.getApplicationContext(), MainActivity.class));
            }
        });
        this.show.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(RcnActivity.this.getApplicationContext(), "1.Bridge\n2.255.255.255.0\n3.All of the above\n4.SMTP\n5.gateway\n6.star network\n7.twice\n8.twisted-pair wire\n9.6 Kbps\n10.zero", 1).show();
            }
        });
    }
}

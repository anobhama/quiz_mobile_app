package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RosActivity extends AppCompatActivity {
    TextView crtans;
    TextView fscore;
    Button restart;
    Button show;
    TextView wrgans;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_ros);
        this.crtans = (TextView) findViewById(R.id.textView36);
        this.wrgans = (TextView) findViewById(R.id.textView37);
        this.fscore = (TextView) findViewById(R.id.textView38);
        this.restart = (Button) findViewById(R.id.button27);
        this.show = (Button) findViewById(R.id.button26);
        StringBuffer sb = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Correct answers: ");
        sb2.append(OsActivity.crt);
        String str = "\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuffer sb22 = new StringBuffer();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Wrong Answers: ");
        sb3.append(OsActivity.wrg);
        sb3.append(str);
        sb22.append(sb3.toString());
        StringBuffer sb32 = new StringBuffer();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Final Score: ");
        sb4.append(OsActivity.crt);
        sb4.append(str);
        sb32.append(sb4.toString());
        this.crtans.setText(sb);
        this.wrgans.setText(sb22);
        this.fscore.setText(sb32);
        OsActivity.crt = 0;
        OsActivity.wrg = 0;
        this.restart.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RosActivity.this.startActivity(new Intent(RosActivity.this.getApplicationContext(), MainActivity.class));
            }
        });
        this.show.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(RosActivity.this.getApplicationContext(), "1.Operation code\n2.1\n3.a program in execution\n4.is an access to a page not currently in memory\n5.spooling\n6.all of the above\n7.Terminal Table\n8.turnaround time\n9.banker’s algorithm\n10.only one disk", 1).show();
            }
        });
    }
}

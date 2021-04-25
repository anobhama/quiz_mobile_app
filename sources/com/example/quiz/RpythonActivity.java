package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RpythonActivity extends AppCompatActivity {
    TextView crtans;
    TextView fscore;
    Button restart;
    Button show;
    TextView wrgans;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_rpython);
        this.crtans = (TextView) findViewById(R.id.textView39);
        this.wrgans = (TextView) findViewById(R.id.textView40);
        this.fscore = (TextView) findViewById(R.id.textView41);
        this.restart = (Button) findViewById(R.id.button29);
        this.show = (Button) findViewById(R.id.button28);
        StringBuffer sb = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Correct answers: ");
        sb2.append(PythonActivity.crt);
        String str = "\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuffer sb22 = new StringBuffer();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Wrong Answers: ");
        sb3.append(PythonActivity.wrg);
        sb3.append(str);
        sb22.append(sb3.toString());
        StringBuffer sb32 = new StringBuffer();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Final Score: ");
        sb4.append(PythonActivity.crt);
        sb4.append(str);
        sb32.append(sb4.toString());
        this.crtans.setText(sb);
        this.wrgans.setText(sb22);
        this.fscore.setText(sb32);
        PythonActivity.crt = 0;
        PythonActivity.wrg = 0;
        this.restart.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RpythonActivity.this.startActivity(new Intent(RpythonActivity.this.getApplicationContext(), MainActivity.class));
            }
        });
        this.show.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(RpythonActivity.this.getApplicationContext(), "1.list\n2.A B C D\n3.Error\n4.set()\n5.[‘h’, ‘e’, ‘l’, ‘l’, ‘o’]\n6.Error\n7.Address of m\n8.zero or more\n9.getopt\n10.Special methods", 1).show();
            }
        });
    }
}

package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RActivity extends AppCompatActivity {
    TextView crtans;
    TextView fscore;
    Button restart;
    Button show;
    TextView wrgans;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_r2);
        this.crtans = (TextView) findViewById(R.id.textView5);
        this.wrgans = (TextView) findViewById(R.id.textView6);
        this.fscore = (TextView) findViewById(R.id.textView7);
        this.restart = (Button) findViewById(R.id.button4);
        this.show = (Button) findViewById(R.id.button5);
        StringBuffer sb = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Correct answers: ");
        sb2.append(QActivity.crt);
        String str = "\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuffer sb22 = new StringBuffer();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Wrong Answers: ");
        sb3.append(QActivity.wrg);
        sb3.append(str);
        sb22.append(sb3.toString());
        StringBuffer sb32 = new StringBuffer();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Final Score: ");
        sb4.append(QActivity.crt);
        sb4.append(str);
        sb32.append(sb4.toString());
        this.crtans.setText(sb);
        this.wrgans.setText(sb22);
        this.fscore.setText(sb32);
        QActivity.crt = 0;
        QActivity.wrg = 0;
        this.restart.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RActivity.this.startActivity(new Intent(RActivity.this.getApplicationContext(), MainActivity.class));
            }
        });
        this.show.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(RActivity.this.getApplicationContext(), "1.discovered four satellites of Jupiter\n2.Canada\n3.22\n4.3:4:10\n5.Flow\n6.Cousin\n7.Saturday\n8.5 km/hr\n9.Adventitious\n10.Electrocute", 1).show();
            }
        });
    }
}

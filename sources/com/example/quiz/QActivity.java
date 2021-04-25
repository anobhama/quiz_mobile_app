package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QActivity extends AppCompatActivity {
    public static int crt = 0;
    public static int marks = 0;
    public static int wrg = 0;
    String[] answer = {"discovered four satellites of Jupiter", "Canada.", "22", "3:4:10 ", "Flow ", "Cousin", "Saturday", "5km/hr", "Adventitious", "Electrocute"};
    int flag = 0;
    Button next;
    String[] opt = {" developed the telescope", "discovered four satellites of Jupiter", " discovered that the movement of pendulum produces a regular time measurement", "All the above.", "Canada.", "USA", "China", "Russia", "24", "22", "23", "21", "3:2:5", "3:6:5", "3:4:10 ", "2:3:4", "Flow", "Animal", "Wood", "Fox", "Sister", "Mother", "Cousin", "Aunt", "Monday", "Wednesday", "Friday", "Saturday", "2km/hr", "3km/hr", "4km/hr", "5km/hr", "Adventitious", "Adventitous", "Adventitus", "Adventituous", "Elcute", "Elecute", "Electrocute", "Elecxecute"};
    String[] que = {"1.Galileo was an astronomer who", "2.What is the second largest country (in size) in the world?", "3.How many times the hands of a clock coincide in a day?", " 4.If a: b is 3: 4 and b: c is 2: 5. Find a: b: c.", "5.Parts : Strap :: Wolf :", "6.How is Radha’s mother’s mother’s daughter-in-law’s daughter related to Radha?", "7.The last day of a century cannot be :", "8.A person can row 750 metres  against the stream in 11 ¼ minutes and returns in 7 ½ minutes. The speed of the person in in still water is :", "9.Select the correct spelling word ", "10.Blend the word: Electro + Execute"};
    Button quit;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioGroup rg;
    TextView score;
    TextView tv;

    public QActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_q);
        this.tv = (TextView) findViewById(R.id.textView1);
        this.next = (Button) findViewById(R.id.button2);
        this.quit = (Button) findViewById(R.id.button3);
        this.rg = (RadioGroup) findViewById(R.id.radiogroup);
        this.r1 = (RadioButton) findViewById(R.id.radioButton);
        this.r2 = (RadioButton) findViewById(R.id.radioButton2);
        this.r3 = (RadioButton) findViewById(R.id.radioButton3);
        this.r4 = (RadioButton) findViewById(R.id.radioButton4);
        this.score = (TextView) findViewById(R.id.textView3);
        this.tv.setText(this.que[this.flag]);
        this.r1.setText(this.opt[0]);
        this.r2.setText(this.opt[1]);
        this.r3.setText(this.opt[2]);
        this.r4.setText(this.opt[3]);
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (QActivity.this.rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QActivity.this.getApplicationContext(), "please choose an option", 1).show();
                    return;
                }
                QActivity qActivity = QActivity.this;
                if (((RadioButton) qActivity.findViewById(qActivity.rg.getCheckedRadioButtonId())).getText().toString().equals(QActivity.this.answer[QActivity.this.flag])) {
                    QActivity.crt++;
                } else {
                    QActivity.wrg++;
                }
                QActivity.this.flag++;
                if (QActivity.this.flag < QActivity.this.que.length) {
                    QActivity.this.tv.setText(QActivity.this.que[QActivity.this.flag]);
                    QActivity.this.r1.setText(QActivity.this.opt[QActivity.this.flag * 4]);
                    QActivity.this.r2.setText(QActivity.this.opt[(QActivity.this.flag * 4) + 1]);
                    QActivity.this.r3.setText(QActivity.this.opt[(QActivity.this.flag * 4) + 2]);
                    QActivity.this.r4.setText(QActivity.this.opt[(QActivity.this.flag * 4) + 3]);
                } else {
                    QActivity.marks = QActivity.crt;
                    QActivity.this.startActivity(new Intent(QActivity.this.getApplicationContext(), RActivity.class));
                }
                QActivity.this.rg.clearCheck();
            }
        });
        this.quit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                QActivity.this.startActivity(new Intent(QActivity.this.getApplicationContext(), RActivity.class));
            }
        });
    }
}

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

public class OsActivity extends AppCompatActivity {
    public static int crt = 0;
    public static int marks = 0;
    public static int wrg = 0;
    String[] answer = {"Operation code", "1", "a program in execution", "is an access to a page not currently in memory", "spooling", "all of the above", "Terminal Table", "turnaround time", "banker’s algorithm", "only one disk"};
    int flag = 0;
    Button next;
    String[] opt = {"Operation code", "Address", "Locator", "Flip-Flop", "8", "1", "16", "0", "program in High level language kept on disk", "contents of main memory", "a program in execution", "a job in secondary memory", "is an error is a specific page", "occurs when a program accesses a page of memory", "is an access to a page not currently in memory", "is a reference to a page belonging to another program", "multiprogramming", "spooling", "caching", "virtual programming", "semaphores", "event counters", "monitors", "all of the above", "Literal Table", "Identifier Table", "Terminal Table", "Source code", "waiting time", "turnaround time", "response time", "throughput", "banker’s algorithm", "round-robin algorithm", "elevator algorithm", "karn’s algorithm", "only one disk", "all disks simultaneously", "all disks sequentially", "None of these"};
    String[] que = {"1.The part of machine level instruction, which tells the central processor what has to be done is", "2.To avoid the race condition, the number of processes that may be simultaneously inside their critical section is", "3.Process is", "4.A page fault is ", "5.The process of transferring data intended for a peripheral device into a disk (or intermediate store) so that it can be transferred to peripheral at a more convenient time or in bulk, is known as", "6.Producer consumer problem can be solved using", "7.Which is a permanent database in the general model of compiler?", "8.The interval from the time of submission of a process to the time of completion is termed as:", "9.Which one of the following is the deadlock avoidance algorithm?", "10.In RAID level 4, one block read, accesses "};
    Button quit;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioGroup rg;
    TextView score;
    TextView tv;

    public OsActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_os);
        this.tv = (TextView) findViewById(R.id.textView19);
        this.next = (Button) findViewById(R.id.button16);
        this.quit = (Button) findViewById(R.id.button17);
        this.rg = (RadioGroup) findViewById(R.id.radiogroup3);
        this.r1 = (RadioButton) findViewById(R.id.radioButton13);
        this.r2 = (RadioButton) findViewById(R.id.radioButton14);
        this.r3 = (RadioButton) findViewById(R.id.radioButton15);
        this.r4 = (RadioButton) findViewById(R.id.radioButton16);
        this.score = (TextView) findViewById(R.id.textView20);
        this.tv.setText(this.que[this.flag]);
        this.r1.setText(this.opt[0]);
        this.r2.setText(this.opt[1]);
        this.r3.setText(this.opt[2]);
        this.r4.setText(this.opt[3]);
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (OsActivity.this.rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(OsActivity.this.getApplicationContext(), "please choose an option", 1).show();
                    return;
                }
                OsActivity osActivity = OsActivity.this;
                if (((RadioButton) osActivity.findViewById(osActivity.rg.getCheckedRadioButtonId())).getText().toString().equals(OsActivity.this.answer[OsActivity.this.flag])) {
                    OsActivity.crt++;
                } else {
                    OsActivity.wrg++;
                }
                OsActivity.this.flag++;
                if (OsActivity.this.flag < OsActivity.this.que.length) {
                    OsActivity.this.tv.setText(OsActivity.this.que[OsActivity.this.flag]);
                    OsActivity.this.r1.setText(OsActivity.this.opt[OsActivity.this.flag * 4]);
                    OsActivity.this.r2.setText(OsActivity.this.opt[(OsActivity.this.flag * 4) + 1]);
                    OsActivity.this.r3.setText(OsActivity.this.opt[(OsActivity.this.flag * 4) + 2]);
                    OsActivity.this.r4.setText(OsActivity.this.opt[(OsActivity.this.flag * 4) + 3]);
                } else {
                    OsActivity.marks = OsActivity.crt;
                    OsActivity.this.startActivity(new Intent(OsActivity.this.getApplicationContext(), RosActivity.class));
                }
                OsActivity.this.rg.clearCheck();
            }
        });
        this.quit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                OsActivity.this.startActivity(new Intent(OsActivity.this.getApplicationContext(), RosActivity.class));
            }
        });
    }
}

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

public class CnActivity extends AppCompatActivity {
    public static int crt = 0;
    public static int marks = 0;
    public static int wrg = 0;
    String[] answer = {"Bridge", "255.255.255.0", "All of the above", "SMTP", "gateway", "star network", "twice", "twisted-pair wire", "6 Kbps", "zero"};
    int flag = 0;
    Button next;
    String[] opt = {"Router", "Bridge", "Repeater", "Modem", "127.0.0.1", "255.0.0.0", "255.255.0.0", "255.255.255.0", "Slower data transmission", "higher error rate", "interference of transmissions from different computers", "All of the above", "FTP", "SNMP", "SMTP", "RPC", "hub", "bridge", "gateway", "repeater", "bus network", "star network", "ring network", "Point-to-point network", "once", "twice", "three times", "never", "twisted-pair wire", "coaxial cable", "fiber-optic cable", "microwaves", "3 Kbps", "6 Kbps", "12 Kbps", "24 Kbps", "equal to the remainder at the sender", "zero", "nonzero", "the quotient at the sender"};
    String[] que = {"1.Frames from one LAN can be transmitted to another LAN via the device", "2.What is the default subnet mask for a class C network", "3.Which of the following is not a disadvantage of wireless LAN?", "4.Which of the following TCP/IP protocol is used for transferring electronic mail messages from one machine to another?", "5.Which of the following device is used to connect two systems, especially if the systems use different protocols?", "6.A distributed network configuration in which all data/information pass through a central computer is", "7.If you get both local and remote echoes, every character you type will appear on the screen", "8.The slowest transmission speeds are those of", "9.A noiseless 3 KHz Channel transmits bits with binary level signals. What is the maximum data rate?", "10.In CRC there is no error if the remainder at the receiver is"};
    Button quit;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioGroup rg;
    TextView score;
    TextView tv;

    public CnActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_cn);
        this.tv = (TextView) findViewById(R.id.textView15);
        this.next = (Button) findViewById(R.id.button14);
        this.quit = (Button) findViewById(R.id.button15);
        this.rg = (RadioGroup) findViewById(R.id.radiogroup2);
        this.r1 = (RadioButton) findViewById(R.id.radioButton9);
        this.r2 = (RadioButton) findViewById(R.id.radioButton10);
        this.r3 = (RadioButton) findViewById(R.id.radioButton11);
        this.r4 = (RadioButton) findViewById(R.id.radioButton12);
        this.score = (TextView) findViewById(R.id.textView16);
        this.tv.setText(this.que[this.flag]);
        this.r1.setText(this.opt[0]);
        this.r2.setText(this.opt[1]);
        this.r3.setText(this.opt[2]);
        this.r4.setText(this.opt[3]);
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (CnActivity.this.rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(CnActivity.this.getApplicationContext(), "please choose an option", 1).show();
                    return;
                }
                CnActivity cnActivity = CnActivity.this;
                if (((RadioButton) cnActivity.findViewById(cnActivity.rg.getCheckedRadioButtonId())).getText().toString().equals(CnActivity.this.answer[CnActivity.this.flag])) {
                    CnActivity.crt++;
                } else {
                    CnActivity.wrg++;
                }
                CnActivity.this.flag++;
                if (CnActivity.this.flag < CnActivity.this.que.length) {
                    CnActivity.this.tv.setText(CnActivity.this.que[CnActivity.this.flag]);
                    CnActivity.this.r1.setText(CnActivity.this.opt[CnActivity.this.flag * 4]);
                    CnActivity.this.r2.setText(CnActivity.this.opt[(CnActivity.this.flag * 4) + 1]);
                    CnActivity.this.r3.setText(CnActivity.this.opt[(CnActivity.this.flag * 4) + 2]);
                    CnActivity.this.r4.setText(CnActivity.this.opt[(CnActivity.this.flag * 4) + 3]);
                } else {
                    CnActivity.marks = CnActivity.crt;
                    CnActivity.this.startActivity(new Intent(CnActivity.this.getApplicationContext(), RcnActivity.class));
                }
                CnActivity.this.rg.clearCheck();
            }
        });
        this.quit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CnActivity.this.startActivity(new Intent(CnActivity.this.getApplicationContext(), RcnActivity.class));
            }
        });
    }
}

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

public class PythonActivity extends AppCompatActivity {
    public static int crt = 0;
    public static int marks = 0;
    public static int wrg = 0;
    String[] answer = {"list", "A B C D", "Error", "set()", "[‘h’, ‘e’, ‘l’, ‘l’, ‘o’]", "Error", "Address of m", "zero or more", "getopt", "Special methods"};
    int flag = 0;
    Button next;
    String[] opt = {"list", "dictionary", "array", "tuple", "a b c d", "A B C D", "a B C D", "error", "Error", "‘The bright side of life’", "‘The {bright} side {of} {life}’", "No output", "{ }", "set()", "[ ]", "( )", "[‘h’, ‘e’, ‘l’, ‘l’, ‘o’]", "‘hello’", "[‘hello’]", "hello", "snow", "snow world", "Error", "snos world", "[-4, 16]", "Address of m", "Error", "-416", "zero", "one", "zero or more", "one or more", "getopt", "os", "getarg", "main", "Special methods", "In-built methods", "User-defined methods", "Additional methods"};
    String[] que = {"1.What dataype is this L = [1, 23, ‘hello’, 1].", "2.What is the output of the following?\n\nx = 'abcd'\nfor i in x:\n    print(i.upper())", "3.What is the output of the code shown below?\n\n'The {} side {1} {2}'.format('bright', 'of', 'life')", "4.Which of the following statements is used to create an empty set?", "5.What is the output of the following?\n\nprint([i.lower() for i in \"HELLO\"])", "6.What is the output of the following code ?\n\nexample = \"snow world\"\nexample[3] = 's'\nprint example", "7.What is the output of the code shown below?\n\nl=[-2, 4]\nm=map(lambda x:x*2, l)\nprint(m)", "8.How many keyword arguments can be passed to a function in a single function call?", "9.Which module in the python standard library parses options received from the command line?", "10.What are the methods which begin and end with two underscore characters called?"};
    Button quit;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioGroup rg;
    TextView score;
    TextView tv;

    public PythonActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_python);
        this.tv = (TextView) findViewById(R.id.textView23);
        this.next = (Button) findViewById(R.id.button18);
        this.quit = (Button) findViewById(R.id.button19);
        this.rg = (RadioGroup) findViewById(R.id.radiogroup4);
        this.r1 = (RadioButton) findViewById(R.id.radioButton17);
        this.r2 = (RadioButton) findViewById(R.id.radioButton18);
        this.r3 = (RadioButton) findViewById(R.id.radioButton19);
        this.r4 = (RadioButton) findViewById(R.id.radioButton20);
        this.score = (TextView) findViewById(R.id.textView24);
        this.tv.setText(this.que[this.flag]);
        this.r1.setText(this.opt[0]);
        this.r2.setText(this.opt[1]);
        this.r3.setText(this.opt[2]);
        this.r4.setText(this.opt[3]);
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (PythonActivity.this.rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(PythonActivity.this.getApplicationContext(), "please choose an option", 1).show();
                    return;
                }
                PythonActivity pythonActivity = PythonActivity.this;
                if (((RadioButton) pythonActivity.findViewById(pythonActivity.rg.getCheckedRadioButtonId())).getText().toString().equals(PythonActivity.this.answer[PythonActivity.this.flag])) {
                    PythonActivity.crt++;
                } else {
                    PythonActivity.wrg++;
                }
                PythonActivity.this.flag++;
                if (PythonActivity.this.flag < PythonActivity.this.que.length) {
                    PythonActivity.this.tv.setText(PythonActivity.this.que[PythonActivity.this.flag]);
                    PythonActivity.this.r1.setText(PythonActivity.this.opt[PythonActivity.this.flag * 4]);
                    PythonActivity.this.r2.setText(PythonActivity.this.opt[(PythonActivity.this.flag * 4) + 1]);
                    PythonActivity.this.r3.setText(PythonActivity.this.opt[(PythonActivity.this.flag * 4) + 2]);
                    PythonActivity.this.r4.setText(PythonActivity.this.opt[(PythonActivity.this.flag * 4) + 3]);
                } else {
                    PythonActivity.marks = PythonActivity.crt;
                    PythonActivity.this.startActivity(new Intent(PythonActivity.this.getApplicationContext(), RpythonActivity.class));
                }
                PythonActivity.this.rg.clearCheck();
            }
        });
        this.quit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PythonActivity.this.startActivity(new Intent(PythonActivity.this.getApplicationContext(), RpythonActivity.class));
            }
        });
    }
}

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

public class DbmsActivity extends AppCompatActivity {
    public static int crt = 0;
    public static int marks = 0;
    public static int wrg = 0;
    String[] answer = {"A number of tuples.", "Conceptual view", "Open Database Connectivity", "Tree.", "not Null", "DML", "users.", "subschema.", "hash.", "values."};
    int flag = 0;
    Button next;
    String[] opt = {"A number of tuples.", "number of attributes", "A number of tables.", "A number of constraints.", "Conceptual view", "Internal view", "External view", " Physical View", "Object Database Connectivity", "Oral Database Connectivity", "Oracle Database Connectivity", "Open Database Connectivity", "Graph.", "List.", "Links.", "Tree.", "not Null", "Null", "both Null & not Null.", "any value.", "DML", "DDL", "VDL", "SDL", "users.", "separate files.", "database.", "database administrator.", "module.", "relational model.", "schema. ", "subschema.", "hash.", "direct.", "sequential.", "all of the above.", "values.", "distinct values.", "groups.", "columns."};
    String[] que = {"1.In the relational model, cardinality is termed as:", "2.The view of total database content is", "3. ODBC stands for", " 4.In Hierarchical model records are organised as", "5. In case of entity integrity, the primary key maybe", "6.The language used in application programs to request data from the DBMS is referred to as the", "7.The database environment has all of the following components except:", "8.The way a particular application views the data from the database that the application uses is a", "9.The method in which records are physically stored in a specified order according to a key field in each record is", "10.Count function in SQL returns the number of"};
    Button quit;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioGroup rg;
    TextView score;
    TextView tv;

    public DbmsActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_dbms);
        this.tv = (TextView) findViewById(R.id.textView11);
        this.next = (Button) findViewById(R.id.button12);
        this.quit = (Button) findViewById(R.id.button13);
        this.rg = (RadioGroup) findViewById(R.id.radiogroup1);
        this.r1 = (RadioButton) findViewById(R.id.radioButton5);
        this.r2 = (RadioButton) findViewById(R.id.radioButton6);
        this.r3 = (RadioButton) findViewById(R.id.radioButton7);
        this.r4 = (RadioButton) findViewById(R.id.radioButton8);
        this.score = (TextView) findViewById(R.id.textView12);
        this.tv.setText(this.que[this.flag]);
        this.r1.setText(this.opt[0]);
        this.r2.setText(this.opt[1]);
        this.r3.setText(this.opt[2]);
        this.r4.setText(this.opt[3]);
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (DbmsActivity.this.rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(DbmsActivity.this.getApplicationContext(), "please choose an option", 1).show();
                    return;
                }
                DbmsActivity dbmsActivity = DbmsActivity.this;
                if (((RadioButton) dbmsActivity.findViewById(dbmsActivity.rg.getCheckedRadioButtonId())).getText().toString().equals(DbmsActivity.this.answer[DbmsActivity.this.flag])) {
                    DbmsActivity.crt++;
                } else {
                    DbmsActivity.wrg++;
                }
                DbmsActivity.this.flag++;
                if (DbmsActivity.this.flag < DbmsActivity.this.que.length) {
                    DbmsActivity.this.tv.setText(DbmsActivity.this.que[DbmsActivity.this.flag]);
                    DbmsActivity.this.r1.setText(DbmsActivity.this.opt[DbmsActivity.this.flag * 4]);
                    DbmsActivity.this.r2.setText(DbmsActivity.this.opt[(DbmsActivity.this.flag * 4) + 1]);
                    DbmsActivity.this.r3.setText(DbmsActivity.this.opt[(DbmsActivity.this.flag * 4) + 2]);
                    DbmsActivity.this.r4.setText(DbmsActivity.this.opt[(DbmsActivity.this.flag * 4) + 3]);
                } else {
                    DbmsActivity.marks = DbmsActivity.crt;
                    DbmsActivity.this.startActivity(new Intent(DbmsActivity.this.getApplicationContext(), RdbmsActivity.class));
                }
                DbmsActivity.this.rg.clearCheck();
            }
        });
        this.quit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                DbmsActivity.this.startActivity(new Intent(DbmsActivity.this.getApplicationContext(), RdbmsActivity.class));
            }
        });
    }
}

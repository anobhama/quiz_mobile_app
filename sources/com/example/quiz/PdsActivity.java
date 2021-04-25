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

public class PdsActivity extends AppCompatActivity {
    public static int crt = 0;
    public static int marks = 0;
    public static int wrg = 0;
    String[] answer = {"Ancestor node", "Single ended queue", "Last in first out", "vertices, edges", "Linear search", "Depth First", "Tree", "Stack", "Binary tree", "Arrays"};
    int flag = 0;
    Button next;
    String[] opt = {"Ancestor node", "Successor node", "Internal node", "None of the above", "Priority queue", "Circular queue", "Single ended queue", "Ordinary queue", "First in first out", "First in last out", "Last in last out", "Last in first out", "vertices, paths", "vertices, edges", "graph node, edges", "edges, vertices", "Binary search", "Hash Search", "Linear search", "Binary Tree search", "Depth Limited", "Width First", "Breadth First", "Depth First", "Graph", "Tree", "Dequeue", "Priority", "Stack", "Graph", "Trees", "Binary tree", "Queues", "Stacks", "Graphs", "Binary tree", "Arrays", "Stacks", "Records", "None of the above"};
    String[] que = {"1.Any node is the path from the root to the node is called", "2.Which of the following is not the type of queue?", "3.Stack is also called as", "4.A graph is a collection of nodes, called...... And line segments called arcs or ...... that connect pair of nodes", "5.In ........, search start at the beginning of the list and check every element in the list", "6.In the ....... traversal we process all of a vertex’s descendants before we move to an adjacent vertex.", "7.To represent hierarchical relationship between elements, which data structure is suitable?", "8.Which of the following data structure is linear type?", "9.Herder node is used as sentinel in", "10.Which of the following data structure can’t store the non-homogeneous data elements?"};
    Button quit;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    RadioGroup rg;
    TextView score;
    TextView tv;

    public PdsActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_pds);
        this.tv = (TextView) findViewById(R.id.textView27);
        this.next = (Button) findViewById(R.id.button20);
        this.quit = (Button) findViewById(R.id.button21);
        this.rg = (RadioGroup) findViewById(R.id.radiogroup5);
        this.r1 = (RadioButton) findViewById(R.id.radioButton21);
        this.r2 = (RadioButton) findViewById(R.id.radioButton22);
        this.r3 = (RadioButton) findViewById(R.id.radioButton23);
        this.r4 = (RadioButton) findViewById(R.id.radioButton24);
        this.score = (TextView) findViewById(R.id.textView28);
        this.tv.setText(this.que[this.flag]);
        this.r1.setText(this.opt[0]);
        this.r2.setText(this.opt[1]);
        this.r3.setText(this.opt[2]);
        this.r4.setText(this.opt[3]);
        this.next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (PdsActivity.this.rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(PdsActivity.this.getApplicationContext(), "please choose an option", 1).show();
                    return;
                }
                PdsActivity pdsActivity = PdsActivity.this;
                if (((RadioButton) pdsActivity.findViewById(pdsActivity.rg.getCheckedRadioButtonId())).getText().toString().equals(PdsActivity.this.answer[PdsActivity.this.flag])) {
                    PdsActivity.crt++;
                } else {
                    PdsActivity.wrg++;
                }
                PdsActivity.this.flag++;
                if (PdsActivity.this.flag < PdsActivity.this.que.length) {
                    PdsActivity.this.tv.setText(PdsActivity.this.que[PdsActivity.this.flag]);
                    PdsActivity.this.r1.setText(PdsActivity.this.opt[PdsActivity.this.flag * 4]);
                    PdsActivity.this.r2.setText(PdsActivity.this.opt[(PdsActivity.this.flag * 4) + 1]);
                    PdsActivity.this.r3.setText(PdsActivity.this.opt[(PdsActivity.this.flag * 4) + 2]);
                    PdsActivity.this.r4.setText(PdsActivity.this.opt[(PdsActivity.this.flag * 4) + 3]);
                } else {
                    PdsActivity.marks = PdsActivity.crt;
                    PdsActivity.this.startActivity(new Intent(PdsActivity.this.getApplicationContext(), RpdsActivity.class));
                }
                PdsActivity.this.rg.clearCheck();
            }
        });
        this.quit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PdsActivity.this.startActivity(new Intent(PdsActivity.this.getApplicationContext(), RpdsActivity.class));
            }
        });
    }
}

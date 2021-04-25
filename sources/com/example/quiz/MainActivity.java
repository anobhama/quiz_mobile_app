package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button start;
    TextView tv;
    EditText uname;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        getWindow().setFlags(1024, 1024);
        this.uname = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        this.start = button;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (MainActivity.this.uname.getText().toString().matches(BuildConfig.FLAVOR)) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "please enter your name", 0).show();
                    return;
                }
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), TopicActivity.class));
            }
        });
    }
}

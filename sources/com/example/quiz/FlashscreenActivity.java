package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class FlashscreenActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT = 2000;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_flashscreen);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                FlashscreenActivity.this.startActivity(new Intent(FlashscreenActivity.this, MainActivity.class));
                FlashscreenActivity.this.finish();
            }
        }, (long) SPLASH_SCREEN_TIME_OUT);
    }
}

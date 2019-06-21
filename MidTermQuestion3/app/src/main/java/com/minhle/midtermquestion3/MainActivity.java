package com.minhle.midtermquestion3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView statustextView;
    Button button;
    boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize ();

    }

    private void initialize() {
        statustextView = findViewById(R.id.status);
        button = findViewById(R.id.btnDownload);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FooThread thread = new FooThread();
               thread.start();
            }
        });
    }

    public void stop(View view) {
        stopThread = true;
    }

    class FooThread extends Thread {
        @Override
        public void run() {
            for(int i = 0; i <= 100; i++) {
                Log.d("MainActivity", "Starting thread: " + i);
                try {
                    Random rand = new Random();
                    // Work to do which takes 1 seconds to complete
                    int generatedNumber = (int)(Math.random()*100+50);
                    Thread.sleep(generatedNumber);
                    if(i%2==0) {
                        statustextView.setText(String.valueOf(i));
                        //Log.i("key",String.valueOf(i));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


package com.epicodus.muscore;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        @BindView(R.id.goHome)
        Button mGoHome;

//        private ProgressBar pgsBar;
//        private int i = 0;
//        private TextView txtView;
//        private Handler hdlr = new Handler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//            pgsBar = (ProgressBar) findViewById(R.id.pBar);
//            txtView = (TextView) findViewById(R.id.tView);
//            Button btn = (Button) findViewById(R.id.btnShow);
            ButterKnife.bind(this);
            mGoHome.setOnClickListener( this);

//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    i = pgsBar.getProgress();
//                    new Thread(new Runnable() {
//                        public void run() {
//                            while (i < 100) {
//                                i += 1;
//
//
//                                hdlr.post(new Runnable() {
//                                    public void run() {
//                                        pgsBar.setProgress(i);
//                                        txtView.setText(i + "/" + pgsBar.getMax());
//                                    }
//                                });
//                                try {
//                                    // Sleep for 100 milliseconds to show the progress slowly.
//                                    Thread.sleep(100);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    }).start();
//
//                }
//            });
        }

        @Override
        public void onClick(View view) {
            if(view == mGoHome){
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        }

    }

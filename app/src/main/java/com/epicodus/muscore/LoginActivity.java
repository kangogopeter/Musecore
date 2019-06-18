package com.epicodus.muscore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import okhttp3.Response;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity{
        public static final String TAG = LoginActivity.class.getSimpleName();

        private TextView mLocationTextView;

        private ListView mListView;



        private String[] login = new String[] {};


        private String[] logs = new String[] {
        };



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login_main);


            ButterKnife.bind(this);



            mLocationTextView = (TextView) findViewById(R.id.locationTextView);



            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String restaurant = ((TextView)view).getText().toString();
                    Toast.makeText(LoginActivity.this, restaurant, Toast.LENGTH_LONG).show();
                    Log.v(TAG, "IN the onItemClickListener!");

                }
            });



            Intent intent = getIntent();
            String location = intent.getStringExtra("location");
            mLocationTextView.setText("Here are all the restaurants near: " + location);
            Log.d(TAG, "In the onCreate method !");

        }
}

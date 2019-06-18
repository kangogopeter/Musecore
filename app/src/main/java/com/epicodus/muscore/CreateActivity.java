package com.epicodus.muscore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import okhttp3.Response;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CreateActivity extends  AppCompatActivity{
        public static final String TAG = CreateActivity.class.getSimpleName();

        private TextView mLocationTextView;

        private CheckBox mCheckBox;


        private String[] signup = new String[]{};


        private String[] account = new String[]{
        };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sign_up);


            ButterKnife.bind(this);


            mCheckBox = (CheckBox) findViewById(R.id.checkBox);
            mLocationTextView = (TextView) findViewById(R.id.locationTextView);


//
//            mCheckBox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    String restaurant = ((TextView) view).getText().toString();
//                    Toast.makeText(CreateActivity.this, restaurant, Toast.LENGTH_LONG).show();
//                    Log.v(TAG, "IN the onItemClickListener!");
//
//                }
//            });


            Intent intent = getIntent();
            String location = intent.getStringExtra("location");
            mLocationTextView.setText("Create Account " + location);
            Log.d(TAG, "In the onCreate method !");

        }

    }


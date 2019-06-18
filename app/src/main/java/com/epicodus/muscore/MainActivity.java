package com.epicodus.muscore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.findSigninButton)
    Button mFindSigninButton;
    @BindView(R.id.findLoginButton)
    Button mFindLoginButton;
    TextView mLocationEditText;

    public static final String TAG = MainActivity.class.getSimpleName();

//    private Button mFindSigninButton;
//    private Button mFindLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mFindLoginButton = (Button) findViewById(R.id.findLoginButton);
        mFindSigninButton = (Button) findViewById(R.id.findSigninButton);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        mFindLoginButton = (Button) findViewById(R.id.findLoginButton);
        mFindSigninButton = (Button) findViewById(R.id.findSigninButton);




        mFindLoginButton.setOnClickListener(this);
        mFindSigninButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mFindLoginButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);

        }
    }


}
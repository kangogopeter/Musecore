package com.epicodus.muscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.muscore.ui.CreateAccountActivity;
import com.epicodus.muscore.ui.LoginActvivity;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.loginPart)
    Button mLoginPart;
    @BindView(R.id.signinPart)
    Button mSigninPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        mLoginPart.setOnClickListener(this);
        mSigninPart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view == mLoginPart){
            Intent intent = new Intent(MenuActivity.this, CreateAccountActivity.class);
            startActivity(intent);
            finish();
        }
        if(view == mSigninPart){
            Intent intent = new Intent(MenuActivity.this, LoginActvivity.class);
            startActivity(intent);
            finish();
        }

    }

}
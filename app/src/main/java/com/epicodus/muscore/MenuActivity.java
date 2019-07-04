package com.epicodus.muscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.findSigninButton)
    Button mFindSigninButton;
    @BindView(R.id.findCreateAccountButton)
    Button mFindCreateAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);
        mFindSigninButton.setOnClickListener(this);
        mFindCreateAccountButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mFindSigninButton) {
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mFindCreateAccountButton) {
            Intent intent = new Intent(MenuActivity.this, CreateAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
package com.epicodus.muscore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.epicodus.muscore.R;

public class LoginActvivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.registerTextView)
    TextView mRegisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_actvivity);

        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);
    }



    @Override
    public void onClick(View view){
        if(view == mRegisterTextView){
            Intent intent = new Intent(LoginActivity.this, OptionActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

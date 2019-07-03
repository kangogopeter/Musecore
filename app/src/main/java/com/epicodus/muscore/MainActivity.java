package com.epicodus.muscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.muscore.ui.YoutubeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.registerTextView)
    Button mRegisterTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view == mRegisterTextView){
            Intent intent = new Intent(MainActivity.this, YoutubeActivity.class);
            startActivity(intent);
            finish();
        }
    }

}

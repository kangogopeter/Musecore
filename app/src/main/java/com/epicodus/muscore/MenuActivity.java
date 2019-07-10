package com.epicodus.muscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.muscore.ui.CreateAccountActivity;
import com.epicodus.muscore.ui.LoginActvivity;
import com.google.firebase.auth.FirebaseAuth;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MenuActivity.this, LoginActvivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
package com.epicodus.muscore.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.muscore.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MusiqActivity extends AppCompatActivity {
    private DatabaseReference myDatabasej;
    private DatabaseReference myDatabasea;
    private DatabaseReference myDatabaseb;
    private DatabaseReference myDatabasec;
    private DatabaseReference myDatabased;
    private DatabaseReference myDatabasee;
    private DatabaseReference myDatabasef;
    private DatabaseReference myDatabaseg;
    private DatabaseReference myDatabaseh;
    private DatabaseReference myDatabasei;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musiq);

        myDatabasej = FirebaseDatabase.getInstance().getReference("Message0");
        myDatabasea = FirebaseDatabase.getInstance().getReference("Message1");
        myDatabaseb = FirebaseDatabase.getInstance().getReference("Message2");
        myDatabasec = FirebaseDatabase.getInstance().getReference("Message3");
        myDatabased = FirebaseDatabase.getInstance().getReference("Message4");
        myDatabasee = FirebaseDatabase.getInstance().getReference("Message5");
        myDatabasef = FirebaseDatabase.getInstance().getReference("Message6");
        myDatabaseg = FirebaseDatabase.getInstance().getReference("Message7");
        myDatabaseh = FirebaseDatabase.getInstance().getReference("Message8");
        myDatabasei = FirebaseDatabase.getInstance().getReference("Message9");

        final TextView myTextl = findViewById(R.id.textViewJ);
        final TextView myTexta = findViewById(R.id.textViewA);
        final TextView myTextb = findViewById(R.id.textViewB);
        final TextView myTextc = findViewById(R.id.textViewC);
        final TextView myTextd = findViewById(R.id.textViewD);
        final TextView myTexte = findViewById(R.id.textViewE);
        final TextView myTextf = findViewById(R.id.textViewF);
        final TextView myTextg = findViewById(R.id.textViewG);
        final TextView myTexth = findViewById(R.id.textViewH);
        final TextView myTexti = findViewById(R.id.textViewI);


        //myDatabasej = Message0.... = myTextl....
        myDatabasej.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTextl.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTextl.setText("CANCELLED");

            }
        });

        //myDatabasea = Message1.... = myTexta....

        myDatabasea.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTexta.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTexta.setText("CANCELLED");

            }
        });

        //myDatabaseb = Message2.... = myTextb....

        myDatabaseb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTextb.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTextb.setText("CANCELLED");

            }
        });

        //myDatabasec = Message3.... = myTextc....

        myDatabasec.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTextc.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTextc.setText("CANCELLED");

            }
        });

        //myDatabased = Message4.... = myTextd....

        myDatabased.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTextd.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTextd.setText("CANCELLED");

            }
        });

        //myDatabasee = Message5.... = myTexte....

        myDatabasee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTexte.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTexte.setText("CANCELLED");

            }
        });

        //myDatabasef = Message6.... = myTextf....

        myDatabasef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTextf.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTextf.setText("CANCELLED");

            }
        });

        //myDatabaseg = Message7.... = myTextg....

        myDatabaseg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTextg.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTextg.setText("CANCELLED");

            }
        });

        //myDatabaseh = Message8.... = myTexth....

        myDatabaseh.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTexth.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTexth.setText("CANCELLED");

            }
        });

        //myDatabasei = Message9.... = myTexti....

        myDatabasei.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myTexti.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myTexti.setText("CANCELLED");

            }
        });

    }

    public void sendMessage(View view){

        EditText myEditText1 = findViewById(R.id.editTexta);
        myDatabasea.setValue(myEditText1.getText().toString());
        myEditTexta.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText2 = findViewById(R.id.editTextb);
        myDatabaseb.setValue(myEditText2.getText().toString());
        myEditTextb.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText3 = findViewById(R.id.editTextc);
        myDatabasec.setValue(myEditText3.getText().toString());
        myEditTextc.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText4 = findViewById(R.id.editTextd);
        myDatabased.setValue(myEditText4.getText().toString());
        myEditTextd.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText5 = findViewById(R.id.editTexte);
        myDatabasee.setValue(myEditText5.getText().toString());
        myEditTexte.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText6 = findViewById(R.id.editTextf);
        myDatabasef.setValue(myEditText6.getText().toString());
        myEditTextf.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText7 = findViewById(R.id.editTextg);
        myDatabaseg.setValue(myEditText7.getText().toString());
        myEditTextg.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText8 = findViewById(R.id.editTexth);
        myDatabaseh.setValue(myEditText8.getText().toString());
        myEditTexth.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText9 = findViewById(R.id.editTexti);
        myDatabasei.setValue(myEditText9.getText().toString());
        myEditTexti.setText("");
    }

    public void sendMessage(View view){

        EditText myEditText10 = findViewById(R.id.editTextj);
        myDatabasej.setValue(myEditText10.getText().toString());
        myEditTextj.setText("");
    }

}

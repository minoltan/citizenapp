package com.example.minoltan.citizenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private EditText mUsername;
    private DatabaseReference mDatabase;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mUsername = (EditText) findViewById(R.id.Username);
        mRegister = (Button) findViewById(R.id.Register);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Name").setValue("Minoltan");

            }
        });
    }
}

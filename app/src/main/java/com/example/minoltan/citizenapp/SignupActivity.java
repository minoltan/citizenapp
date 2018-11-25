package com.example.minoltan.citizenapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {
    private EditText mUsername, mEmail, mPhone, mPassword;
    private DatabaseReference mDatabase;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mUsername = (EditText) findViewById(R.id.Username);
        mEmail = (EditText) findViewById(R.id.Email);
        mPhone = (EditText) findViewById(R.id.Phone);
        mPassword = (EditText) findViewById(R.id.Password);
        mRegister = (Button) findViewById(R.id.Register);



        mDatabase = FirebaseDatabase.getInstance().getReference().child("User_01");



        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mUsername.getText().toString().trim();
                String email = mEmail.getText().toString().trim();

                HashMap<String,String> datamap = new HashMap<String, String>();
                datamap.put("Name", name);
                datamap.put("Email", email);


                mDatabase.push().setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignupActivity.this, "Registered Succesfully", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(SignupActivity.this, "Registere Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }
}

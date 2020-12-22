package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // These are the global variables
        EditText username, phone, password, confirmPass;
        Button btnSignup, btnLogin;
        DbAccount DB;

        username  = (EditText) findViewById(R.id.username);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        confirmPass = (EditText) findViewById(R.id.confirmPass);

        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        DB = new DbAccount(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String phoneNum  = phone.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirmPass.getText().toString();

                if(user.equals("") || phoneNum.equals("")|| pass.equals("")|| confirm.equals("")){
                    Toast.makeText(MainActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();

                }else{
                    if(pass.equals(confirm)){
                        Boolean checkUser = DB.checkUsername(user);
                        if(checkUser == false){
                            Boolean insert = DB.addUser(user, pass, phoneNum);
                            if(insert == true){
                                Toast.makeText(MainActivity.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
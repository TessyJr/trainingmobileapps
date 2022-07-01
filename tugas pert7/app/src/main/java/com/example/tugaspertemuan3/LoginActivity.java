package com.example.tugaspertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnRegister;
    EditText loginUsername, loginPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        loginUsername = findViewById(R.id.et_username);
        loginPassword = findViewById(R.id.et_password);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        btnLogin.setOnClickListener(v ->{
            if(!loginUsername.getText().toString().equals(sharedPref.getString("account_username", "")) || !loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))){
                Toast.makeText(LoginActivity.this, "Invalid Username or Password!", Toast.LENGTH_SHORT).show();
            }else if(loginUsername.getText().toString().equals(sharedPref.getString("account_username", "")) && loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))){
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                loginIntent.putExtra("account_username", sharedPref.getString("account_username",""));
                startActivity(loginIntent);
            }
        });

        btnRegister.setOnClickListener(v ->{
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });
    }
}
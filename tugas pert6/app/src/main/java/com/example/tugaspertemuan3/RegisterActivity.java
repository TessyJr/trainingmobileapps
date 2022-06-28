package com.example.tugaspertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister, btnCancel;
    EditText registerUsername, registerPassword;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsername  = findViewById(R.id.et_registerUsername);
        registerPassword = findViewById(R.id.et_registerPassword);
        btnRegister = findViewById(R.id.btn_register);
        btnCancel = findViewById(R.id.btn_cancel);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        btnRegister.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("account_username", registerUsername.getText().toString());
            editor.putString("account_password", registerPassword.getText().toString());
            editor.apply();

            Toast.makeText(RegisterActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();

            Intent registerIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(registerIntent);
        });

        btnCancel.setOnClickListener(v ->{
            Intent cancelIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(cancelIntent);
        });
    }
}
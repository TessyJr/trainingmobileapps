package com.example.tugaspertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnLogout;
    TextView helloUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloUser = findViewById(R.id.tv_helloUser);
        btnLogout = findViewById(R.id.btn_logout);

        Intent intent = getIntent();
        String tempUsername = intent.getStringExtra("account_username");

        helloUser.setText("Hello, " + tempUsername);

        btnLogout.setOnClickListener(v ->{
            Intent logoutIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
        });
    }
}
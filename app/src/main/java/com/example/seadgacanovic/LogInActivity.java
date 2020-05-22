package com.example.seadgacanovic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    private EditText userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        userName = findViewById(R.id.userText);
        password = findViewById(R.id.passText);
    }

    public void checkLogIn(View view){
        users users = new users(userName.getText().toString(),password.getText().toString());
        UsersDatabase.getAppDatabase(this).usedDao().insertSingleUser(users);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void register(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}

package com.example.seadgacanovic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LogInActivity extends AppCompatActivity {
    private EditText userName, password;
    Button signIn;
    public static final String EXTRA_CUSTOMERS_ID = "LoginActivity/EXTRA_CUSTOMERS_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.passText);
        signIn = findViewById(R.id.loginButton);
    }

    public void checkLogIn(View view){
        if(userName.getText().toString().equals("") || password.getText().toString().equals("")) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
        } else {

            List<users> customers = UsersDatabase.getAppDatabase(this).usedDao().getAll();
            int k = 1;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUsername().equals(userName.getText().toString()) && customers.get(i).getPassword().equals(password.getText().toString())) {
                    k = 0;
                    Intent intent = new Intent(this, MainActivity.class);
                    int customerId = i + 1;
                    intent.putExtra(EXTRA_CUSTOMERS_ID, customerId);
                    startActivity(intent);

                }
            }
            if (k == 1) {
                Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_LONG).show();
            }
        }

    }
    public void register(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}

package com.example.seadgacanovic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, username, password, surname, DoB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name=findViewById(R.id.Name);
        username=findViewById(R.id.userName);
        surname=findViewById(R.id.userSurname);
        password=findViewById(R.id.userPass);
        DoB=findViewById(R.id.userDoB);
    }
    public void onReg(View view){
        int j=0;
        String username_check = username.getText().toString();
        List<users> customers = UsersDatabase.getAppDatabase(this).usedDao().getAll();
        for(int i = 0; i < customers.size();i++){
            if(customers.get(i).getUsername().equals(username_check)){
                j=j+1;
            }
        }
        if(j==0){
            users user = new users(name.getText().toString(),surname.getText().toString(),DoB.getText().toString(),username.getText().toString(), password.getText().toString());
            UsersDatabase.getAppDatabase(this).usedDao().insertSingleUser(user);
            Intent intent = new Intent(this,LogInActivity.class);
            startActivity(intent);

        }else{ Toast.makeText(this,"Username already exists",Toast.LENGTH_LONG).show();  }

    }

    @Override
    public void finish() {
        super.finish();
    }
}

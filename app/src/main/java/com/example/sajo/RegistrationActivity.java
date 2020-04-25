package com.example.sajo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sajo.data.model.registerstudent;
import com.example.sajo.database.RegisterDatabase;
import com.example.sajo.ui.login.LoginActivity;

public class RegistrationActivity extends AppCompatActivity {

    RegisterDatabase registerDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_registration);

        Button signup = findViewById(R.id.signup);
        EditText stdname = findViewById(R.id.student_name);
        EditText stdemail = findViewById(R.id.student_email);
        EditText stdpass = findViewById(R.id.student_password);

        registerDatabase = RegisterDatabase.getDatabaseInstance(getApplicationContext());

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = stdname.getText().toString() ;
                String Email = stdemail.getText().toString() ;
                String Password = stdpass.getText().toString() ;

                registerstudent registerstudent  = new registerstudent(Name,Email,Password);
                 registerDatabase.registrationDao().registerstudent(registerstudent);
                Toast.makeText(RegistrationActivity.this, "Student Registered successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

    }
}

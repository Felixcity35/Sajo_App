package com.example.sajo.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sajo.R;
import com.example.sajo.RegistrationActivity;
import com.example.sajo.StudentDashboardActivity;
import com.example.sajo.data.model.registerstudent;
import com.example.sajo.database.RegisterDatabase;
import com.example.sajo.organisationActivity;
import com.example.sajo.ui.login.LoginViewModel;
import com.example.sajo.ui.login.LoginViewModelFactory;

public class LoginActivity extends AppCompatActivity {

    RegisterDatabase registerDatabase ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerDatabase = RegisterDatabase.getDatabaseInstance(getApplicationContext());

        EditText stdemail = findViewById(R.id.email);
        EditText stdpass = findViewById(R.id.password);
        ImageView loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = stdemail.getText().toString() ;
                String Password = stdpass.getText().toString() ;

                registerstudent registerstudent = registerDatabase.registrationDao().getDetails(Email);
                 if (registerstudent.getPassword().equalsIgnoreCase(Password))
                 {
                     Toast.makeText(LoginActivity.this, "Login Success ", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(getApplicationContext(), StudentDashboardActivity.class));
                 }else
                 {
                     Toast.makeText(LoginActivity.this, "Wrong Email or Password ", Toast.LENGTH_SHORT).show();
                 }
            }
        });

    }

    public void gotoreg(View view)
    {
        startActivity(new Intent(getApplicationContext(), organisationActivity.class));
    }

    public void regStudent(View view)
    {
        startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
    }
}
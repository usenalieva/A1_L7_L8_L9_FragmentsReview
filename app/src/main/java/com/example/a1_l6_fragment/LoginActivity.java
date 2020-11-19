package com.example.a1_l6_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;

    private static final Pattern PATTERN_PASSWORD =
            Pattern.compile(
                    //"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$");
            "0000"
            );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        login.setOnClickListener(view -> {
            if (isValidEmail(email.getText().toString()) && PATTERN_PASSWORD.matcher(password.getText().toString()).matches()) {
                Intent intent = new Intent(LoginActivity.this, ApplicationActivity.class);
                startActivity(intent);
            }
            if(!PATTERN_PASSWORD.matcher(password.getText().toString()).matches()) {
                Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_LONG).show();
            }
            if (!isValidEmail(email.getText().toString())) {
                Toast.makeText(LoginActivity.this, "Wrong email", Toast.LENGTH_LONG).show();

            }

        });
    }

    private void init() {
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);

    }

    public static boolean isValidEmail (String email) {

        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
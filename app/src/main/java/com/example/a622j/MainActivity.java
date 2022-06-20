package com.example.a622j;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edit_name, edit_email, edit_password, edit_passwordConfirm;
    private TextView load_name, load_email, load_psw, load_pswC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        edit_passwordConfirm = findViewById(R.id.edit_passwordConfirm);

        load_name = findViewById(R.id.load_name);
        load_email = findViewById(R.id.load_email);
        load_psw = findViewById(R.id.load_psw);
        load_pswC = findViewById(R.id.load_pswC);

        save();
        load();
    }

    private void save() {
        Button button_register = findViewById(R.id.button_register);
        button_register.setOnClickListener(view -> {
            SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("name", edit_name.getText().toString());
            editor.putString("email", edit_email.getText().toString());
            editor.putString("psw", edit_password.getText().toString());
            editor.putString("psw_c", edit_passwordConfirm.getText().toString());
            editor.apply();
        });
    }

    @SuppressLint("SetTextI18n")
    private void load() {
        Button button_load = findViewById(R.id.button_load);
        button_load.setOnClickListener(view -> {
            SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            String name = prefs.getString("name", null);
            String email = prefs.getString("email", null);
            String psw = prefs.getString("psw", null);
            String psw_c = prefs.getString("psw_c", null);
            if (name != null || email != null || psw != null || psw_c != null) {
                load_name.setText("Full name: " + name);
                load_email.setText("Email : " + email);
                load_psw.setText("Password : " + psw);
                load_pswC.setText("Password Confirm : " + psw_c);
            }
        });

    }

    void clearAll() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}
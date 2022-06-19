package com.example.a622j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edit_name, edit_email, edit_password, edit_passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        edit_passwordConfirm = findViewById(R.id.edit_passwordConfirm);
        init();
    }

    private void init() {
        Button button_register = findViewById(R.id.button_register);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit_name.getText().toString();
                String email = edit_email.getText().toString();
                String psw = edit_password.getText().toString();
                String psw_conf = edit_passwordConfirm.getText().toString();

                saveName(name);
                saveEmailData(email);
                savePswData(psw);
                savePswdData(psw_conf);
//                clearAll();
            }
        });
    }

    void saveName(String name) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", name);
        editor.apply();
    }

    void saveEmailData(String email) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", email);
        editor.apply();
    }

    void savePswData(String psw) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("psw", psw);
        editor.apply();
    }

    void savePswdData(String psw_conf) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("psw_conf", psw_conf);
        editor.apply();
    }
    void clearAll() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}
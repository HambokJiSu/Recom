package com.adflyercompany.recom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = (EditText) findViewById(R.id.editText_email);
        txtPass = (EditText) findViewById(R.id.editText_password);
    }

    public void onLoginClick(View view){
        if ("chan@gmail.com".equals(txtEmail.getText().toString()) == false || "chanTest!1".equals(txtPass.getText().toString()) == false) {
            Toast.makeText(getApplicationContext(), R.string.login_failed,Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("login", "S");

        startActivity(intent);
    }
}
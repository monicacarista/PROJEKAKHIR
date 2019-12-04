package com.example.projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectakhir.CRUDDosen.DosenActivity;

public class MainActivity extends AppCompatActivity {
    EditText email, pass;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.txtEmail);
        pass = (EditText) findViewById(R.id.txtPass);
        login = (Button) findViewById(R.id.btnSignIn);
        sharedPreferences = getSharedPreferences("loginref", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        savelogin = sharedPreferences.getBoolean("savelogin", true);
        if (savelogin == true) {
            email.setText(sharedPreferences.getString("username", null));
            pass.setText(sharedPreferences.getString("password", null));
        }
    }


    public void login() {
        String emaail = email.getText().toString();
        String password = pass.getText().toString();
        if (emaail.contains("@si.ukdw.ac.id") ) {
            editor.putString("isLogin","Dos");
            editor.commit();
            Intent i = new Intent(MainActivity.this, DosenActivity.class);
            startActivity(i);


        } else if (emaail.contains("@staff.ac.id")) {
            editor.putString("isLogin","Admin");
            editor.commit();
            Intent i = new Intent(MainActivity.this, AdminActivity.class);
            startActivity(i);

        } else {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
        }
    }
}
package com.kerjasama1.uasmobileprom_06tple009;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    TextView textFullName, textEmail;
    Button buttonLogout;
    SharedPreferences sharedPreferences;

    // Creating a Shared preferences name and also creating key's name
    private static final String SHARED_PREF_NAME = "loginSession";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textFullName = findViewById(R.id.textFullName);
        textEmail = findViewById(R.id.textEmail);
        buttonLogout = findViewById(R.id.buttonLogout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        // Getting Full Name and Email value from shared preferences
        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        if(name != null || email != null){
            // So you must set the data on textView
            textFullName.setText("Full Name - " + name);
            textEmail.setText("Email - " + email);
        }

        // Calling logout button
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                finish();

                Toast.makeText(Dashboard.this, "LOGOUT", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
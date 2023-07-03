package com.kerjasama1.uasmobileprom_06tple009;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Creating objects
    EditText editTextName, editTextEmail;
    Button buttonLogin;
    SharedPreferences sharedPreferences;

    // Creating a Shared preferences name and also creating key's name
    private static final String SHARED_PREF_NAME = "loginSession";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Using findViewById() for getting android:id from XML
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Obtaining instance of "SharedPreferences"
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        // When open login form, check is shared preferences data available or not
        String name = sharedPreferences.getString(KEY_NAME, null);
        if(name != null) {
            // If data is available, it will directly call on Dashboard
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            startActivity(intent);
        }

        // Creating a listener function for LOGIN
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When click a button, put data on Shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, editTextName.getText().toString());
                editor.putString(KEY_EMAIL, editTextEmail.getText().toString());
                editor.apply();

                // After click LOGIN button, it redirect to Dashboard
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);

                // Creating Toast for displaying notification that we success doing login
                Toast.makeText(MainActivity.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
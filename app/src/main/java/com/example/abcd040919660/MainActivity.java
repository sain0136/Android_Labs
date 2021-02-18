package com.example.abcd040919660;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs = null;
    @Override
    protected void onPause() {
        super.onPause();
        EditText typeField = findViewById(R.id.plain_text_input);
        saveSharedPrefs(typeField.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear_email);
        prefs = getSharedPreferences("FileName", Context.MODE_PRIVATE);
        String savedString = prefs.getString("Email", "");
        EditText typeField = findViewById(R.id.plain_text_input);
        typeField.setText(savedString);
        Button loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(bt -> {
            Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
            goToProfile.putExtra("Email",typeField.getText().toString());
            startActivity(goToProfile);
        });

        /*Switch toggle = (Switch) findViewById(R.id.switch4);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Snackbar.make(buttonView, "The switch is now on", Snackbar.LENGTH_SHORT)
                            .show();
                } else {
                    Snackbar.make(buttonView, "The switch is now off", Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
    *//** Called when the user touches the button *//*
    public void sendMessage(View view) {
        Toast.makeText(MainActivity.this, "Here is more information", Toast.LENGTH_SHORT).show();    }*/
    }
    private void saveSharedPrefs(String stringToSave) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Email", stringToSave);
        editor.commit();
    }
}
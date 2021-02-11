package com.example.abcd040919660;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid );
        Switch toggle = (Switch) findViewById(R.id.switch4);
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
    /** Called when the user touches the button */
    public void sendMessage(View view) {
        Toast.makeText(MainActivity.this, "Here is more information", Toast.LENGTH_SHORT).show();    }
}

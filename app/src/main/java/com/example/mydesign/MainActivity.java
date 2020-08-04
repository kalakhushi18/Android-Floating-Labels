package com.example.mydesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textusername;
    private TextInputLayout textpassword;
    private TextInputLayout textemail;
    private ConstraintLayout constraintLayout;
    TextView sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textemail = findViewById(R.id.textemail);
        textpassword = findViewById(R.id.textpassword);
        textusername = findViewById(R.id.textusername);
        sign = findViewById(R.id.textView);

        Switch s = findViewById(R.id.s);
        constraintLayout = findViewById(R.id.constrain);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    constraintLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    Toast.makeText(getApplicationContext(), "Dark mode On!", Toast.LENGTH_SHORT).show();
                    sign.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                } else {
                    sign.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    constraintLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                }
            }
        });

    }

    private boolean emailvalidate() {

        String email = textemail.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            textemail.setError("Field can't be empty");
            return false;
        } else {
            textemail.setError(null);
            return true;
        }
    }

    private boolean uservalidate() {

        String name = textusername.getEditText().getText().toString().trim();
        if (name.isEmpty()) {

            textusername.setError("Field can't be empty ");
            return false;
        } else {
            textusername.setError(null);
            return true;
        }
    }

    private boolean userpswd() {

        String name = textpassword.getEditText().getText().toString().trim();
        if (name.isEmpty()) {

            textpassword.setError("Field can't be empty ");
            return false;
        } else {
            textpassword.setError(null);
            return true;
        }
    }


    public void on(View v) {

        if (!emailvalidate() | !uservalidate() | !userpswd()) {
            return;

        }

        Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
    }

}
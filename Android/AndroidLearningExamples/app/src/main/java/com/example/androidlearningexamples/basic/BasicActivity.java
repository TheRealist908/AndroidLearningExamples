package com.example.androidlearningexamples.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidlearningexamples.R;

public class BasicActivity extends AppCompatActivity {
    private TextView name, address, email, phone, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the button's OnClickListener
        Button btnSave = findViewById(R.id.bf_btn_Save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = findViewById(R.id.bf_et_ContactName);
                address = findViewById(R.id.bf_et_Address);
                email = findViewById(R.id.bf_et_EmailAddress);
                phone = findViewById(R.id.bf_et_Phone);
                dob = findViewById(R.id.bf_et_DOB);

                // Create the new activity
                Intent intent = new Intent(v.getContext(),BasicActivityDetails.class);

                // Add data from this Activity to next Activity
                intent.putExtra("PARAM_NAME",name.getText().toString());
                intent.putExtra("PARAM_ADDRESS", address.getText().toString());
                intent.putExtra("PARAM_EMAIL", email.getText().toString());
                intent.putExtra("PARAM_PHONE",phone.getText().toString());
                intent.putExtra("PARAM_DOB",dob.getText().toString());

                // Start the new Activity
                startActivity(intent);
            }
        });

    }

    // Todo: Add onPause() method to persist the data or do something else with it that is fun
    // Todo: Add onRestart() method to refill the form with the data or do something else handy
}

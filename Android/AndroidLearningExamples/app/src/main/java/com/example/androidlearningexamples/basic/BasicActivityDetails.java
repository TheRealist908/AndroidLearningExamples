package com.example.androidlearningexamples.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.androidlearningexamples.R;

public class BasicActivityDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Todo: Would love to create this confirmation page dynamically rather than predetermined

        // First, need to get this Intent
        Intent intent = getIntent();

        // Get the parameter (extra) data
        String pName = intent.getStringExtra("PARAM_NAME");
        String pAddress = intent.getStringExtra("PARAM_ADDRESS");
        String pEmail = intent.getStringExtra("PARAM_EMAIL");
        String pPhone = intent.getStringExtra("PARAM_PHONE");
        String pDob = intent.getStringExtra("PARAM_DOB");

        // Find the fields in the Activity
        TextView tvName = findViewById(R.id.bad_tv_Name);
        TextView tvAddress = findViewById(R.id.bad_tv_Address);
        TextView tvEmail = findViewById(R.id.bad_tv_Email);
        TextView tvPhone = findViewById(R.id.bad_tv_Phone);
        TextView tvDob = findViewById(R.id.bad_tv_DOB);

        // Display the text in the Activity fields
        tvName.setText(pName);
        tvAddress.setText(pAddress);
        tvEmail.setText(pEmail);
        tvPhone.setText(pPhone);
        tvDob.setText(pDob);
    }

}

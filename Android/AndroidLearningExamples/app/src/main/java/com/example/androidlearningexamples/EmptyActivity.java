package com.example.androidlearningexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        String title = this.getIntent().getExtras().getString("NAME");
        TextView tv = findViewById(R.id.tvActivityParameter);
        tv.setText(title);
        //Comment test to see if branching is working.
    }
}

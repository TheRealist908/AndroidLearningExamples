package com.example.androidlearningexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EmptyActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        String title = this.getIntent().getExtras().getString("NAME");
        tv = (TextView) findViewById(R.id.tvActivityParameter);
        tv.setText(title);
    }
}

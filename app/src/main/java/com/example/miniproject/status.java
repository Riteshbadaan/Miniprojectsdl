package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.miniproject.Navigation1.statusc;
import static com.example.miniproject.Navigation1.statusc1;
import static com.example.miniproject.Navigation1.statusjava;

public class status extends AppCompatActivity {

    int arr1234[],j;
    TextView c,c1,java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        c=findViewById(R.id.statusc);
        c1=findViewById(R.id.statusc1);
        java=findViewById(R.id.statusjava);

        getSupportActionBar().setTitle("Status");
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if(statusc>=400) {
            c.setText("You are a pro!");
            c.setBackgroundColor(Color.parseColor("#24562B"));
        }
        else if(statusc>=200 && statusc<400) {
            c.setText("You're almost at the top!");
            c.setBackgroundColor(Color.parseColor("#FFE338"));
        }
        else if(statusc>0 && statusc<200) {
            c.setBackgroundColor(Color.parseColor("#D61A3C"));
            c.setText("You need to work hard!");
        }
        else {
            c.setText("Start solving now!");
        }

        if(statusc1>=400) {
            c1.setText("You are a pro!");
            c1.setBackgroundColor(Color.parseColor("#24562B"));
        }
        else if(statusc1>=200 && statusc1<400) {
            c1.setText("You're almost at the top!");
            c1.setBackgroundColor(Color.parseColor("#FFE338"));
        }
        else if(statusc1>0 && statusc1<200) {
            c1.setBackgroundColor(Color.parseColor("#D61A3C"));
            c1.setText("You need to work hard!");
        }
        else {
            c1.setText("Start solving now!");
        }

        if(statusjava>=400) {
            java.setText("You are a pro!");
            java.setBackgroundColor(Color.parseColor("#24562B"));
        }
        else if(statusjava>=200 && statusjava<400) {
            java.setText("You're almost at the top!");
            java.setBackgroundColor(Color.parseColor("#FFE338"));
        }
        else if(statusjava>0 && statusjava<200) {
            java.setBackgroundColor(Color.parseColor("#D61A3C"));
            java.setText("You need to work hard!");
        }
        else {
            java.setText("Start solving now!");
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

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
    String cs,c1s,javas;

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
            cs="You are a pro!";
            c.setBackgroundColor(Color.parseColor("#24562B"));
        }
        else if(statusc>=200 && statusc<400) {
            cs="You're almost at the top!";
            c.setBackgroundColor(Color.parseColor("#FFE338"));
        }
        else if(statusc>0 && statusc<200) {
            c.setBackgroundColor(Color.parseColor("#D61A3C"));
            cs="You need to work hard!";
        }
        else {
            cs="Start solving now!";
        }
        c.setText(cs+" ("+statusc+"/450)");
        if(statusc1>=400) {
            c1s="You are a pro!";
            c1.setBackgroundColor(Color.parseColor("#24562B"));
        }
        else if(statusc1>=200 && statusc1<400) {
            c1s="You're almost at the top!";
            c1.setBackgroundColor(Color.parseColor("#FFE338"));
        }
        else if(statusc1>0 && statusc1<200) {
            c1.setBackgroundColor(Color.parseColor("#D61A3C"));
            c1s="You need to work hard!";
        }
        else {
            c1s="Start solving now!";
        }
        c1.setText(c1s+" ("+statusc1+"/450)");

        if(statusjava>=400) {
            javas="You are a pro!";
            java.setBackgroundColor(Color.parseColor("#24562B"));
        }
        else if(statusjava>=200 && statusjava<400) {
            javas="You're almost at the top!";
            java.setBackgroundColor(Color.parseColor("#FFE338"));
        }
        else if(statusjava>0 && statusjava<200) {
            java.setBackgroundColor(Color.parseColor("#D61A3C"));
            javas="You need to work hard!";
        }
        else {
            javas="Start solving now!";
        }
        java.setText(javas+" ("+statusjava+"/450)");
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import static com.example.miniproject.Navigation1.statusc;
import static com.example.miniproject.Navigation1.statusc1;
import static com.example.miniproject.Navigation1.statusjava;

public class status extends AppCompatActivity {

    int arr1234[],j;
    EditText c,c1,java;

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

        if(statusc>=400)
            c.setText("Excellent");
        else if(statusc>=300 && statusc<400)
            c.setText("Good");
        else if(statusc>=200 && statusc<300)
            c.setText("Average");
        else
            c.setText("Need more practice");

        if(statusc1>=400)
            c1.setText("Excellent");
        else if(statusc1>=300 && statusc1<400)
            c1.setText("Good");
        else if(statusc1>=200 && statusc1<300)
            c1.setText("Average");
        else
            c1.setText("Need more practice");

        if(statusjava>=400)
            java.setText("Excellent");
        else if(statusjava>=300 && statusjava<400)
            java.setText("Good");
        else if(statusjava>=200 && statusjava<300)
            java.setText("Average");
        else
            java.setText("Need more practice");

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

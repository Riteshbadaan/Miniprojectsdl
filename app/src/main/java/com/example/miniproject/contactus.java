package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class contactus extends AppCompatActivity {

    TextView phone1,phone2,phone3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        getSupportActionBar().setTitle("Contact Us");
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        phone1=findViewById(R.id.phone1);
        phone2=findViewById(R.id.phone2);
        phone3=findViewById(R.id.phone3);
        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u=Uri.parse("tel:+91 9469087466");
                Intent intent1=new Intent(Intent.ACTION_DIAL,u);
                startActivity(intent1);
            }
        });
        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u1=Uri.parse("tel:+91 9922337964");
                Intent intent2=new Intent(Intent.ACTION_DIAL,u1);
                startActivity(intent2);
            }
        });
        phone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u1=Uri.parse("tel:+91 9834031037");
                Intent intent2=new Intent(Intent.ACTION_DIAL,u1);
                startActivity(intent2);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

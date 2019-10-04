package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import es.dmoral.toasty.Toasty;

import static com.example.miniproject.RegisterActivity.firename;

public class Preferences extends optionmenu {

    static RadioButton btn_language,btn_mode,btn_level;
    Button submit_btn;
    RadioGroup radiogrp_language,radiogrp_mode,radiogrp_level;
    Boolean c1,c2,c3,cpp1,cpp2,cpp3,java1,java2,java3;
    String currentu,currentp,currentn;
    int currents;
    long currentph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        getSupportActionBar().setTitle("Preferences");

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        DatabaseReference data= FirebaseDatabase.getInstance().getReference().child("Users").child(firename);
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    currentu=dataSnapshot.child("mail").getValue().toString();
                    currentp=dataSnapshot.child("passwrd").getValue().toString();
                    currentn=dataSnapshot.child("name").getValue().toString();
                    currentph=Long.parseLong(dataSnapshot.child("number").getValue().toString());
                    currents=Integer.parseInt(dataSnapshot.child("score").getValue().toString());
                    c1=Boolean.parseBoolean(dataSnapshot.child("t11").getValue().toString());
                    c2=Boolean.parseBoolean(dataSnapshot.child("t12").getValue().toString());
                    c3=Boolean.parseBoolean(dataSnapshot.child("t13").getValue().toString());
                    cpp1=Boolean.parseBoolean(dataSnapshot.child("t21").getValue().toString());
                    cpp2=Boolean.parseBoolean(dataSnapshot.child("t22").getValue().toString());
                    cpp3=Boolean.parseBoolean(dataSnapshot.child("t23").getValue().toString());
                    java1=Boolean.parseBoolean(dataSnapshot.child("t31").getValue().toString());
                    java2=Boolean.parseBoolean(dataSnapshot.child("t32").getValue().toString());
                    java3=Boolean.parseBoolean(dataSnapshot.child("t33").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        addListenerButton();
    }


    public void addListenerButton()
    {

        radiogrp_language=findViewById(R.id.radiogrp_language);
        radiogrp_level=findViewById(R.id.radiogrp_level);
        radiogrp_mode=findViewById(R.id.radiogrp_mode);
        submit_btn=findViewById(R.id.submit);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int language=radiogrp_language.getCheckedRadioButtonId();
                btn_language=findViewById(language);

                int level=radiogrp_level.getCheckedRadioButtonId();
                btn_level=findViewById(level);

                int mode=radiogrp_mode.getCheckedRadioButtonId();
                btn_mode=findViewById(mode);

               // Toast.makeText(Preferences.this,btn_language.getText(),Toast.LENGTH_SHORT).show();
                Log.i("c1",String.valueOf(c1));
                if(btn_language.getText().toString().equals("C") && btn_level.getText().toString().equals("Easy"))
                {
                    if(!c1) {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else if(btn_language.getText().toString().equals("C") && btn_level.getText().toString().equals("Medium"))
                {
                    if(!c2)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else if(btn_language.getText().toString().equals("C") && btn_level.getText().toString().equals("Hard"))
                {
                    if(!c3)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else if(btn_language.getText().toString().equals("C++") && btn_level.getText().toString().equals("Easy"))
                {
                    if(!cpp1)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else if(btn_language.getText().toString().equals("C++") && btn_level.getText().toString().equals("Medium"))
                {
                    if(!cpp2)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else if(btn_language.getText().toString().equals("C++") && btn_level.getText().toString().equals("Hard"))
                {
                    if(!cpp3)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else if(btn_language.getText().toString().equals("Java") && btn_level.getText().toString().equals("Easy"))
                {
                    if(!java1)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else if(btn_language.getText().toString().equals("Java") && btn_level.getText().toString().equals("Medium"))
                {
                    if(!java2)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!java3)
                    {
                        Intent i=new Intent(Preferences.this, Navigation1.class);
                        i.putExtra("username",currentu);
                        i.putExtra("password",currentp);
                        i.putExtra("name",currentn);
                        i.putExtra("number",currentph);
                        i.putExtra("score",currents);
                        i.putExtra("t11",c1);
                        i.putExtra("t12",c2);
                        i.putExtra("t13",c3);
                        i.putExtra("t21",cpp1);
                        i.putExtra("t22",cpp2);
                        i.putExtra("t23",cpp3);
                        i.putExtra("t31",java1);
                        i.putExtra("t32",java2);
                        i.putExtra("t33",java3);
                        startActivity(i);
                    }
                    else
                        Toasty.warning(Preferences.this, "You have given this test already", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

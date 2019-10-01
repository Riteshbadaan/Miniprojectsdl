package com.example.miniproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static com.example.miniproject.Preferences.btn_language;
import static com.example.miniproject.Preferences.btn_level;
import static com.example.miniproject.Preferences.btn_mode;
import static com.example.miniproject.RegisterActivity.firename;

public class Navigation1 extends optionmenu implements NavigationView.OnNavigationItemSelectedListener{

    Boolean exit=false;
    static int a=1;
    Context context=Navigation1.this;
    Button submit;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3,r4;
    int answer=0,attempans,t;
    static int score=0,count=0;
    TextView ques,sco,time;
    DatabaseReference dr,dr12;
    String currentu,currentp,currentn;
    int currents;
    long currentph;
    Boolean currentc1,currentc2,currentc3,currentcpp1,currentcpp2,currentcpp3,currentjava1,currentjava2,currentjava3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation1);

        Intent i12=getIntent();

        currentu= i12.getStringExtra("username");
        currentp= i12.getStringExtra("password");
        currentn= i12.getStringExtra("name");
        currentph= i12.getLongExtra("number",0);
        currents= i12.getIntExtra("score",0);
        currentc1= i12.getBooleanExtra("t11",false);
        currentc2= i12.getBooleanExtra("t12",false);
        currentc3= i12.getBooleanExtra("t13",false);
        currentcpp1=i12.getBooleanExtra("t21",false);
        currentcpp2= i12.getBooleanExtra("t22",false);
        currentcpp3= i12.getBooleanExtra("t23",false);
        currentjava1=i12.getBooleanExtra("t31",false);
        currentjava2= i12.getBooleanExtra("t32",false);
        currentjava3= i12.getBooleanExtra("t33",false);

        time=findViewById(R.id.time);
        if(btn_mode.getText().toString().equals("Test"))
        {
            if(btn_level.getText().toString().equals("Easy"))
                t=900000;
            else if(btn_level.getText().toString().equals("Medium"))
                t=1200000;
            else
                t=1800000;
            new CountDownTimer(t, 1000) {

                public void onTick(long millisUntilFinished) {
                    time.setText((millisUntilFinished / 60000)+":"+(millisUntilFinished % 60000 / 1000));
                }

                public void onFinish() {
                    startActivity(new Intent(Navigation1.this,result.class));
                }

            }.start();
        }
        else
            time.setText("--/--");

        submit=findViewById(R.id.button);
        radioGroup=findViewById(R.id.radiogroup);
        ques=findViewById(R.id.questiontext);
        r1=findViewById(R.id.first);
        r2=findViewById(R.id.second);
        r3=findViewById(R.id.third);
        r4=findViewById(R.id.fourth);
        sco=findViewById(R.id.score);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        questioncome();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radiogroup2=radioGroup.getCheckedRadioButtonId();
                if(radiogroup2==R.id.first)
                    answer=1;
                else if(radiogroup2==R.id.second)
                    answer=2;
                else if(radiogroup2==R.id.third)
                    answer=3;
                else if(radiogroup2==R.id.fourth)
                    answer=4;
            }
        });
        insert();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(answer==attempans) {
                   Log.i("count",String.valueOf(count));
                   if(count<15) {
                       score += 10;
                       sco.setText(String.valueOf(score));
                       Toasty.success(context, "Correct answer", Toast.LENGTH_SHORT).show();
                       questioncome();
                   }
                   else {
                       score += 10;
                       sco.setText(String.valueOf(score));
                       Toasty.success(context, "Correct answer", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(Navigation1.this, result.class));
                   }
                   }
               else {
                   Toasty.error(context, "Wrong answer", Toast.LENGTH_SHORT).show();
                   if(count<15)
                        questioncome();
                   else
                       startActivity(new Intent(Navigation1.this, result.class));
               }
               }

        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.LEFT)) {

            drawer.closeDrawer(Gravity.LEFT);

            exit = false;

        } else {
            if (context == Navigation1.this) {
                if(a==1) {
                    if (exit) {
                        super.onBackPressed();
                        finishAffinity();
                        finish();
                        return;
                    }
                    this.exit = true;
                    Toasty.info(this, "Press Back again to exit", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            exit = false;
                        }
                    }, 3000);
                }
                else
                {
                    super.onBackPressed();
                    a=1;
                }
            }
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        item.setChecked(true);


        Log.i("abcd",String.valueOf(id));
        switch (id)
        {
            case R.id.myaccount:
                startActivity(new Intent(Navigation1.this,myaccount.class));
                break;
            case R.id.leaderboard:
                startActivity(new Intent(Navigation1.this,Leaderboard.class));
                break;
            case R.id.prefer:
                startActivity(new Intent(Navigation1.this,Preferences.class));
                break;
            case R.id.contact:
                startActivity(new Intent(Navigation1.this,contactus.class));
                break;
            case R.id.logout:
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void insert()
    {
        dr12=FirebaseDatabase.getInstance().getReference().child("Users").child(firename);
        if(btn_language.getText().toString().equals("C") && btn_level.getText().toString().equals("Easy"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,true,currentc2,currentc3,currentcpp1,currentcpp2,currentcpp3,currentjava1,currentjava2,currentjava3);
            dr12.setValue(u1234);
        }
        else if(btn_language.getText().toString().equals("C") && btn_level.getText().toString().equals("Medium"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,true,currentc3,currentcpp1,currentcpp2,currentcpp3,currentjava1,currentjava2,currentjava3);
            dr12.setValue(u1234);
        }
        else if(btn_language.getText().toString().equals("C") && btn_level.getText().toString().equals("Hard"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,currentc2,true,currentcpp1,currentcpp2,currentcpp3,currentjava1,currentjava2,currentjava3);
            dr12.setValue(u1234);
        }
        else if(btn_language.getText().toString().equals("C++") && btn_level.getText().toString().equals("Easy"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,currentc2,currentc3,true,currentcpp2,currentcpp3,currentjava1,currentjava2,currentjava3);
            dr12.setValue(u1234);
        }
        else if(btn_language.getText().toString().equals("C++") && btn_level.getText().toString().equals("Medium"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,currentc2,currentc3,currentcpp1,true,currentcpp3,currentjava1,currentjava2,currentjava3);
            dr12.setValue(u1234);
        }
        else if(btn_language.getText().toString().equals("C++") && btn_level.getText().toString().equals("Hard"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,currentc2,currentc3,currentcpp1,currentcpp2,true,currentjava1,currentjava2,currentjava3);
            dr12.setValue(u1234);
        }
        else if(btn_language.getText().toString().equals("Java") && btn_level.getText().toString().equals("Easy"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,currentc2,currentc3,currentcpp1,currentcpp2,currentcpp3,true,currentjava2,currentjava3);
            dr12.setValue(u1234);
        }
        else if(btn_language.getText().toString().equals("Java") && btn_level.getText().toString().equals("Medium"))
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,currentc2,currentc3,currentcpp1,currentcpp2,currentcpp3,currentjava1,true,currentjava3);
            dr12.setValue(u1234);
        }
        else
        {
            user u1234=new user(currentu,currentp,currentn,currentph,currents,currentc1,currentc2,currentc3,currentcpp1,currentcpp2,currentcpp3,currentjava1,currentjava2,true);
            dr12.setValue(u1234);
        }
    }

public void questioncome()
{
    count++;
    dr= FirebaseDatabase.getInstance().getReference("Questions").child(btn_language.getText().toString()).child(btn_level.getText().toString()).child(String.valueOf(count));
    dr.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()) {
                ques.setText(dataSnapshot.child("ques").getValue().toString());
                r1.setText(dataSnapshot.child("op1").getValue().toString());
                r2.setText(dataSnapshot.child("op2").getValue().toString());
                r3.setText(dataSnapshot.child("op3").getValue().toString());
                r4.setText(dataSnapshot.child("op4").getValue().toString());
                attempans = Integer.parseInt(dataSnapshot.child("ans").getValue().toString());
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}
}

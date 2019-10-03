package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.miniproject.Navigation1.arr;
import static com.example.miniproject.RegisterActivity.firename;

public class myaccount extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView name, phone, email, pass;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);

        getSupportActionBar().setTitle("My Account");

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        edit = findViewById(R.id.edit);

        name.setFocusable(false);
        phone.setFocusable(false);
        email.setFocusable(false);
        pass.setFocusable(false);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Users").child(firename);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        user u1 = new user();
        for(int i = 0; i < arr.size(); i++)
        {
            u1 = arr.get(i);
            String ui = "";
            String u = u1.mail;
            for(int j = 0; j < u.length(); j++)
            {
                if(u.charAt(j) == '.'|| u.charAt(j) == '#')
                {

                }
                else
                {
                    ui += u.charAt(j);
                }
            }
            if(ui.equals(firename))
                break;
        }
        name.setText(u1.name);
        email.setText(u1.mail);
        phone.setText(String.valueOf(u1.number));
        pass.setText(u1.passwrd);

        edit.setOnClickListener(new View.OnClickListener() {
            int flag = 1;
            @Override
            public void onClick(View view) {
                if (flag == 1) {
                    edit.setText("Confirm");
                    name.setFocusableInTouchMode(true);
                    phone.setFocusableInTouchMode(true);
                    name.setFocusable(true);
                    phone.setFocusable(true);
                    flag = 0;
                }
                else if (flag == 0) {
                    edit.setText("Edit");
                    name.setFocusable(false);
                    phone.setFocusable(false);
                    databaseReference.child("name").setValue(name.getText().toString());
                    databaseReference.child("number").setValue(Long.parseLong(phone.getText().toString()));
                    flag = 1;
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

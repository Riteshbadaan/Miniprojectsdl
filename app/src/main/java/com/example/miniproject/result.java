package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.miniproject.Navigation1.count;
import static com.example.miniproject.Navigation1.score;
import static com.example.miniproject.Preferences.btn_language;
import static com.example.miniproject.Preferences.btn_level;
import static com.example.miniproject.RegisterActivity.firename;

public class result extends AppCompatActivity {

    TextView lang,level,s1,attemp,correct;
    Button btn;
    DatabaseReference dr12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setTitle("Result");

        s1=findViewById(R.id.score1);
        attemp=findViewById(R.id.attempt);
        correct=findViewById(R.id.correct);
        lang=findViewById(R.id.lang1);
        level=findViewById(R.id.level1);
        btn=findViewById(R.id.back);

        s1.setText(String.valueOf(score));
        attemp.setText(String.valueOf(count));
        correct.setText(String.valueOf(score/10));
        lang.setText(btn_language.getText());
        level.setText(btn_level.getText());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(result.this,Preferences.class));
            }
        });

    }
}

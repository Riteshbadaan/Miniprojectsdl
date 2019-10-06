package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import es.dmoral.toasty.Toasty;

public class QuestionPage extends AppCompatActivity {

    TextView question,lang,diff,op1,op2,op3,op4,ans;
    Button btn;
    long id=0;
    DatabaseReference d1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);

        question=findViewById(R.id.question);
        lang=findViewById(R.id.lang);
        diff=findViewById(R.id.level);
        op1=findViewById(R.id.option1);
        op2=findViewById(R.id.option2);
        op3=findViewById(R.id.option3);
        op4=findViewById(R.id.option4);
        ans=findViewById(R.id.answer);
        btn=findViewById(R.id.button);
        d1= FirebaseDatabase.getInstance().getReference("Practice");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q,l,d,o1,o2,o3,o4,a;
                q=question.getText().toString().trim();
                l=lang.getText().toString().trim();
                d=diff.getText().toString().trim();
                o1=op1.getText().toString().trim();
                o2=op2.getText().toString().trim();
                o3=op3.getText().toString().trim();
                o4=op4.getText().toString().trim();
                a=ans.getText().toString().trim();
                if(q.isEmpty()||l.isEmpty()||d.isEmpty()||o1.isEmpty()||o2.isEmpty()||o3.isEmpty()||o4.isEmpty()||a.isEmpty())
                    Toasty.error(QuestionPage.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                else {
                        question question=new question(q,o1,o2,o3,o4,Integer.parseInt(a));
                        id++;
                        d1.child(l).child(d).child(String.valueOf(id)).setValue(question);
                    Toasty.success(QuestionPage.this, "Question added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

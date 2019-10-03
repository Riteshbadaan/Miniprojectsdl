package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.miniproject.Navigation1.arr;


public class Leaderboard extends AppCompatActivity {

    ListView listView;
    String uname[];
    int uscore[];
    int rank[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        getSupportActionBar().setTitle("Leaderboard");

        uname=new String[arr.size()];
        uscore=new int[arr.size()];
        rank=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
            rank[i]=i+1;
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        for(int i=0;i<arr.size();i++)
        {
            for(int j=i+1;j<arr.size();j++)
            {
                int a=arr.get(i).score;
                int b=arr.get(j).score;
                if(a<b)
                {
                    user u12;
                    u12=arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,u12);
                }
            }
        }
        if(arr.isEmpty())
            Log.i("empty","empty");
        for(int i=0;i<arr.size();i++)
        {
            uname[i]=arr.get(i).name;
            uscore[i]=arr.get(i).score;
        }
        listView=findViewById(R.id.listview);
        adapter adapter=new adapter(this,uname,uscore,rank);
        listView.setAdapter(adapter);


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    class adapter extends ArrayAdapter<String>
    {
        Context c;
        String n[];
        int s[];
        int r[];


        public adapter(@NonNull Context context,String un[],int us[],int rk[]) {
            super(context, R.layout.leadview,R.id.rankname,un);
            this.c=context;
            this.n=un;
            this.s=us;
            this.r=rk;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View leaderview=inflater.inflate(R.layout.leadview,parent,false);
            TextView userview=leaderview.findViewById(R.id.rankname);
            TextView scoreview=leaderview.findViewById(R.id.rankscore);
            TextView rankview=leaderview.findViewById(R.id.rank);

            if(position%2==1)
                leaderview.setBackgroundColor(Color.parseColor("#5D6D7E"));

            userview.setText(n[position]);
            scoreview.setText(Integer.toString(s[position]));
            rankview.setText(Integer.toString(r[position]));

            Animation animation= AnimationUtils.loadAnimation(c,R.anim.slide_up);
            leaderview.startAnimation(animation);

            return leaderview;
        }
    }
}

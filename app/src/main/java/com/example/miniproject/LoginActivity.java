package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import static com.example.miniproject.RegisterActivity.firename;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends Fragment {

    EditText user,pass;
    Button login;
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_page, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = getView().findViewById(R.id.username1);
        pass = getView().findViewById(R.id.password1);
        login = getView().findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                final String u = user.getText().toString().trim();
                String p = pass.getText().toString().trim();

                if (u.isEmpty())
                    Toasty.info(getActivity(), "Please Enter the username", Toast.LENGTH_SHORT).show();
                else if (p.isEmpty())
                    Toasty.info(getActivity(), "Please Enter the password", Toast.LENGTH_SHORT).show();

                else
                {
                firebaseAuth.signInWithEmailAndPassword(u, p)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String ui="";
                                    for(int i=0;i<u.length();i++)
                                    {
                                        if(u.charAt(i)=='.'||u.charAt(i)=='#')
                                        {

                                        }
                                        else
                                        {
                                            ui+=u.charAt(i);
                                        }
                                    }
                                    firename=ui;
                                    Toasty.success(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(view.getContext(), Preferences.class);
                                    startActivity(i);

                                } else {

                                    Toasty.error(getActivity(), "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            }
        });
    }
}

package com.example.di_la_covid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    private EditText mEmail, mPassword;
    private Button   mLoginBtn;
    private TextView mCreateBtn;
    String adminEmail = "jomar@gmail.com";

    private FirebaseAuth fAuth;

//    SharedPreferences sharedPreferences;
//    private static final String SHARED_PREF_NAME="mypref";
//    private static final String KEY_EMAIL ="email";
//    private static final String KEY_PASSWORD ="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail      = (EditText)    findViewById(R.id.Email);
        mPassword   = (EditText)    findViewById(R.id.password);
        mLoginBtn   = (Button)      findViewById(R.id.loginBtn);
        mCreateBtn  = (TextView)    findViewById(R.id.createText);

//        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//        String name = sharedPreferences.getString(KEY_EMAIL,null);
//
//        if (name != null){
//            Intent intent = new Intent(Login.this,MainActivity.class);
//            startActivity(intent);
//        }


        AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);


        fAuth = FirebaseAuth.getInstance();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString(KEY_EMAIL,mEmail.getText().toString());
//                editor.putString(KEY_PASSWORD,mPassword.getText().toString());
//                editor.apply();

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }

                if(password.length()<8){
                    mPassword.setError("Password must be equal or greater than 8 Characters");
                    return;
                }


                // authenticate the user

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(Login.this,"Logged in Successfully", Toast.LENGTH_SHORT).show();

                            if(email.equals(adminEmail)) {
                                startActivity(new Intent(getApplicationContext(),Admin.class));
                            }
                            else {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                        }else{
                            Toast.makeText(Login.this,"Error ! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

    }
}
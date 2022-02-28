package com.example.di_la_covid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Call_now extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView callText, callText1, callText2, callText3,callText4, callText5;
    private Button callbtn, callbtn1, callbtn2, callbtn3, callbtn4,callbtn5;
    ImageView backkk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_now);

        callText = findViewById(R.id.PNP);
        callText1 = findViewById(R.id.PHO);
        callText2 = findViewById(R.id.PCGP);
        callText3 = findViewById(R.id.BFPP);
        callText4 = findViewById(R.id.PRC);
        callText5 = findViewById(R.id.PDRRMO);

        callbtn = findViewById(R.id.CallBtn);
        callbtn1 = findViewById(R.id.CallBtn1);
        callbtn2 = findViewById(R.id.CallBtn2);
        callbtn3 = findViewById(R.id.CallBtn3);
        callbtn4 = findViewById(R.id.CallBtn4);
        callbtn5 = findViewById(R.id.CallBtn5);

        backkk = findViewById(R.id.backkk);
        backkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Call_now.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbutton();
            }
        });
        callbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbutton1();
            }
        });
        callbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbutton2();
            }
        });
        callbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbutton3();
            }
        });
        callbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbutton4();
            }
        });
        callbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbutton5();
            }
        });
    }

    private void callbutton() {
        String number = callText.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Call_now.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Call_now.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callbutton1() {
        String number = callText1.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Call_now.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Call_now.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callbutton2() {
        String number = callText2.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Call_now.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Call_now.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callbutton3() {
        String number = callText3.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Call_now.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Call_now.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callbutton4() {
        String number = callText4.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Call_now.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Call_now.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void callbutton5() {
        String number = callText5.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Call_now.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Call_now.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callbutton();
                callbutton1();
                callbutton2();
                callbutton3();
                callbutton4();
                callbutton5();
            } else {
                Toast.makeText(this, "permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
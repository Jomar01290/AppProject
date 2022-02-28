package com.example.di_la_covid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class Admin extends AppCompatActivity {

    Button mupdate;

    EditText mactive,maffected,mdied,mrecovered,mserious;
    SharedPreferences sharedPreferences;

//    TextView maffectedval, mdiedval, mrecoveredval, mactiveval, mseriousval;

    DatabaseReference updateRef;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_ACTIVE="active";
    private static final String KEY_AFFECTED="affected";
    private static final String KEY_DIED="died";
    private static final String KEY_RECOVERED="recovered";
    private static final String KEY_SERIOUS="serious";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

//        maffectedval = findViewById(R.id.affectedval);
//        mdiedval = findViewById(R.id.diedval);
//        mrecoveredval = findViewById(R.id.recoveredval);
//        mactiveval = findViewById(R.id.activeval);
//        mseriousval = findViewById(R.id.seriousval);

        mactive = findViewById(R.id.active);
        maffected = findViewById(R.id.affected);
        mdied = findViewById(R.id.died);
        mrecovered = findViewById(R.id.recovered);
        mserious = findViewById(R.id.serious);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String active = sharedPreferences.getString(KEY_ACTIVE,null);

        if (active != null){

            Intent intent = new Intent(Admin.this,Statistics.class);
            startActivity(intent);
        }


//        final EditText mActive = findViewById(R.id.active);                       OLD
//        final EditText mAffected = findViewById(R.id.affected);                   OLD
//        final EditText mDied = findViewById(R.id.died);

        Button mupdate = findViewById(R.id.update);

        mupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_ACTIVE,mactive.getText().toString());
                editor.putString(KEY_AFFECTED,maffected.getText().toString());
                editor.putString(KEY_DIED, mdied.getText().toString());
                editor.putString(KEY_RECOVERED,mrecovered.getText().toString());
                editor.putString(KEY_SERIOUS, mserious.getText().toString());
                editor.apply();


//                String affectedval = mactiveval.getText().toString();
//                String diedval= mdiedval.getText().toString();
//                String recoveredval = mrecoveredval.getText().toString();
//                String activeval = mactiveval.getText().toString();
//                String seriousval = mseriousval.getText().toString();


//                Statisticsuser user = new Statisticsuser(affectedval,diedval,recoveredval,activeval,seriousval);
//                updateRef.push().setValue(user);

                Intent intent = new Intent(Admin.this,Statistics.class);
                startActivity(intent);

                Toast.makeText(Admin.this, "Update successfully", Toast.LENGTH_SHORT).show();


            }
        });

//         mupdate.setOnClickListener(new View.OnClickListener() {                     --OLD
//            @Override
//            public void onClick(View v) {
//
//                String updatedActive = mActive.getText().toString();                OLD
////                String updatedAffected = mAffected.getText().toString();
////                String updatedDied = mDied.getText().toString();
//
//                Intent intent = new  Intent (Admin.this,Statistics.class);
//                intent.putExtra("", updatedActive);
////                intent.putExtra("", updatedAffected);
////                intent.putExtra("", updatedDied);
//                startActivity(intent);
//            }
//        });                                                                       OLD--

    }
}
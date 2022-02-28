package com.example.di_la_covid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Statistics extends AppCompatActivity {

    ImageView back, map, mlogoutperst;
    TextView maffectedval, mdiedval, mrecoveredval, mactiveval, mseriousval;
    FirebaseDatabase fDatabase;
    DatabaseReference databaseReference;
    String affectedData, diedData, recoveredData, activeData, seriousData;

    Button mgotologin;

    DatabaseReference updateRef;



    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_ACTIVE="active";
    private static final String KEY_AFFECTED="affected";
    private static final String KEY_DIED="died";
    private static final String KEY_RECOVERED="recovered";
    private static final String KEY_SERIOUS="serious";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

//    back = findViewById(R.id.imageView);
    map = findViewById(R.id.map);

        maffectedval = findViewById(R.id.affectedval);
        mdiedval = findViewById(R.id.diedval);
        mrecoveredval = findViewById(R.id.recoveredval);
        mactiveval = findViewById(R.id.activeval);
        mseriousval = findViewById(R.id.seriousval);
        fDatabase = FirebaseDatabase.getInstance();
        databaseReference = fDatabase.getReference();


        updateRef = FirebaseDatabase.getInstance().getReference().child("Updated Cases");



    mlogoutperst = findViewById(R.id.logoutfirst);
    mgotologin = findViewById(R.id.gotologin);
    
    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

    String active = sharedPreferences.getString(KEY_ACTIVE,null);
    String affected = sharedPreferences.getString(KEY_AFFECTED,null);
    String died = sharedPreferences.getString(KEY_DIED,null);
    String recovered= sharedPreferences.getString(KEY_RECOVERED,null);
    String serious = sharedPreferences.getString(KEY_SERIOUS,null);

    if (active != null || affected != null || died != null || recovered != null || serious != null){

        mactiveval.setText(""+active);
        maffectedval.setText(""+affected);
        mdiedval.setText(""+died);
        mrecoveredval.setText(""+recovered);
        mseriousval.setText(""+serious);
    }

    mlogoutperst.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
            Toast.makeText(Statistics.this, "Logout succesfully", Toast.LENGTH_SHORT).show();
            finish();

        }
    });

    mgotologin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Statistics.this,Login.class);
            startActivity(intent);
        }
    });





//        save data to firebase
//        updateRef = FirebaseDatabase.getInstance().getReference().child("Updated Active Cases");
//
//                String activeval = mactiveval.getText().toString();
//
//                updateUser user = new updateUser(activeval);
//                updateRef.push().setValue(user);

//        affectedData = "";
//        diedData = "";
//        recoveredData = "";
//        activeData = "";
//        seriousData = "";

//        Intent intent = getIntent();
//        String mActive = intent.getStringExtra("");
//        String mAffected = intent.getStringExtra("");
//        String mDied = intent.getStringExtra("");
//        String mRecovered = intent.getStringExtra("");
//        String mSerious = intent.getStringExtra("");
//
//
//
//        mactiveval.setText(""+mActive);
//        maffectedval.setText(""+mAffected);
//        mdiedval.setText(""+mDied);
//        mrecoveredval.setText(""+mRecovered);
//        mseriousval.setText(""+mSerious);



        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Statistics.this,MapsActivity.class);
                startActivity(i);
                finish();

            }
        });

//    back.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//            Intent i = new Intent(Statistics.this,Login.class);
//            startActivity(i);
////            finish();
//
//        }
//    });

//        databaseReference.child("Cases").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // this method is call to get the realtime
//                // updates in the data.
//                // this method is called when the data is
//                // changed in our Firebase console.
//                // below line is for getting the data from
//                // snapshot of our database.
//                Object value = snapshot.getValue();
//                JSONObject json = null;
//                try {
//                    json = new JSONObject(value.toString());
//                    affectedData = json.getString("affected");
//                    diedData = json.getString("died");
//                    recoveredData = json.getString("recovered");
//                    activeData = json.getString("active");
//                    seriousData = json.getString("serious");
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
////                 after getting the value we are setting
////                 our value to our text view in below line.
//                affectedval.setText(affectedData);
//                diedval.setText(diedData);
//                recoveredval.setText(recoveredData);
//                activeval.setText(activeData);
//                seriousval.setText(seriousData);
//                System.out.println(value);
////                Toast.makeText(Statistics.this, ""+affectedData, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        String affectedval = mactiveval.getText().toString();
        String diedval= mdiedval.getText().toString();
        String recoveredval = mrecoveredval.getText().toString();
        String activeval = mactiveval.getText().toString();
        String seriousval = mseriousval.getText().toString();

        Statisticsuser user = new Statisticsuser(affectedval,diedval,recoveredval,activeval,seriousval);
        updateRef.push().setValue(user);
    }
}
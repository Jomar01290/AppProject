 package com.example.di_la_covid;

 import android.content.Intent;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.ImageView;

 import androidx.appcompat.app.AppCompatActivity;

 import com.google.firebase.auth.FirebaseAuth;

 public class MainActivity extends AppCompatActivity {

    ImageView flags;
    Button stat,callNow;
    ImageView logout;

//     SharedPreferences sharedPreferences;
//     private static final String SHARED_PREF_NAME="mypref";
//     private static final String KEY_EMAIL ="email";
//     private static final String KEY_PASSWORD ="password";


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//         String name = sharedPreferences.getString(KEY_EMAIL,null);
//         String password =sharedPreferences.getString(KEY_PASSWORD,null);


         flags = findViewById(R.id.flag);
        stat = findViewById(R.id.stat);
        callNow = findViewById(R.id.callNow);
        logout = findViewById(R.id.logout);


        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Statistics.class);
                startActivity(i);
            }
        });

        callNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Call_now.class);
                startActivity(i);
            }
        });

//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//
//                builder.setTitle("Confirm");
//                builder.setMessage("Are you sure?");
//
//                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Do nothing but close the dialog
//                        FirebaseAuth.getInstance().signOut();
//                        dialog.dismiss();
//
//                        Intent i = new Intent(getApplicationContext(), Login.class);
//                        startActivity(i);
//
////                        SharedPreferences.Editor editor =sharedPreferences.edit();
////                        editor.clear();
////                        editor.commit();
//
//                        Toast.makeText(MainActivity.this, "Log out succesfully", Toast.LENGTH_SHORT).show();
////                        finish();
//                    }
//                });
//
//                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        // Do nothing
//                        dialog.dismiss();
//                    }
//                });
//
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
//        });

         logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }
}
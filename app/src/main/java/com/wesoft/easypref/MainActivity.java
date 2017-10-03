package com.wesoft.easypref;

import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pixplicity.easyprefs.library.Prefs;
import com.wesoft.easypref.Fragment.ProgressFragment;

import java.util.HashSet;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private Button Btn;
    private Button Btn2;
    private Button Btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Prefs.Builder()
                .setContext(getApplicationContext())
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        Btn = (Button) findViewById(R.id.button);
        Btn2 = (Button) findViewById(R.id.button2);
        Btn3 = (Button) findViewById(R.id.button3);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashSet<String> strSet = new HashSet<String>();
                strSet.add("Cat");
                strSet.add("Dog");
                strSet.add("Pig");
                strSet.add("Rat");
                Prefs.putStringSet("CONFIG", strSet);
                Log.i("dlg", "Write: Complete.");
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashSet<String> strSets = (HashSet) Prefs.getStringSet("CONFIG", null);
                Iterator iterator = strSets.iterator();
                while (iterator.hasNext()) {
                    Log.i("dlg", "Iterator Read: " + iterator.next());
                }

                for (String strSet : strSets) {
                    Log.i("dlg", "ForEach read: " + strSet);
                }

                // iterating over HashSet using forEach() method in Java 8
//                strSets.forEach(System.out::println);


            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final ProgressFragment dialog = new ProgressFragment();
                Bundle bundle = new Bundle();
                bundle.putString("MSG", "Text Bundle...");
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "tag1");
                dialog.setCancelable(false);

                new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                }.start();
            }
        });


    }
}

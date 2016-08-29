package com.hfad.joke.shredpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String mypreference = "mypref";
    public static final String NAME = "nameKey";
    public static final String LAST_NAME = "lnameKey";
    private static final String TAG = "MainActivity";
    SharedPreferences sharedPreferences;
    TextView name, lName;
    Button b, b1, b2;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.name);
        lName = (TextView) findViewById(R.id.last_name);
        b = (Button) findViewById(R.id.save);
        b1 = (Button) findViewById(R.id.get);
        b2 = (Button) findViewById(R.id.clear);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
//                if (sharedPreferences.contains(NAME)) {
//                    name.setText(sharedPreferences.getString(NAME, ""));
//                }
//                if (sharedPreferences.contains(LAST_NAME)) {
//                    lName.setText(sharedPreferences.getString(LAST_NAME, ""));
//                }

                ;
                String n = name.getText().toString();
                String l = lName.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(NAME, n);
                editor.putString(LAST_NAME, l);
                editor.commit();
                Log.i(TAG, "onClick: SAve" + n);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: Get " + name);
                sharedPreferences = getSharedPreferences(mypreference, context.MODE_PRIVATE);
                if (sharedPreferences.contains(NAME)) {
                    name.setText(sharedPreferences.getString(NAME, ""));
                }

                if (sharedPreferences.contains(LAST_NAME)) {
                    lName.setText(sharedPreferences.getString(LAST_NAME, ""));
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i(TAG, "onClick: Clear" + name);
                if (sharedPreferences.contains(NAME)) {
                    name.setText("");
                }
                if (sharedPreferences.contains(LAST_NAME)) {
                    lName.setText("");
                }
            }
        });
    }
}

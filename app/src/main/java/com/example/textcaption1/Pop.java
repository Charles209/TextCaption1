package com.example.textcaption1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pop extends AppCompatActivity {
    Button Save;
    EditText Edit1;

    String st;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.powin);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .3));
//popup a window of EditText
        Save = (Button) findViewById(R.id.save);
        Edit1 = (EditText) findViewById(R.id.edit1);


        //to retrive the data from SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String st1 = prefs.getString("st", "");
        Edit1.setText(st1);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                st = Edit1.getText().toString();

                //to save the data
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Pop.this);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("st", st);
                editor.apply();

            }
        });
    }
}

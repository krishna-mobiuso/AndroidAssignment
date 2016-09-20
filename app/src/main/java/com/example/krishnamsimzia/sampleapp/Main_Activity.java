package com.example.krishnamsimzia.sampleapp;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

/**
 * Created by krishna m simzia on 9/13/2016.
 */
public class Main_Activity extends Activity implements View.OnClickListener {

    int count=1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button);
        button3.setOnClickListener(this);
    }

    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }

final  Handler handler= new Handler();
    Runnable thread = new Runnable() {
        public void run () {
                Toast.makeText(getApplicationContext(), "This is notification " + count, Toast.LENGTH_SHORT).show();
                count++;
                handler.postDelayed(thread, 5000);
        }
    };
    void startRepeatingTask() {
        thread.run();
    }
    void stopRepeatingTask() {
        handler.removeCallbacks(thread);
    }

    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button:
                startRepeatingTask();
                break;

            case R.id.button2:
                stopRepeatingTask();
                break;

            case R.id.button3:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage(R.string.exit)

                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                final AlertDialog alert = dialog.create();
                alert.show();
                break;

        }
    }
}












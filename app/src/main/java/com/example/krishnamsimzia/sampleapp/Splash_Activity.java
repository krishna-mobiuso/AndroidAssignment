package com.example.krishnamsimzia.sampleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by krishna m simzia on 9/6/2016.
 */
public class Splash_Activity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Splash_Activity.this,Main_Activity.class);
                    Splash_Activity.this.startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}

package com.zakki.findingfutsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class SplashScreen extends Activity{
    private Thread splashscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashscreen = new Thread() {
            @Override
            public void run() {
                try{
                    synchronized(this){
                        wait(3000);
                    }
                }
                catch(Exception e){}
                finally{
                    Intent startpt=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(startpt);
                    finish();
                }
            }
        };
        splashscreen.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
}

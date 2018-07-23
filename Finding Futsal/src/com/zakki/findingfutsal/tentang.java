package com.zakki.findingfutsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * In this activity the user can, if necessary, choose to update personal or
 * emergency contact information. Depending which view is selected, the user makes that
 * update. There is also an option to go back to the home (main) screen.
 *
 */
public class tentang extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.kembali) {
            startActivity(new Intent(this,MainActivity.class));
            this.finish();
        } else{
        	this.finish();
        }
    }
}
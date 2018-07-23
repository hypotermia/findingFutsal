package com.zakki.findingfutsal;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class Help extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
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

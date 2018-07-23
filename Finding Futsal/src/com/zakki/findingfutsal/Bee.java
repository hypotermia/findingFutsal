package com.zakki.findingfutsal;


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;



/**
 * This Activity dynamically creates buttons for the user to press which will
 * dial different emergency numbers in the event there isn't a unified number
 * like 911.
 *
 */

public class Bee extends Activity implements OnClickListener{
	Button hubungi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bee);
		// Show the Up button in the action bar.
		setupActionBar();
		hubungi = (Button)findViewById(R.id.hubungi);

		hubungi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				try {
					String number = "02192766658";
			    	String uri = "tel:"+number;
			    	Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
			    	startActivity(callIntent);
			    }catch(Exception e) {
			    	Toast.makeText(getApplicationContext(),"Your call has failed...",
			    	Toast.LENGTH_LONG).show();
			    	e.printStackTrace();
			     }
			   }
			});
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
		  // TODO Auto-generated method stub
		  Intent back = new Intent(this, List.class);
		  startActivity(back);
		 }
	
}
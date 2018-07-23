package com.zakki.findingfutsal;

import java.io.IOException;

import com.google.android.gms.internal.be;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.location.Criteria;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends Activity{
	Database dbhelper;
	double latitude, longitude; // variable
	Intent inten;
	ListView list;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		
		dbhelper = new Database(this);
		list = (ListView)findViewById(R.id.list);
		
		String[] from = new String[] { "_id", "nama","lat", "lng" };
		int[] to 	  = new int[] { R.id.id, R.id.nama, R.id.latitude,
				R.id.longitude };

		try {
			dbhelper.createDataBase();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Cursor c = dbhelper.getDataList();
		c.moveToFirst();
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
				getApplicationContext(), R.layout.item, c, from, to,0);
		ListView list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View arg1,
					int pos, long arg3) {
				// TODO Auto-generated method stub
			    	if (pos == 0) {
			        	Intent set = new Intent(List.this, Bywi.class);
			            startActivity(set);    
			        } else if (pos == 1) {
			        	Intent set = new Intent(List.this, Champions.class);
			            startActivity(set);
			        } else if (pos == 2) {
			        	Intent set = new Intent(List.this, Elang.class);
			            startActivity(set);
			        } else if (pos == 3) {
			        	Intent set = new Intent(List.this, Pelangi.class);
			            startActivity(set);
			        } else if (pos == 4) {
			        	Intent set = new Intent(List.this, Hut.class);
			            startActivity(set);
			        } else if (pos == 5) {
			        	Intent set = new Intent(List.this, Magnet.class);
			            startActivity(set);
			        } else if (pos == 6) {
			        	Intent set = new Intent(List.this, Star.class);
			            startActivity(set);
			        } else if (pos == 7) {
			        	Intent set = new Intent(List.this, Centro.class);
			            startActivity(set);
			        } else if (pos == 8) {
			        	Intent set = new Intent(List.this, Savannah.class);
			            startActivity(set);
			        } else if (pos == 9) {
			        	Intent set = new Intent(List.this, Bee.class);
			            startActivity(set);
			        } else if (pos == 10) {
			        	Intent set = new Intent(List.this, Rakyat.class);
			            startActivity(set);
			        } else if (pos == 11) {
			        	Intent set = new Intent(List.this, Crystal.class);
			            startActivity(set);
			        } else if (pos == 12) {
			        	Intent set = new Intent(List.this, Cakra.class);
			            startActivity(set);
			        } else if (pos == 13) {
			        	Intent set = new Intent(List.this, Baba.class);
			            startActivity(set);
			        } else if (pos == 14) {
			        	Intent set = new Intent(List.this, Ground.class);
			            startActivity(set);
			        } else if (pos == 15) {
			        	Intent set = new Intent(List.this, Center.class);
			            startActivity(set);
			        } else if (pos == 16){
			        	Intent set = new Intent(List.this, Total.class);
			        	startActivity(set);
			        	}
			        else{
			        	Intent set = new Intent(List.this, Maps.class);
			            startActivity(set);
			        }
				}
		});
	}
}
package com.zakki.findingfutsal;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.lp_button) {
        	Intent maps = new Intent(this, Maps.class);
            startActivity(maps);
        }  else if (id == R.id.tentang_button) {
        	Intent set = new Intent(this, tentang.class);
            startActivity(set);
        } else if (id == R.id.bantu_button) {
        	Intent set = new Intent(this, Help.class);
            startActivity(set);
        } else if (id == R.id.settings_button) {
        	final AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Info");
			builder.setMessage("Apakah anda yakin ingin Keluar  "+" ?");
			builder.setPositiveButton("Ya",
				new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
					try{
						finish();
					}catch (ActivityNotFoundException activityException) {}

				}
				});
			builder.setNegativeButton("Tidak",
				new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int arg1) {
				// TODO Auto-generated method stub
					dialog.dismiss();
				}
				});
			builder.create().show();
    }
        } 
    }

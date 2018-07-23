package com.zakki.findingfutsal;

import java.io.IOException;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnClickListener,
		LocationListener {
	Button list, reload;
	GoogleMap googleMap;
	Database database;
	String id, nama, latitude, longitude;
	Marker marker;
	double latitude1, longitude1;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_maps);

		list = (Button) findViewById(R.id.list);
		reload = (Button) findViewById(R.id.reload);

		list.setOnClickListener(this);
		reload.setOnClickListener(this);

		try {
			SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map);
			googleMap = fm.getMap();

			googleMap.setMyLocationEnabled(true);

		} catch (Exception e) {
			// TODO: handle exception
		}

		database = new Database(this);
		try {
			database.createDataBase();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		AmbilData();
		CheckGPS();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == list) {
			Intent i = new Intent(Maps.this, List.class);
			i.putExtra("latitude", latitude1);
			i.putExtra("longitude", longitude1);
			startActivity(i);
		}
		if (v == reload) {
			googleMap.clear();
			AmbilData();
		}
	}

	public void CheckGPS() {
		try {
			LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Info");
				builder.setMessage("Apakah anda akan mengaktifkan GPS?");
				builder.setPositiveButton("Ya",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								Intent i = new Intent(
										android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
								startActivity(i);

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
		} catch (Exception e) {
			// TODO: handle exception

		}
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());
		if (status != ConnectionResult.SUCCESS) {
			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this,
					requestCode);
			dialog.show();
		} else {
			Criteria criteria = new Criteria();
			LocationManager locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			String provider = locationmanager.getBestProvider(criteria, true);
			Location location = locationmanager.getLastKnownLocation(provider);
			if (location != null) {
				onLocationChanged(location);
			}
			locationmanager.requestLocationUpdates(provider, 500, 0, this);
			LatLng posisi = new LatLng(latitude1, longitude1); 

			googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posisi,
					12));
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		try {
			latitude1 = location.getLatitude();
			longitude1 = location.getLongitude();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

	public void AmbilData() {
		Cursor c = database.getDataLap();
		c.moveToFirst();
		while (c.moveToNext()) {

			HashMap<String, String> data = new HashMap<String, String>();
			data.put("id", c.getString(0));
			data.put("nama", c.getString(1));
			data.put("kontak", c.getString(2));
			data.put("latitude", c.getString(3));
			data.put("longitude", c.getString(4));
			data.put("alamat", c.getString(5));
			data.put("rating", c.getString(6));

			googleMap.addMarker(new MarkerOptions()
					.position(new LatLng(Double.valueOf(c.getString(3)), Double.valueOf(c.getString(4))))
					.title(c.getString(1)).snippet(c.getString(5))
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_50)));

			}
	}
}
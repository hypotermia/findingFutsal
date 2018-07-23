package com.zakki.findingfutsal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
	private static String DB_Name = "FindingFutsal.sqlite";
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAMA = "nama";
	private SQLiteDatabase db;
	private final Context context;
	private String DB_PATH;

	public Database(Context context) {
		super(context, DB_Name, null, 1);
		this.context = context;
		DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
	}

	public void createDataBase() throws IOException {
		boolean dbExist = checkDataBase();
		if (dbExist) {

		} else {
			this.getReadableDatabase();
			try {
				copyDataBase();
			} catch (IOException e) {
				throw new Error("Error copying database");
				// TODO: handle exception
			}
		}
	}

	private boolean checkDataBase() {
		File dbFile = new File(DB_PATH + DB_Name);
		return dbFile.exists();
	}

	private void copyDataBase() throws IOException {
		InputStream myInput = context.getAssets().open(DB_Name);
		String outFileName = DB_PATH + DB_Name;
		OutputStream myOutput = new FileOutputStream(outFileName);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public Cursor getDataLap() {
		try {
			String myPath = DB_PATH + DB_Name;
			db = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);

		} catch (Exception e) {
			// TODO: handle exception
		}
		Cursor c = db.rawQuery("SELECT * FROM futsal order by nama", null);
		return c;

	}
	
	public Cursor getDataList() {
		try {
			String myPath = DB_PATH + DB_Name;
			db = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);

		} catch (Exception e) {
			// TODO: handle exception
		}
		Cursor c = db.rawQuery("SELECT * FROM futsal order by rating", null);
		return c;

	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
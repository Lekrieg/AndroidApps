package com.lekrieg.basictasklist.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseUtil extends SQLiteOpenHelper {

	public static int VERSION = 1;
	public static String DATABASE_NAME = "TASK_DATABASE";
	public static String TASK_TABLE_NAME = "tasks";

	public DataBaseUtil(@Nullable Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		String sql = "CREATE TABLE IF NOT EXISTS " + TASK_TABLE_NAME
				+ " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, description TEXT);";

		try{
			sqLiteDatabase.execSQL(sql);
			Log.i("Info database: ", "Table created with success");
		}catch (Exception e){
			Log.i("Info database: ", "Error creating a table " + e.getMessage());
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
		// Usado quando tenho uma atualização no banco de dados do aplicativo
		// Exemplo: Deletar ou atualizar/criar alguma tabela do aplicativo existente
	}
}

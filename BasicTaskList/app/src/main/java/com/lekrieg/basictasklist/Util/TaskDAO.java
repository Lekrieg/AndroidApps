package com.lekrieg.basictasklist.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lekrieg.basictasklist.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO implements IGenericDao<Task> {

	private SQLiteDatabase write;
	private SQLiteDatabase read;

	public TaskDAO(Context context) {
		DataBaseUtil dataBaseUtil = new DataBaseUtil(context);

		write = dataBaseUtil.getWritableDatabase();
		read = dataBaseUtil.getReadableDatabase();
	}

	@Override
	public boolean save(Task task) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", task.getTaskName());
		contentValues.put("description", task.getTaskDescription());

		try {
			write.insert(DataBaseUtil.TASK_TABLE_NAME, null, contentValues);

			Log.i("Info: ", "task saved!");
		} catch(Exception e) {
			Log.i("Info: ", "Save error!");
			return false;
		}

		return true;
	}

	@Override
	public boolean update(Task task) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", task.getTaskName());
		contentValues.put("description", task.getTaskDescription());

		try {
			// Argumentos do update
			String[] args = {Long.toString(task.getId())};
			write.update(DataBaseUtil.TASK_TABLE_NAME, contentValues, "id=?", args);

			Log.i("Info: ", "task updated!");
		} catch(Exception e) {
			Log.i("Info: ", "Update error!");
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(Task task) {
		try {
			// Argumentos do delete
			String[] args = {Long.toString(task.getId())};
			write.delete(DataBaseUtil.TASK_TABLE_NAME, "id=?", args);

			Log.i("Info: ", "Task deleted!");
		} catch(Exception e) {
			Log.i("Info: ", "Delete error!");
			return false;
		}

		return true;
	}

	@Override
	public List<Task> listContent() {
		List<Task> taskList = new ArrayList<>();

		String sql = "SELECT * FROM " + DataBaseUtil.TASK_TABLE_NAME + ";";
		Cursor cursor = read.rawQuery(sql, null);

		while(cursor.moveToNext())
		{
			Task task = new Task();

			Long id = cursor.getLong(cursor.getColumnIndex("id"));
			String taskName = cursor.getString(cursor.getColumnIndex("name"));
			String taskDescription = cursor.getString(cursor.getColumnIndex("description"));

			task.setId(id);
			task.setTaskName(taskName);
			task.setTaskDescription(taskDescription);

			taskList.add(task);
		}

		return taskList;
	}
}

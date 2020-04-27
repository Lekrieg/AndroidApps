package com.lekrieg.basictasklist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.lekrieg.basictasklist.R;
import com.lekrieg.basictasklist.Util.TaskDAO;
import com.lekrieg.basictasklist.model.Task;

public class AddTaskActivity extends AppCompatActivity {

	private TextInputEditText textInputEditTextName;
	private EditText editTextDescription;

	private Task currentTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_task);

		setViews();

		currentTask = (Task)getIntent().getSerializableExtra("selectedTask");
		if(currentTask != null)
		{
			textInputEditTextName.setText(currentTask.getTaskName());
			editTextDescription.setText(currentTask.getTaskDescription());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_save, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		int id = item.getItemId();

		switch (id)
		{
			case R.id.action_save:
				TaskDAO taskDAO = new TaskDAO(getApplicationContext());

				// If I click on a task then I will edit it and save else I will just save it on database
				if(currentTask != null)
				{
					String name = checkString(textInputEditTextName.getText().toString());
					String description = checkString(editTextDescription.getText().toString());

					Task task = new Task();
					task.setTaskName(name);
					task.setTaskDescription(description);
					task.setId(currentTask.getId());

					if(taskDAO.update(task)) {
						// close the current activity
						finish();
						Toast.makeText(getApplicationContext(), "Updated!", Toast.LENGTH_SHORT).show();
					}
					else {
						Toast.makeText(getApplicationContext(), "Update error!", Toast.LENGTH_SHORT).show();
					}
				}
				else
				{
					Task task = new Task();
					String name = checkString(textInputEditTextName.getText().toString());
					String description = checkString(editTextDescription.getText().toString());
					task.setTaskName(name);
					task.setTaskDescription(description);

					if(taskDAO.save(task)) {
						finish();
						Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
					}
					else {
						Toast.makeText(getApplicationContext(), "Save error!", Toast.LENGTH_SHORT).show();
					}
				}
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	private void setViews() {
		textInputEditTextName = findViewById(R.id.TextInputTaskName);
		editTextDescription = findViewById(R.id.EditTextDescription);
	}

	private String checkString(String s) {
		if(s.isEmpty())
		{
			return "";
		}

		return s;
	}
}

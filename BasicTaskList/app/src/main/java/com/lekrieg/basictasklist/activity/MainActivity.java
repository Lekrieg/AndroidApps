package com.lekrieg.basictasklist.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lekrieg.basictasklist.R;
import com.lekrieg.basictasklist.Util.DataBaseUtil;
import com.lekrieg.basictasklist.Util.RecyclerItemClickListener;
import com.lekrieg.basictasklist.Util.TaskDAO;
import com.lekrieg.basictasklist.adapter.TaskAdapter;
import com.lekrieg.basictasklist.model.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerViewTaskList;
	private TaskAdapter taskAdapter;
	private List<Task> taskList = new ArrayList<>();
	private Task taskToDelete;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolBar);
		setSupportActionBar(toolbar);

		recyclerViewTaskList = findViewById(R.id.recyclerViewTaskList);

		recyclerViewTaskList.addOnItemTouchListener(
				new RecyclerItemClickListener(
						getApplicationContext(), recyclerViewTaskList, new RecyclerItemClickListener.OnItemClickListener() {
					@Override
					public void onItemClick(View view, int position) {
						Task selectedTask = taskList.get(position);

						Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
						intent.putExtra("selectedTask", selectedTask);

						startActivity(intent);
					}

					@Override
					public void onLongItemClick(View view, int position) {
						taskToDelete = taskList.get(position);

						AlertDialog.Builder alertDialogBuild = new AlertDialog.Builder(MainActivity.this);
						alertDialogBuild.setTitle("Confirm deletion");
						alertDialogBuild.setMessage("Exclude task: " + taskToDelete.getTaskName() + " ?");

						alertDialogBuild.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								TaskDAO taskDAO = new TaskDAO(getApplicationContext());

								if(taskDAO.delete(taskToDelete)) {
									loadTaskList();
									Toast.makeText(getApplicationContext(), "Task deleted", Toast.LENGTH_SHORT).show();
								}
								else {
									Toast.makeText(getApplicationContext(), "Delete error", Toast.LENGTH_SHORT).show();
								}
							}
						});
						alertDialogBuild.setNegativeButton("No", null);

						alertDialogBuild.create();
						alertDialogBuild.show();
					}

					@Override
					public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

					}
				}
				)
		);

		FloatingActionButton fab = findViewById(R.id.fab_add_item);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(), AddTaskActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() {
		loadTaskList();
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		switch (id)
		{
			case R.id.action_settings:
				Toast.makeText(MainActivity.this, "Settings!", Toast.LENGTH_SHORT).show();
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	public void loadTaskList() {
		TaskDAO taskDAO = new TaskDAO(getApplicationContext());
		taskList = taskDAO.listContent();

		taskAdapter = new TaskAdapter(taskList);

		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerViewTaskList.setLayoutManager(layoutManager);
		recyclerViewTaskList.setHasFixedSize(true);
		recyclerViewTaskList.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
		recyclerViewTaskList.setAdapter(taskAdapter);
	}
}

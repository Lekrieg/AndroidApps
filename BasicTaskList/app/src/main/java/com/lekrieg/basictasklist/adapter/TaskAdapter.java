package com.lekrieg.basictasklist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.lekrieg.basictasklist.R;
import com.lekrieg.basictasklist.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
	private List<Task> taskList;

	public TaskAdapter(List<Task> list) {
		this.taskList = list;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_adapter, parent, false);

		return new MyViewHolder(itemList);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		Task task = taskList.get(position);

		holder.textViewTaskName.setText(task.getTaskName());
	}

	@Override
	public int getItemCount() {
		return taskList.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {

		private TextView textViewTaskName;

		public MyViewHolder(@NonNull View itemView) {
			super(itemView);

			textViewTaskName = itemView.findViewById(R.id.TextViewTaskName);
		}
	}
}

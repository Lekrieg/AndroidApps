package com.lekrieg.basicanimelist_recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.lekrieg.basicanimelist_recyclerview.R;

public class AnimeInfoActivity extends AppCompatActivity {

	private ImageView imageViewAnime;
	private TextView textViewName;
	private TextView textViewDescription;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anime_info);

		configurateViews();

		Bundle data = getIntent().getExtras();
		int imageId = data.getInt("image");
		String name = data.getString("name");
		String description = data.getString("description");

		imageViewAnime.setImageResource(imageId);
		textViewName.setText(name);
		textViewDescription.setText(description);
	}

	private void configurateViews()
	{
		imageViewAnime = findViewById(R.id.imageViewAnime);
		textViewName = findViewById(R.id.textViewName);
		textViewDescription = findViewById(R.id.textViewDescription);
	}
}

package com.lekrieg.otakuextreme_prototype01.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.lekrieg.otakuextreme_prototype01.R;

public class PlayerActivity extends AppCompatActivity {

	private VideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);

		// Hide the statusBar and navigation bar
		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
		// Hide action bar
		getSupportActionBar().hide();

		Bundle data = getIntent().getExtras();
		int videoID = data.getInt("videoID");

		videoView = findViewById(R.id.videoView);

		videoView.setMediaController(new MediaController(this));
		videoView.setVideoPath("android.resource://" + getPackageName() + "/" + videoID);
		videoView.start();
	}
}

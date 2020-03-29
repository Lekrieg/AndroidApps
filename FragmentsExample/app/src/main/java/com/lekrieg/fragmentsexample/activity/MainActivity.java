package com.lekrieg.fragmentsexample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lekrieg.fragmentsexample.R;
import com.lekrieg.fragmentsexample.fragment.AnimeFragment;
import com.lekrieg.fragmentsexample.fragment.MangaFragment;

public class MainActivity extends AppCompatActivity {

	private Button buttonAnime;
	private Button buttonManga;

	private MangaFragment mangaFragment;
	private AnimeFragment animeFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setElevation(0);

		buttonAnime = findViewById(R.id.buttonAnime);
		buttonManga = findViewById(R.id.buttonManga);

		mangaFragment = new MangaFragment();
		animeFragment = new AnimeFragment();


		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.fragmentLayoutContent, animeFragment);
		transaction.commit();

		buttonAnime.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.fragmentLayoutContent, animeFragment);
				transaction.commit();
			}
		});
		buttonManga.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.fragmentLayoutContent, mangaFragment);
				transaction.commit();
			}
		});
	}
}

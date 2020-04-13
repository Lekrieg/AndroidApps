package com.lekrieg.learningjapanese.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.lekrieg.learningjapanese.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalsFragment extends Fragment implements View.OnClickListener {

	private ImageButton imageButtonAnimalCat;
	private ImageButton imageButtonAnimalCow;
	private ImageButton imageButtonAnimalDog;
	private ImageButton imageButtonAnimalLion;
	private ImageButton imageButtonAnimalMonkey;
	private ImageButton imageButtonAnimalSheep;

	private MediaPlayer mediaPlayer;

	public AnimalsFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_animals, container, false);

		bindViews(view);
		setOnClickListeners();

		return view;
	}

	private void bindViews(View view) {
		imageButtonAnimalCat = view.findViewById(R.id.imageButtonAnimalCat);
		imageButtonAnimalCow = view.findViewById(R.id.imageButtonAnimalCow);
		imageButtonAnimalDog = view.findViewById(R.id.imageButtonAnimalDog);
		imageButtonAnimalLion = view.findViewById(R.id.imageButtonAnimalLion);
		imageButtonAnimalMonkey = view.findViewById(R.id.imageButtonAnimalMonkey);
		imageButtonAnimalSheep = view.findViewById(R.id.imageButtonAnimalSheep);
	}

	private void setOnClickListeners() {
		imageButtonAnimalCat.setOnClickListener(this);
		imageButtonAnimalCow.setOnClickListener(this);
		imageButtonAnimalDog.setOnClickListener(this);
		imageButtonAnimalLion.setOnClickListener(this);
		imageButtonAnimalMonkey.setOnClickListener(this);
		imageButtonAnimalSheep.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.imageButtonAnimalCat:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.animal_cat);
				playSound();
				break;
			case R.id.imageButtonAnimalCow:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.animal_cow);
				playSound();
				break;
			case R.id.imageButtonAnimalDog:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.animal_dog);
				playSound();
				break;
			case R.id.imageButtonAnimalLion:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.animal_lion);
				playSound();
				break;
			case R.id.imageButtonAnimalMonkey:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.animal_monkey);
				playSound();
				break;
			case R.id.imageButtonAnimalSheep:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.animal_sheep);
				playSound();
				break;
		}
	}

	private void playSound() {
		if(mediaPlayer != null) {
			mediaPlayer.start();

			mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mediaPlayer) {
					mediaPlayer.release();
				}
			});
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if(mediaPlayer != null)
		{
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
}

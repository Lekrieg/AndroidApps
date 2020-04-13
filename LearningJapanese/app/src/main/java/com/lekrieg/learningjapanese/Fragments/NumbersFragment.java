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
public class NumbersFragment extends Fragment implements View.OnClickListener {

	private ImageButton imageButtonNumberOne;
	private ImageButton imageButtonNumberTwo;
	private ImageButton imageButtonNumberThree;
	private ImageButton imageButtonNumberFour;
	private ImageButton imageButtonNumberFive;
	private ImageButton imageButtonNumberSix;

	private MediaPlayer mediaPlayer;

	public NumbersFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_numbers, container, false);

		bindViews(view);
		setOnClickListeners();

		return view;
	}

	private void bindViews(View view) {
		imageButtonNumberOne = view.findViewById(R.id.imageButtonNumberOne);
		imageButtonNumberTwo = view.findViewById(R.id.imageButtonNumberTwo);
		imageButtonNumberThree = view.findViewById(R.id.imageButtonNumberThree);
		imageButtonNumberFour = view.findViewById(R.id.imageButtonNumberFour);
		imageButtonNumberFive = view.findViewById(R.id.imageButtonNumberFive);
		imageButtonNumberSix = view.findViewById(R.id.imageButtonNumberSix);
	}

	private void setOnClickListeners() {
		imageButtonNumberOne.setOnClickListener(this);
		imageButtonNumberTwo.setOnClickListener(this);
		imageButtonNumberThree.setOnClickListener(this);
		imageButtonNumberFour.setOnClickListener(this);
		imageButtonNumberFive.setOnClickListener(this);
		imageButtonNumberSix.setOnClickListener(this);
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
	public void onClick(View view) {
		switch (view.getId())
		{
			case R.id.imageButtonNumberOne:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_one);
				playSound();
				break;
			case R.id.imageButtonNumberTwo:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_two);
				playSound();
				break;
			case R.id.imageButtonNumberThree:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_three);
				playSound();
				break;
			case R.id.imageButtonNumberFour:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_four);
				playSound();
				break;
			case R.id.imageButtonNumberFive:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_five);
				playSound();
				break;
			case R.id.imageButtonNumberSix:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_six);
				playSound();
				break;
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

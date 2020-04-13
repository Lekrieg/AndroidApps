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
public class ItemsFragment extends Fragment implements View.OnClickListener {

	private ImageButton imageButtonItemChair;
	private ImageButton imageButtonItemNotebook;
	private ImageButton imageButtonItemPen;
	private ImageButton imageButtonItemSchoolbag;
	private ImageButton imageButtonItemShoes;
	private ImageButton imageButtonItemSock;

	private MediaPlayer mediaPlayer;

	public ItemsFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_items, container, false);

		bindViews(view);
		setOnClickListeners();

		return view;
	}

	private void bindViews(View view) {
		imageButtonItemChair = view.findViewById(R.id.imageButtonItemChair);
		imageButtonItemNotebook = view.findViewById(R.id.imageButtonItemNotebook);
		imageButtonItemPen = view.findViewById(R.id.imageButtonItemPen);
		imageButtonItemSchoolbag = view.findViewById(R.id.imageButtonItemSchoolbag);
		imageButtonItemShoes = view.findViewById(R.id.imageButtonItemShoes);
		imageButtonItemSock = view.findViewById(R.id.imageButtonItemSock);
	}

	private void setOnClickListeners() {
		imageButtonItemChair.setOnClickListener(this);
		imageButtonItemNotebook.setOnClickListener(this);
		imageButtonItemPen.setOnClickListener(this);
		imageButtonItemSchoolbag.setOnClickListener(this);
		imageButtonItemShoes.setOnClickListener(this);
		imageButtonItemSock.setOnClickListener(this);
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
			case R.id.imageButtonItemChair:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.item_chair);
				playSound();
				break;
			case R.id.imageButtonItemNotebook:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.item_notebook);
				playSound();
				break;
			case R.id.imageButtonItemPen:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.item_pen);
				playSound();
				break;
			case R.id.imageButtonItemSchoolbag:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.item_schoolbag);
				playSound();
				break;
			case R.id.imageButtonItemShoes:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.item_shoes);
				playSound();
				break;
			case R.id.imageButtonItemSock:
				mediaPlayer = MediaPlayer.create(getActivity(), R.raw.item_sock);
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

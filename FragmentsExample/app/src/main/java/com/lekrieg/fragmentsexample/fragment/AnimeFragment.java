package com.lekrieg.fragmentsexample.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lekrieg.fragmentsexample.R;
import com.lekrieg.fragmentsexample.adapter.AnimeAdapter;
import com.lekrieg.fragmentsexample.model.Anime;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimeFragment extends Fragment {

	RecyclerView reciRecyclerViewAnime;
	List<Anime> animeList = new ArrayList<>();

	public AnimeFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_anime, container, false);

		reciRecyclerViewAnime = view.findViewById(R.id.RecyclerViewAnime);

		CreateMangaList();

		AnimeAdapter animeAdapter = new AnimeAdapter(animeList);

		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
		reciRecyclerViewAnime.setLayoutManager(layoutManager);
		reciRecyclerViewAnime.setHasFixedSize(true);
		reciRecyclerViewAnime.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
		reciRecyclerViewAnime.setAdapter(animeAdapter);

		return view;
	}

	private void CreateMangaList()
	{
		Anime anime = new Anime(R.drawable.anime_hamatora, "Hamatora", "2014", "Mistery/Comedy", "Autor: Yukinori Kitajima");
		animeList.add(anime);

		anime = new Anime(R.drawable.anime_overlord_mask, "Overlord Mask", "2017", "Action/Supernatural", "Autor: Moxi");
		animeList.add(anime);

		anime = new Anime(R.drawable.anime_dimension_w, "Dimension W", "2016", "Action/Seinen", "Autor: Yuji Iwahara");
		animeList.add(anime);

		anime = new Anime(R.drawable.anime_gate_keepers, "Gate Keepers", "2000", "Action/Mecha", "Autor: Hiroshi Yamaguchi");
		animeList.add(anime);

		anime = new Anime(R.drawable.anime_gate_jieitai, "Gate Jieitai", "2015", "Action/Fantasy", "Autor: Takumi Yanai");
		animeList.add(anime);

		anime = new Anime(R.drawable.anime_guilty_crown, "Guilty Crown", "2011", "Action/Drama", "Autor: Hirouyuki Yoshino");
		animeList.add(anime);

		anime = new Anime(R.drawable.anime_campione, "Campione", "2012", "Comedy/Ecchi", "Autor: Jou Taketsuki");
		animeList.add(anime);

		anime = new Anime(R.drawable.anime_angolmois, "Angolmois", "2018", "Action/Drama", "Autor: Nanahiko Takagi");
		animeList.add(anime);
	}
}

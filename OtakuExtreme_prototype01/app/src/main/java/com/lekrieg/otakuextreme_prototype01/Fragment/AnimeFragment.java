package com.lekrieg.otakuextreme_prototype01.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lekrieg.otakuextreme_prototype01.Adapter.AnimeAdapter;
import com.lekrieg.otakuextreme_prototype01.Model.Anime;
import com.lekrieg.otakuextreme_prototype01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimeFragment extends Fragment {
	private List<Anime> animeList = new ArrayList<>();
	private RecyclerView recyclerViewAnime;

	public AnimeFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_anime, container, false);

		recyclerViewAnime = view.findViewById(R.id.RecyclerViewAnime);

		initData();
		initRecyclerViewManga();

		return view;
	}

	// Here I create the adapter and set the recyclerview
	private void initData() {
		AnimeAdapter animeAdapter = new AnimeAdapter(animeList);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
		recyclerViewAnime.setLayoutManager(layoutManager);
		recyclerViewAnime.setHasFixedSize(true);
		recyclerViewAnime.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
		recyclerViewAnime.setAdapter(animeAdapter);
	}

	private void initRecyclerViewManga() {
		// The data would come from an API, this is just a example
		Anime anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Tower of god", "Year: 2020", 4.9f);
		animeList.add(anime);
		anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Anime 2", "Year: 2001", 3.4f);
		animeList.add(anime);
		anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Anime 3", "Year: 2004", 4.4f);
		animeList.add(anime);
		anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Anime 4", "Year: 1995", 2.0f);
		animeList.add(anime);
		anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Anime 5", "Year: 2000", 1f);
		animeList.add(anime);
		anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Anime 6", "Year: 2010", 3.4f);
		animeList.add(anime);
		anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Anime 7", "Year: 2015", 5f);
		animeList.add(anime);
		anime = new Anime(R.drawable.tower_of_god_cover_image, R.raw.tower_of_god_op, "Anime 8", "Year: 2018", 4f);
		animeList.add(anime);

	}
}

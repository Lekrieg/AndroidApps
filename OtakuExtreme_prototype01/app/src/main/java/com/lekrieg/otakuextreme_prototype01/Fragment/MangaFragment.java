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

import com.lekrieg.otakuextreme_prototype01.Adapter.MangaAdapter;
import com.lekrieg.otakuextreme_prototype01.Model.Manga;
import com.lekrieg.otakuextreme_prototype01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MangaFragment extends Fragment {
	private List<Manga> mangaList = new ArrayList<>();
	private RecyclerView recyclerViewManga;

	public MangaFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_manga, container, false);

		recyclerViewManga = view.findViewById(R.id.RecyclerViewManga);

		initData();
		initRecyclerViewManga();

		return view;
	}

	// Here I create the adapter and set the recyclerview
	private void initRecyclerViewManga() {
		MangaAdapter mangaAdapter = new MangaAdapter(mangaList);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
		recyclerViewManga.setLayoutManager(layoutManager);
		recyclerViewManga.setHasFixedSize(true);
		recyclerViewManga.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
		recyclerViewManga.setAdapter(mangaAdapter);
	}

	private void initData() {
		// The data would come from an API, this is just a example
		Manga manga = new Manga(R.drawable.manga_gangsta, "Gangsta", "Year: 2011", 9.95);
		mangaList.add(manga);
		manga = new Manga(R.drawable.manga_gangsta, "Manga 2", "Year: 2005", 8.9);
		mangaList.add(manga);
		manga = new Manga(R.drawable.manga_gangsta, "Manga 3", "Year: 2014", 9);
		mangaList.add(manga);
		manga = new Manga(R.drawable.manga_gangsta, "Manga 4", "Year: 2000", 8.85);
		mangaList.add(manga);
		manga = new Manga(R.drawable.manga_gangsta, "Manga 5", "Year: 2017", 7.7);
		mangaList.add(manga);
		manga = new Manga(R.drawable.manga_gangsta, "Manga 6", "Year: 2017", 5);
		mangaList.add(manga);
		manga = new Manga(R.drawable.manga_gangsta, "Manga 7", "Year: 2010", 3.75);
		mangaList.add(manga);
	}
}

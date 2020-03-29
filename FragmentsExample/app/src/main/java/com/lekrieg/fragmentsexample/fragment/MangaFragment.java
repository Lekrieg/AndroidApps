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
import com.lekrieg.fragmentsexample.adapter.MangaAdapter;
import com.lekrieg.fragmentsexample.model.Manga;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MangaFragment extends Fragment {

	private RecyclerView recyclerViewManga;
	private List<Manga> mangaList = new ArrayList<>();

	public MangaFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_manga, container, false);

		recyclerViewManga = view.findViewById(R.id.RecyclerViewManga);

		CreateMangaList();

		MangaAdapter mangaAdapter = new MangaAdapter(mangaList);

		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
		recyclerViewManga.setLayoutManager(layoutManager);
		recyclerViewManga.setHasFixedSize(true);
		recyclerViewManga.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
		recyclerViewManga.setAdapter(mangaAdapter);

		return view;
	}

	private void CreateMangaList()
	{
		Manga manga = new Manga(R.drawable.manga_beck, "Beck", "Drama/Musical", "Autor: Harold Sakuishi");
		mangaList.add(manga);

		manga = new Manga(R.drawable.manga_gangsta, "Gangsta", "Action/Drama", "Autor: Kohske");
		mangaList.add(manga);

		manga = new Manga(R.drawable.manga_gantz, "Gantz", "Action/Drama/Horror", "Autor: Hiroya Oku");
		mangaList.add(manga);

		manga = new Manga(R.drawable.manga_gigante, "Gigant", "Drama/Ecchi/Romance", "Autor: Hiroya Oku");
		mangaList.add(manga);

		manga = new Manga(R.drawable.manga_rakudai, "Rakudai", "Action/Comedy/Seinen", "Autor: Misora Riku");
		mangaList.add(manga);

		manga = new Manga(R.drawable.manga_made_in_abyss, "Made in abyss", "Action/Fiction/Seinen", "Autor: Tsukushi Akihito");
		mangaList.add(manga);

		manga = new Manga(R.drawable.manga_fullmetal_alchemist, "Fullmetal Alchemist", "Action/Adventure", "Autor: Hiromu Arakawa");
		mangaList.add(manga);

		manga = new Manga(R.drawable.manga_zetsuen_no_tempest, "Zetsuen No Tempest", "Action/Drama/Magic", "Autor: Saizaki Ren");
		mangaList.add(manga);
	}
}

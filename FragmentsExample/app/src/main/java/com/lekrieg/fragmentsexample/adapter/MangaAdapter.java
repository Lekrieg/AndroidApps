package com.lekrieg.fragmentsexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lekrieg.fragmentsexample.R;
import com.lekrieg.fragmentsexample.model.Manga;

import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MyViewHolder> {
	private List<Manga> mangaList;

	public MangaAdapter(List<Manga> listAux)
	{
		this.mangaList = listAux;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_manga, parent, false);
		return new MyViewHolder(itemList);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		Manga manga = mangaList.get(position);

		holder.imageViewManga.setImageResource(manga.getMangaImageId());
		holder.textViewTitle.setText(manga.getMangaTitle());
		holder.textViewGenre.setText(manga.getMangaGenre());
		holder.textViewAuthor.setText(manga.getMangaAuthor());
	}

	@Override
	public int getItemCount() {
		return mangaList.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		private ImageView imageViewManga;
		private TextView textViewTitle;
		private TextView textViewGenre;
		private TextView textViewAuthor;

		public MyViewHolder(@NonNull View itemView) {
			super(itemView);

			imageViewManga = itemView.findViewById(R.id.imageViewManga);
			textViewTitle = itemView.findViewById(R.id.textViewMangaTitle);
			textViewGenre = itemView.findViewById(R.id.textViewMangaGenre);
			textViewAuthor = itemView.findViewById(R.id.textViewMangaAuthor);
		}
	}
}

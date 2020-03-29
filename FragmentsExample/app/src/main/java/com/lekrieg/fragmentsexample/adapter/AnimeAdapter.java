package com.lekrieg.fragmentsexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lekrieg.fragmentsexample.R;
import com.lekrieg.fragmentsexample.model.Anime;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyViewHolder> {

	private List<Anime> animeList;

	public AnimeAdapter(List<Anime> listAux)
	{
		this.animeList = listAux;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_anime, parent, false);
		return new MyViewHolder(itemList);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		Anime anime = animeList.get(position);

		// Seta a informacao
		holder.imageViewAnime.setImageResource(anime.getAnimeImageId());
		holder.textViewTitle.setText(anime.getAnimeTitle());
		holder.textViewYear.setText(anime.getAnimeYear());
		holder.textViewGenre.setText(anime.getAnimeGenre());
		holder.textViewAuthor.setText(anime.getAnimeAuthor());
	}

	@Override
	public int getItemCount() {
		return animeList.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		private ImageView imageViewAnime;
		private TextView textViewTitle;
		private TextView textViewYear;
		private TextView textViewGenre;
		private TextView textViewAuthor;

		public MyViewHolder(@NonNull View itemView) {
			super(itemView);

			imageViewAnime = itemView.findViewById(R.id.imageViewAnime);
			textViewTitle = itemView.findViewById(R.id.textViewAnimeTitle);
			textViewYear = itemView.findViewById(R.id.textViewAnimeYear);
			textViewGenre = itemView.findViewById(R.id.textViewAnimeGenre);
			textViewAuthor = itemView.findViewById(R.id.textViewAnimeAuthor);
		}
	}

}

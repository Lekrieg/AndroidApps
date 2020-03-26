package com.lekrieg.basicanimelist_recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lekrieg.basicanimelist_recyclerview.R;
import com.lekrieg.basicanimelist_recyclerview.activity.model.Anime;

import java.util.List;

public class AdapterAnimes extends RecyclerView.Adapter<AdapterAnimes.MyViewHolder> {

	private List<Anime> animeList;

	public AdapterAnimes(List<Anime> listAux)
	{
		this.animeList = listAux;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_anime_list, parent, false);

		return new MyViewHolder(itemList);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		Anime anime = animeList.get(position);

		holder.imageViewAnime.setImageResource(anime.getAnimeImage());
		holder.textViewAnimeName.setText(anime.getAnimeTitle());
		holder.textViewYear.setText(anime.getAnimeYear());
		holder.textViewGenre.setText(anime.getAnimeGenre());
	}

	@Override
	public int getItemCount() {
		return animeList.size();
	}

	public class MyViewHolder extends  RecyclerView.ViewHolder
	{
		ImageView imageViewAnime;
		TextView textViewAnimeName;
		TextView textViewYear;
		TextView textViewGenre;

		public MyViewHolder(@NonNull View itemView) {
			super(itemView);

			imageViewAnime = itemView.findViewById(R.id.imageViewAnime);
			textViewAnimeName = itemView.findViewById(R.id.textViewAnimeName);
			textViewYear = itemView.findViewById(R.id.textViewYear);
			textViewGenre = itemView.findViewById(R.id.textViewGenre);
		}
	}

}

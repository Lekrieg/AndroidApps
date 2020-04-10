package com.lekrieg.otakuextreme_prototype01.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.lekrieg.otakuextreme_prototype01.Activity.PlayerActivity;
import com.lekrieg.otakuextreme_prototype01.Model.Anime;
import com.lekrieg.otakuextreme_prototype01.R;

import java.util.List;

public class AnimeAdapter extends  RecyclerView.Adapter<AnimeAdapter.MyViewHolder> {
	private List<Anime> animeList;

	public AnimeAdapter(List<Anime> animeList) {
		this.animeList = animeList;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View itemListView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_anime, parent, false);

		return new MyViewHolder(itemListView);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		Anime anime = animeList.get(position);

		holder.imageViewAnime.setImageResource(anime.getAnimeImageID());
		holder.textViewAnimeName.setText(anime.getAnimeName());
		holder.textViewAnimeYear.setText(anime.getAnimeYear());
		// TODO: Modificar o rating para as estrelinhas
		holder.ratingBarAnime.setMax(5);
		holder.ratingBarAnime.setRating(anime.getAnimeRating());

		boolean isExpanded = anime.isExpanded();
		holder.expandableLayoutAnime.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
	}

	@Override
	public int getItemCount() {
		return animeList.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		private ImageView imageViewAnime;
		private ImageView imageViewPlayButton;
		private TextView textViewAnimeName;
		private TextView textViewAnimeYear;
		private RatingBar ratingBarAnime;

		ConstraintLayout expandableLayoutAnime;

		public MyViewHolder(@NonNull final View itemView) {
			super(itemView);

			imageViewAnime = itemView.findViewById(R.id.imageViewAnime);
			imageViewPlayButton = itemView.findViewById(R.id.imageViewPlayButton);
			textViewAnimeName = itemView.findViewById(R.id.textViewAnimeName);
			textViewAnimeYear = itemView.findViewById(R.id.textViewAnimeYear);
			ratingBarAnime = itemView.findViewById(R.id.ratingBarAnime);

			expandableLayoutAnime = itemView.findViewById(R.id.expandableLayoutAnime);

			imageViewPlayButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Anime anime = animeList.get(getAdapterPosition());

					Intent intent = new Intent(itemView.getContext().getApplicationContext(), PlayerActivity.class);
					intent.putExtra("videoID", anime.getAnimeVideoID());

					itemView.getContext().startActivity(intent);
				}
			});

			textViewAnimeName.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Anime anime = animeList.get(getAdapterPosition());
					anime.setExpanded(!anime.isExpanded());

					notifyItemChanged(getAdapterPosition());
				}
			});
		}
	}
}

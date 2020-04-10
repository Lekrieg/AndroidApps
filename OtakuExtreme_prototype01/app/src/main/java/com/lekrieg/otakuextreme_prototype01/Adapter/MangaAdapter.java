package com.lekrieg.otakuextreme_prototype01.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.lekrieg.otakuextreme_prototype01.Activity.MangaReaderActivity;
import com.lekrieg.otakuextreme_prototype01.Model.Manga;
import com.lekrieg.otakuextreme_prototype01.R;

import java.util.ArrayList;
import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MyViewHolder> {

	private List<Manga> mangaList;

	public MangaAdapter(List<Manga> mangaList) {
		this.mangaList = mangaList;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View itemListView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_manga, parent, false);

		return new MyViewHolder(itemListView);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		Manga manga = mangaList.get(position);

		holder.imageViewManga.setImageResource(manga.getMangaImageID());
		holder.textViewMangaName.setText(manga.getMangaName());
		holder.textViewMangaYear.setText(manga.getMangaYear());
		holder.textViewMangaRating.setText("Rating: " + manga.getMangaRating());

		boolean isExpanded = manga.isExpanded();
		holder.expandableLayoutManga.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
	}

	@Override
	public int getItemCount() {
		return mangaList.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder
	{
		private ImageView imageViewManga;
		private TextView textViewMangaName;
		private TextView textViewMangaYear;
		private TextView textViewMangaRating;

		ConstraintLayout expandableLayoutManga;

		public MyViewHolder(@NonNull final View itemView) {
			super(itemView);

			imageViewManga = itemView.findViewById(R.id.imageViewManga);
			textViewMangaName = itemView.findViewById(R.id.textViewMangaName);
			textViewMangaYear = itemView.findViewById(R.id.textViewMangaYear);
			textViewMangaRating = itemView.findViewById(R.id.textViewMangaRating);

			expandableLayoutManga = itemView.findViewById(R.id.expandableLayoutManga);

			imageViewManga.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Manga manga = mangaList.get(getAdapterPosition());

					Intent intent = new Intent(itemView.getContext().getApplicationContext(), MangaReaderActivity.class);
					// If I have more images I need to put the ID from manga class here to pass to the other activity
					// intent.putExtra("mangaID", manga.getMangaID());

					itemView.getContext().startActivity(intent);
				}
			});

			textViewMangaName.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Manga manga = mangaList.get(getAdapterPosition());
					manga.setExpanded(!manga.isExpanded());

					notifyItemChanged(getAdapterPosition());
				}
			});
		}
	}
}

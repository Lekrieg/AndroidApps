package com.lekrieg.basicanimelist_recyclerview.activity.model;

import android.media.Image;
import android.widget.ImageView;

public class Anime {
	private int animeImageID;
	private String animeTitle;
	private String animeYear;
	private String animeGenre;

	public Anime()
	{

	}

	public Anime(int animeImageID, String animeTitle, String animeYear, String animeGenre)
	{
		this.animeImageID = animeImageID;
		this.animeTitle = animeTitle;
		this.animeYear = animeYear;
		this.animeGenre = animeGenre;
	}

	public int getAnimeImage() {
		return animeImageID;
	}

	public void setAnimeImage(int animeImageID) {
		this.animeImageID = animeImageID;
	}

	public String getAnimeTitle() {
		return animeTitle;
	}

	public void setAnimeTitle(String animeTitle) {
		this.animeTitle = animeTitle;
	}

	public String getAnimeYear() {
		return animeYear;
	}

	public void setAnimeYear(String animeYear) {
		this.animeYear = animeYear;
	}

	public String getAnimeGenre() {
		return animeGenre;
	}

	public void setAnimeGenre(String animeGenre) {
		this.animeGenre = animeGenre;
	}
}

package com.lekrieg.fragmentsexample.model;

public class Anime {
	private int animeImageId;
	private String animeTitle;
	private String animeYear;
	private String animeGenre;
	private String animeAuthor;

	public Anime() {
	}

	public Anime(int animeImageId, String animeTitle, String animeYear, String animeGenre, String animeAuthor) {
		this.animeImageId = animeImageId;
		this.animeTitle = animeTitle;
		this.animeYear = animeYear;
		this.animeGenre = animeGenre;
		this.animeAuthor = animeAuthor;
	}

	public int getAnimeImageId() {
		return animeImageId;
	}

	public void setAnimeImageId(int animeImageId) {
		this.animeImageId = animeImageId;
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

	public String getAnimeAuthor() {
		return animeAuthor;
	}

	public void setAnimeAuthor(String animeAuthor) {
		this.animeAuthor = animeAuthor;
	}
}

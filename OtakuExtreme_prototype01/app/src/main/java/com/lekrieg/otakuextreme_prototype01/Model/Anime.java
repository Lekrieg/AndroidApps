package com.lekrieg.otakuextreme_prototype01.Model;

public class Anime {
	private int animeImageID;
	private int animeVideoID;
	private String animeName;
	private String animeYear;
	private float animeRating;

	private boolean expanded;

	public Anime(int animeImageID, int animeVideoID, String animeName, String animeYear, float animeRating) {
		this.animeImageID = animeImageID;
		this.animeVideoID = animeVideoID;
		this.animeName = animeName;
		this.animeYear = animeYear;
		this.animeRating = animeRating;

		expanded = false;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public int getAnimeVideoID() {
		return animeVideoID;
	}

	public void setAnimeVideoID(int animeVideoID) {
		this.animeVideoID = animeVideoID;
	}

	public int getAnimeImageID() {
		return animeImageID;
	}

	public void setAnimeImageID(int animeImageID) {
		this.animeImageID = animeImageID;
	}

	public String getAnimeName() {
		return animeName;
	}

	public void setAnimeName(String animeName) {
		this.animeName = animeName;
	}

	public String getAnimeYear() {
		return animeYear;
	}

	public void setAnimeYear(String animeYear) {
		this.animeYear = animeYear;
	}

	public float getAnimeRating() {
		return animeRating;
	}

	public void setAnimeRating(float animeRating) {
		this.animeRating = animeRating;
	}
}

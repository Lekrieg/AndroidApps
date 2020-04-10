package com.lekrieg.otakuextreme_prototype01.Model;

public class Manga {

	private int mangaImageID;
	private String mangaName;
	private String mangaYear;
	private double mangaRating;

	private boolean expanded;

	public Manga(int mangaImageID, String mangaName, String mangaYear, double mangaRating) {
		this.mangaImageID = mangaImageID;
		this.mangaName = mangaName;
		this.mangaYear = mangaYear;
		this.mangaRating = mangaRating;

		expanded = false;
	}

	public int getMangaImageID() {
		return mangaImageID;
	}

	public void setMangaImageID(int mangaImageID) {
		this.mangaImageID = mangaImageID;
	}

	public String getMangaName() {
		return mangaName;
	}

	public void setMangaName(String mangaName) {
		this.mangaName = mangaName;
	}

	public String getMangaYear() {
		return mangaYear;
	}

	public void setMangaYear(String mangaYear) {
		this.mangaYear = mangaYear;
	}

	public double getMangaRating() {
		return mangaRating;
	}

	public void setMangaRating(double mangaRating) {
		this.mangaRating = mangaRating;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
}

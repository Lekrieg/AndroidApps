package com.lekrieg.fragmentsexample.model;

public class Manga {
	private int mangaImageId;
	private String mangaTitle;
	private String mangaGenre;
	private String mangaAuthor;

	public Manga() {
	}

	public Manga(int mangaImageId, String mangaTitle, String mangaGenre, String mangaAuthor) {
		this.mangaImageId = mangaImageId;
		this.mangaTitle = mangaTitle;
		this.mangaGenre = mangaGenre;
		this.mangaAuthor = mangaAuthor;
	}

	public int getMangaImageId() {
		return mangaImageId;
	}

	public void setMangaImageId(int mangaImageId) {
		this.mangaImageId = mangaImageId;
	}

	public String getMangaTitle() {
		return mangaTitle;
	}

	public void setMangaTitle(String mangaTitle) {
		this.mangaTitle = mangaTitle;
	}

	public String getMangaGenre() {
		return mangaGenre;
	}

	public void setMangaGenre(String mangaGenre) {
		this.mangaGenre = mangaGenre;
	}

	public String getMangaAuthor() {
		return mangaAuthor;
	}

	public void setMangaAuthor(String mangaAuthor) {
		this.mangaAuthor = mangaAuthor;
	}
}

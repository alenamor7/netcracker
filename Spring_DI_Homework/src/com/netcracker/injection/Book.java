package com.netcracker.injection;

import com.netcracker.genres.IGenre;

public class Book {
    private IGenre genre;
    private String title;

    public Book(IGenre genre, String title) {
        this.genre = genre;
        this.title = title;
    }

    public Book() {
    }

    public IGenre getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(IGenre genre) {
        this.genre = genre;
    }

    public void setTitle(String titile) {
        this.title = titile;
    }

}

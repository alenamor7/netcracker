package com.netcracker.shared;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private Author author;
    private String title;
    private int pages;
    private int publishYear;
    private Date dateAdded;


    public Book(){}

    public Book(int id, Author author, String title, int pages, int publishYear, Date dateAdded) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.publishYear = publishYear;
        this.dateAdded = dateAdded;
    }

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Book)){
            return true;
        }
        Book book = (Book)obj;
        return book.id == id && book.author.equals(author) && book.title.equals(title) && book.pages == pages && book.publishYear == publishYear;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

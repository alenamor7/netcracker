package com.netcracker.collections;

import com.netcracker.injection.Book;

import java.util.List;

public class LibraryList {
    private List<Book> libraryList;

    public LibraryList(List<Book> library) {
        this.libraryList = library;
    }

    public LibraryList() {
    }

    public List<Book> getLibrary() {
        return libraryList;
    }

    public void setLibrary(List<Book> library) {
        this.libraryList = library;
    }

    @Override
    public String toString() {
        String result = "List: ";
        for(Book b : libraryList) {
            result += b.getTitle() + ", ";
        }
        return result;
    }
}

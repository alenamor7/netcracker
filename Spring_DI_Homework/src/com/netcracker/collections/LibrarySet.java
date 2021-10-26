package com.netcracker.collections;

import com.netcracker.injection.Book;

import java.util.Set;

public class LibrarySet {
    Set<Book> librarySet;

    public LibrarySet(Set<Book> librarySet) {
        this.librarySet = librarySet;
    }

    public LibrarySet() {
    }

    public void setLibrarySet(Set<Book> librarySet) {
        this.librarySet = librarySet;
    }

    public Set<Book> getLibrarySet() {
        return librarySet;
    }

    @Override
    public String toString() {
        String result = "Set: ";
        for(Book b : librarySet) {
            result += b.getTitle() + ", ";
        }
        return result;
    }
}

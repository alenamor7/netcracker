package com.netcracker.collections;

import com.netcracker.injection.Book;

import java.util.Map;

public class LibraryMap {
    private Map<Integer, Book> libraryMap;

    public LibraryMap(Map<Integer, Book> libraryMap) {
        this.libraryMap = libraryMap;
    }

    public LibraryMap() {
    }

    public Map<Integer, Book> getLibraryMap() {
        return libraryMap;
    }

    public void setLibraryMap(Map<Integer, Book> libraryMap) {
        this.libraryMap = libraryMap;
    }

    @Override
    public String toString() {
        String result = "Map: ";
        for(Book b : libraryMap.values()) {
            result += b.getTitle() + ", ";
        }
        return result;
    }
}

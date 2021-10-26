package com.netcracker.genres;

public class GenresFactory {
    public IGenre getGenre(){
        return new Fantasy();
    }
}

package com.example.pmdb.Exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException() {
        super("No Movies Found");
    }
}

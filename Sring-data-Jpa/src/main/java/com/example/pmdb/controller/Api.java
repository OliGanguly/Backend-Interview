package com.example.pmdb.controller;

import com.example.pmdb.Entity.Movie;
import com.example.pmdb.Entity.Reviews;
import com.example.pmdb.Exception.MovieNotFoundException;
import com.example.pmdb.Repo.MovieRepo;
import com.example.pmdb.Repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Api {
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ReviewRepo reviewRepo;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> all = movieRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }
    @PostMapping("/add")
    public ResponseEntity<Movie> createMovie(@RequestHeader(name = "X_COUNTRY",required = false,defaultValue = "CANADA") String country ,@RequestBody Movie movie){
        movie.setCreateDate(Instant.now());
        movie.setUpdateDate(Instant.now());
        Movie save = movieRepo.save(movie);
        return  ResponseEntity.status(HttpStatus.CREATED).header("X_SERVED_Y","pragra "+country)
                .body(save);

    }
    @PostMapping("/movie/{id}/reviews")
    public ResponseEntity<Reviews> addReview(@PathVariable ("id") Long movieId,@RequestBody Reviews reviews){
        Optional<Reviews> movieOptional = reviewRepo.findById(movieId);
        Movie movie = movieOptional.orElseThrow(()->new MovieNotFoundException());
//        Movie movie = movieOptional.orElseThrow(MovieNotFoundException::new);
        Reviews save = reviewRepo.save(reviews);
        movieRepo
                .save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(save);

    }
}

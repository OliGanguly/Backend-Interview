package com.example.pmdb.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movie_id;
    private String movie_name;
    @Column(unique = true)
    private String uuid;
    @Column(columnDefinition = "BLOB")
    private String poster;
    //@Builder.Default
    //cascade - any operation we doing in parent should be cacaded
    //merge - update data(insert,updated)
    //persist-only created
    //remove delete movies pls delete reviews
    //refresh
    //fetch Eger automatically pull all reviews
    //lazy - get the movies no reviews
    //lazy - movie.getReviews then it get the reviews
    @OneToMany(targetEntity = Reviews.class, fetch=FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<Reviews> reviews;
    private Instant createDate;
    //@Builder.Default
    private Instant updateDate;

}

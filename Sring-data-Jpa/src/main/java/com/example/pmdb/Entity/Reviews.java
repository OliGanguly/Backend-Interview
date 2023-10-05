package com.example.pmdb.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reviews extends Movie {
    @Id
    @GeneratedValue
    private Long review_id;
    private int rating;
    private String comment;
    @ManyToOne
    private Movie movie;
    private Instant createDate;
    //@Builder.Default
    private Instant updateDate;
}

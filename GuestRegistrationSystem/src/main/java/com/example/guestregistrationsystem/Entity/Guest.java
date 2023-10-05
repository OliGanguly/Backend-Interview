package com.example.guestregistrationsystem.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "GUEST_DETAILS")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Guest_id")
    private int id;
    @Column(name = "Guest_first_name",nullable = false)
    private String firstName;
    @Column(name = "Guest_last_name",nullable = false)
    private String lastName;
    private String email;
    private Date createDate;
    private Date updateDate;
}

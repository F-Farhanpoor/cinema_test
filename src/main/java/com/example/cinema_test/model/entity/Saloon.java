package com.example.cinema_test.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name="saloonEntity")
@Table(name="cinema_saloon_tbl")
public class Saloon implements Serializable {

    @Id
    @SequenceGenerator(name = "saloonSeq", sequenceName = "saloon_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saloonSeq")

    @Column(name = "id")
    private Long id;

    @Column(name = "name", length =30 , nullable = false )
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(name = "cinema_saloon_seat_tbl")
    private List<Seat> seats;

    @Column(name = "status")
    private boolean status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "description")
    private String description;
}

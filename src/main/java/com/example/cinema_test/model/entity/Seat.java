package com.example.cinema_test.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name="seatEntity")
@Table(name="cinema_seat_tbl")
public class Seat implements Serializable {

    @Id
    @SequenceGenerator(name = "seatSeq", sequenceName = "seat_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seatSeq")

    @Column(name = "id")
    private Long id;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "label", length =30 , nullable = false )
    private String label;

    @Column(name = "price_ratio")
    private double priceRatio;

    @Column(name = "status")
    private boolean status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "description")
    private String description;
}

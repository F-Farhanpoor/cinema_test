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


@Entity(name="seatVoEntity")
@Table(name="cinema_seatVo_tbl")

public class SeatVo implements Serializable {

    @Id
    @SequenceGenerator(name = "seatVoSeq", sequenceName = "seat_vo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seatVoSeq")

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


    public SeatVo(Seat seat) {

        this.seatNumber = seat.getSeatNumber();
        this.label = seat.getLabel();
        this.priceRatio = seat.getPriceRatio();
        this.status = seat.isStatus();
        this.deleted = seat.isDeleted();
        this.description = seat.getDescription();
    }
}

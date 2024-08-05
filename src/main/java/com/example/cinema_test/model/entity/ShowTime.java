package com.example.cinema_test.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name="showTimeEntity")
@Table(name="cinema_show_time_tbl")
public class ShowTime implements Serializable {

    @Id
    @SequenceGenerator(name = "showTimeSeq", sequenceName = "show_time_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showTimeSeq")

    @Column(name = "id")
    private Long id;

    @OneToOne
    private Saloon saloon;

    @OneToOne
    private Show show;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cinema_show_seat_tbl")
    private List<SeatVo> showSeats;

    @Column(name = "status")
    private boolean status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "description")
    private String description;


    public void showSeatCreator(){

        if (showSeats == null){
            showSeats = new ArrayList<>();
        }

    }
}



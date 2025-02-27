package com.example.cinema_test.model.entity;

import com.example.cinema_test.model.entity.enums.ShowType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name="showEntity")
@Table(name="cinema_show_tbl")
public class Show implements Serializable {

    @Id
    @SequenceGenerator(name = "showSeq", sequenceName = "show_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showSeq")

    @Column(name = "id")
    private Long id;

    @Column(name = "name", length =30 , nullable = false )
    private String name;

    @Column(name = "genre", length =30)
    private String genre;

    @Column(name = "director", length =30)
    private String director;

    @Column(name = "released_date")
    private LocalDate releasedDate;

    @Column(name = "base_price")
    private double basePrice;

    @Column(name = "show_type")
    @Enumerated(EnumType.ORDINAL)
    private ShowType showType;

    @Column(name = "status")
    private boolean status;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "description")
    private String description;
}

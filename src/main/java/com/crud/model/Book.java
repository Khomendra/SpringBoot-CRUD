package com.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_price")
    private int price;
}

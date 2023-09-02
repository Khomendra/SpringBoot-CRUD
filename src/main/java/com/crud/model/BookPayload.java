package com.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookPayload {
    @JsonProperty(value = "book_id")
    private int id;
    @JsonProperty(value = "book_name")
    private String bookName;
    @JsonProperty(value = "book_author")
    private String author;
    @JsonProperty(value = "book_price")
    private int price;
}

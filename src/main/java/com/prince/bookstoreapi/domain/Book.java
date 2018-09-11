package com.prince.bookstoreapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private String format;
    private Integer pages;
    private String isbn;
    private Double weight;
    private Double originalPrice;
    private Double discountedPrice;
    private Boolean isActive;
    private Integer numbersInStock;

    @Column(columnDefinition = "text")
    private String description;

    @Transient
    private MultipartFile image;
}

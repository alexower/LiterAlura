package com.alura.literatura.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String name;
    private String birth_year;
    private String death_year;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(){}

    public Author(DataAuthor dataAuthor) {
        this.name = dataAuthor.name();
        this.birth_year = dataAuthor.birth_year();
        this.death_year = dataAuthor.death_year();
        this.books = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getDeath_year() {
        return death_year;
    }

    public void setDeath_year(String death_year) {
        this.death_year = death_year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

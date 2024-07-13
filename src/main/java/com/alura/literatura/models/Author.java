package com.alura.literatura.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String name;
    @Column(name = "birth_year")
    private Integer birth_year;
    @Column(name = "death_year")
    private Integer death_year;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(){}

    public Author(DataAuthor dataAuthor) {
        this.name = dataAuthor.name();
        this.birth_year = dataAuthor.birth_year();
        this.death_year = dataAuthor.death_year();
        this.books = new ArrayList<>();
    }

    @Override
    public String toString() {
        return
                "----------------------------------\n"+
                "Author     = " + name + "\n"+
                "Birth year = " + birth_year + "\n"+
                "Death year = " + death_year + "\n"+
                "Books      = [" + books.stream().map(Book::getTitle).collect(Collectors.joining())+"]";

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

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

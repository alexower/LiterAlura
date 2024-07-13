package com.alura.literatura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String nameAuthor;
    private String language;
    private Double downloads;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    public Book(){}

    public Book(DataBook dataBook,Author author){
        this.title = dataBook.title();
        this.nameAuthor = author.getName();
        this.language = dataBook.languages().get(0);
        this.downloads = dataBook.downloads();
        this.author = author;

    }

    @Override
    public String toString() {
        return
                "****************************\n"+
                " Libro    = " + title + "\n" +
                " Autor     = " + nameAuthor + "\n" +
                " Lenguaje  =  " + language + "\n" +
                " Descargas = " + downloads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return nameAuthor;
    }

    public void setAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }
}

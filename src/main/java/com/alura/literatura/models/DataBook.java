package com.alura.literatura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
                              String title,
        @JsonAlias("authors") List<DataAuthor> author,
                              List<String> languages,
        @JsonAlias("download_count") Double downloads) {

}

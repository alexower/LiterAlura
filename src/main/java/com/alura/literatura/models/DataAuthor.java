package com.alura.literatura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(
        String name,
        String birth_year,
        String death_year) {
}

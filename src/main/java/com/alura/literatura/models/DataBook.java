package com.alura.literatura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.core.annotation.AliasFor;

public record Book(
        @JsonAlias("title") String titulo,
        @JsonAlias("title") List<Autores> autor) {
}

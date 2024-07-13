package com.alura.literatura.repository;

import com.alura.literatura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository  extends JpaRepository <Author,Long> {

        Optional<Author> findByName(String name);

}


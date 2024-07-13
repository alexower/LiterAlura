package com.alura.literatura.repository;

import com.alura.literatura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository  extends JpaRepository <Author,Long> {

        Optional<Author> findByName(String name);

        @Query("SELECT a FROM Author a WHERE a.birth_year <= :year AND a.death_year >= :year")
        List<Author> findAuthorNamesAliveInYear(@Param("year") Integer year);

}


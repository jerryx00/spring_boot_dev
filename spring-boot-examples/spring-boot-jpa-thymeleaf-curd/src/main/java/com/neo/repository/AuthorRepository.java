package com.neo.repository;

import com.neo.entity.Author;
import com.neo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);

    List<Author> findByNameContaining(String name);

    Author findById(long id);

    Long deleteById(Long id);
}
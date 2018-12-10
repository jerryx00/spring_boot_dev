package com.neo.service.impl;

import com.neo.entity.Author;
import com.neo.entity.User;
import com.neo.repository.AuthorRepository;
import com.neo.repository.UserRepository;
import com.neo.service.AuthorService;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getList() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void edit(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(long id) {
        authorRepository.delete(id);
    }
}



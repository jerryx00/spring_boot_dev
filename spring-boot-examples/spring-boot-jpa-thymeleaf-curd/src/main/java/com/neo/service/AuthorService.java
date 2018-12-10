package com.neo.service;

import com.neo.entity.Author;
import com.neo.entity.User;

import java.util.List;

public interface AuthorService {

    public List<Author> getList();

    public Author findById(long id);

    public void save(Author author);

    public void edit(Author author);

    public void delete(long id);


}

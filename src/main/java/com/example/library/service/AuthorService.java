package com.example.library.service;

import com.example.library.model.Author;
import java.util.List;

public interface AuthorService {
    Author getAuthorById(Long id);

    Author createAuthor(Author author);

    List<Author> getAllAuthors();

    void deleteAuthorById(Long id);
}

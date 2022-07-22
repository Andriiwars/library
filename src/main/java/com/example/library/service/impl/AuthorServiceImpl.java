package com.example.library.service.impl;

import com.example.library.dao.AuthorDao;
import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorDao.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get author by id " + id));
    }

    @Override
    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorDao.deleteById(id);
    }
}

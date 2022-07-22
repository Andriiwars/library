package com.example.library.service.impl;

import com.example.library.dao.BookDao;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book createBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.findById(id).orElseThrow(() ->
                new RuntimeException("Cant get book by this id " + id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public void deleteBookById(Long id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> findAllByAuthorName(String authorName) {
        return bookDao.findAllByAuthorName(authorName);
    }

    @Override
    public Book getBookByMaxSoldByAuthorName(String authorName) {
        return bookDao.getBookByMaxSoldByAuthorName(authorName);
    }

    @Override
    public Book getBookPublishedByAuthorName(String authorName) {
        return bookDao.getBookPublishedByAuthorName(authorName);
    }

    @Override
    public List<Book> getAllBooksSuccessRateOfAuthor(String authorName) {
        return bookDao.getAllBooksSuccessRateOfAuthor(authorName);
    }

    @Override
    public List<Book> getBooksPublishedByAuthorPartName(String authorName) {
        return bookDao.getBooksPublishedByAuthorPartName(authorName);
    }

    @Override
    public List<Book> getBookByMaxSoldByAuthorPartName(String authorName) {
        return bookDao.getBookByMaxSoldByAuthorPartName(authorName);
    }
}

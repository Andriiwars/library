package com.example.library.service;

import com.example.library.model.Book;
import java.util.List;

public interface BookService {
    Book createBook(Book book);

    Book getBookById(Long id);

    List<Book> getAllBooks();

    void deleteBookById(Long id);

    List<Book> findAllByAuthorName(String authorName);

    Book getBookByMaxSoldByAuthorName(String authorName);

    Book getBookPublishedByAuthorName(String authorName);

    List<Book> getAllBooksSuccessRateOfAuthor(String authorName);

    List<Book> getBooksPublishedByAuthorPartName(String authorName);

    List<Book> getBookByMaxSoldByAuthorPartName(String authorName);
}

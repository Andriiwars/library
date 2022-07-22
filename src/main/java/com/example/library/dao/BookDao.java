package com.example.library.dao;

import com.example.library.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
    @Query(value = "select book "
            + "from Book book "
            + "where book.author.authorName = :authorName")
    List<Book> findAllByAuthorName(String authorName);

    @Query(value = "select book "
            + "from Book book "
            + "where book.author.authorName = :authorName and "
            + "book.soldAmount = (select max(b.soldAmount) from Book b "
            + "where b.author.authorName = :authorName)")
    Book getBookByMaxSoldByAuthorName(String authorName);

    @Query(value = "select book "
            + "from Book book "
            + "where book.author.authorName like %:authorName% and "
            + "book.soldAmount = (select max(b.soldAmount) from Book b "
            + "where b.author.authorName = book.author.authorName)")
    List<Book> getBookByMaxSoldByAuthorPartName(String authorName);

    @Query(value = "select book "
            + "from Book book "
            + "where book.author.authorName = :authorName and "
            + "book.publishedAmount = (select max(book.publishedAmount) from Book b "
            + "where b.author.authorName = :authorName)")
    Book getBookPublishedByAuthorName(String authorName);

    @Query(value = "select book "
            + "from Book book "
            + "where book.author.authorName like %:authorName% and "
            + "book.publishedAmount = (select max(b.publishedAmount) from Book b "
            + "where b.author.authorName = book.author.authorName)")
    List<Book> getBooksPublishedByAuthorPartName(String authorName);

    @Query(value = "select book "
            + "from Book book "
            + "where book.author.authorName like %:authorName% and "
            + "(book.soldAmount / book.publishedAmount) = "
            + "(select max(b.soldAmount / b.publishedAmount) from Book b "
            + "where b.author.authorName = book.author.authorName)")
    List<Book> getAllBooksSuccessRateOfAuthor(String authorName);
}

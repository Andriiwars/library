package com.example.library.service.mapper;

import com.example.library.dto.request.BookRequestDto;
import com.example.library.dto.response.BookResponseDto;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Book mapToModel(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setBookName(bookRequestDto.getBookName());
        book.setPublishedAmount(bookRequestDto.getPublishedAmount());
        book.setSoldAmount(bookRequestDto.getSoldAmount());
        book.setAuthor(authorService.getAuthorById(bookRequestDto.getAuthorId()));
        return book;
    }

    public BookResponseDto mapToDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setBookName(book.getBookName());
        bookResponseDto.setPublishedAmount(book.getPublishedAmount());
        bookResponseDto.setSoldAmount(book.getSoldAmount());
        bookResponseDto.setAuthorId(book.getAuthor().getId());
        return bookResponseDto;
    }
}

package com.example.library.controller;

import com.example.library.dto.request.BookRequestDto;
import com.example.library.dto.response.BookResponseDto;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import com.example.library.service.mapper.BookMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final AuthorService authorService;

    public BookController(BookService bookService,
                          BookMapper bookMapper,
                          AuthorService authorService) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
        this.authorService = authorService;
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks()
                .stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookResponseDto getById(@PathVariable Long id) {
        return bookMapper.mapToDto(bookService.getBookById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto createBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
        return bookMapper.mapToDto(bookService.createBook(
                bookMapper.mapToModel(bookRequestDto)));
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "Book by id " + id + " is deleted";
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id,
                                      @Valid @RequestBody BookRequestDto bookRequestDto) {
        Book book = bookMapper.mapToModel(bookRequestDto);
        book.setId(id);
        return bookMapper.mapToDto(bookService.createBook(book));
    }

    @GetMapping("/author-name")
    public List<BookResponseDto> findAllByAuthorName(@RequestParam String authorName) {
        return bookService.findAllByAuthorName(authorName).stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/max-sold")
    public BookResponseDto getBookByMaxSoldByAuthorName(@RequestParam
                                                            String authorName) {
        return bookMapper.mapToDto(bookService.getBookByMaxSoldByAuthorName(authorName));
    }

    @GetMapping("/most-published")
    public BookResponseDto getBookPublishedByAuthorName(@RequestParam
                                                            String authorName) {
        return bookMapper.mapToDto(bookService.getBookPublishedByAuthorName(authorName));
    }

    @GetMapping("/most-success-rate")
    public List<BookResponseDto> getAllBooksSuccessRateOfAuthor(@RequestParam
                                                                    String authorPartName) {
        return bookService.getAllBooksSuccessRateOfAuthor(authorPartName).stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-published-by-part-name")
    public List<BookResponseDto> getBooksPublishedByAuthorPartName(@RequestParam
                                                                       String authorPartName) {
        return bookService.getBooksPublishedByAuthorPartName(authorPartName).stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/max-sold-by-part-name")
    public List<BookResponseDto> getBookByMaxSoldByAuthorPartName(@RequestParam
                                                                      String authorPartName) {
        return bookService.getBookByMaxSoldByAuthorPartName(authorPartName).stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

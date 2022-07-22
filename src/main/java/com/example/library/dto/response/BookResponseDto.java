package com.example.library.dto.response;

import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String bookName;
    private Long publishedAmount;
    private Long soldAmount;
    private Long authorId;
}

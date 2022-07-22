package com.example.library.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotNull
    private String bookName;
    @NotNull
    private Long publishedAmount;
    @NotNull
    private Long soldAmount;
    @NotNull
    private Long authorId;
}

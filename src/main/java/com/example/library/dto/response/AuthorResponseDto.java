package com.example.library.dto.response;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Long id;
    private String authorName;
    private String birthDate;
    private String phone;
    private String email;
}

package com.example.library.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthorRequestDto {
    @NotNull
    private String authorName;
    @NotNull
    private String birthDate;
    @NotNull
    private String phone;
    @NotNull
    private String email;
}

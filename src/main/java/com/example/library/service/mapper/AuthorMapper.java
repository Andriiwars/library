package com.example.library.service.mapper;

import com.example.library.dto.request.AuthorRequestDto;
import com.example.library.dto.response.AuthorResponseDto;
import com.example.library.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author mapToModel(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setAuthorName(authorRequestDto.getAuthorName());
        author.setBirthDate(authorRequestDto.getBirthDate());
        author.setEmail(authorRequestDto.getEmail());
        author.setPhone(authorRequestDto.getPhone());
        return author;
    }

    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setAuthorName(author.getAuthorName());
        authorResponseDto.setBirthDate(author.getBirthDate());
        authorResponseDto.setEmail(author.getEmail());
        authorResponseDto.setPhone(author.getPhone());
        return authorResponseDto;
    }
}

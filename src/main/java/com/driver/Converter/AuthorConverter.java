package com.driver.Converter;

import com.driver.RequestDto.AuthorRequestDto;
import com.driver.models.Author;

public class AuthorConverter {

    public static Author convertDtoToAuthor(AuthorRequestDto authorRequestDto) {
        Author author;
        try {
            author = Author.builder().name(authorRequestDto.getName()).email(authorRequestDto.getEmail()).
                    age(authorRequestDto.getAge()).country(authorRequestDto.getCountry()).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return author;
    }
}

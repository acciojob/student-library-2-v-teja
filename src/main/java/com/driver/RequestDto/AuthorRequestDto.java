package com.driver.RequestDto;



import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
public class AuthorRequestDto {

    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    private String country;

    public AuthorRequestDto(){

    }

    public AuthorRequestDto(String name, String email, int age, String country) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.country = country;
    }
}

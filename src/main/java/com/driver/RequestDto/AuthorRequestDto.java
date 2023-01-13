package com.driver.RequestDto;



import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestDto {

    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    private String country;
}

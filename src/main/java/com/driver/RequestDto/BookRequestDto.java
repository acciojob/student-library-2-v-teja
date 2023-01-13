package com.driver.RequestDto;

import com.driver.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int authorId;

    private int cardId;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean available;


}

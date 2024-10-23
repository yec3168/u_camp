package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookReqDTO {
    private Long id;

    @NotBlank(message = "Title은 필수 입력값입니다.")
    private String title;

    @NotBlank(message = "Author는 필수 입력값입니다.")
    private String author;

    @NotBlank(message = "Genre은 필수 입력값입니다.")
    private String genre;

    @NotBlank(message = "Isbn은 필수 입력값입니다.")
    private String isbn;

    @NotNull(message = "쪽수를 입력해 주세요..")
    @Min(message = "쪽수는 최소한 50이상으로 입력해주세요.", value = 50)
    private Integer pages;
}

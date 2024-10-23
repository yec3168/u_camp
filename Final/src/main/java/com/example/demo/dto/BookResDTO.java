package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class BookResDTO {
    private Long id;

    private String title;

    private String author;

    private String genre;

    private String isbn;

    private int pages;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm E a", timezone = "Asia/Seoul")
    private LocalDateTime created_at;
}

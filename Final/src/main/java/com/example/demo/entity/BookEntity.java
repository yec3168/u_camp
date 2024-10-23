package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Getter @Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(nullable = false)
    private String genre;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private int pages;

    @Column(nullable = false)
    private String title;
}

package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    // isBn으로 조회.
    Optional<BookEntity> findByIsbn(String isBn);

    @Query("SELECT b from BookEntity b where b.pages >= :pages ")
    List<BookEntity> findByPages(@Param("pages")int pages);

    @Query("SELECT b from BookEntity b where b.title like %:title%")
    List<BookEntity> findByTitle(@Param("title") String title);
}

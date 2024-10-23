package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookSimpleRestController {

    private final BookRepository bookRepository;

    //등록
    @PostMapping
    public BookEntity saveBook(@RequestBody BookEntity bookEntity){
        return bookRepository.save(bookEntity);
    }

    // 전체목록조회
    @GetMapping
    public List<BookEntity> getBooks(){
        return bookRepository.findAll();
    }

    //id로 조회
    @GetMapping("/{id}")
    public BookEntity getBookById(@PathVariable("id")Long id){
        return getBookNotFound(id);
    }

    //ISBN 으로 조회
    @GetMapping("/isbn/{idbn}")
    public BookEntity getBookByIsbn(@PathVariable("idbn") String idbn){
        return bookRepository.findByIsbn(idbn)
                .orElseThrow(
                        () -> new BusinessException("Book not Found", HttpStatus.NOT_FOUND)
                );
    }

    //수정
    @PutMapping("/{id}")
    public BookEntity updateBook(@PathVariable("id")Long id, @RequestBody BookEntity bookEntity){
        BookEntity exist = getBookNotFound(id);
        exist.setAuthor(bookEntity.getAuthor()); // 작가 수정.
        exist.setGenre(bookEntity.getGenre()); //카테고리 수정
        exist.setIsbn(bookEntity.getIsbn()); // 책번호 수정
        exist.setPages(bookEntity.getPages()); // 페이지 수정
        exist.setTitle(bookEntity.getTitle()); // title 수정
        
        return bookRepository.save(exist);

    }
    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id")Long id){
        BookEntity exist = getBookNotFound(id);
        bookRepository.delete(exist);

        return ResponseEntity.ok(id + " 의 책이 db에서 삭제되었습니다.");
    }

    private BookEntity getBookNotFound(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException("Book not Found", HttpStatus.NOT_FOUND)
                );
    }
}

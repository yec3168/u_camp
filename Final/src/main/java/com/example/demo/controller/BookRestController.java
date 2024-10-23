package com.example.demo.controller;

import com.example.demo.dto.BookReqDTO;
import com.example.demo.dto.BookResDTO;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    //등록
    @PostMapping
    public BookResDTO saveBook(@RequestBody BookReqDTO bookReqDTO){
        return bookService.saveBook(bookReqDTO);
    }

    @GetMapping
    public List<BookResDTO> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookResDTO getBookById(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/pages/{pages}")
    public List<BookResDTO> getBooksByPages(@PathVariable("pages")int pages){
        return bookService.getBooksByPages(pages);
    }

    @GetMapping("/title/{title}/")
    public List<BookResDTO> getBooksByTitle(@PathVariable("title")String title){
        return bookService.getBooksByTitle(title);
    }

    @PutMapping("/{id}")
    public BookResDTO updateBook(@PathVariable("id")Long id, @RequestBody BookReqDTO bookReqDTO){
        return bookService.updateBook(id, bookReqDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id")Long id){
        return bookService.deleteBook(id);
    }
}

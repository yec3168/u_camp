package com.example.demo.service;


import com.example.demo.dto.BookReqDTO;
import com.example.demo.dto.BookResDTO;
import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public BookResDTO saveBook(BookReqDTO bookReqDTO){
        BookEntity bookEntity = modelMapper.map(bookReqDTO, BookEntity.class);

        bookRepository.save(bookEntity);

        return modelMapper.map(bookEntity, BookResDTO.class);
    }

    public List<BookResDTO> getBooks(){
        return bookRepository.findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookResDTO.class))
                .toList();
    }

    public BookResDTO getBookById(Long id){
        return bookRepository.findById(id)
                .map(bookEntity -> modelMapper.map(bookEntity, BookResDTO.class))
                .orElseThrow(
                        () -> new BusinessException("Book not Found", HttpStatus.NOT_FOUND)
                );

    }

    public List<BookResDTO> getBooksByPages(int pages){
        return bookRepository.findByPages(pages)
                .stream()
                .map(book -> modelMapper.map(book, BookResDTO.class))
                .toList();
    }

    public List<BookResDTO> getBooksByTitle(String title){
        return bookRepository.findByTitle(title)
                .stream()
                .map(book -> modelMapper.map(book, BookResDTO.class))
                .toList();
    }

    @Transactional
    public BookResDTO updateBook(Long id, BookReqDTO bookReqDTO){
        BookEntity exist = getBookNotFound(id);
        exist.setTitle(bookReqDTO.getTitle());
        exist.setAuthor(bookReqDTO.getAuthor());
        exist.setGenre(bookReqDTO.getGenre());
        exist.setIsbn(bookReqDTO.getIsbn());
        exist.setPages(bookReqDTO.getPages());

        return modelMapper.map(exist, BookResDTO.class);
    }
    @Transactional
    public ResponseEntity<?> deleteBook(Long id){
        BookEntity exist = getBookNotFound(id);
        bookRepository.delete(exist);

        return ResponseEntity.ok(id + " 의 책이 db에서 삭제되었습니다.");
    }

    public BookEntity getBookNotFound(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException("Book not Found", HttpStatus.NOT_FOUND)
                );
    }
}

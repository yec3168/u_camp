package com.example.demo.controller;

import com.example.demo.dto.BookReqDTO;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bookpage")
public class BookController {

    private final BookService bookService;

    @GetMapping("/index")
    public String bookList(Model model){
        model.addAttribute("bookList", bookService.getBooks());

        return "list-book";
    }

    @GetMapping("/addForm")
    public String showAddForm(Model model){
        model.addAttribute("bookRequest", new BookReqDTO());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("bookRequest") BookReqDTO bookReqDTO,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-book";
        }

        bookService.saveBook(bookReqDTO);

        return "redirect:/bookpage/index";
    }

    @GetMapping("/editForm/{id}")
    public String showUpdateForm(@PathVariable("id") Long id,
                                 Model model){
        model.addAttribute("bookRequest", bookService.getBookById(id));

        return "update-book";

    }

    @PostMapping("/edit/{id}")
    public String updateBook(@Valid @ModelAttribute("bookRequest") BookReqDTO bookReqDTO,
                             BindingResult bindingResult,
                             @PathVariable("id")Long id){
        if(bindingResult.hasErrors()){
            return "update-book";
        }

        bookService.updateBook(id, bookReqDTO);

        return "redirect:/bookpage/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id")Long id){
        bookService.deleteBook(id);

        return "redirect:/bookpage/index";
    }
}

package com.esExampleTwo.studentDataElasticsearchEx.controller;

import com.esExampleTwo.studentDataElasticsearchEx.model.Book;
import com.esExampleTwo.studentDataElasticsearchEx.search.SearchRequestDTO;
import com.esExampleTwo.studentDataElasticsearchEx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/book")
public class BookControlller {

    private final BookService bookService;

    @Autowired
    public BookControlller(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void index(@RequestBody final Book book) {
        bookService.index(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable final String id) {
        return bookService.getById(id);
    }

    @PostMapping("/search")
    public List<Book> search(@RequestBody final SearchRequestDTO dto) {
        return bookService.search(dto);
    }
}

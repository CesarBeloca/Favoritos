package com.coracaonamao.favoritos.controllers;


import com.coracaonamao.favoritos.dtos.BookDto;
import com.coracaonamao.favoritos.entities.Book;
import com.coracaonamao.favoritos.services.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto) {
        var book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") Long id) {
        Optional<Book> bookModelOptional = bookService.findByID(id);
        bookService.delete(bookModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> list = bookService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll());
    }

    @GetMapping(value = "/book/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
        Book book = bookService.findByID(id).get();
        return ResponseEntity.ok().body(book);
    }

    @GetMapping(value = "/author/{author}")
    public ResponseEntity<List<Book>> findAllByAuthor(@PathVariable("author") String author) {
        List<Book> listByAuthor = bookService.findAllByAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAllByAuthor(author));
    }

    @GetMapping(value = "/genre/{genre}")
    public ResponseEntity<List<Book>> findAllByGenre(@PathVariable("genre") String genre) {
        List<Book> listByGenre = bookService.findAllByGenre(genre);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAllByGenre(genre));
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<List<Book>> findAllByYear(@PathVariable("year") String year) {
        List<Book> listByYear = bookService.findAllByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAllByYear(year));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(value = "id") Long id,
                                             @RequestBody BookDto bookDto) {
        Optional<Book> bookOptional = bookService.findByID(id);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        var book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        book.setId(bookOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(bookService.save(book));
    }
}

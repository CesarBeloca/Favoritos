package com.coracaonamao.favoritos.services;

import com.coracaonamao.favoritos.entities.Book;
import com.coracaonamao.favoritos.repositories.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findByID(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public void delete(Book book) {
        this.bookRepository.delete(book);
    }

    public List<Book> findAllByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> findAllByGenre(String genre) {
        return bookRepository.findAllByGenre(genre);
    }

    public List<Book> findAllByYear(String year) {
        return bookRepository.findAllByYear(year);
    }
}

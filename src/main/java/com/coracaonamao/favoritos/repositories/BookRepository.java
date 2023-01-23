package com.coracaonamao.favoritos.repositories;

import com.coracaonamao.favoritos.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByGenre(String genre);

    List<Book> findAllByYear(String year);
}

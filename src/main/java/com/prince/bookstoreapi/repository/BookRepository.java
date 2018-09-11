package com.prince.bookstoreapi.repository;

import com.prince.bookstoreapi.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitleContaining(String titleKeyword);
}

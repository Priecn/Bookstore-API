package com.prince.bookstoreapi.service;

import com.prince.bookstoreapi.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> listAllBooks();
    Book findBookById(Long bookId);
    Book save(Book newBook);
    void remove(Long bookId);
    List<Book> searchBookTitle(String titleKeyword);
}

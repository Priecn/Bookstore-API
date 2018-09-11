package com.prince.bookstoreapi.service;

import com.prince.bookstoreapi.domain.Book;
import com.prince.bookstoreapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll()
                .forEach(book -> {
                    if(book.getIsActive())
                        bookList.add(book);
                });
        return bookList;
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public Book save(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public void remove(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> searchBookTitle(String titleKeyword) {
        return bookRepository.findByTitleContaining(titleKeyword);
    }
}

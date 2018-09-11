package com.prince.bookstoreapi.resources;

import com.prince.bookstoreapi.domain.Book;
import com.prince.bookstoreapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

@RestController
@RequestMapping("/book")
public class BookResource {

    private BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        Book createdBook = bookService.save(newBook);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PostMapping("/image/upload")
    public ResponseEntity<String> uploadImage(@RequestParam Long bookId,
                                      HttpServletRequest request) {
        try {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartHttpServletRequest.getFileNames();
            while(it.hasNext()) {
                MultipartFile multipartFile = multipartHttpServletRequest.getFile(it.next());
                String fileName = bookId + "_" + multipartFile.getName()+".png";
                byte[] bytes = multipartFile.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("src/main/resources/static/images/book/" + fileName)));
                stream.write(bytes);
                stream.close();
            }
            return new ResponseEntity<>("Upload success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }
}

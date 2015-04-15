package org.apache.karaf.sample.acna15.persistence.api;

import org.apache.karaf.sample.acna15.persistence.entity.Book;

import java.util.List;

public interface BookService {

    Book getBookByName(String name);

    Book getBookByIsbn(String isbn);

    void createBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

}

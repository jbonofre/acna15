package org.apache.karaf.sample.acna15.persistence.dao;

import org.apache.karaf.sample.acna15.persistence.api.BookService;
import org.apache.karaf.sample.acna15.persistence.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookServiceImpl implements BookService {

    EntityManager em;

    void close() {
        em.close();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Book getBookByName(String name) {
        TypedQuery<Book> query = em.createQuery("SELECT book FROM Book WHERE book.name=:name", Book.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    public Book getBookByIsbn(String isbn) {
        TypedQuery<Book> query = em.createQuery("SELECT book FROM Book WHERE book.isbn=:isbn", Book.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    public Book getBookById(Long id) {
        TypedQuery<Book> query = em.createQuery("SELECT book FROM Book WHERE book.id=:id", Book.class);
        query.setParameter("id", id);
        Book book = null;
        try {
            book = query.getSingleResult();
        } catch (NoResultException e) {
            // nothing to do
        }
        return book;
    }

    public void createBook(Book book) {
        em.persist(book);
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> query = em.createQuery("SELECT book FROM Book book ORDER BY book.name", Book.class);
        return query.getResultList();
    }

}

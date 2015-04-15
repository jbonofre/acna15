package org.apache.karaf.sample.acna15.rest;

import org.apache.karaf.sample.acna15.persistence.api.BookService;
import org.apache.karaf.sample.acna15.persistence.entity.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class BookRestService {

    private BookService bookService;

    @GET
    @Produces("application/xml")
    @Path("/books")
    public List<BookRestView> getAllBooks() {
        ArrayList<BookRestView> list = new ArrayList<BookRestView>();
        for (Book book : bookService.getAllBooks()) {
            BookRestView restBook = new BookRestView();
            restBook.id = book.getId();
            restBook.title = book.getName();
            restBook.isbn = book.getIsbn();
            list.add(restBook);
        }
        return list;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

}

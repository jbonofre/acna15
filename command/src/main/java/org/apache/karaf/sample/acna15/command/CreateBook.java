package org.apache.karaf.sample.acna15.command;

import org.apache.karaf.sample.acna15.persistence.api.BookService;
import org.apache.karaf.sample.acna15.persistence.entity.Book;
import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;

@Command(scope = "apachecon", name = "create-book", description = "Create and persist a new book")
public class CreateBook extends OsgiCommandSupport {

    @Option(name = "-i", aliases = { "--isbn" }, description = "The ISBN of the book", required = false, multiValued = false)
    private String isbn;

    @Argument(name = "name", description = "The name of the book", required = true, multiValued = false)
    private String name;

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    protected Object doExecute() throws Exception {
        Book book = new Book();
        book.setName(name);
        book.setIsbn(isbn);

        bookService.createBook(book);

        System.out.println("Book " + name  + " created");

        return null;
    }

}

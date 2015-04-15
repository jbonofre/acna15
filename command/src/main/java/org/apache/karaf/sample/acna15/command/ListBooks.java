package org.apache.karaf.sample.acna15.command;

import org.apache.karaf.sample.acna15.persistence.api.BookService;
import org.apache.karaf.sample.acna15.persistence.entity.Book;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.apache.karaf.shell.table.Col;
import org.apache.karaf.shell.table.ShellTable;

import java.util.List;

@Command(scope = "apachecon", name = "list-books", description = "List books")
public class ListBooks extends OsgiCommandSupport {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected Object doExecute() throws Exception {

        List<Book> books = bookService.getAllBooks();

        ShellTable table = new ShellTable();
        table.column(new Col("ID"));
        table.column(new Col("Name"));
        table.column(new Col("ISBN"));

        for (Book book : books) {
            table.addRow().addContent(book.getId(), book.getName(), book.getIsbn());
        }

        table.print(System.out);

        return null;
    }

}

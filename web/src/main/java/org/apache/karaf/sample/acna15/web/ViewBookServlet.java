package org.apache.karaf.sample.acna15.web;

import org.apache.karaf.sample.acna15.persistence.api.BookService;
import org.apache.karaf.sample.acna15.persistence.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/book")
public class ViewBookServlet extends HttpServlet {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            writer.println("<html><head><title>ApacheCon</title></head><body>");
            writer.println("<h1>Books</h1>");
            writer.println("<table border=\"1\">");
            for (Book book : bookService.getAllBooks()) {
                writer.println("<tr>");
                writer.println("<td>" + book.getId() + "</td>");
                writer.println("<td>" + book.getName() + "</td>");
                writer.println("<td>" + book.getIsbn() + "</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</body></html>");
        } finally {
            writer.flush();
            writer.close();
        }
    }

}

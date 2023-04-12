package com.mazasoft.rest;

import com.mazasoft.rest.models.Book;
import com.mazasoft.rest.repositories.BookRepository;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Optional;


@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookRepository bookRepository;
    private final Logger logger;

    @Inject
    public BookResource(BookRepository bookRepository, Logger logger) {
        this.bookRepository = bookRepository;
        this.logger = logger;
    }


    @GET
    public Collection<Book> getAllBook() {
        logger.info("Return all books");
        return bookRepository.getAllBook();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int getBooksCount() {
        logger.info("Return books count");
        return bookRepository.getAllBook().size();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBook(@PathParam("id") int id) {
        logger.info("Return book with id = {" + id + "}");
        return bookRepository.getBook(id);
    }

}

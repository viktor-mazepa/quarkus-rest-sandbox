package com.mazasoft.rest.repositories;

import com.mazasoft.rest.models.Book;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-fi")
    protected String genre;

    public Collection<Book> getAllBook() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
                new Book(2, "Practising Quarkus", "Antonio", 2020, genre),
                new Book(3, "Effective Java", "Josh Blocj", 2001, genre),
                new Book(4, "Thinking in Java", "Brus Eckel", 1998, genre)
        );
    }

    public Optional<Book> getBook(int id) {
        return getAllBook().stream().filter(book -> book.id == id).findFirst();
    }
}

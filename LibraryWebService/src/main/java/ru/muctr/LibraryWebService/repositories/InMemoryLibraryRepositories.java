package ru.muctr.LibraryWebService.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.muctr.LibraryWebService.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class InMemoryLibraryRepositories {
    List<Book> books;

    public List<Book> getBooks()
    {
        return books;
    }
    public Book findBookById(int id)
    {
        for(Book book: books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }

    public void createBook(int id, String name, int pages)
    {
        books.add(new Book(id, name, pages));
    }
    @PostConstruct
    public void init()
    {
        books = new ArrayList<>(Arrays.asList(new Book(0, "книга1", 20),
                new Book(1, "книга2", 25),
                new Book(2, "книга3", 40))
        );
    }
    public void updateBook(int id, String name, int pages)
    {
        Book book = findBookById(id);
        if (book != null) {
            book.setPages(pages);
            book.setName(name);
        }
    }
    public void deleteBook(int id)
    {
        for(int i = 0; i < books.size(); i++)
            if (id == books.get(i).getId()) {
                books.remove(i);
                break;
            }

    }
}

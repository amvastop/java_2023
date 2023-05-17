package ru.muctr.LibraryWebService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.muctr.LibraryWebService.models.Book;
import ru.muctr.LibraryWebService.repositories.InMemoryLibraryRepositories;

import java.util.List;

@Service
public class LibraryService {
    InMemoryLibraryRepositories inMemoryLibraryRepositories;
    @Autowired
    public LibraryService(InMemoryLibraryRepositories inMemoryLibraryRepositories) {
        this.inMemoryLibraryRepositories = inMemoryLibraryRepositories;
    }
    public List<Book> getListBooks()
    {
        return inMemoryLibraryRepositories.getBooks();
    }
    public Book getBookById(int id){
        return inMemoryLibraryRepositories.findBookById(id);
    }
    public void createBook(int id, String name, int pages)
    {
        inMemoryLibraryRepositories.createBook(id, name, pages);
    }
    public void updateBook(int id, String name, int pages)
    {
        inMemoryLibraryRepositories.updateBook(id, name, pages);
    }
    public void deleteBook(int id)
    {
        inMemoryLibraryRepositories.deleteBook(id);
    }
}

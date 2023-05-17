package ru.muctr.LibraryWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.muctr.LibraryWebService.models.Book;
import ru.muctr.LibraryWebService.services.LibraryService;

import java.util.List;

@RestController
public class LibraryControllers {
    LibraryService libraryService;
    @Autowired
    public LibraryControllers(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    @GetMapping("/books")
    public List<Book> getList(){
        return libraryService.getListBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id)
    {
        return libraryService.getBookById(id);
    }
    @PostMapping("/books")
    public String creatBook(@RequestParam int id, @RequestParam String name, @RequestParam int pages){
        libraryService.createBook(id, name, pages);
        return "Создалась запись";
    }
    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable int id, @RequestParam String name, @RequestParam int pages )
    {
       libraryService.updateBook(id, name, pages);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id )
    {
        libraryService.deleteBook(id);
    }
}

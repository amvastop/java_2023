package ru.muctr;

import java.util.Objects;

public class Book implements Comparable<Book>{
    String title;
    int numberPage;
    Author author;

    public Book(String title, int numberPage, Author author)
    {
        this.title = title;
        this.numberPage = numberPage;
        this.author = author;
    }
    @Override
    public String toString()
    {
        return String.format("имя книги %s, количетво страниц %d, автор  %s", title, numberPage, author.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}

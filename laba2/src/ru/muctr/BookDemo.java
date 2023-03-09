package ru.muctr;

import java.util.Arrays;
import java.util.Comparator;

public class BookDemo {
    public static void main (String[] args){
        Author author1 = new Author("Александр Петрович Сумароков");
        Author author2 = new Author("Гавриил Романович Державин");
        Author author3 = new Author("Василий Андреевич Жуковский");
        Book book1 = new Book("Мастер и Маргарита", 500 , author1);
        Book book2 = new Book("Собачье сердце", 250 , author2);
        Book book3 = new Book("Граф Монте-Кристо", 650 , author3);
        Book[] arrayBooks = new Book[] {book1, book2, book3};
        Arrays.sort(arrayBooks);
        System.out.println(Arrays.toString(arrayBooks));

        Comparator<Book> byNumberPage = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.numberPage - o2.numberPage ;
            }
        };
        Arrays.sort(arrayBooks, byNumberPage);
        System.out.println(Arrays.toString(arrayBooks));

        Comparator<Book> byAuthorName = Comparator.comparing(o -> o.author.name);
        Arrays.sort(arrayBooks, byAuthorName);
        System.out.println(Arrays.toString(arrayBooks));

    }
}

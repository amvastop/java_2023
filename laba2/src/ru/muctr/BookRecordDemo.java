package ru.muctr;

import java.util.Arrays;
import java.util.Comparator;

public class BookRecordDemo {
    public static void main (String[] args){
        Author author1 = new Author("Александр Петрович Сумароков");
        Author author2 = new Author("Гавриил Романович Державин");
        Author author3 = new Author("Василий Андреевич Жуковский");
        BookRecord book1 = new BookRecord("Мастер и Маргарита", 500 , author1);
        BookRecord book2 = new BookRecord("Собачье сердце", 250 , author2);
        BookRecord book3 = new BookRecord("Граф Монте-Кристо", 650 , author3);
        BookRecord[] arrayBooks = new BookRecord[] {book1, book2, book3};
        Arrays.sort(arrayBooks);
        System.out.println(Arrays.toString(arrayBooks));

        Comparator<BookRecord> byNumberPage = new Comparator<BookRecord>() {
            @Override
            public int compare(BookRecord o1, BookRecord o2) {
                return o1.numberPage() - o2.numberPage() ;
            }
        };
        Arrays.sort(arrayBooks, byNumberPage);
        System.out.println(Arrays.toString(arrayBooks));

        Comparator<BookRecord> byAuthorName = Comparator.comparing(o -> o.author().getName());
        Arrays.sort(arrayBooks, byAuthorName);
        System.out.println(Arrays.toString(arrayBooks));

    }
}

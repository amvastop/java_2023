package ru.muctr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DBDemo {
    private  static SessionFactory factory;

    public static void prepareData(){
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try{
            String sqlString = Files.lines(Paths.get("init.sql"))
                    .collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sqlString).executeUpdate();
            session.getTransaction().commit();
        } catch ( IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        prepareData();
        addInDb();
        deleteFromDb();
        updateInDb();
        readFromDB();
        factory.close();
    }
    private static void addInDb() {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Library library = new Library("library5", "+755555");
            session.save(library);
            session.getTransaction().commit();
        }
    }
    private static void deleteFromDb() {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Library library = session.get(Library.class, 3);
            session.delete(library);
            session.getTransaction().commit();

        }
    }
    private static void updateInDb() {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Library library = session.get(Library.class, 2);
            library.setPhoneNumber("+72555558");
            session.getTransaction().commit();
        }
    }

    private static void readFromDB() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Library library = session.get(Library.class, 1);
            System.out.println();
            System.out.println("Бблотека №1: " + library.toString() + "\n");
            System.out.println("книги в бибилиотеке  №1: " + library.getBooks() + "\n");
            System.out.println("работкники бибилиотеки: " + library.getWorkers() + "\n");
            System.out.println("адрес: " + library.getBuilding() + "/n");
            session.getTransaction().commit();


        }
    }

}

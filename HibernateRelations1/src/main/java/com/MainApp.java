package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class MainApp {
    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Director director = new Director();
            director.setId(101);
            director.setName("Christopher Nolan");
            HashSet<Movie> hashSet = new HashSet<>();
            hashSet.add(new Movie(1, "Interstaller"));
            hashSet.add(new Movie(2, "Inception"));
            hashSet.add(new Movie(3, "Tenet"));
            director.setMovies(hashSet);
            Director director1 = new Director();
            director1.setId(102);
            director1.setName("Stephen Spielberg");
            HashSet<Movie> hashSet1 = new HashSet<>();
            hashSet1.add(new Movie(4, "Bridge of Spies"));
            hashSet1.add(new Movie(5, "Lincoln"));
            director1.setMovies(hashSet1);
            session.save(director);
            session.save(director1);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
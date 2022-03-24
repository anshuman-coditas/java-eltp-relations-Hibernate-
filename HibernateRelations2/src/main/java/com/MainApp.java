package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class MainApp {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Movie movie=new Movie();
        movie.setId(11);
        movie.setName("The Matrix");
        HashSet<Director> directors=new HashSet<>();
        directors.add(new Director(101,"Lilly Wachowski"));
        directors.add(new Director(102,"Lana Wachowski"));
        movie.setDirectors(directors);
        Movie movie1=new Movie();
        movie1.setId(12);
        movie1.setName("The Matrix Reloaded");
        HashSet<Director> directors1=new HashSet<>();
        directors1.add(new Director(103,"Hugo Weaving"));
        directors1.add(new Director(104,"Carrie-Anne Moss"));
        movie1.setDirectors(directors1);
        session.save(movie);
        session.save(movie1);
        transaction.commit();


    }
}


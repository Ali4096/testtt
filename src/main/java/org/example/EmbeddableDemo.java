package org.example;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
public class EmbeddableDemo {
    public static void main(String[] args) throws Exception{
//        Configuration con = new Configuration().configure();
//        org.hibernate.cfg.Configuration con = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(Alien.class);
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // creating object of class Alien
        Alien a1 = new Alien();
        a1.setAid(123);
        a1.setAname("thor");
        a1.setColor("red");
        Certificate certificate = new Certificate();
        certificate.setCourse("hibernate");
        certificate.setDuration("2 days");
        a1.setCerti(certificate);

        Alien a2 = new Alien();
        a2.setAid(123);
        a2.setAname("thor");
        a2.setColor("red");
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("JPA");
        certificate1.setDuration("2 days");
        a2.setCerti(certificate1);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(a1);
        session.save(a2);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}

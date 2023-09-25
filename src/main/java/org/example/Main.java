package org.example;

import java.io.FileInputStream;
import java.lang.Exception;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import javax.imageio.spi.ServiceRegistry;

public class Main {
    public static void main(String[] args) throws Exception{

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        SessionFactory sf = con.buildSessionFactory();

        //creating object of Alien  class
        Alien heeno = new Alien();
        heeno.setAid(100);
        heeno.setAname("bhoot");
        heeno.setColor("pink");

        //creating object of Address class
        Address ad = new Address();
        ad.setAddressId(200);
        ad.setStreet("moon");
        ad.setCity("moon hi pe");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setM(13141.1115);

        //reading image
        FileInputStream fis= new FileInputStream("src/main/resources/pic.jpeg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        System.out.println("hello world");
        ad.setImage(data);


        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(heeno);  //finally saves the data into the database
        session.save(ad);

//        heeno = (Alien) session.get(Alien.class,102); //get method is used to fetch the data from database.

        tx.commit();
        session.close();
        sf.close();
        System.out.println(heeno);
    }
}
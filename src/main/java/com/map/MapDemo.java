package com.map;

import org.example.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        SessionFactory sf = con.buildSessionFactory();
        //Creating question object
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("what is hibernate ??");

        //Creating answer object
        Answer answer = new Answer();
        answer.setAnswerId(344);
        answer.setAnswer("hibernate is a orm tool ");
        answer.setQuestion(q1);
        q1.setAnswer(answer);

        //session
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //save
        session.save(q1);
        session.save(answer);

        tx.commit();

        //fetching data from data base
        Question newQ = (Question) session.get(Question.class,1212);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());


        session.close();
        sf.close();
    }
}

package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {
        SessionFactory sf =
        new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Insert Record
        Vehicle v = new Vehicle();
        v.setName("Car");
        v.setDescription("Toyota Vehicle");
        v.setDate(new Date());
        v.setStatus("Available");

        session.save(v);

        tx.commit();
        System.out.println("Vehicle Inserted");

        // Update Record
        Transaction tx2 = session.beginTransaction();

        Vehicle v2 = session.get(Vehicle.class,1);
        v2.setStatus("Sold");

        session.update(v2);

        tx2.commit();

        System.out.println("Vehicle Updated");

        session.close();
        sf.close();
    }
}
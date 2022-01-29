package com.rating;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {
    private static final SessionFactory sessionFactory;
        static {
            try {
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(RegisterUser.class)
                        .addAnnotatedClass(Outlet.class)
                        .addAnnotatedClass(Restaurant.class)
                        .addAnnotatedClass(Bistro.class)
                        .addAnnotatedClass(TakeAway.class)
                        .buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}

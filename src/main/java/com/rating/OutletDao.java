package com.rating;

import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class OutletDao {
    public void saveOutlet(Outlet outlet){
        Transaction transaction = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(outlet);
            transaction.commit();
        }
    }
    public void updateOutlet(Outlet outlet){
        Transaction transaction = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(outlet);
            transaction.commit();
        }
    }
    public Restaurant getRestaurantById(long id){
        Transaction transaction = null;
        Restaurant restaurant = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            restaurant = session.get(Restaurant.class, id);
            transaction.commit();
        }
        return restaurant;
    }
    public Bistro getBistrotById(long id){
        Transaction transaction = null;
        Bistro bistro = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            bistro = session.get(Bistro.class, id);
            transaction.commit();
        }
        return bistro;
    }

    public TakeAway getTakeAwayById(long id){
        Transaction transaction = null;
        TakeAway takeAway = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            takeAway = session.get(TakeAway.class, id);
            transaction.commit();
        }
        return takeAway;
    }

    public List<Restaurant> getAllRestaurants(){
        Transaction transaction = null;
        List<Restaurant> restaurants = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            restaurants = session.createQuery("from et_restaurant").list();
            transaction.commit();
        }
        return restaurants;
    }
    public List<Bistro> getAllBistros(){
        Transaction transaction = null;
        List<Bistro> bistros = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            bistros = session.createQuery("from et_bistro").list();
            transaction.commit();
        }
        return bistros;
    }
    public List<TakeAway> getAllTakeAways(){
        Transaction transaction = null;
        List<TakeAway> takeAways = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            takeAways = session.createQuery("from et_take_away").list();
            transaction.commit();
        }
        return takeAways;
    }
    public void deleteRestaurant(long id){
        Transaction transaction = null;
        Outlet outlet = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            outlet = session.get(Restaurant.class, id);
            session.delete(outlet);
            transaction.commit();
        }
    }
    public void deleteBistro(long id){
        Transaction transaction = null;
        Outlet outlet = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            outlet = session.get(Bistro.class, id);
            session.delete(outlet);
            transaction.commit();
        }
    }
    public void deleteTakeAway(long id){
        Transaction transaction = null;
        Outlet outlet = null;
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            outlet = session.get(TakeAway.class, id);
            session.delete(outlet);
            transaction.commit();
        }
    }
}

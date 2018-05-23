package com.cis365.week5;

import java.util.List;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.Starship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            String dbName = System.getenv("RDS_DB_NAME");
            String hostname = System.getenv("RDS_HOSTNAME");
            String port = System.getenv("RDS_PORT");
            String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName;

            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
            cfg.setProperty("hibernate.connection.url", jdbcUrl);
            cfg.setProperty("hibernate.connection.username", System.getenv("RDS_USERNAME"));
            cfg.setProperty("hibernate.connection.password", System.getenv("RDS_PASSWORD"));

            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static List<Planet> listPlanets( ) {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Planet").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Starship> listReps() {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Starship").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship findRepById(String repNum) {
        Session session = getSessionFactory().openSession();

        try {
            return (Starship) session.get(Starship.class, repNum);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship updateRep(String repNum, Starship starshipToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Starship existing = findRepById(repNum);
            if (existing != null && repNum == starshipToUpdate.getId())
                existing = starshipToUpdate;
            tx.commit();
            return starshipToUpdate;
        }  catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
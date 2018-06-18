package com.cis365.week5;

import java.util.List;

import com.cis365.week5.models.*;
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
            return session.createQuery("FROM PLANET").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet findPlanetById(String planetId) {
        Session session = getSessionFactory().openSession();

        try {
            return (Planet) session.get(Planet.class, planetId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Planet updatePlanet(String planetId, Planet planetToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet existing = findPlanetById(planetId);
            if (existing != null && planetId == planetToUpdate.getPlanetId())
                existing = planetToUpdate;
            tx.commit();
            return planetToUpdate;
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

    public static List<PlanetVisit> listPlanetVisits( ) {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM PLANETVISIT").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static PlanetVisit findPlanetVisitById(String planetId, String starshipId) {
        Session session = getSessionFactory().openSession();

        try {
            return (PlanetVisit) session.get(PlanetVisit.class, planetId, starshipId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static PlanetVisit updatePlanetVisit(String planetId, String starshipId, PlanetVisit planetVisitToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            PlanetVisit existing = findPlanetVisitById(planetId, starshipId);
            if (existing != null && planetId == planetVisitToUpdate.getPlanetId())
                existing = planetVisitToUpdate;
            tx.commit();
            return planetVisitToUpdate;
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


    public static List<Starship> listStarships( ) {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM STARSHIP").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    public static Starship findStarshipById(String starshipId) {
        Session session = getSessionFactory().openSession();

        try {
            return (Starship) session.get(Starship.class, starshipId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static Starship updateStarship(String starshipId, Starship starshipToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Starship existing = findStarshipById(starshipId);
            if (existing != null && starshipId == starshipToUpdate.getStarshipId())
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
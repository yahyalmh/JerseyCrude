package model;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by yahya on 2017/02/24.
 */
public class EntityManager {
    public static void addUser(User User) {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        org.hibernate.service.ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(User);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("hibernate exception!");
        } finally {
            session.close();
        }
    }

    public static ArrayList<User> readUser(int id) {

        ArrayList<User> per = new ArrayList<User>();
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            User p1 = (User) session.get(User.class, id);
            if (p1 != null) {
                per.add(p1);

            }else {
                List Users = session.createQuery("FROM User").list();
                for (Iterator iterator = Users.iterator(); iterator.hasNext(); ) {
                    User p = (User) iterator.next();
                    per.add(p);
                }
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();


        }
        return per;
    }

    public static void deleteUser(int id) {
        User p = new User();
        p.setId(id);
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateUser(User User) {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(User);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("hibernate exception!");
        } finally {
            session.close();

        }
    }
}

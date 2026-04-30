package org.example.utilita_hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@Slf4j
public class HibernateUtilita {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            log.error("Ошибка: ", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

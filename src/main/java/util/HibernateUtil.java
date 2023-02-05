package util;

import entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory=null;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Eser.class);
                configuration.addAnnotatedClass(Muze.class);
                configuration.addAnnotatedClass(Sanatci.class);
                configuration.addAnnotatedClass(Sergi.class);
                configuration.addAnnotatedClass(Ziyaretci.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

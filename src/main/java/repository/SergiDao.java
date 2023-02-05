package repository;

import entities.Sergi;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class SergiDao {
    private Session session = null;

    public void save(Sergi sergi){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sergi);
            session.getTransaction().commit();
            System.out.println("Sergi kaydetme işlemi başarılıdır.");
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Sergi> getAll(){
        List<Sergi> sergiList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            sergiList = session.createQuery("from Sergi").list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        return sergiList;
    }

    public void update(Sergi sergi){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sergi);
            session.getTransaction().commit();
            System.out.println("Güncelleme işlemi başarılı");
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void deleteById(Integer id){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Sergi sergi = session.load(Sergi.class,id);
            session.delete(sergi);
            session.getTransaction().commit();
            getAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }
}

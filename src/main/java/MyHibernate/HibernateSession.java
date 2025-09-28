package MyHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    private static final SessionFactory session = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static SessionFactory gSessionFactory(){
        return session;
    }
    
}

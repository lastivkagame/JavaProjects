package Utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {


        private static SessionFactory sessionFactory;
        private HibernateSessionFactoryUtil() {}
        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {

                    // Configuration cfg1 = new Configuration();
                   // Configuration cfg1 = new Configuration().configure("sqlserver.cfg.xml");
                    //cfg1.configure("/hibernate-oracle.cfg.xml");
                    //cfg1.addAnnotatedClass(MyTestUser.class); // mapped classes
                    //cfg1.addAnnotatedClass(SomeOtherClass.class);
                  //  SessionFactory sf1 = cfg1.buildSessionFactory();

                /*Configuration cfg2 = new Configuration().configure("sqlserver.cfg.xml"); //new AnnotationConfiguration();
                //cfg2.configure("/hibernate-mysql.cfg.xml");
                cfg2.addAnnotatedClass(User.class); // could be the same or different than above
               // cfg2.addAnnotatedClass(SomeOtherClass.class);
                SessionFactory sf2 = cfg2.buildSessionFactory();*/

                Configuration configuration = new Configuration().configure("hibermssql.cfg.xml");
                configuration.addAnnotatedClass(AppUser.class);
                configuration.addAnnotatedClass(UserOrder.class);
                configuration.addAnnotatedClass(Role.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                } catch (Exception e) {
                    System.out.println("Exception!" + e);
                }
            }
            return sessionFactory;
        }
}

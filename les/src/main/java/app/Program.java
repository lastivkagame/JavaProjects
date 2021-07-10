package app;

import Utils.HibernateSessionFactoryUtil;
import models.AppUser;
import models.UserOrder;
import org.hibernate.Session;

import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

       AppUser user = AddUser(session);
       AddUserOrder(session, user.getId());
        session.close();
    }

    public  static UserOrder AddUserOrder(Session session, int user_id){
        session.beginTransaction();
        UserOrder user = new UserOrder(new Date(System.currentTimeMillis()), "Jane-sdsdw-d3", user_id);
        session.save(user);
        session.getTransaction().commit();

        return user;
    }

    public  static AppUser AddUser(Session session){
        session.beginTransaction();
        AppUser user = new AppUser("Jane");
        session.save(user);
        session.getTransaction().commit();

        return user;
    }
}

import models.User;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class UserManager {

    //SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    //Session session;// = sessionFactory.openSession();
    public Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public UserManager() {
        //session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        //OpenConn();
    }

    public void OpenConn(){
       // session = sessionFactory.openSession();
        session.beginTransaction();
    }

    public void CloseConn(){
        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();

    }

    //show users
    public void ShowUsers(){
        List<User> studentsList = ReadUsers();

        for(User student : studentsList)
        {
            System.out.println(" -> User(id: "+student.getId()+"; name:  "+student.getName()+" )");
        }
    }

    ///read users
    public List<User> ReadUsers(){
        List<User> studentsList = new ArrayList();
        try {
            // Getting Session Object From SessionFactory
            //session = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object

            //if(!session.isOpen()){
                //session.close();
            //}

            //sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();


            //session = sessionFactory.openSession();
            session.beginTransaction();

            //OpenConn();
            studentsList = session.createQuery("FROM User").list();
            //CloseConn();
            session.getTransaction().commit();
            session.close();

            return studentsList;

            /*for(User student : studentsList)
            {
                System.out.println(" -> User( name:  "+student.getName()+" )");
            }*/

            //Query query = session.createQuery("FROM User");

        } catch(Exception sqlException) {
            /*if(null != session.getTransaction()) {
                //logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();*/
        } finally {
           /* if(session != null) {
                session.close();
            }*/
        }

        //session.getTransaction().commit();
        //sessionFactory.close();
        return studentsList;
    }

    public User FillUser(){
        User user = new User();
        int min = 0, max=10000;

        Random random = new Random();
        String str = "someone" + random.nextInt((max - min) + 1) + min + "@mail.com";
        System.out.printf(str);
        user.setName(str);
        return  user;
    }

    ///add user
    public void AddUser(User user){
        //System.out.println("Working data base ...");
        //session.beginTransaction();

       boolean flag = true;
        /* List<User> studentsList = ReadUsers();
        for(User student : studentsList)
        {
            if(user.getName() == student.getName())
            {
                flag=false;
                break;
            }
        }*/

        //session.close();
        /*if(session.isOpen()){
            session.close();
        }*/

        /*try {
            session.beginTransaction();
        }
        catch (Exception ex)
        {}*/
        //Add new Employee object
        //User user = new User();
        //user.setName("lokesh@mail.com");
        //emp.setFirstName("lokesh");
        //emp.setLastName("gupta");

        if(flag) {
            //Save the employee in database
            /*if(!session.isOpen()) {
            }*/

            //Create session factory object
            //sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
            //getting session object from session factory
            //getting transaction object from session object


            //session = sessionFactory.openSession();
            session.beginTransaction();

           // CloseConn();
            //OpenConn();

            session.save(user);
            System.out.println("Success add user!");

            //CloseConn();

            session.getTransaction().commit();
            session.close();
           // sessionFactory.close();


            //Commit the transaction
            /*session.getTransaction().commit();
            session.close();*/
        }
        else {
            System.out.println("This user already exists!");
        }

    }

    //delete user
    public void DeleteUser(int id){
        //sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
       // session = sessionFactory.openSession();
        //session.beginTransaction();

        //sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        //getting session object from session factory
        //session = sessionFactory.openSession();
        //getting transaction object from session object
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User student = (User)session.load(User.class, id);
        session.delete(student);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
       // sessionFactory.close();
        session.close();

    }

    public User GetUserByID(int id){
        //Create session factory object
        //sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        //getting session object from session factory
        //session = sessionFactory.openSession();
        //getting transaction object from session object
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User student = (User)session.get(User.class, id);
        session.close();
        //sessionFactory.close();
        return student;
    }

    public void UpdateUser(User user){
        //Create session factory object
       // sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        //getting session object from session factory
        //session = sessionFactory.openSession();
        //getting transaction object from session object
        Session session2 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session2.beginTransaction();

        //User student = (User)session.get(User.class, user.getId());
        session2.update(user);
        //student.setName(user.getName());
        System.out.println("Updated Successfully");
        session2.getTransaction().commit();
        session2.close();
        //sessionFactory.close();
    }
}

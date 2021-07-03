/*
import models.User;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;
*/


import models.User;

import java.util.Scanner;

public class Main {

    //main + enter
    public static void main(String[] args) {

        UserManager manager = new UserManager();
        //manager.AddUser(new User("jake@dd.cv"));
        //manager.AddUser(new User("lina@dd.cv"));
        //manager.ShowUsers();
        //System.out.println(manager.ShowUsers());
       // manager.ShowUsers();

       // manager.ShowUsers();

        Scanner in = new Scanner(System.in);
        //System.out.println("Enter id: ");
        //int user_id = in.nextInt();
        //manager.DeleteUser(user_id);

       // manager.ShowUsers();

        //manager.UpdateUser(new User(10, "some30"));
       // manager.ShowUsers();
        //manager.CloseConn();
       // manager.AddUser(new User("ldgsdgd@dd.cv"));

        boolean stop = true;

        do{
            System.out.println("Menu");
            System.out.println("1.Create user");
            System.out.println("2.Read all users");
            System.out.println("3.Update user");
            System.out.println("4.Delete user");
            System.out.println("5.Stop");
            System.out.println("choose: ");
            int choose = in.nextInt();

            switch (choose){
                case 1:
                    System.out.println("Enter name: ");
                   // String name = manager.FillUser();//in.();

                    manager.AddUser(manager.FillUser());
                    break;
                case 2:
                    manager.ShowUsers();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    int us_id = in.nextInt();

                    System.out.println("Enter name: ");
                    String us_name = in.nextLine();
                    us_name = in.nextLine();

                    manager.UpdateUser(new User(us_id, us_name));
                    break;
                case 4:
                    System.out.println("Enter id: ");
                    int us_id_del = in.nextInt();

                    manager.DeleteUser(us_id_del);
                    break;
                case 5:
                    stop=false;
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }

        }while (stop);
    }
}

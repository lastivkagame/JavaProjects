import java.util.Random;
import java.util.Scanner;
import domain.*;

public class Program {
    public static void main(String[] args) {

        //System.out.println("Hi)");

        //#region Data Types

       /* int n=10;
        boolean b=false;
        float z=12;
        double d = 32.25;
        short s  = 11;
        byte v = 23;
        char ch='a';
        String str="Hello Everyone";*/

        //System.out.println(str);
        //#endregion

        //#region jghjh
        // +, -, /, *, %
        //+=, -=, ....
        //System.out.println(3/5.0);
        //#endregion

        //#region Task
       /* for (int i=0; i<7;i++) {
            // System.out.println("ss");

            Scanner in = new Scanner(System.in);
            System.out.println("Enter age: ");
            int age = in.nextInt();
            //System.out.printf("Your age: %s", age);

            if (age < 0 || age > 200) {
                System.out.printf("Incorrect age! People can't live %s", age);
                System.out.println();
            } else if (age >= 0 && age <= 14) {
                System.out.println("You are child;");
            } else if (age >= 15 && age <= 24) {
                System.out.println("You are child which can work;");
            } else if (age >= 25 && age <= 54) {
                System.out.println("You are 'young' people that can work(main work possible age);");
            } else if (age >= 55 && age <= 64) {
                System.out.println("You are a you are old person that can work yet;");
            }
            else {
                System.out.println("You are a old person;");
            }
        }

        int [] arr = new int[12];
    }*/
        //#endregion

        int n = 10;
        int[] arr = new int[n];

        //InitArray(arr);

        //show(arr);


       // Person p = new Person();
        //p.setLastName("Some");
        //p.setName("Leo");
        //System.out.println(p);

        Person k = new User("S", "K", "email@gg.hh");
       // k.setEmail("vv@hh.ll");
        System.out.println(k);
    }

    public static void InitArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomTest(10, 15);
        }
    }

    public static int RandomTest(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static void show(int[] arr) {
        for (int item :
                arr) {
            System.out.printf("%d\t", item);
        }
    }
}


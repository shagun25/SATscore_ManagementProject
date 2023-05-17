package stdapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        double SATscore;
        StudentDaoIntrf dao=new StudentDaoImpl();
        System.out.println("Welcome to Student management application");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Insert data\n" +
                    "2. View all data\n" +
                    "3. Get Rank \n" +
                    "4. Update score\n" +
                    "5. Delete one record\n");

            System.out.println("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Student std=new Student();

                    System.out.println("Enter name ");
                     name=sc.next();

                    System.out.println("Enter City ");
                    String city =sc.next();

                    System.out.println("Enter Country ");
                    String country =sc.next();

                    System.out.println("Enter Pincode ");
                    int pincode =sc.nextInt();

                    System.out.println("Enter SATscore ");
                    SATscore=sc.nextDouble();


                    std.setName(name);
                    std.setCity(city);
                    std.setCountry(country);
                    std.setPincode(pincode);
                    std.setSATscore(SATscore);
                    dao.createStudent(std);
                    break;
                case 2:
                    dao.showAllStudents();
                    break;
                case 3:
                    System.out.println("Enter name to show the rank ");
                    String stdName =sc.next();
                    dao.showRank(stdName);
                    break;
                case 4:
                    System.out.println("Enter name to update the details");
                    String name1 =sc.next();
                    System.out.println("Enter the new SATscore");
                    SATscore=sc.nextDouble();
                    dao.updateStudent(name1,SATscore);
                    break;
                case 5:
                    System.out.println("Enter the name to delete");
                    name=sc.next();
                    dao.deleteStudent(name);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;


            }

        }while (true);

    }
}

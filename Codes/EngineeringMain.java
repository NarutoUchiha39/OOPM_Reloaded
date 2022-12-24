package Codes;

import java.util.Scanner;
import java.util.Vector;

public class EngineeringMain
{
    public static void main(String[] args) {
        System.out.println("Enter number of students: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i <number; i++)
        {
            System.out.println("Enter Name: ");
            String name = sc.next();
            Vector<String>sub = new Vector<>();
            Vector<Integer>marks = new Vector<>();
            System.out.println("Enter number of subjects: ");
            int num = sc.nextInt();
            for (int j=0;j<num;j++)
            {
                System.out.println("Enter subjects: ");
                String subject = sc.next();
                sub.add(subject);
                System.out.println("Enter marks: ");
                int marks1 = sc.nextInt();
                marks.add(marks1);

            }
            Codes.Engineering.Student.create(name,marks,sub);
        }
        Codes.Engineering.Student.getAccess();
    }
}

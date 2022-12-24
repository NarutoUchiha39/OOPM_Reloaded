package Codes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class Employee_Array extends Employee // Inherits from previous file(Codes.CollectionsFramework)
{
    static int size=0;

    static Employee_Array array[];

    static void create()
    {
        array = new Employee_Array[Employee_Array.size];
    }
    Employee_Array(String Name, long Eid,long salary)
    {
        super(Name,Eid,salary);

    }
    static  void add(int size)
    {
        if(Employee_Array.size==size)
        {
            System.out.println("Sorry more elements cant be added!!");
            return;
        }
        else
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Name: ");
            String name = sc.next();
            System.out.println("Enter EID");
            long EID = sc.nextLong();
            System.out.println("Enter Salary");
            long salary = sc.nextLong();
            array[Employee_Array.size]= new Employee_Array(name,EID,salary);
            Employee_Array.size+=1;
            sort();
            display();
        }
    }

    static void delete(String Name)
    {
        for (int i = 0; i < size; i++)
        {
            if(array[i].EName.equals(Name)) {
                for (int j = i; j < size-1; j++) {
                    array[j] = array[j + 1];

                }
                size-=1;
                break;

            }
        }


    }
    static void display()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println("Name: "+array[i].EName+ " Salary: "+array[i].salary+" EID: "+array[i].EId);

        }
    }
    static void sort()// standard bubble sort with one small optimization such that if elements are already sorted then after any pass flag becomes 0 and we return out
    {
        int flag = 0;
        for (int i = 0; i <size; i++)
        {
            for (int j = 0; j <size-i-1; j++)
            {
                if(array[j].salary>array[j+1].salary)
                {
                    flag = 1;
                    Employee_Array temp =  array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(flag == 0) {
                return;
            }
        }
    }
}
public class ArrayOfObjects
{
    public static void main(String[] args)
    {
        System.out.println("Enter number of employees:");
        Scanner bufferedReader = new Scanner(System.in);
        int size = bufferedReader.nextInt();
        Employee_Array.size = size;
        Employee_Array.create();
        for (int i = 0; i < size; i++)
        {
            System.out.println("Enter Name");
            String name = bufferedReader.next();
            System.out.println("Enter ID");
            long ID = bufferedReader.nextInt();
            System.out.println("Enter salary");
            long salary = bufferedReader.nextInt();
            Employee_Array obj = new  Employee_Array(name,ID,salary);
            Employee_Array.array[i] = obj;

        }
        System.out.println("Using Comparator");
        Collections.sort(Arrays.asList(Employee_Array.array),new Comparator<Employee_Array>()// Sort in descending order
        {
            @Override
            public int compare(Employee_Array o1, Employee_Array o2) {
                if (o1.salary < o2.salary) {
                    return 1;
                }
                if (o1.salary == o2.salary) {
                    return 0;
                }
                return -1;
            }
        });
        Employee_Array.display();
        System.out.println("Using bubble sort");
        Employee_Array.sort();
        Employee_Array.display();
        System.out.println("Enter name tobe deleted: ");
        String name = bufferedReader.next();
        Employee_Array.delete(name);

        Employee_Array.display();
        System.out.println();

        Employee_Array.add(size);







    }
}

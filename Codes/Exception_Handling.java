package Codes;

import java.util.Scanner;

//Create a class to implement the following interface (interface block given in question), take an input from the user (marks) and check if those marks are in the range of Minmarks=0 and Maxmarks=100, throw an exception if the input marks are out of range, exception message should be "marks are out of range."
interface Marks
{
    void check(int marks) throws My_Own_Exception;
}

class My_Own_Exception extends Exception implements Marks
{

    @Override
    public void check(int marks) throws My_Own_Exception
    {
        if(marks>100 || marks<0)
        {
            throw new My_Own_Exception();
        }
        else
        {
            System.out.println("Marks in correct range!!");
        }
    }
    @Override
    public String toString()
    {
        return "Enter Valid Number!!";
    }
}
public class Exception_Handling
{
    public static void main(String[] args) {
        System.out.println("Enter Marks: ");
        Scanner sc = new Scanner(System.in);
        int marks = sc.nextInt();
        My_Own_Exception obj = new My_Own_Exception();
        try
        {
            obj.check(marks);
        }
        catch (My_Own_Exception e)
        {
            System.out.println(e);
        }
    }

}

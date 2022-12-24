package Codes.Engineering;
import java.util.Vector;

public class Student {
    static Vector<Student> stu = new Vector<>();
    String Name;
    int marks = 0;
    Vector<String> subject;

    Student(String Name, Vector<Integer> marks, Vector<String> subjects) {
        this.Name = Name;
        for (Integer e : marks) {
            this.marks = this.marks + e;
        }
        this.subject = subjects;
    }

    public static void create(String Name, Vector<Integer> marks, Vector<String> subjects) {
            stu.add(new Student(Name,marks,subjects));
    }
    public static void  getAccess()
    {
        Marks.display();
        System.out.println();
        Marks.sort();
        Marks.display();
    }
}
class Marks
{
    static void sort()
    {

        for (int i = 0; i <Student.stu.size(); i++)
        {
            int flag = 0;
            for (int j=0;j<Student.stu.size()-i-1;j++)
            {
                if(Student.stu.get(j).marks>Student.stu.get(j+1).marks){
                    flag = 1;
                    Student temp = Student.stu.get(j);
                    Student.stu.set(j,Student.stu.get(j+1));
                    Student.stu.set(j+1,temp);
                }
            }
            if(flag==0)
            {
                break;
            }
        }
    }
    static void display()
    {
        for (Student e: Student.stu){
            System.out.println("Name: "+e.Name+" Marks: "+e.marks+" Subjects: "+e.subject.toString());
        }
    }
}


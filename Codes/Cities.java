package Codes;

import java.util.Scanner;
import java.util.Vector;

public class Cities
{
    static void sort(Vector<String>vec)
    {
        String temp;
        for (int i = 0; i < vec.size(); i++) {
            for (int j = 0; j < vec.size()-1-i; j++) {
                if(vec.get(j).charAt(0)>vec.get(j+1).charAt(0))
                {
                    temp = vec.get(j);
                    vec.set(j,vec.get(j+1));
                    vec.set(j+1,temp);
                }
                else if (vec.get(j).charAt(0)==vec.get(j+1).charAt(0)) {
                    int flag = 0;
                    int length;
                    if(vec.get(j).length()>vec.get(j+1).length())
                    {
                        flag = 2;
                        length = vec.get(j+1).length();
                    }
                    else {length = vec.get(j).length();}

                    for (int k = 0; k < length; k++) {
                        if(vec.get(j).charAt(k)>vec.get(j+1).charAt(k))
                        {
                            temp = vec.get(j);
                            vec.set(j,vec.get(j+1));
                            vec.set(j+1,temp);
                            flag=1;
                            break;
                        }
                    }
                    if(flag == 2)
                    {
                        temp = vec.get(j);
                        vec.set(j,vec.get(j+1));
                        vec.set(j+1,temp);
                    }
                }
            }
        }
    }

    static void delete(Vector<String >vec,String name)
    {
        if(!vec.contains(name)){
            System.out.println("Name doesn't exist");
            return;
        }
        Vector<String >index = new Vector<>();
        for(int i=0;i<vec.size();i++){
            if(vec.get(i).equals(name)){
                index.add(vec.get(i));
            }
        }
        for (int i=0;i<index.size();i++){
            vec.remove(index.get(i));
        }
    }
    public static void main(String[] args) {
        Vector<String> vec = new Vector<>();
        System.out.println("Keep adding cities and press q to quit");
        Scanner sc = new Scanner(System.in);
        String choice = "a";
        while (true)
        {
            System.out.println("Enter city name: ");
            choice = sc.next();
            if(choice.equals("q"))
            {
                break;
            }
            if(vec.contains(choice))
            {
                System.out.println("City already exists!!");
            }
            else
            {vec.add(choice);}
        }
        sort(vec);
        System.out.println(vec);
        System.out.println("Enter string to deleted");
        String name = sc.next();
        delete(vec,name);
        System.out.println(vec);

    }
}

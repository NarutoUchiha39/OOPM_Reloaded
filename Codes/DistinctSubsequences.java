package Codes;

import java.util.ArrayList;
import java.util.Scanner;
/*
Distinct subsequences example:
consider GFG as string all the subsequences are
1) GF
2) FG
3) GG
4)GFG
5)' '
6) g
7) f
Basically make all possible combination from  current index to all the elements at the remaining indexes. note: Do not go backward only forward
I have used an ArrayList to check if any permutation is repeating or not. After that i have used plain recursion to concatenate letter at a particular index
with an empty string at beginning and then used the same string to concatenate other letters
 */
public class DistinctSubsequences

{
    static ArrayList<String> arrayList = new ArrayList();
    public static void recursion(int cur,int i,String s,String cur1)
    {
        if(cur==i && !arrayList.contains(cur1))
        {
            arrayList.add(cur1);
            System.out.println(cur1);
            return;
        }
        for (int j = 0; j < s.length(); j++) {
            recursion(cur+1,i,s.substring(j+1),cur1+s.charAt(j));
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Enter String: ");
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println("' '");
        for (int i = 1; i <=string.length(); i++) {
            recursion(0,i,string,"");
        }
        System.out.println("Total number of distinct subsequences are: "+(arrayList.size()+1));



    }
}

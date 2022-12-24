package Codes;

import java.util.*;
public class AllPossibleCombinations
{
    public static void recursion(int index,HashMap<String,Integer>map,String cur,String s,int i)
    {
        if(index == i)
        {
            System.out.println(cur);
            return;
        }
        for (String e: map.keySet())
        {
            if(map.get(e)>0)
            {
                map.put(e,map.get(e)-1);
                recursion(index+1,map,cur+e,s,i);
                map.put(e,map.get(e)+1);
            }
        }
    }

    public static void main(String[] args)
    {
        HashMap<String,Integer> hashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String IHateJava = sc.next();

        for (int i = 0; i <IHateJava.length(); i++) {
            hashMap.put(String.valueOf(IHateJava.charAt(i)),hashMap.getOrDefault(IHateJava.charAt(i),0)+1);
        }
        for (int i = 1; i <=hashMap.size(); i++) {
            recursion(0,hashMap,"",IHateJava,i);
        }

    }


}

package Codes;
/*
Two strings are considered close if you can attain one from the other using the following operations:

    Operation 1: Swap any two existing characters.
        For example, abcde -> aecdb
    Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
        For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
*/
import java.util.Arrays;
import java.util.Scanner;
public class CloseStrings
{
    static Boolean contains(char[]array,char val)
    {
        for (int i = 0; i < array.length; i++)
        {
            if(array[i] == val) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Enter first String");
        Scanner sc = new Scanner(System.in);

        String anagram1 = sc.next();
        String anagram2 = sc.next();

        char ana1[] = new char[26];
        Arrays.fill(ana1,'%');
       int freq1 [] = new int[26];
       Arrays.fill(freq1,0);

        char ana2[] = new char[26];
        Arrays.fill(ana2,'%');
        int freq2 [] = new int[26];
        Arrays.fill(freq2,0);


        if(anagram1.length()!=anagram2.length())
        {
            System.out.println("Not Close Strings");
            return;
        }

        for (int i = 0; i <anagram1.length() ;i++)
        {
            if(contains(ana1,anagram1.charAt(i)))
            {
                freq1[anagram1.charAt(i)-'a']+=1;
            }
            if(contains(ana2,anagram2.charAt(i)))
            {
                freq2[anagram2.charAt(i)-'a']+=1;
            }
            if(!contains(ana1,anagram1.charAt(i)))
            {
                ana1[anagram1.charAt(i)-'a'] = anagram1.charAt(i);
                freq1[anagram1.charAt(i)-'a']+=1;
            }
            if(!contains(ana2,anagram2.charAt(i)))
            {
                ana2[anagram2.charAt(i)-'a'] = anagram2.charAt(i);
                freq2[anagram2.charAt(i)-'a']+=1;
            }
        }
        Arrays.sort(ana1);
        Arrays.sort(freq1);

        Arrays.sort(ana2);
        Arrays.sort(freq2);
        if(Arrays.equals(ana1,ana2) && Arrays.equals(ana2,ana1))
        {
            System.out.println("Close Strings!!");
        }
        else
        {
            System.out.println("Not Close STrings");
        }
        System.out.println(Arrays.toString(ana1)+" "+Arrays.toString(freq1));
        System.out.println(Arrays.toString(ana2)+" "+Arrays.toString(freq2));



    }

}
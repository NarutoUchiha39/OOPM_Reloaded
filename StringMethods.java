import java.util.Arrays;
import java.util.Scanner;

public class StringMethods
{
    public static void main(String[] args)
    {
        System.out.println("Enter String: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String arr[] = name.split(" ");
        int words = 0;
        int uppercase = 0;
        int lowercase = 0;
        System.out.println(Arrays.toString(arr));
        for(String e:arr){

            if(!e.equals(""))
            {
                for (int i=0;i<e.length();i++){
                    if(Character.isUpperCase(e.charAt(i))){
                        uppercase+=1;
                    }
                    else if(Character.isLowerCase(e.charAt(i))){
                        lowercase+=1;
                    }
                }

                words+=1;
            }

        }
        System.out.println("Total number of UpperCase Words: "+uppercase+" Total number of lowercase words: "+lowercase+" Total number of words: "+words);


    }
}

package Codes;

import java.lang.String;
public class CommonStringMethods 
{
    public static void main(String[] args) 
    {
        String arr = "ABCDEFAB  ";
        System.out.println(arr.length());
        System.out.println(arr.toUpperCase());
        System.out.println(arr.toLowerCase());
        System.out.println(arr.concat("accha"));
        System.out.println(arr.replace("AB","XY"));
        System.out.println(arr.charAt(0));
        System.out.println(arr.compareTo("ABCDEFAB"));
        System.out.println(arr.compareToIgnoreCase("AbcdEfab"));
        System.out.println(arr.equals("java"));
        System.out.println(arr.equalsIgnoreCase("ok"));
        System.out.println(arr.endsWith("B"));
        System.out.println(arr.startsWith("ABC"));
        System.out.println(arr.substring(0,3));

        StringBuilder builder = new StringBuilder(arr);
        builder.append("SDF");
        builder.setCharAt(0, 'W');
        builder.deleteCharAt(3);
        builder.delete(0, 3);
        builder.reverse();
        builder.length();
        builder.capacity();
        builder.insert(1, "ABCD");
        builder.equals(builder);
        builder.compareTo(builder);
        builder.indexOf("SD");//-1 for not found
        builder.lastIndexOf("AB");
        builder.replace(builder.indexOf("FA"), builder.indexOf("FA")+2,"OK");
        builder.substring(1,4);

        System.out.println();
        System.out.println(builder.toString());


        
    }
    
}

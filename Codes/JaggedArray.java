package Codes;

import java.util.Arrays;
import java.util.Scanner;
class players
{
    float arr[];
    float average;
    players(float arr[],float average)
    {
        this.arr = arr;
        this.average = average;
    }
}

public class JaggedArray
{
    public static void main(String[] args)
    {
        System.out.println("Enter number of Codes.players: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        float rec[][] = new float[number][];
        for (int i = 0; i < number; i++) {
            System.out.println("Enter number of matches played: ");
            int matches = sc.nextInt();
            rec[i] = new float[matches];
            for (int j = 0; j <matches; j++)
            {
                System.out.println("Enter runs in match "+(j+1));
                float runs = sc.nextFloat();
                rec[i][j] = runs;
            }
        }

        players avg[] = new players[number];

        for (int i=0;i<rec.length;i++)
        {
            float runs = 0;
            for (int j = 0; j <rec[i].length; j++) {
                System.out.print("Runs in match "+(j+1)+": "+rec[i][j]+" ");
                runs+=rec[i][j];
            }
            System.out.println(" Average: "+ runs/rec[i].length);
            players player = new players(rec[i],runs/rec[i].length);
            avg[i] = player;
        }

        for (int i = 0; i < number; i++)
        {
            for (int j = 0; j < number-i-1; j++) {
                if(avg[i].average>avg[i+1].average)
                {
                    players temp = avg[i];
                    avg[i] = avg[i+i];
                    avg[i+1] = temp;
                }
            }
        }

        for (players i: avg)
        {
            System.out.println("Average is: "+i.average+" Runs are: "+Arrays.toString(i.arr));
        }


    }
}

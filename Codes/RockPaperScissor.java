package Codes;

import java.util.Scanner;

/*
implement a rock paper scissor game where user has to input rock paper or scissor and the computer as to select among the three options randomly. Display score
of the user after 10 rounds along with his/her name
 */
class user{
    String[] arr = {"rock","paper","scissor"};
    int scores;
    String Name;
    user(String name){
        this.Name = name;
        this.scores = 0;
    }
    public void start(String choice){
        String Random = arr[(int)(Math.random()*(3))];
        System.out.println(Random);
        if(choice.equalsIgnoreCase(Random)){
            this.scores+=1;
            System.out.println("Draw you get one point!!");
        }
        else if(choice.equalsIgnoreCase("paper") && Random.equals("rock"))
        {
            this.scores+=1;
            System.out.println("You won this round!!");
        }
        else if (choice.equalsIgnoreCase("scissor")&& Random.equals("paper")) {
            this.scores+=1;
            System.out.println("You won this round!!");
        }
        else if (choice.equalsIgnoreCase("rock")&&Random.equals("scissor")) {
            this.scores+=1;
            System.out.println("You won this round!!");
        }
        else{
            System.out.println("You Lost this round :(");
        }
    }
}
public class RockPaperScissor {
    public static void main(String[] args) {
        System.out.println("Enter your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        user obj = new user(name);
        for (int i = 0; i <10; i++) {
            System.out.println("Enter your choice: ");
            String choice = sc.next();
            obj.start(choice);
        }
        System.out.println("Name: "+name+" Your Score is: "+ obj.scores);

    }
}

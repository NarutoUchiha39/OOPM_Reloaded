package Codes.Trigonometry;
//Make a package having class Codes.Trigonometry(and import it)which will take input as 0,30,60,90 for the functions sine,cos,tan,cot… (And you can't make inbuilt function you have to basically import functions from the class trigonometry..which has predefined functions)


public class Trigonometry {
    static Double factorial(long num) {
        Double fact = 1.0;
        while (num != 0) {
            fact = fact * num;
            num -= 1;
        }
        return fact;
    }

    public static void sine(int rad) {
        //x - x^2/2! + x^3/3! + x^4/4! - x^5/5!
        Double rad1 = rad * ((Math.PI) / 180);
        Double res = 0.0;
        int counter = 0;
        for (long i = 1; i < 1200; i++) {

            if (i % 2 != 0) {
                res = res + ((Math.pow(-1, (counter)) * Math.pow(rad1, i)) / (factorial(i)));
                counter += 1;

            }

        }
        System.out.println("The sine Value is: " + res);
    }

    public static Double cosine(int rad) {
        Double rad1 = rad * ((Math.PI) / 180);
        Double res = 0.0;
        int counter = 0;
        for (long i = 0; i < 1200; i++) {

            if (i % 2 == 0) {
                res = res + ((Math.pow(-1, (counter)) * Math.pow(rad1, i)) / (factorial(i)));
                counter += 1;
            }

        }
        System.out.println("The cosine Value is: " + res);
        return res;
    }


}


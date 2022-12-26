package Codes;
class random_numbers extends Thread
{
    static void check(int num)
    {
        if(num%2!=0){
            System.out.println(num*num*num);
        }
        else{
            System.out.println(num*num);
        }
    }
    @Override
    public void run()
    {
        for (int i = 0; i <20; i++) 
        {
            int random = (int)(Math.random()*((10-1)+1))+1;
            check(random);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class months implements Runnable
{
    static String Months[] = {"Jan","Feb","March","April","May","June","July","August","September","October","Noveber","December"};
    @Override
    public void run() 
    {
        for (int i = 0; i < Months.length; i++) 
        {
            System.out.print(Months[i]+" ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class days implements Runnable
{
    static String days[] = {"Mon","Tues","Wed","Thurs","Friday","Saturday","Sunay"};
    @Override
    public void run() 
    {
        for (int i = 0; i < days.length; i++) 
        {
            System.out.print(days[i]+" ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
public class Multi_Threading 
{
    public static void main(String[] args) 
    {
        //random_numbers numbers = new random_numbers();
        //numbers.start();
        months months = new months();
        Thread thread1 = new Thread(months);
        days Days = new days();
        Thread thread2 = new Thread(Days);

        thread1.start();
       
        
        try {
            thread1.join();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        thread2.start();
        
    }
    
}

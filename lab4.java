import java.util.*;
public class lab4 
{
    public static void main(String [] Args)
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("enter number of simulations: ");
        int simulations = sc.nextInt();
        System.out.println("enter number of steps: ");
        int steps = sc.nextInt();
        double sum = 0;
        double estimate;

        for(int i = 1; i <= simulations; i++)
        {
            double temp = 1.0;
            for(int j = 0; j < steps; j++ )
            {               
                double r = rand.nextDouble() * 0.005;
                temp = temp + r;
            }
            sum += temp;
        }
        estimate = sum/simulations;
        System.out.println("estimated value of e is: " + estimate);
        double error = estimate - 2.71828;
        System.out.println("error is: " + error);    
    }
}
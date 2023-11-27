import java.util.*;
public class lab4_part2 
{
    public static void main(String [] Args)
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("enter number of simulations: ");
        int simulations = sc.nextInt();
        double pi;
        
        double total_points = 0;
        double points_in_circle = 0;

        int square_height = 2;
        int square_width = 2;

        for(int i = 0; i < simulations; i++)
        {
            Double x = rand.nextDouble() * 2;
            Double y = rand.nextDouble() * 2;

            if(x * x + y * y <= (square_height) * (square_width))
            {
                points_in_circle +=1;
                total_points += 1;
            }
            else
            {
                total_points += 1;   
            }        
        }
        pi = 4.0 * points_in_circle / total_points;
        System.out.println("Estimated Pi: " + pi);

    }
}

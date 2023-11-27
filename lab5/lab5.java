import java.util.*;
public class lab5  
{
    public static void main(String []Args)
    {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int nbase = sc.nextInt();
        int num = sc.nextInt();
        int res = getvalue(base, nbase, num);
        System.out.println(res);
    }
    public static int getvalue(int base, int nbase, int num)
    {
        int dec = toDec(base, num);
        int dest = decToBase(dec, nbase);
        return dest;
    }
    public static int toDec(int base, int num)
    {
        int dn = 0;
        int pow = 0;
        while(num>0)
        {
            int temp = num%10;
            dn+= temp*Math.pow(base,pow);
            pow+=1;
            num /= 10;
        }
        return dn;
    }
    public static int decToBase(int dec, int nbase)
    {
        int dest = 0;
        int pow = 0;
        while (dec > 0) 
        {
            int temp = dec%nbase;
            dest+=temp*Math.pow(10,pow);
            pow += 1;
            dec /=nbase;  
        }
        return dest;
    }
}

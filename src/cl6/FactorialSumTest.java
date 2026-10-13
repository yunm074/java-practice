package cl6;

public class FactorialSumTest
{
    public static void main(String[] args)
    {
        int n=6;
        System.out.println("1!+2!+3!+4!+5!+6！的结果是："+sum(n));
    }
    public static long factorial(int n)
    {
        long result=1;
        for(int i=1;i<=n;i++)
          result *=i;
        return result;
    }
    public static long sum(int n)
    {
        long result=0;
        for(int i=1;i<=n;i++)
        {
            result+=factorial(i);
        }
        return result;
    }
}

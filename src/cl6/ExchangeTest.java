package cl6;

public class ExchangeTest
{
    public static void main(String[] args)
    {
        int a=5,b=40;
        System.out.println("调用exchange方法前a,b的值为"+a+","+b);
        exchange(a,b);
        System.out.println("调用exchange方法后a,b的值为"+a+","+b);
    }
    public static void exchange(double num1,double num2)
    {
        double temp;
        temp=num1;
        num1=num2;
        num2=temp;
    }
}

package cl5;

public class shuzu
{
    public static void main(String[] args)
    {
        int a=10,b;
        int[]num1,num2;
        num1=new int[3];
        num1[0]=1;
        num1[1]=2;
         num1[2]=3;
         b=a;
         num2=num1;
         System.out.println(a+"\t"+b);
         System.out.println(num1[0]+"\t"+num1[1]+"\t"+num1[2]);
         System.out.println(num2[0]+"\t"+num2[1]+"\t"+num2[2]);
         System.out.println("---------------------");
         b=5;
         num2[0]=3;
         num2[1]=2;
         num2[2]=1;
         System.out.println(a+"\t"+b);
         System.out.println(num1[0]+"\t"+num1[1]+"\t"+num1[2]);
         System.out.println(num2[0]+"\t"+num2[1]+"\t"+num2[2]);


    }
}

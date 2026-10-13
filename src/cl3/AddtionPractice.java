package cl3;
import java.util.Random;
import java.util.Scanner;
public class AddtionPractice {
    public static void main(String[] args){
        int op1,op2,result;
        Random ran=new Random();
        Scanner scanner=new Scanner(System.in);
        op1=(int)(ran.nextDouble() * 10);
        op2=(int) (ran.nextDouble() * 10);
        System.out.print(op1+"+"+op2+"=");
        result=scanner.nextInt();
        System.out.println(op1+op2==result);
    }
}

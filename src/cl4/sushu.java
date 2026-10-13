package cl4;
import java.util.Scanner;
public class sushu {
    public static void main(String[] args){
        int num;
        boolean flag=true;
        Scanner s=new Scanner(System.in);
        System.out.println("请输入学号后四位:");
         num=s.nextInt();
         int i;
         for(i=2;i<num;i++){
             if(num%i==0)
                 flag=false;
         }
         if(flag)
             System.out.println(num+"是一个素数。");
         else
             System.out.println(num+"不是一个素数");
    }
}

package cl4;
import java.util.Scanner;
public class for1 {
    public static void main(String[] args){
        int sum=0,n;
        Scanner s=new Scanner(System.in);
        System.out.println("请输入学号后四位:");
        n=s.nextInt();
        for (int i=1;i<=n;i++)
        sum+=i;
        System.out.println("零到n的和为："+sum);
    }
}

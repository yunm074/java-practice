package cl4;
import java.util.Scanner;
public class continue1 {
    public static void main(String[] args){
        int sum=0,n;
        Scanner s=new Scanner(System.in);
        System.out.println("请输入学号后四位:");
        n=s.nextInt();
        for (int i=1;i<=n;i++){
            if(i%3==0)
                continue;
            sum+=i;
        }
        System.out.println("零到一百的数字不能被3整除的和："+sum);
    }
}

package lian;
import java.util.Scanner;//两个数比较输出较大值
public class MaxTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数：");
        int a = sc.nextInt();
        System.out.print("请输入第二个数：");
        int b = sc.nextInt();
        int max;
        if(a > b){
            max = a;
        }else{
            max = b;
        }
        System.out.println(max);
        sc.close();
    }
}

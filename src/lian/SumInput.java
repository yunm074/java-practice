package lian;
import java.util.Scanner;  //累加正整数，输入 - 1 结束
public class SumInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true){
            System.out.print("请输入正整数（输入-1结束）：");
            int num = sc.nextInt();
            if(num == -1){
                break;
            }
            if(num > 0){
                sum += num;
            }
        }
        System.out.println("总和为："+sum);
        sc.close();
    }
}


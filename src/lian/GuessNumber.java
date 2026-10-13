package lian;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        // 生成1~100随机整数
        int target = rand.nextInt(100) + 1;

        System.out.println("欢迎来到猜数字游戏！请输入一个1到100之间的整数进行猜测：");

        while (true) {
            System.out.print("请输入一个1到100之间的整数进行猜测：");
            int guess = sc.nextInt();

            // 输入验证：必须在1~100
            if (guess < 1 || guess > 100) {
                System.out.println("输入不符合要求，请重新输入。");
                continue;
            }

            if (guess > target) {
                System.out.println("太大");
            } else if (guess < target) {
                System.out.println("太小");
            } else {
                System.out.println("恭喜猜中");
                break; // 猜中，结束循环
            }
        }
        sc.close();
    }
}

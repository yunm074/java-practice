package cl3;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学号后四位N：");
        int N = sc.nextInt();
        if (N % 2 == 0) {
            if (N % 3 == 0) {
                System.out.println("能同时被 2 和 3 整除");
            } else {
                System.out.println("能被 2 整除，不能被 3 整除");
            }
        } else {
            if (N % 3 == 0) {
                System.out.println("能被 3 整除，不能被 2 整除");
            } else {
                System.out.println("既不能被 2 整除，也不能被 3 整除");
            }
        }
        int a = N / 1000;
        int d = N % 10;
        System.out.printf("千位a=%d，个位d=%d\n", a, d);
        if (a > d) {
            System.out.println("千位大于个位");
        } else if (a < d) {
            System.out.println("千位小于个位");
        } else {
            System.out.println("千位等于个位");
        }
        char grade;
        switch (N / 1000) {
            case 9:
            case 8:
            case 7:
                grade = 'A';
                break;
            case 6:
            case 5:
                grade = 'B';
                break;
            case 4:
            case 3:
                grade = 'C';
                break;
            case 2:
            case 1:
                grade = 'D';
                break;
            default:
                grade = 'E';
        }
        System.out.println("等级为：" + grade);

        sc.close();
    }
}

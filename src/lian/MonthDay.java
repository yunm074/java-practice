package lian;
import java.util.Scanner;//switch 判断月份天数
public class MonthDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + "月有31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + "月有30天");
                break;
            case 2:
                System.out.println(month + "月有28天");
                break;
            default:
                System.out.println("输入的月份不合法，请输入1 - 12之间的整数");
        }
        sc.close();
    }
}
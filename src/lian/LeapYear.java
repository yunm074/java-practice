package lian;
import java.util.Scanner;//判断闰年，带输入
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if((year % 4 == 0 && year % 100 !=0) || year %400 ==0){
            System.out.println(year + "年是闰年");
        }else{
            System.out.println(year + "年不是闰年");
        }
        sc.close();
    }
}

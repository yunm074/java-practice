package lianxi;
import java.util.Scanner;//三门成绩求平均分
public class Tools {

    public static int getAvg(int a, int b, int c){
        return (a + b + c) / 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();
        int avg = getAvg(s1,s2,s3);
        System.out.println(avg);
        sc.close();
    }
}

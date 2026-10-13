package lian;
import java.util.Scanner;//录入三个数，返回最大值
public class MaxThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数：");
        int a = sc.nextInt();
        System.out.print("请输入第二个数：");
        int b = sc.nextInt();
        System.out.print("请输入第三个数：");
        int c = sc.nextInt();
        int res = getMax(a,b,c);
        System.out.println(res);
        sc.close();
    }
    public static int getMax(int x,int y,int z){
        int temp = x > y ? x : y;
        return temp > z ? temp : z;
    }
}

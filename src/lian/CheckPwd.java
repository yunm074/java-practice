package lian;
import java.util.Scanner;//验证既定密码，
public class CheckPwd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入密码：");
        String pwd = sc.nextLine();
        if("111111".equals(pwd)){
            System.out.println("密码正确");
        }else{
            System.out.println("密码输入错误");
        }
        sc.close();
    }
}

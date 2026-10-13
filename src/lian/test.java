package lian;
import java.util.Scanner;//实现根据输入的分数判断其对应的等级
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入百分制成绩：");
        int score = sc.nextInt();
        if(score >=90 && score <=100){
            System.out.println("等级：A");
        }else if(score >=80){
            System.out.println("等级：B");
        }else if(score >=70){
            System.out.println("等级：C");
        }else if(score >=60){
            System.out.println("等级：D");
        }else if(score >=0){
            System.out.println("等级：E");
        }else{
            System.out.println("成绩不合法");
        }
        sc.close();
    }
}

package lian;
import java.util.Scanner;//社区垃圾回收
public class GarbageScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int householdNum = sc.nextInt();
        int totalScore = 0;

        for(int i = 0; i < householdNum; i++){
            int recycleWeight = sc.nextInt();
            int harmfulCount = sc.nextInt();
            int score = recycleWeight * 5 + harmfulCount * 10;
            totalScore += score;
        }
        double avgScore = (double) totalScore / householdNum;
        avgScore = Math.round(avgScore * 10) / 10.0;

        System.out.println("社区垃圾分类总积分为: " + totalScore);
        System.out.println("平均每户积分为: " + avgScore);
        if(totalScore >= 500){
            System.out.println("社区环保意识优秀！");
        }else{
            System.out.println("继续努力，共建绿色社区！");
        }
        sc.close();
    }
}

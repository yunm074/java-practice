package cl3;

import java.util.Scanner;

public class ScoreGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入百分制成绩：");
        int score = sc.nextInt();

        char level;
        // 合法性判断
        if(score <0 || score >100){
            System.out.println("输入成绩不合法！");
            return;
        }

        switch (score / 10) {
            case 10:
            case 9: level = 'A'; break;
            case 8: level = 'B'; break;
            case 7: level = 'C'; break;
            case 6: level = 'D'; break;
            default: level = 'E'; // 0~59
        }
        System.out.println("五等制等级：" + level);
        sc.close();
    }
}

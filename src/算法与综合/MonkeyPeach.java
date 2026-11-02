package 算法与综合;
public class MonkeyPeach {
    public static void main(String[] args) {
        int peach = 1;
        // 第10天是1个，倒推9天
        for (int i = 9; i >= 1; i--) {
            peach = (peach + 1) * 2;
        }
        System.out.println("第一天共摘了" + peach + "个桃子");
    }
}

package lian;
//# 计算输出 1~100 以内奇数的和（无输入）
public class jiSum {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            if(i % 2 != 0){ // 判断奇数
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

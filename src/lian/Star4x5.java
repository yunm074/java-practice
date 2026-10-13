package lian;
//使用 for 循环输出 4 行 5 列的星星
public class Star4x5 {
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 5; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

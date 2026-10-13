package lian;
import java.util.Scanner;//行、列打印星形图形
public class StarPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入行数：");
        int row = sc.nextInt();
        System.out.print("输入列数：");
        int col = sc.nextInt();
        printStar(row,col);
        sc.close();
    }
    public static void printStar(int r,int c){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


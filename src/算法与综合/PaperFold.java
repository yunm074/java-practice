package 算法与综合;
public class PaperFold {
    public static void main(String[] args) {
        double height = 8848;
        double thick = 0.01;
        int count = 0;
        while (thick < height) {
            thick *= 2;
            count++;
        }
        System.out.println(count);
    }
}

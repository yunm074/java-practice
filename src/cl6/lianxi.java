package cl6;

public class lianxi {
    public static int cube(int num) {
        return num * num * num;
    }

    public static boolean isNarcissus(int n) {
        int hundred = n / 100;
        int ten = (n / 10) % 10;
        int unit = n % 10;
        return cube(hundred) + cube(ten) + cube(unit) == n;
    }

    public static void main(String[] args) {
        System.out.println("100~999 之间的水仙花数：");
        for (int i = 100; i <= 999; i++) {
            if (isNarcissus(i)) {
                System.out.println(i);
            }
        }
    }
}

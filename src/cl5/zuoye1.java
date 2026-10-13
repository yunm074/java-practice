package cl5;

public class zuoye1 {
    public static void main(String[] args) {
        int N = 40125;
        int a = N / 1000;
        int b = N / 100 % 10;
        int c = N / 10 % 10;
        int d = N % 10;
        int len = d + 3;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (N * (i + 1)) % 100;
        }
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}


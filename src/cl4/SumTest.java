package cl4;
public class SumTest {
    public static void main(String[] args) {
        int N = 0125;
        int sum1 = 0;
        int i = 1;
        while(i <= N){
            sum1 = sum1 + i;
            i++;
        }
        System.out.println("while 结果："+sum1);

        int sum2 = 0;
        int j = 1;
        do{
            sum2 = sum2 + j;
            j++;
        }while(j <= N);
        System.out.println("do‑while 结果："+sum2);

        int sum3 = 0;
        for(int k=1; k<=N; k++){
            sum3 = sum3 + k;
        }
        System.out.println("for 结果："+sum3);
    }
}

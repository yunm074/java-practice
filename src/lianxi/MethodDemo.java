package lianxi;
import java.util.Scanner;

public class MethodDemo {

    public static int max3(int a, int b, int c){
        int max = a;
        if(b>max) max = b;
        if(c>max) max = c;
        return max;
    }

    public static boolean isEven(int n){
        return n % 2 == 0;
    }


    public static void swap(int x, int y){
        int temp = x;
        x = y;
        y = temp;
        System.out.println("swap方法内部：x="+x+", y="+y);
    }
    public static void reverse(int[] arr){
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    public static int pow(int base, int exp){
        int res = 1;
        for(int i=0; i<exp; i++){
            res *= base;
        }
        return res;
    }

    public static int sumOfPowers(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += pow(i,i);
        }
        return sum;
    }

    public static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // ==========1. max3 从键盘输入3个数求最大值==========
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入3个整数：");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        System.out.println("三个数最大值："+max3(num1,num2,num3));

        // ==========2. 输出1~100所有偶数==========
        System.out.println("\n1~100的偶数：");
        for(int i=1;i<=100;i++){
            if(isEven(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();

        // ==========3.基本类型值传递测试swap==========
        System.out.println("\n====值传递swap测试====");
        int a=10,b=20;
        System.out.println("调用swap前：a="+a+",b="+b);
        swap(a,b);
        System.out.println("调用swap后：a="+a+",b="+b);
        // 结论：方法内部交换，main里实参不变，基本类型值传递，只传副本

        // ==========4.数组逆序 引用传递==========
        System.out.println("\n====数组逆序reverse====");
        int[] arr = {1,2,3,4,5};
        System.out.print("逆序前：");
        for(int x:arr) System.out.print(x+" ");
        reverse(arr);
        System.out.print("\n逆序后：");
        for(int x:arr) System.out.print(x+" ");
        System.out.println();
        //结论：数组是引用类型，方法内修改数组元素，main中原数组跟着变

        // ==========5.嵌套调用pow sumOfPowers==========
        System.out.println("\n====sumOfPowers====");
        System.out.println("1^1+2^2+3^3+...+n^n，n=4时结果="+sumOfPowers(4));

        // ==========6.输出2~100素数，每行5个==========
        System.out.println("\n====2~100素数====");
        int count=0;
        for(int i=2;i<=100;i++){
            if(isPrime(i)){
                System.out.print(i+"\t");
                count++;
                if(count%5 ==0) System.out.println();
            }
        }
        sc.close();
    }
}


package cl9;
import java.util.Random;
public class Example18 {
    public static void main(String[] args){
        Random r1=new Random();
        System.out.println("产生float类型的随机数："+r1.nextFloat());
        System.out.println("产生零到一百之间的int类型的随机数："+r1.nextInt(100));
        System.out.println("产生double类型的随机数："+r1.nextDouble());
    }
}

package cl2;

public class Base {
    public static void main(String[] args){
        byte  num1=127;
        short  num2=-32768;
        int  num3=65535,num4=100;
        long  num5=1000000000L;
        float num6=32.5f;
        double num7=3.1415926;
        boolean flag=true;
        char  ch='a';
        num3=65535;
        System.out.println("字节类型："+num1);
        System.out.println("短整型："+num2);
        System.out.println("标准整型："+num3+","+num4);
        System.out.println("长整型："+num5);
        System.out.println("单精度实行："+num6);
        System.out.println("双精度实型："+num7);
        System.out.println("布尔类型："+flag);
        System.out.println("字符类型："+ch);
    }
}

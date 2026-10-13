package cl7;

public class Example14 {
    static{
        System.out.println("测试类的静态代码块被执行了");
    }
    public static void main(String[] args){
        Person11 p1=new Person11();
        Person11 p2=new Person11();
    }
}
class Person11{
    static String country;
    static {
        country="China";
        System.out.println("Person类的静态代码块被执行了");
    }
}

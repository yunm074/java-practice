package cl7;
class Person09{
    public Person09(){
        System.out.println("无参构造方法被调永");
    }
    public Person09(String name){
        this();
        System.out.println("有参构造函数被调用");
    }
}
public class Example10 {
    public static void main(String[] args){
        Person09 p=new Person09("itcast");
    }
}

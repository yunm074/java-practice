package cl7;
class Person04{
    String name;
    int age;
    public Person04(String con_name,int con_age){
        name=con_name;
        age=con_age;
    }
    public Person04(String con_name){
        name=con_name;
    }
    public void speak(){
        System.out.println("大家好，我叫"+name+",今年"+age+"岁");
    }
}
public class Example07 {
    public static void main(String[] args){
        Person04 p1=new Person04("陈杰");
        Person04 p2=new Person04("李芳",18);
        p1.speak();
        p2.speak();
    }
}

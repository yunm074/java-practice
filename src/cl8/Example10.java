package cl8;
abstract class Animal04{
    abstract void shout();
}
class Dog03 extends Animal04{
    void shout(){
        System.out.println("汪汪");
    }
}
public class Example10 {
    public static void main(String[] args){
        Dog03 dog03=new Dog03();
        dog03.shout();
    }
}

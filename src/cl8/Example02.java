package cl8;
class Animal01{
    void shout(){
        System.out.println("动物发出叫声");
    }
}
class Dog01 extends Animal01{
    void shout(){
        System.out.println("汪汪");
    }
}
public class Example02 {
    public static void main(String[] args){
        Dog01 dog01=new Dog01();
        dog01.shout();
    }
}

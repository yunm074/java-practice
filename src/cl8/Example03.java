package cl8;
class Animal02{
    String name="动物";
    void shout(){
        System.out.println("动物发出叫声");
    }
}
class Dog02 extends Animal02{
    String name="犬类";
    void shout(){
        super.shout();
    }
    void printName(){
        System.out.println("name="+super.name);
    }
}
public class Example03 {
    public static void main(String[] args){
        Dog02 dog02=new Dog02();
        dog02.shout();
        dog02.printName();
    }
}

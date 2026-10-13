package cl8;
interface Animal08{
    void shout();
}
class Cat05 implements Animal08{
    public void shout(){
        System.out.println("喵喵......");
    }
    void sleep(){
        System.out.println("猫睡觉");
    }
}
public class Example14 {
    public static void main(String[] args){
        Cat05 cat05=new Cat05();
        animalshout(cat05);
    }
    public static void animalshout(Animal08 animal08){
        Cat05 cat05=(Cat05) animal08;
        cat05.shout();
        cat05.sleep();
    }
}

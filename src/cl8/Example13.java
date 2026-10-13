package cl8;
interface Animal07{
    void shout();

}
class Cat implements Animal07{
    public void shout(){
        System.out.println("喵喵......");
    }
}
class Dog06 implements Animal07{
    public void shout(){
        System.out.println("汪汪.....");
    }
}
public class Example13 {
    public static void main(System[] args){
        Animal07 an1=new Cat();
        Animal07 an2=new Dog06();
        animal07shout(an1);
        animal07shout(an2);
    }
    public static void animal07shout(Animal07 an){
        an.shout();
    }
}

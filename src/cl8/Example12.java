package cl8;
interface Animal06{
    int ID=1;
    void brethe();
    void run();
}
interface LandAnimal extends Animal05{
    void liveOnLand();
}
class Dog05 implements LandAnimal{
    public void breathe(){
        System.out.println("狗在呼吸");
    }
    public void run(){
        System.out.println("狗在呼吸");
    }
    public void liveOnLand(){
        System.out.println("狗在陆地上");
    }

}
public class Example12 {
    public static void main(String[] args){
        Dog05 dog05=new Dog05();
        dog05.breathe();
        dog05.run();
        dog05.liveOnLand();
    }
}

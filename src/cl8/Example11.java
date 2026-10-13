package cl8;
interface Animal05{
    int ID=1;
    void breathe();
    void run();
}
class Dog04 implements Animal05{
    public void breathe(){
        System.out.println("狗在呼吸");
    }
    public void run(){
        System.out.println("狗在呼吸");
    }
}
public class Example11 {
    public static void main(String[] args){
        Dog04 dog04=new Dog04();
        dog04.breathe();
        dog04.run();
    }
}

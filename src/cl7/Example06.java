package cl7;
class Person00{
    int age;
    public Person00(int a){
        age=a;
    }
    public void speak(){
        System.out.println("I am"+age+"years old");
    }
}
public class Example06 {
    public static void main(String[] args){
        Person00 p=new Person00(20);
        p.speak();}

}

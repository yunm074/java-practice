package cl7;
class Outer02{
    private int num=4;
    public void test(){
        class Inner{
            void show(){
                System.out.println("num="+num);
            }
        }
        Inner in=new Inner();
        in.show();
    }
}
public class Example18 {
    public static void main(String[] args){
        Outer02 outer02=new Outer02();
        outer02.test();
    }
}
